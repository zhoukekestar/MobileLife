#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <netdb.h>
#include <iostream>
#include <vector>
#include <errno.h>
#include <sys/types.h>
#include <signal.h>
#include <string>
#include <vector>

#include "http.hpp"

using namespace std;

int simpleHttp::rev()
{
	if (debug)
		cout << "[ rev() ]" << endl;

    header.clear();
    res.clear();

	int n, rv, r;
	fd_set readfds;
	struct timeval tv;

	FD_ZERO(&readfds);
	FD_SET(s, &readfds);

	n = s + 1;

	tv.tv_sec = 3; //Timeout in seconds for recv().
	tv.tv_usec = 0;

	bool haveHeader = false;

	for (size_t i = 0; rv = select(n, &readfds, NULL, NULL, &tv); i++)
	{

		if (rv <= 0)
			break;

		char buf[5000];
		r = recv(s, buf, sizeof buf, 0);

		if (r <= 0)
			break;

		string str = string(buf);


		if (( str.find("\r\n\r\n") != string::npos) && (haveHeader == false ))
		{
			size_t headerEnd = str.find("\r\n\r\n") + 3;

			header = str.substr(0, headerEnd);

			parseHeaders(header);
			getCookies(header);
			res += str.substr(headerEnd, str.size() - headerEnd);

			haveHeader = true;
		}
		else
		{
			res += str;
		}
	}

	string headres;
	getHeaderValue("Connection", headres);
	if ((headres == "close") || (headres.empty())) //Make new socket if server asks us to close connection.
		reCreateSocket();

	if (r <= 0)
		return r - 2;
	if (rv < 0)
		return rv;
	return 1;
}

int simpleHttp::doSend(string tmp)
{
/*
    int len = 0;
    string toBeSent = tmp.substr(len, tmp.size());

    while(len = send(s, toBeSent.c_str(), toBeSent.size(), 0) > 0 )
    {
        if ( len == tmp.size())
            break;
        toBeSent = tmp.substr(len, tmp.size() - len);
    }
*/
    return send(s, tmp.c_str(), tmp.size(), 0);

}


int simpleHttp::GET(string q, string cookies)
{
	if (debug)
		cout << "[ GET(" + q + ") ]" << endl;
	string str = "GET " + q + " HTTP/1.1\r\nHost: " + host + "\r\n" + cookies + "Connection: keep-alive\r\n\r\n";
	if (doSend(str) > 0)
		if (revstatus)
			return rev();
	return 0;
}

int simpleHttp::POST(std::string path, std::string q, string cookies)
{
	if (debug)
		cout << "[ POST(" << path << ", " << q << + ") ]"  << endl;

	string str = "POST " + path + " HTTP/1.1\r\nHost: " + host + "\r\n" + cookies + "Content-Type: application/x-www-form-urlencoded\r\nContent-Length:" + to_string(q.size()) + "\r\nConnection: keep-alive\r\n\r\n" + q;
	if (doSend(str) > 0)
		if (revstatus)
			return rev();
	return 0;
}


int simpleHttp::HEAD(string q, string cookies)
{
	string tmp;
	if (debug)
		cout << "[ HEAD(" << q << ") ]" << endl;
	string str = "HEAD " + q + " HTTP/1.1\r\nHost: " + host + "\r\n" + cookies + "Connection: keep-alive\r\n\r\n";
	if (doSend(str) > 0)
		return rev();
	return 0;
}


int simpleHttp::openConnection(string _host, string _port)
{

    if (debug) { std::cout << "[ openConnection(" << _host << ", " << _port << ") ]" << std::endl; }

	if ((!host.empty()) && (host != _host))
		clearCookies();

	struct addrinfo hints;
	struct addrinfo *servinfo;

	host = _host;
	port = _port;

	memset(&hints, 0, sizeof hints);
	hints.ai_family = AF_UNSPEC;
	hints.ai_socktype = SOCK_STREAM;

	if (getaddrinfo(host.c_str(), port.c_str(), &hints, &servinfo) != 0) { return -2; }

	s = socket (servinfo->ai_family, servinfo->ai_socktype, servinfo->ai_protocol);

	if (s == -1) { return -1; }

	if (connect(s, servinfo->ai_addr, servinfo->ai_addrlen) != 0) { return -3; }
	freeaddrinfo(servinfo);

	return 1;
}

int simpleHttp::reCreateSocket()
{
    if (debug) { std::cout << "[ reCreateSocket() ]" << std::endl; }
	close(s);
	return openConnection(host, port);
}


void simpleHttp::toggleDebug(bool val)
{
	Headers::toggleDebug(val);
	Cookies::toggleDebug(val);
	debug = val;
}
void simpleHttp::toggleRevStatus(bool val) { revstatus = val; }
std::string simpleHttp::returnResult() { return res; }
