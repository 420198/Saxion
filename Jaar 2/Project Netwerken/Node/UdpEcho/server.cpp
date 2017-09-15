#define PLATFORM_WINDOWS  1
#define PLATFORM_MAC      2
#define PLATFORM_LINUX    3

#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <iostream>
#include "../Handlers/MessageDecoderHandler.h"

#if defined(_WIN32)

#define PLATFORM PLATFORM_WINDOWS

#elif defined(__APPLE__)

#define PLATFORM PLATFORM_MAC

#else

#define PLATFORM PLATFORM_LINUX

#endif

#if PLATFORM == PLATFORM_WINDOWS

#include <winsock2.h>

#elif PLATFORM == PLATFORM_MAC || PLATFORM == PLATFORM_LINUX

#include <sys/socket.h>
#include <netinet/in.h>
#include <fcntl.h>
#include <arpa/inet.h>
#include <string>
//#include "../Handlers/MessageDecoderHandler.h"

#endif

#if PLATFORM == PLATFORM_WINDOWS

#pragma comment(lib,"ws2_32.lib")

#endif

#define PORTNUM 27015
#define BUFMAX 128

#if PLATFORM == PLATFORM_MAC || PLATFORM == PLATFORM_LINUX
void macLinuxEchoLoop(int, struct sockaddr*, socklen_t);
void macLinuxEchoServer();
#endif


#if PLATFORM == PLATFORM_WINDOWS

void windowsEchoLoop(SOCKET, sockaddr *, size_t);

int windowsEchoServer();

#endif

int main(int argc, char **argv) {
#if PLATFORM == PLATFORM_WINDOWS
    windowsEchoServer();
#else

    macLinuxEchoServer();

#endif

    puts("Press any key to continue");
    getc(stdin);

    return EXIT_SUCCESS;
}

bool validRequest(const std::string &msg) {
    std::string validRequest("{\"keyrequest\" : true}");
    return validRequest.compare(msg) == 0;
}

std::string trim(const std::string &str) {
    size_t first = str.find_first_not_of(' ');
    if (std::string::npos == first) {
        return str;
    }
    size_t last = str.find_last_not_of(' ');
    return str.substr(first, (last - first + 1));
}


#if PLATFORM == PLATFORM_MAC || PLATFORM == PLATFORM_LINUX

bool validateIpAddress(const std::string &ipAddress)
{
    struct sockaddr_in sa;
    int result = inet_pton(AF_INET, ipAddress.c_str(), &(sa.sin_addr));
    return result != 0;

}

void macLinuxEchoServer()
{
    int socketFileDescriptor;
    struct sockaddr_in serverAddr;
    struct sockaddr_in clientAddr;

    socketFileDescriptor = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);

    bzero(&serverAddr, sizeof(serverAddr));

    serverAddr.sin_family = AF_INET;
    serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);
    serverAddr.sin_port = htons(PORTNUM);

    bind(socketFileDescriptor, (struct sockaddr*)& serverAddr, sizeof(serverAddr));

    macLinuxEchoLoop(socketFileDescriptor, (struct sockaddr*)& clientAddr, sizeof(clientAddr));
}

void macLinuxEchoLoop(int sockFd, struct sockaddr* cliaddr, socklen_t clilen)
{
    socklen_t len;
    char msg[BUFMAX] = {0};

    printf("Waiting for datagrams on 127.0.0.1:%d\n", PORTNUM);

    while(true)
    {
        len = clilen;
        bzero(&msg, sizeof(msg)); //copy zeroes in string

        //receive!
        recvfrom(sockFd, msg, BUFMAX, 0, cliaddr, &len);

        std::cout << "Got message: " << msg << std::endl;

        std::string message(msg); //msg to string
        char messageToSendCharArray[128]; //make message to send array

        //ip address / digit! send to next server
        if(isdigit(msg[0])){
            //determine next IP address
            std::string nextIPAddress = trim(message.substr(0, 16));

            if(validateIpAddress(nextIPAddress)){
                char ipCharArray[16];
                strcpy(ipCharArray, nextIPAddress.c_str());

                std::cout << "Forwarding to " << nextIPAddress << std::endl; //print info

                //copy to msg to new chararray..
                strcpy(messageToSendCharArray, message.substr(16).c_str());

                //make object to send to
                struct sockaddr_in sendToAddr;
                sendToAddr.sin_family = AF_INET;
                sendToAddr.sin_port = htons(PORTNUM);

                //put in the correct IP..
                sendToAddr.sin_addr.s_addr = inet_addr(ipCharArray);
                inet_pton(AF_INET, ipCharArray, &sendToAddr.sin_addr);

                int sentResult = sendto(
                        socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP),
                        messageToSendCharArray,
                        strlen(messageToSendCharArray),
                        0,
                        (struct sockaddr*)&sendToAddr,
                        sizeof(sendToAddr)
                );

                if(sentResult < 0){
                    std::cerr << "Failed to forward!" << std::endl;
                }
            } else {
                std::cerr << "Invalid ip-address" << std::endl;
            }
        } else { //not an ip address! key request

            std::string messageToSend = "hierkomtdekey";
            strcpy(messageToSendCharArray, messageToSend.c_str());

            std::cout << "Sending key : " << messageToSend << std::endl;

            sendto(sockFd, messageToSendCharArray, messageToSend.size(), 0, cliaddr, len);
        }
    }
}

#endif

#if PLATFORM == PLATFORM_WINDOWS

#include <winsock2.h>
#include <ws2tcpip.h>


