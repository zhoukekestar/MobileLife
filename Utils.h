#include <iostream>
#include <fstream>
#include <map>

using namespace std;

class Utils
{
public:
	static void showSetting(map<string, string> map_in)
	{
		map<string, string>::iterator it;
		for (it = map_in.begin(); it != map_in.end(); it++)
			cout << (*it).first << " -> " << (*it).second << endl;
	}
};
