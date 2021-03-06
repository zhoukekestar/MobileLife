#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/ioctl.h>
#include <pthread.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <iostream>
#include <sstream>

using namespace std;

class CtrlLED
{
	int on;  	/*	 on = 0 means turn it off,
	 	 	 	 	 on = 1 means turn it on.*/
	int led_no;	/* 	 led_no is the led's number.*/
	int fd;		/*	 The device's file id.*/
private:
	void init()
	{
		fd = open("/dev/leds0", 0);
		if (fd < 0) {
			fd = open("/dev/leds", 0);
		}
		if (fd < 0) {
			perror("open  device  leds");
			exit(1);
		}
	}
	void runit()
	{
		ioctl(fd, on, led_no);
	}
public:
	CtrlLED()
	{
		init();
	}

	void ctrl(int ledNO, int switchNO)
	{
		led_no = ledNO;
		on = switchNO;

		runit();
	}

	~CtrlLED()
	{
		close(fd);
	}
};


int main(int argc, char **argv) {

	system("/etc/rc.d/init.d/leds stop");
	CtrlLED led;

	if (argc != 3)
	{
		cout << "-------------------------------" << endl;
		cout << "Run it by two params:" << endl;
		cout << "First is the led's num." << endl;
		cout << "Second is the led's switch." << endl;
		cout << "-------------------------------" << endl;
		return 0;
	}
	int ln, n;
	stringstream s1, s2;
	s1 << argv[1];
	s1 >> ln;
	s2 << argv[2];
	s2 >> n;
	if (ln > -1 && ln < 4 && (n == 0 || n == 1))
	{
		cout << "Lednum:" << ln << "  Switch:" << n << endl;
		led.ctrl(ln, n);
		cout << "OK!" << endl;
	}
	else
	{
		cout << "Lednum:" << ln << "  Switch:" << n << endl;
		cout << "Your params is not right." << endl;
		cout << "Lednum must be bigger than -1 and samller than 4." << endl;
		cout << "Switch must be 0 OR 1." << endl;
	}
	return 0;
}



