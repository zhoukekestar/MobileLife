#include <iostream>
#include <fstream>
#include <map>

#include "Setting.h"
#include "Utils.h"
#include "net/Send.h"
#include "net/Recv.h"

using namespace std;


int main()
{
	PipeWrite write_nouse((char*)"./recv.pipe");
	PipeWrite write((char*)"./send.pipe");
    PipeRead read((char*)"./recv.pipe", 4000);
    
    
	return 0;
}
