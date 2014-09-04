#include <iostream>
#include <fstream>
#include <map>

#include "Setting.h"
#include "Utils.h"
#include "net/mod_socket_client.h"
#include "net/mod_pipe_w.h"
#include "net/mod_pipe_r.h"

int length(char* ch)
{
	int i = 0;
	while (*ch != '\0')
	{
			i++;
			ch++;
			//cout << *ch << endl;
		}
	return i;
}

int main()
{
	map<string, string> abc = Setting::getSetting("conf.txt");
	Setting::showSetting(abc);
	cout << "---------------" << endl;
	
	SocketClient client(1234, (char*)"192.168.0.112");
	PipeWrite write_nouse((char*)"./send.pipe");
	PipeWrite write((char*)"./recv.pipe");
    PipeRead read((char*)"./send.pipe", 4000);
    
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
			char* buf = client.recvMsg();
			cout << "recv:[" << buf << "]" << endl;
			write.writeBlock(buf);
		}
	}
	else 
	{
		cout << "Start send." << endl;
		while (1)
		{
			char* buf = read.readBlock();
			cout << "send:[" << buf << "]" << endl;
			
			client.sendMsg(buf,length(buf));
		}
	}
	return 0;
}
