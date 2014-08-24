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

	
	map<string, string> abc = Setting::getSetting("conf.txt");
	Setting::showSetting(abc);
	cout << "---------------" << endl;
	map<string, string> abd = Setting::getSetting("conf-2.txt");
	Setting::showSetting(abd);
	cout << "---------------" << endl;
	Send s;
	Recv r;	
	return 0;
}
