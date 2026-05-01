/////////////////////////Addition de deux nombres///////////////

//Créer les contrôleurs
TextEditingController c1 = TextEditingController();
TextEditingController c2 = TextEditingController();

//Champs de texte
TextField(controller: c1),
TextField(controller: c2),

//Bouton + calcul
ElevatedButton(
  onPressed: () {
    int n1 = int.parse(c1.text);
    int n2 = int.parse(c2.text);

    int somme = n1 + n2;

    print(somme);
  },
  child: Text("Calculer"),
)

//parse convertit texte → nombre
//erreurs si champ vide !