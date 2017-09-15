#define WIN32_LEAN_AND_MEAN
#include <WinSock2.h>
#include <WS2tcpip.h>
#include <sys/types.h>
#include <stdio.h>
#include <thread>
#include <iostream>
#include <string>
#include <sys/socket.h>

#pragma comment (lib,"Ws2_32.lib")

void sender();
void receiver(SOCKET s);
int main() {
	WSADATA wsa;
	SOCKET s = INVALID_SOCKET;
	struct sockaddr_in server;

	if (WSAStartup(MAKEWORD(2, 2), &wsa) != 0) {
		return 1;
	}

	//Create a socket
	s = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
	if (s == INVALID_SOCKET) {
		WSACleanup();
		return 1;
	}

	server.sin_family = AF_INET;
	server.sin_addr.s_addr = ADDR_ANY;
	server.sin_port = htons(27015);

	//Bind socket
	if (bind(s, (SOCKADDR *)&server, sizeof(server)) == SOCKET_ERROR) {
		WSACleanup();
		return 1;
	} else {
		std::thread recvT(receiver,s);
		std::thread sendT(sender);

		try {
			recvT.join();
			sendT.join();
		}
		catch (std::system_error &e) {
			std::cerr << "Error: " << e.what() << std::endl;
		}
	}

	return 0;
}

void sender() {
}

void receiver(SOCKET s) {
	char buf[1024];
	int iResult;
	while(true)
	{
		std::cout << "Sout" << std::endl;
		iResult = recv(s, buf, 1024, 0);
		if (iResult <= 0) {
			std::cout << "Sout" << std::endl;
			break;
		}
		buf[iResult] = '\0';
		std::cout << "Recv: " << std::endl;
	}
	std::cout << "Sout" << std::endl;
}