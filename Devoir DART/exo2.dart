String transformerChaine(String texte) {
  List<String> chiffres = texte.split('').where((char) => RegExp(r'[0-9]').hasMatch(char)).toList();
  List<String> chiffresInverses = chiffres.reversed.toList();
  int indexChiffre = 0;
  StringBuffer resultat = StringBuffer();

  for (int i = 0; i < texte.length; i++) {
    String char = texte[i];
    if (RegExp(r'[a-zA-Z]').hasMatch(char)) {
      resultat.write(char == char.toUpperCase() ? char.toLowerCase() : char.toUpperCase());
    } else if (RegExp(r'[0-9]').hasMatch(char)) {
      resultat.write(chiffresInverses[indexChiffre++]);
    } else {
      resultat.write(char);
    }
  }
  return resultat.toString();
}

void main() {
  String test = "Hello123World!";
  print("Original : $test");
  print("Transformé : ${transformerChaine(test)}");
}