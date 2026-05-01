import java.net.*;
import java.io.*;

public class UDPReceiver {
    public static void main(String[] args) {
        boolean done = false;
        try {
            // Construction d'un DatagramSocket
            int port = Integer.parseInt(args[0]);
            DatagramSocket ds = new DatagramSocket(port);
            
            // Construction d'un DatagramPacket
            int len = Integer.parseInt(args[1]);
            byte[] buffer = new byte[len];
            DatagramPacket incomingPacket = new DatagramPacket(buffer, buffer.length);
            
            System.out.println("Serveur en attente sur le port " + port + "...");

            while (!done) {
                ds.receive(incomingPacket);
                String s = new String(incomingPacket.getData(), 0, incomingPacket.getLength());
                
                System.out.println(incomingPacket.getAddress() 
                    + "(Client) sur le port " + incomingPacket.getPort() + " a dit: " + s);
                
                // Optionnel : condition pour arrêter la boucle
                if (s.trim().equalsIgnoreCase("quit")) done = true;
            }
            ds.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}