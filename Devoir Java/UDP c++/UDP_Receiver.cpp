#include <iostream>
#include <winsock2.h>

#pragma comment(lib, "ws2_32.lib") // Liaison avec la bibliothèque réseau

int main(int argc, char* argv[]) {
    if (argc < 3) {
        std::cerr << "Usage: " << argv[0] << " <port> <buffer_size>" << std::endl;
        return 1;
    }

    WSADATA wsaData;
    WSAStartup(MAKEWORD(2, 2), &wsaData);

    SOCKET ds = socket(AF_INET, SOCK_DGRAM, 0);
    
    sockaddr_in serverAddr;
    serverAddr.sin_family = AF_INET;
    serverAddr.sin_addr.s_addr = INADDR_ANY;
    serverAddr.sin_port = htons(atoi(argv[1]));

    bind(ds, (struct sockaddr*)&serverAddr, sizeof(serverAddr));

    int len = atoi(argv[2]);
    char* buffer = new char[len];
    sockaddr_in clientAddr;
    int clientLen = sizeof(clientAddr);

    std::cout << "Serveur C++ en attente sur le port " << argv[1] << "..." << std::endl;

    while (true) {
        int bytesReceived = recvfrom(ds, buffer, len, 0, (struct sockaddr*)&clientAddr, &clientLen);
        if (bytesReceived > 0) {
            buffer[bytesReceived] = '\0'; // Fin de chaîne
            std::cout << "Client dit: " << buffer << std::endl;
            if (std::string(buffer) == "quit") break;
        }
    }

    closesocket(ds);
    WSACleanup();
    delete[] buffer;
    return 0;
}