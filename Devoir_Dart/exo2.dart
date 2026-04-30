//Comptage des voyelles

import 'dart:io';

void main() {
  stdout.write("Entrez une phrase : ");
  String phrase = stdin.readLineSync() ?? "";
  
  int count = countVowels(phrase);
  print("Le nombre de voyelles dans votre phrase est : $count");
}

int countVowels(String text) {
  // Définition des voyelles
  final vowels = RegExp(r'[aeiouyAEIOUY]');
  return vowels.allMatches(text).length;
}