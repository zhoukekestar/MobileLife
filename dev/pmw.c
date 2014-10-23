#include <stdio.h>
#include <termios.h>
#include <unistd.h>
#include <stdlib.h>
#include <iostream>
#include <sstream>

#include <unistd.h>
#include <sys/ioctl.h>
#include <pthread.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>

using namespace std;

class CtrlPMW
{
private:
	int fd;
	int PWM_IOCTL_SET_FREQ;
	int PWM_IOCTL_STOP;
	void init()
	{
		this->PWM_IOCTL_SET_FREQ = 1;
		this->PWM_IOCTL_STOP = 2;
		this->fd = -1;
		open_buzzer();
	}
	void close_fd() {
		if (fd >= 0) {
			//ioctl(fd, PWM_IOCTL_STOP);
			close(fd);
			fd = -1;
		}
	}
	void open_buzzer()
	{
		fd = open("/dev/pwm", 0);
		if (fd < 0) {
			perror("open pwm_buzzer device");
			exit(1);
		}
		//atexit(close_buzzer);
	}

	void set_buzzer_freq(int freq) {
		int ret = ioctl(fd, PWM_IOCTL_SET_FREQ, freq);
		if (ret < 0) {
			perror("set the frequency of the buzzer");
			exit(1);
		}
	}
	void stop_buzzer(void) {
		int ret = ioctl(fd, PWM_IOCTL_STOP);
		if (ret < 0) {
			perror("stop the buzzer");
			exit(1);
		}
	}
public:
	CtrlPMW()
	{
		init();
	}

	void setFreq(int freq, int time)
	{
		this->set_buzzer_freq(freq);
		sleep(time);
	}

	void stopFreq()
	{
		this->stop_buzzer();
		this->close_fd();
	}
};

int main(int argc, char **argv)
{
	int freq;
	int time;
	stringstream ss;
	stringstream s1;
	ss << argv[1];
	ss >> freq;
	s1 << argv[2];
	s1 >> time;

	if (argc != 3)
	{
		cout << "Input two params: freq, count." << endl;
		return 0;
	}
	CtrlPMW pmw;
	if (freq != -1)
		pmw.setFreq(freq, time);
	else
		pmw.stopFreq();

	return 0;
}



