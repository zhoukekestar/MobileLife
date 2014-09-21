App_net.cxx 
This is network application. Receive message from server. And write message to "recv.pipe". OR read message from "send.pipe" then send message to server.

App.cpp
This program is a control program. Read message from "recv.pipe" and execute command. OR write message to "send.pipe" if there are some message want to send to server.






