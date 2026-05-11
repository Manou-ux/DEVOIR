int trouverLePlusFrequent(List<int> nombres) {
  if (nombres.isEmpty) return 0;
  Map<int, int> occurrences = {};
  for (var n in nombres) {
    occurrences[n] = (occurrences[n] ?? 0) + 1;
  }
  int plusFrequent = nombres[0];
  int maxCount = 0;
  occurrences.forEach((nombre, count) {
    if (count > maxCount) {
      maxCount = count;
      plusFrequent = nombre;
    }
  });
  return plusFrequent;
}

void main() {
  var liste = [1, 3, 2, 3, 4, 3, 5, 2];
  print("Liste : $liste");
  print("Le nombre le plus fréquent est : ${trouverLePlusFrequent(liste)}");
}