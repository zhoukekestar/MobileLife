#include "mod_SocketClient.h"
#include "mod_SysCMD.h"
#include "mod_ThreadPool.h"
#include "mod_ThreadSocketClient.h"

using namespace std;

void modTest()
{
	SysCMD::test();
	ThreadPool::test();
	SocketClient::test();
}

class ThreadCMD
{
private:
public:
	static void* threadRun(void* arg)
	{
		string str = (char*)arg;
		SysCMD cmd(str);
		while(1)
		{
			string msg = cmd.get();
			cmd.del();
			
			msg = SysCMD::convertOneLine(msg);
			if (msg.length() != 0)
			{
				cout << "msg:[" << msg << "]" << endl;
				SysCMD::exe(msg);
			}
			else
			{
				sleep(1);
			}
			sleep(3);
		}
		return (void*)0;
	}
};

int main()
{
	ThreadPool pool;
	pool.addMethod(ThreadCMD::threadRun, (void*)"recv");
	pool.wait();
	return 0;
}
