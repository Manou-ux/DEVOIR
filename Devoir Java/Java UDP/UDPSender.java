import java.net.*;
import java.io.*;

public class UDPSender {
    public static void main(String[] args) {
        BufferedReader stdin; // input du clavier
        String sendString;    // string à envoyer
        byte[] sendBytes;     // octets à envoyer

        try {
            InetAddress receiver = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]);
            
            DatagramSocket theSocket = new DatagramSocket();
            stdin = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Ecrit un message (Taper Entrer pour envoyer, ctrl-C pour quitter):");
            
            while ((sendString = stdin.readLine()) != null) {
                sendBytes = sendString.getBytes();
                
                // Création du paquet avec les données, l'adresse et le port
                DatagramPacket thePacket = new DatagramPacket(sendBytes, sendBytes.length, receiver, port);
                
                // Envoi du paquet
                theSocket.send(thePacket);
                
                if (sendString.equalsIgnoreCase("quit")) break;
            }
            theSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}