int inet_pton(int af, const char *src, void *dst) {
    struct sockaddr_storage ss;
    int size = sizeof(ss);
    char src_copy[INET6_ADDRSTRLEN + 1];

    ZeroMemory(&ss, sizeof(ss));
    /* stupid non-const API */
    strncpy(src_copy, src, INET6_ADDRSTRLEN + 1);
    src_copy[INET6_ADDRSTRLEN] = 0;

    if (WSAStringToAddress(src_copy, af, NULL, (struct sockaddr *) &ss, &size) == 0) {
        switch (af) {
            case AF_INET:
                *(struct in_addr *) dst = ((struct sockaddr_in *) &ss)->sin_addr;
                return 1;
            case AF_INET6:
                *(struct in6_addr *) dst = ((struct sockaddr_in6 *) &ss)->sin6_addr;
                return 1;
        }
    }
    return 0;
}

bool isValidIpAddress(char *st) {
    int num, i, len;
    char *ch;

    //counting number of quads present in a given IP address
    int quadsCnt = 0;

    printf("Split IP: \"%s\"\n", st);

    len = strlen(st);

    //  Check if the string is valid
    if (len < 7 || len > 15)
        return false;

    ch = strtok(st, ".");

    while (ch != NULL) {
        quadsCnt++;
        printf("Quald %d is %s\n", quadsCnt, ch);

        num = 0;
        i = 0;

        //  Get the current token and convert to an integer value
        while (ch[i] != '\0') {
            num = num * 10;
            num = num + (ch[i] - '0');
            i++;
        }

        if (num < 0 || num > 255) {
            printf("Not a valid ip\n");
            return false;
        }

        if ((quadsCnt == 1 && num == 0) || (quadsCnt == 4 && num == 0)) {
            printf("Not a valid ip, quad: %d AND/OR quad:%d is zero\n", quadsCnt, quadsCnt);
            return false;
        }

        ch = strtok(NULL, ".");
    }

    //  Check the address string, should be n.n.n.n format
    if (quadsCnt != 4) {
        printf("illegale ip");
        return false;
    }

    //  Looks like a valid IP address
    return true;
}

int windowsEchoServer() {
    SOCKET sock;
    sockaddr_in serverAddr;
    sockaddr_in clientAddr;
    WSADATA wsaDat;

    int wsaError = WSAStartup(MAKEWORD(2, 2), &wsaDat);

    if (!wsaError) {
        sock = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);

        ZeroMemory(&serverAddr, sizeof(serverAddr));

        serverAddr.sin_family = AF_INET;
        serverAddr.sin_addr.s_addr = htonl(INADDR_ANY);
        serverAddr.sin_port = htons(PORTNUM);

        bind(sock, (struct sockaddr *) &serverAddr, sizeof(serverAddr));

        windowsEchoLoop(sock, (struct sockaddr *) &clientAddr, sizeof(clientAddr));
    } else {
        return EXIT_FAILURE;
    }
}

void windowsEchoLoop(SOCKET sock, sockaddr *cliaddr, size_t clilen) {
    int bytesRead;
    int len;
    char msg[BUFMAX] = {0};
    char inputBuffer[BUFMAX] = {0};
    char recvBuffer[BUFMAX] = {0};
    int sendToResult;

    std::cout << "Waiting for datagrams on 127.0.0.1" << std::endl;

    for (;;) {
        len = clilen;
        ZeroMemory(&msg, sizeof(msg));

        bytesRead = recvfrom(sock, msg, BUFMAX, 0, cliaddr, &len);

        char messageToSendCharArray[128]; //make message to send array

        std::cout << "Got message: " << msg << std::endl;

        std::string message(msg);
        //ip address / digit! send to next server
        if (isdigit(msg[0])) {
            //determine next IP address
            std::string nextIPAddress = trim(message.substr(0, 16));

            char temp[16];
            strcpy(temp, nextIPAddress.c_str());

            if (isValidIpAddress(temp)) {
                char ipCharArray[16];
                strcpy(ipCharArray, nextIPAddress.c_str());

                std::cout << "Forwarding to " << nextIPAddress << std::endl; //print info

                //copy to msg to new chararray..
                strcpy(messageToSendCharArray, message.substr(16).c_str());

                //make object to send to
                sockaddr_in sendToAdress;
                sendToAdress.sin_family = AF_INET;
                sendToAdress.sin_addr.s_addr = inet_addr(ipCharArray);
                sendToAdress.sin_port = htons(PORTNUM);
                inet_pton(AF_INET, ipCharArray, &sendToAdress.sin_addr);

                sendToResult = sendto(sock, messageToSendCharArray, strlen(messageToSendCharArray), 0,
                                      (SOCKADDR *) &sendToAdress, sizeof(sendToAdress));

                if (sendToResult == SOCKET_ERROR) {
                    wprintf(L"sendto failed with error: %d\n", WSAGetLastError());
                    closesocket(sock);
                    WSACleanup();

                    puts("Press any key to continue");
                    getc(stdin);
                    exit(sendToResult);
                }

                bytesRead = recvfrom(sock, recvBuffer, BUFMAX, 0, NULL, NULL);

                if (bytesRead == SOCKET_ERROR) {
                    wprintf(L"recvfrom failed with error: %d\n", WSAGetLastError());
                    closesocket(sock);
                    WSACleanup();

                    puts("Press any key to continue");
                    getc(stdin);
                    exit(sendToResult);
                }

            } else {
                std::cout << "n00b" << std::endl;
            }
        } else {
            std::string messageToSend = "hierkomtdekey";
            strcpy(messageToSendCharArray, messageToSend.c_str());

            if (validRequest(msg)) {
                std::cout << "Sending key : " << messageToSend << std::endl;
                sendto(sock, messageToSendCharArray, messageToSend.size(), 0, cliaddr, len);
            } else {
                std::cout << "Illegal request" << std::endl;
            }
        }
    }
}


#endif
