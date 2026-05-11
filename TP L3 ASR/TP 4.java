//InetAddress et Architecture Réseau

//1. Affichage IP et résolution DNS
System.out.println(InetAddress.getLocalHost().getHostAddress());
Scanner sc = new Scanner(System.in);
while(true) {
    String name = sc.next();
    if(name.equals("stop")) break;
    System.out.println(InetAddress.getByName(name).getHostAddress());
}

//4. a) Raisons du choix d'architecture (Proxy/Passerelle) :  

//  1- Sécurité : Isoler le réseau local de l'extérieur.
//  2 - Performance : Centraliser les requêtes pour réduire le trafic sortant (mise en cache).
//  3 - Contrôle : Surveiller l'activité des machines actives depuis un point unique.