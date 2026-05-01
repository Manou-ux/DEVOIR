//////////////////Ajouter un compteur de caractères//////////////

//Méthode 1 : avec maxLength

TextField(
  maxLength: 20,
)
//Flutter ajoute automatiquement le compteur


//----------------------------------------------

//Méthode 2 : avec counterText personnalisé

TextField(
  maxLength: 20,
  decoration: InputDecoration(
    counterText: "0/20",
  ),
)
//✔️ Permet de personnaliser le texte