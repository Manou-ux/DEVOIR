//Client/Serveur TCP Multi-clients

//a) Synchronisation des threads : Le serveur doit utiliser une liste synchronisée (ou un bloc
// synchronized) pour stocker les flux de sortie de tous les clients connectés afin d'éviter des conflits lors 
// de l'envoi simultané d'un message à tout le groupe.

//b) Code Serveur (Extrait logique)
// Dans le thread de gestion client du serveur

while ((msg = in.readLine()) != null) {
    for (PrintWriter writer : allClientWriters) {
        writer.println(msg); // Diffusion à tous [cite: 23]
    }
}