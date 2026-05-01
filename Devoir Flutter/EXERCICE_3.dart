///////////////Plusieurs TextField dans un Container/////////

    //Oui c’est possible avec Column

Container(
  padding: EdgeInsets.all(20),
  child: Column(
    children: [
      TextField(
        decoration: InputDecoration(labelText: "Nom"),
      ),
      TextField(
        decoration: InputDecoration(labelText: "Prénom"),
      ),
      TextField(
        decoration: InputDecoration(labelText: "Email"),
      ),
    ],
  ),
)


//Column permet d’empiler les champs
//Tu peux ajouter SizedBox(height: 10) pour espacer