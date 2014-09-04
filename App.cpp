#include <iostream>
#include <fstream>
#include <map>

#include "Setting.h"
#include "Utils.h"
#include "net/mod_pipe_w.h"
#include "net/mod_pipe_r.h"

using namespace std;


int main()
{
	PipeWrite write_nouse((char*)"./recv.pipe");
	PipeWrite write((char*)"./send.pipe");
    PipeRead read((char*)"./recv.pipe", 4000);
    
     pid_t fpid;
    fpid = fork();
    
    if (fpid < 0)
    {
		perror(" fork() error");
	}
	else if (fpid == 0)
	{
		cout << "Pipe w" << endl;\
		char buf[] = "hi auto acom";
		while (1)
		{
			sleep(3);
			cout << "sleep" << endl;
			//char* buf = client.recvMsg();
			//cout << "recv:[" << buf << "]" << endl;
			write.writeBlock(buf);
		}
	}
	else 
	{
		cout << "Pipe R" << endl;
		while (1)
		{
			char* buf = read.readBlock();
			cout << "Got:[" << buf << "]" << endl;
			//client.sendMsg(buf, sizeof(buf));
		}
	}
    
	return 0;
}
