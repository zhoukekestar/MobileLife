#include <stdio.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <unistd.h>
#include <string.h>
#include <iostream>


#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>

#define MAXSOCKFD 10

using namespace std;

class SocketServer
{
private:
    uint16_t port;
    
    int server_fd, newsockfd, fd;   //服务器fd，接受fd，客户端fd
    int is_connected[MAXSOCKFD];    //所有客户端连接
    struct sockaddr_in addr;        //地址信息
    int addr_len;
    fd_set readfds;
    
    char buffer[256];
    
    
    void init()
    {
		addr_len  = sizeof(struct sockaddr_in);
        cout << "Server is listen [" << port << "]." << endl;
        if ((server_fd = socket(AF_INET, SOCK_STREAM, 0)) < 0)
        {
            perror("socket");
            return;
        }
        bzero(&addr, sizeof(addr));
        addr.sin_family = AF_INET;
        addr.sin_port = htons(port);
        addr.sin_addr.s_addr = htonl(INADDR_ANY);
        
        if (bind(server_fd, (sockaddr *)&addr, sizeof(addr)) < 0)
        {
            perror("connect");
            return;
        }
        if (listen(server_fd, 3) < 0) {
            perror("listen");
            return;
        }
        for (fd = 0; fd < MAXSOCKFD; fd++)
            is_connected[fd] = 0;
    }
    
public:
    SocketServer(uint16_t _port = 1234)
    {
        port = _port;
        init();
    }
    int firstfd;
    void startListen()
    {
		char msg[] = "welcome to server.";
        while (1)
        {
            
            FD_ZERO(&readfds);
            FD_SET(server_fd, &readfds);
            for (fd = 0; fd < MAXSOCKFD; fd++)
                if (is_connected[fd])
                    FD_SET(fd, &readfds);
            if (!select(MAXSOCKFD, &readfds, NULL, NULL, NULL))
                continue;
            for (fd = 0; fd < MAXSOCKFD; fd++)
                if (FD_ISSET(fd, &readfds))
                {
                    if (server_fd ==fd)
                    {
                        if ((newsockfd = accept(server_fd, (sockaddr*)&addr, (socklen_t*)&addr_len)) < 0)
                            perror("accept");
                        firstfd = newsockfd;
                        cout << "newsocket: " << newsockfd << " fir" << firstfd << endl;
                        write(newsockfd, msg, sizeof(msg));
                        is_connected[newsockfd] = 1;
                        printf("cnnect from %s\n",inet_ntoa(addr.sin_addr));
                    }
                    else
                    {
                        bzero(buffer, sizeof(buffer));
                        if(read(fd,buffer,sizeof(buffer))<=0)
                        {
                            printf("connect closed.\n");
                            is_connected[fd]=0;
                            close(fd);
                        }
                        
                        else
                            printf("%s",buffer);
                    }
                }
        }
    }
    void sendMsg(char* msg, int len)
    {
		firstfd = 4;
		cout << "---first:" << firstfd << endl;
		write(firstfd, msg, len);
		cout << "---new:" << newsockfd << endl;
		write(newsockfd, msg, len);
        for (int i = 0; i < MAXSOCKFD; i++)
        {
            if (is_connected[i] == 1)
            {
				cout << "coned:" << i << endl;
                write(i, msg, len);
            }
            cout << "none:" << i << endl;
        }
    }
    void testit()
    {
		pid_t fpid;
		fpid = fork();
		
		if (fpid < 0)
		{
			perror(" fork() error");
		}
		else if (fpid == 0)
		{
			cout << "Listen start." << endl;
			startListen();
		}
		else 
		{
			cout << "Server send can be done." << endl;
			while (1)
			{
				char sbuf[256];
				bzero(&sbuf,sizeof(sbuf));
				read(STDIN_FILENO,sbuf,sizeof(sbuf));
				sendMsg(sbuf, sizeof(sbuf));
				cout << "send [" << sbuf << "](" << sizeof(sbuf) << ") over." << endl;
			}
		}
		return;
	}
};

int main()
{
    SocketServer server;
    server.testit();
   
}

