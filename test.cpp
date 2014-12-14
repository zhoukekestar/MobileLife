#include <iostream>
#include "Setting.h"
#include "Utils.h"

using namespace std;

void setttingTest()
{
	map<string, string> map = Setting::getSetting("conf.txt");
	cout << map["server_ip"] << endl;
	
	Utils::showSetting(map);
}

int main()
{
	setttingTest();
	return 0;
}