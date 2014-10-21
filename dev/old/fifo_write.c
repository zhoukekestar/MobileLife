#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <unistd.h>
#include <errno.h>

/*蒙艶廣吭亟砿祇扮�譜崔嬉蝕砿祇猟周議鯉塀駅倬葎辛亟*/
#define FIFO_SERVER "MYCGI_SERVER_2"
#define OPENMODE (O_WRONLY | O_NONBLOCK)

int main(int argc, char **argv)
{
        int fd;
        int nwrite;

        /*嬉蝕砿祇猟周�辛亟掲怦毘*/
        if ((fd = open(FIFO_SERVER, OPENMODE)) < 0) {
                perror("open");
                exit(1);
        }

        /*泌惚短嗤壓凋綜佩嶄亟秘歌方�椎担勣嶷仟塰佩殻會*/
        if (argc == 1) {
                printf("Please send something\n");
                exit(1);
        }

        /*�砿祇猟周嶄亟秘方象�壓宸戦勣喘strlen�泌惚喘sizeof�夸峪頁4倖忖准議峺寞海業*/
        if ((nwrite = write(fd, argv[1], strlen(argv[1]))) < 0) {
                if (errno == EAGAIN) {
                        printf("The FIFO has not been read yet.Please try later\n");
                }
        }
        else {
                printf("write %s to FIFO\n", argv[1]);
        }

        return 0;
}
