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

int main()
{
	ThreadPool pool;
	SocketClient client(1234, (char*)"10.64.130.222");

	pool.addMethod(ThreadSocketClient::threadSend, (void*)&client);
	pool.addMethod(ThreadSocketClient::threadRecv, (void*)&client);
	pool.wait();
	return 0;
}
