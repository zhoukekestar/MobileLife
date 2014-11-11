#include <stdlib.h>
#include <stdio.h>
#include <errno.h>
#include <string.h>
#include <netdb.h>
#include <unistd.h>
#include <fcntl.h>
#include <signal.h>
#include <arpa/inet.h>

#include <netinet/in.h>

#include <sys/socket.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <sys/types.h>



#define FIFO_CREATE  (O_CREAT | O_RDWR | O_NONBLOCK)
#define PIPE_RD_MODE (O_RDONLY | O_NONBLOCK)
#define PIPE_WR_MODE (O_WRONLY | O_NONBLOCK)

char PIPE_REV_NAME[50]	= "SOCKET_REV.TEMP";
char PIPE_SEND_NAME[50] = "SOCKET_SEND.TEMP";

char SERVER_IP[100] = "220.170.79.208";
char PORT[6] 		= "16258";
int is_running 		= 1;
int pid_rev = 0;
int pid_send = 0;

int socket_init()
{
	int socket_id = 0;
	
	struct sockaddr_in client_addr;
  	
  	
  	socket_id = socket(AF_INET, SOCK_STREAM, 0);
  	
  	if(socket_id < 0)
  	{
	    fprintf(stderr,"Socket error:%s\a\n",strerror(errno));
	    exit(1);
  	}
 
  	bzero(&client_addr,sizeof(struct sockaddr_in));

  	client_addr.sin_family		= AF_INET;
  	client_addr.sin_port		= htons(atoi(PORT));
  	client_addr.sin_addr.s_addr	= inet_addr(SERVER_IP);
  	
  	
  	int err = connect(socket_id,(struct sockaddr *)(&client_addr),sizeof(struct sockaddr));
  	if(err == -1)
  	{
    	fprintf(stderr,"Connect Error:%s\n\a",strerror(errno));
    	exit(1);
  	}
  	
  	return socket_id;
}

int send_msg(char* buffer, int length)
{
	int socket_id = socket_init();
	send(socket_id, buffer, length, 0);
	close(socket_id);
	return 0;
}

//Give the buffer's address and return the rec_msg's length
int rev_msg(char* buffer, int buffer_MAX_length)
{
	int length = 0;
	int socket_id = socket_init();
	length = recv(socket_id, buffer, buffer_MAX_length, 0);	
	if(length == -1)
  	{
    	fprintf(stderr,"Recv msg Error:%s\n\a",strerror(errno));
    	exit(1);
  	}
  	close(socket_id);
  	return length;
}

void proc_send_msg()
{
	
	
}

void exit_program();
void proc_rev_msg()
{
	while (1)
	{
		char buffer[1024];
		int length = rev_msg(buffer, 1024);
		buffer[length] = '\0';
	  	printf("Received:[%s]\n",buffer);
	  
	  	if (strcmp(buffer, "SERVER_EXIT") == 0)
	  	{
  			exit_program();
	  	}	
	  		
	  	char cmd_temp[1000];
	  	sprintf(cmd_temp, "echo '%s' >> %s", buffer, PIPE_REV_NAME);
	  	system(cmd_temp);
	}
}

void show_notes()
{
	////////////////NOTES/////////////////////////
	puts("If you want to connect to other Socket.");
	puts("Please exe this program like this:");
	puts("./pragram_name 127.0.0.1 8080");
	puts("Exit this program: send [SERVER_EXIT].");
	
	//////////////NOTES END///////////////////////
	printf("This program is connect to %s:%s\n", SERVER_IP, PORT);
}

void exit_program()
{
	int pid_rev_result = 0;
   	int pid_send_result = 0;
   	pid_rev_result = kill(pid_rev, 31);
   	pid_send_result = kill(pid_send, 31);
   	
	if (pid_send_result == -1 || pid_rev_result == -1)
    {
           perror("Kill the recevied OR send pid Error : ");
    }
    exit(0);
}

int main(int argc,char *argv[])
{
  	if (argc == 3)
  	{
  		strcpy(SERVER_IP, argv[1]);
  		strcpy(PORT, argv[2]);
  	}
 	show_notes();
  	
 	

  	pid_rev = fork();
  	
  	
  	if(pid_rev < 0)
   	{
         perror("Fork is error!\n");
         exit(1);
   	}
   	else if(pid_rev == 0)//receved son
   	{
	   	pid_send = fork();
    	if (pid_send < 0)
    	{
	    	perror("Fork is error!\n");
         	exit(1);
	    }
	    else if (pid_send == 0)
	    {
	    	puts("Send msg is starting...");
    		proc_send_msg();
    	}
    	else
    	{
    		puts("Recv msg is starting...");
	    	proc_rev_msg();
	    }
   	}
   	else//father
   	{
   		while (1)
   		{
			sleep(10);
			//printf("Main proc runable:%d\n", is_running);
	   	}
	   		
   	} 
  	exit(0);
}
