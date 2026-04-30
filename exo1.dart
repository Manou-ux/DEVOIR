import 'dart:io';

void main() {
  stdout.write("Entrez le nombre de termes (n) : ");
  String? input = stdin.readLineSync();
  
  if (input != null && int.tryParse(input) != null) {
    int n = int.parse(input);
    generateFibonacci(n);
  } else {
    print("Veuillez entrer un nombre entier valide.");
  }
}

void generateFibonacci(int n) {
  int a = 0, b = 1;
  List<int> sequence = [];

  for (int i = 0; i < n; i++) {
    sequence.add(a);
    int next = a + b;
    a = b;
    b = next;
  }
  
  // Utilisation de ${n} au lieu de $n$ pour éviter les erreurs de parsing
  print("Les ${n} premiers nombres de Fibonacci sont : ${sequence.join(', ')}");
}