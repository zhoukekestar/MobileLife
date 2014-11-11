#include <stdio.h>
#include <string.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <iostream>
#include <sstream>

#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

class SocketClient
{
private:
    int s;
    struct sockaddr_in addr;
    
    char recv_buffer[256];
    int recv_len;
    
    uint16_t port;
    char* server_ip;
    
    void init()
    {
		cout << "Client is try " << server_ip << ":" << port << endl;
		//cout << port << " " << server_ip << endl;
        if((s = socket(AF_INET,SOCK_STREAM,0))<0)
        {
			cout << " socket error" << endl;
            perror("socket");
            return;
        }
        bzero(&addr,sizeof(addr));
        addr.sin_family = AF_INET;
        addr.sin_port=htons(port);
        addr.sin_addr.s_addr = inet_addr(server_ip);
        /* 尝试连线*/
        if(connect(s,(sockaddr*)&addr,sizeof(addr))<0)
        {
			cout << "connect error" << endl;
            perror("connect");
            return;
        }
    }
public:
    SocketClient()
    {
		port = 1234;
		server_ip = (char *)"127.0.0.1";
        init();
    }
    SocketClient(uint16_t _port, char* _server_ip)
    {
        port = _port;
        server_ip = _server_ip;
        init();
    }
    char* recvMsg()
    {
		bzero(&recv_buffer,sizeof(recv_buffer));
        recv(s,recv_buffer, sizeof(recv_buffer), 0);
        recv_len = sizeof(recv_buffer);
        return recv_buffer;
    }
    int getRecvLen()
    {
		return recv_len;
	}
    bool sendMsg(char* msg, int len)
    {
        if(send(s,msg,len,0)<0)
        {
            perror("send");
            return false;
        }
        return true;
    }
};

int main(int argc, char **argv)
{
	if (argc != 4)
	{
		cout << "Args Error: ip port file" << endl;
		return 0;
	}
	string ip;
	int port;
	string file;
	stringstream s1, s2,s3;
	s1 << argv[1];
	s1 >> ip;
	s2 << argv[2];
	s2 >> port;
	s3 << argv[3];
	s3 >> file;

	SocketClient client(port, (char*)ip.c_str());
    pid_t fpid;
    fpid = fork();
    
    if (fpid < 0)
    {
		perror(" fork() error");
	}
	else if (fpid == 0)
	{
		cout << "Start recv." << endl;
		while (1)
		{
			string buf;
			buf = client.recvMsg();
			cout << "recv [" << buf << "] & to " << file << endl;
			string cmd = "echo " + buf + " >> " + file;
			system(cmd.c_str());
		}
	}
	else 
	{
		cout << "Start send." << endl;
		while (1)
		{
			char sbuf[256];
			bzero(&sbuf,sizeof(sbuf));
			read(STDIN_FILENO,sbuf,sizeof(sbuf));
			client.sendMsg(sbuf, sizeof(sbuf));
			cout << "send [" << sbuf << "](" << sizeof(sbuf) << ") over." << endl;
		}
	}
    return 0;
}

