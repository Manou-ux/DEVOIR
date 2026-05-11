int plusGrandeDifference(List<int> nombres) {
  if (nombres.length < 2) return 0;
  int maxDiff = 0;
  for (int i = 0; i < nombres.length - 1; i++) {
    int diff = (nombres[i] - nombres[i + 1]).abs();
    if (diff > maxDiff) maxDiff = diff;
  }
  return maxDiff;
}

void main() {
  var liste = [10, 2, 5, 15, 3];
  print("Liste : $liste");
  print("La plus grande différence consécutive est : ${plusGrandeDifference(liste)}");
}