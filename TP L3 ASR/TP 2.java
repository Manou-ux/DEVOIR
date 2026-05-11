//Manipulation de flux et Sockets TCP simples

//1. a) Lecture clavier avec Scanner

import java.util.Scanner;

public class ReadStop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String line = sc.nextLine();
            if (line.equals("stop")) break;
            System.out.println(line);
        }
    }
}


//1. b) Copie de fichier avec PrintStream
import java.util.*;
import java.io.*;

public class FileCopy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String in = sc.next();
        String out = sc.next();
        Scanner fileReader = new Scanner(new File(in));
        PrintStream ps = new PrintStream(new FileOutputStream(out));
        while(fileReader.hasNextLine()) ps.println(fileReader.nextLine());
    }
}


//2. Communication TCP (A transmet à B)

    //Protocole de terminaison : Pour arrêter proprement, A envoie la chaîne "stop" via la socket. B, en recevant "stop", ferme sa connexion et s'arrête.

    //Code pour A (Client)
Socket s = new Socket("localhost", 1027);
PrintWriter out = new PrintWriter(s.getOutputStream(), true);
Scanner sc = new Scanner(System.in);
String msg = "";
while (!msg.equals("stop")) {
    msg = sc.nextLine();
    out.println(msg);
}
s.close();



