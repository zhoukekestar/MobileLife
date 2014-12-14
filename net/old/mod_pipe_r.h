#include <sys/types.h>
#include <sys/stat.h>
#include <errno.h>
#include <fcntl.h>
#include <stdio.h>
#include <string.h>
#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include <iostream>

using namespace std;

class PipeRead
{
private:
    char r_buf[4096*2];
    
    int  fd;
    int  r_size;
    int  ret_size;
    
    char* file_name;
    
    void init()
    {
        
    }
    
    char* pri_read()
    {
        if(fd==-1)
        {
            if (errno == 13)
                printf("Error: permission deny.\n");
            else
                printf("Other error while open file.\n");
            return NULL;
        }
        
        
        memset(r_buf,0,sizeof(r_buf));
        ret_size=read(fd,r_buf,r_size);
        
        if(ret_size==-1)
            if(errno==EAGAIN)
            {
                printf("no data avlaible/n");
                return NULL;
            }

        return r_buf;
    }
public:
    PipeRead()
    {
		
        file_name = (char*)"/tmp/fifoserver";
        r_size = 4000;
        init();
    }
    PipeRead(char* _file_name, int _read_size)
    {
        
        file_name = _file_name;
        r_size = _read_size;
        init();
    }
    
    char* readBlock()
    {
        fd=open(file_name,O_RDONLY);
        return pri_read();
    }
    char* readNonblock()
    {
        fd=open(file_name,O_RDONLY|O_NONBLOCK);
        return pri_read();
    }
    
    void removeFile()
    {
        unlink(file_name);
    }
};
/*
int main(int argc,char** argv)
{
    PipeRead read;
    while (1)
    {
        printf("out:%s\n", read.readBlock());
    }
    return 0;
}
*/

