import java.net.*;
import java.io.*;

public class ClientUDP {
    public static void main(String[] args) {
        try {
            BufferedReader clavier = new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket socket = new DatagramSocket();

            InetAddress serveur = InetAddress.getByName("localhost");

            System.out.println("Tape un message :");

            String message = clavier.readLine();
            byte[] sendData = message.getBytes();

            DatagramPacket packet = new DatagramPacket(
                    sendData, sendData.length, serveur, 9876);

            socket.send(packet);

            // recevoir réponse
            byte[] buffer = new byte[1024];
            DatagramPacket response = new DatagramPacket(buffer, buffer.length);

            socket.receive(response);

            String reponse = new String(response.getData(), 0, response.getLength());
            System.out.println("Serveur: " + reponse);

            socket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}