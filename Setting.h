#include <iostream>
#include <fstream>
#include <map>

using namespace std;

class Setting
{
private:
	static void trim(string& str )
	{
	    int s = str.find_first_not_of(" ");
	    int e = str.find_last_not_of(" ");
	    e = e - s + 1;
	    if (s >= 0 && e >= 0)
		    str = str.substr(s, e);
	    return ;
	}
public:
	static map<string, string> getSetting(string file)
	{
		map<string, string> setting;
		ifstream fin(file.c_str());
		string temp;
		
		while (getline(fin, temp))
		{
			trim(temp);
			if (temp.length() != 0)
			{
				int index = temp.find("=");
				string key = temp.substr(0, index);
				string value = temp.substr(index + 1, temp.length());
				setting[key] = value;
			}
		}
		return setting;
	}
};
