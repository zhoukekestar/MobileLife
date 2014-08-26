simpleHttp
==========

Easy to use HTTP client class made with C++ and POSIX, feel free to fork and send pull request(s).

Example:
```
#include <iostream>
#include <string>

#include "./simpleHttp/http.hpp"

using namespace std;

int main()
{

  cout << "Start: " << time(0) << endl;

  string server = "www.google.com";
  string port = "80";

  simpleHttp Client;

  Client.toggleDebug(true);

  Client.openConnection(server, port);
  Client.GET("/");


  cout << Client.returnCookies() << endl;
  cout << Client.returnHeaders() << endl;
  cout << Client.returnResult() << endl;

  Client.toggleRevStatus(false); // We wont revive data from requests now.
  Client.GET("/", "Set-cookie: SSID=myinvalidsessios"); //We can use our own cookie value(s).
  Client.forceCookie("SSID", "newvalue"); //Forces new value to cookie, this wont be changed if server sends another value.

  Client.toggleRevStatus(); //Now we want to revive data from requests.
  Client.GET("/"); //Now we send cookies using Cookies::returnCookies().
  cout << "Client.returnResult():" <<  Client.returnResult() << endl;

  std::string value;
  if (Client.getCookieValue("SSID", value) == 1)
    cout << "Value of cookie \"SSID\" is " << value << endl;

  return 1;
}
```

Todo:
=====
–Add HTTP authentication support.
–Add SSl support.
–Sepreate cookies by site(now cookies will be deleted if connectin is opened to new domain).
–Replace POSIX things with Boost:asio.
–Find out why this can't bee seen right on github.

Issues:
=======
-Seems like some extra data is addded to end of result in rev().
