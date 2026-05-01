/////////////////Centrer un TextField///////////////////

//Méthode 1 : avec Center

Center(
  child: TextField(),
)

//Simple et direct
//Centre automatiquement dans l’écran

//------------------------------------

//Méthode 2 : avec Align

Align(
  alignment: Alignment.center,
  child: TextField(),
)

//Plus flexible (tu peux changer la position)
//Un peu plus long que Center