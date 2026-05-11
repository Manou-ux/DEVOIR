//Somme de deux nombres (Optimisé $O(n)$)

void main() {
  List<int> nombres = [2, 4, 6, 3, 1, 5];
  int cible = 7;
  
  List<List<int>> resultats = findPairs(nombres, cible);
  print("Input : $nombres, $cible");
  print("Output : $resultats");
}

List<List<int>> findPairs(List<int> nums, int sum) {
  List<List<int>> pairs = [];
  Set<int> vus = {}; // Stocke les nombres déjà rencontrés

  for (int nombre in nums) {
    int complement = sum - nombre;
    
    if (vus.contains(complement)) {
      pairs.add([complement, nombre]);
    }
    
    vus.add(nombre);
  }
  
  return pairs;
}