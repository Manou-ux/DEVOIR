import java.io.*;
import java.net.*;

class ClientTCP {
    public static void main(String args[]) throws Exception {
        String phrase, phraseModifiee;
        BufferedReader entreeDepuisUtilisateur = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            //creer le flux d'entrer
            Socket socketClient = new Socket(args[0], Integer.parseInt(args[1]));
            DataOutputStream sortieVersServeur = new DataOutputStream(socketClient.getOutputStream());
            BufferedReader entreeDepuisServeur = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));
            
            // Boucle infinie pour envoyer plusieurs messages
            while (true) {
                phrase = entreeDepuisUtilisateur.readLine();
                if (phrase == null) break; // Arrêt si Ctrl+C ou flux fermé
                //envoyer la chaine au serveur
                sortieVersServeur.writeBytes(phrase + '\n');
                //lire chaine depuis serveur
                phraseModifiee = entreeDepuisServeur.readLine();
                System.out.println("reponse serveur: " + phraseModifiee);
            }
            
            socketClient.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}