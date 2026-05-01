import java.io.*;
import java.net.*;

class ServeurTCP {
    public static void main(String args[]) throws Exception {
        try {
            ServerSocket socketEcoute = new ServerSocket(Integer.parseInt(args[0]));
            
            while(true) {
                Socket socketConnexion = socketEcoute.accept();
                
                BufferedReader entreeDepuisClient = new BufferedReader(
                    new InputStreamReader(socketConnexion.getInputStream()));
                DataOutputStream sortieVersClient = new DataOutputStream(
                    socketConnexion.getOutputStream());
                
                // NOUVELLE BOUCLE : Tant que ce client envoie des messages
                String phraseClient;
                while ((phraseClient = entreeDepuisClient.readLine()) != null) {
                    
                    System.out.println("From: " + socketConnexion.getInetAddress() + " Message: " + phraseClient);
                    
                    String phraseMajuscule = phraseClient.toUpperCase() + '\n';
                    sortieVersClient.writeBytes(phraseMajuscule);
                }
                
                // Le client a fermé la connexion, on ferme la socket de session
                socketConnexion.close();
            } 
        } catch (Exception e) {
            System.err.println(e);
        }
    }
}