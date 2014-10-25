#include <iostream>
#include <fstream>

#include "mod_socket_client.h"
#include "mod_pipe_w.h"
#include "mod_pipe_r.h"
using namespace std;
int main()
{
	PipeWrite write((char*)"./temp.pipe");
	//PipeRead read((char*)"./temp.pipe", 40000);
	while (1)
	{
		//cout << read.readBlock() << endl;
		//use command $:echo "hello" >> temp.pipe
		
		
		char msg[10] = {"i:"};
		for (int i = 0; i < 10; i++)
		{
			msg[2] = i + 70;
			cout << "write: " << msg << endl;
			write.writeBlock(msg);
			sleep(2);
		}
		sleep(20);
	}
	
	return 0;
}
