//TP 1 : Conversion du code Multicast Java en C++
//Ce code utilise les sockets BSD standards pour reproduire le comportement du fichier

//Émetteur Multicast (C++)#include <iostream>
#include <sys/types.h>
#include <sys/socket.h>
#include <netinet/in.h>
#include <arpa/inet.h>
#include <string>
#include <cstring>

int main(int argc, char* argv[]) {
    if (argc < 3) return 1;
    
    int sock = socket(AF_INET, SOCK_DGRAM, 0);
    struct sockaddr_in addr;
    memset(&addr, 0, sizeof(addr));
    addr.sin_family = AF_INET;
    addr.sin_addr.s_addr = inet_addr(argv[1]);
    addr.sin_port = htons(std::stoi(argv[2]));

    std::string msg;
    std::cout << "Begin typing (Ctrl+D to quit):" << std::endl;
    while (std::getline(std::cin, msg)) {
        sendto(sock, msg.c_str(), msg.length(), 0, (struct sockaddr*)&addr, sizeof(addr));
    }
    return 0;
}
