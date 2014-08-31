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


class PipeWrite
{
private:
    int fd;
    char w_buf[4096*2];
    int real_wnum;
    char* file_name;
    
    void init()
    {
        memset(w_buf,0,4096*2);
        
        //unlink(file_name);
        if(mkfifo(file_name,O_CREAT|O_EXCL) < 0)
        {
            if (errno == EEXIST)
                printf("Pipe Already exist.\n");
            else
                printf("Mkfifo other error.\n");
        }
        chmod(file_name, 07777);

    }
    
    void pri_write()
    {
        if(fd==-1)
        {
            if(errno == ENXIO)
                printf("open error; no reading process/n");
            else
                printf("fd others error");
        }
        //cout << "pri_w: " << w_buf << endl;
        real_wnum=write(fd,w_buf,2048);
    }
public:
    PipeWrite()
    {
        file_name = (char*)"/tmp/fifoserver";
        init();
    }
    PipeWrite(char* _file_name)
    {
        file_name = _file_name;
        init();
    }
    
    void writeBlock(char* msg)
    {
        fd=open(file_name,O_WRONLY);
        if (sizeof(msg) > sizeof(w_buf))
            printf("warning: msg seems like too large.");
        strcpy(w_buf, msg);
        pri_write();

    }
    void writeNonblock(char* msg)
    {
        fd=open(file_name,O_WRONLY|O_NONBLOCK);
        if (sizeof(msg) > sizeof(w_buf))
            printf("warning: msg seems like too large.");
        strcpy(w_buf, msg);
        pri_write();

    }
};
/*
int main(int argc,char** argv)
{
    
    PipeWrite write;
    while (1)
    {
        char msg[100];
        memset(msg, 0, sizeof(msg));
        cin >> msg;
        write.writeBlock(msg);
    }
    
    strcpy(w_buf, "hello lalal");
    
    //unlink(FIFO_SERVER);
    
    
    
    printf("writing...\n");
        return 0;
    
    
    if(real_wnum==-1)
    {
        if(errno==EAGAIN)
            printf("write to fifo error; try later/n");
    }
    else
        printf("real write num is %d/n",real_wnum);
    
    
    real_wnum=write(fd,w_buf,5000);
    //5000用于测试写入字节大于4096时的非原子性
    //real_wnum=write(fd,w_buf,4096);
    //4096用于测试写入字节不大于4096时的原子性
    
    if(real_wnum==-1)
        if(errno==EAGAIN)
            printf("try later/n");
    
    return 0;
    
}*/
