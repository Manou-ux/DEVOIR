#include <iostream>
#include <winsock2.h>
#include <string>

#pragma comment(lib, "ws2_32.lib")

int main(int argc, char* argv[]) {
    if (argc < 3) {
        std::cerr << "Usage: " << argv[0] << " <ip> <port>" << std::endl;
        return 1;
    }

    WSADATA wsaData;
    if (WSAStartup(MAKEWORD(2, 2), &wsaData) != 0) {
        std::cerr << "Erreur d'initialisation Winsock" << std::endl;
        return 1;
    }

    SOCKET theSocket = socket(AF_INET, SOCK_DGRAM, IPPROTO_UDP);
    if (theSocket == INVALID_SOCKET) {
        std::cerr << "Erreur de creation du socket" << std::endl;
        WSACleanup();
        return 1;
    }

    sockaddr_in receiverAddr;
    receiverAddr.sin_family = AF_INET;
    receiverAddr.sin_port = htons(atoi(argv[2])); // Utilise l'argument 2 pour le port
    receiverAddr.sin_addr.s_addr = inet_addr(argv[1]); // Utilise l'argument 1 pour l'IP

    std::string sendString;
    std::cout << "Begin typing (return to send, 'quit' to stop): " << std::endl;

    while (std::getline(std::cin, sendString)) {
        int result = sendto(theSocket, sendString.c_str(), sendString.length(), 0, (struct sockaddr*)&receiverAddr, sizeof(receiverAddr));
        
        if (result == SOCKET_ERROR) {
            std::cerr << "Erreur d'envoi: " << WSAGetLastError() << std::endl;
        }

        if (sendString == "quit") break;
    }

    closesocket(theSocket);
    WSACleanup();
    return 0;
}