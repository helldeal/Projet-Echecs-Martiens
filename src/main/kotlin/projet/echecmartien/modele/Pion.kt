package projet.echecmartien.modele


/**
 * Classe Pion
 */
open class Pion {
	/**
	 * récupère la valeur du score d'un pion
	 * @return la valeur du score
	 */
	open fun getScore():Int{
		return 3
	}


	/**
	 * donne le chemin de coordonnées que constitue le déplacement
	 * du point de départ vers le point d'arrivée. Les déplacements autorisés sont horizontaux, verticaux, diagonaux.
	 *
	 * @param deplacement le déplacement
	 * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée.
	 * La liste ne contient pas les coordonnées du point de départ.
	 *
	 * @throws DeplacementException est levée si le déplacement n'est pas possible
	 */
	open fun getDeplacement(deplacement: Deplacement):List<Coordonnee> {
		if (deplacement.estDiagonal()) return deplacement.getCheminDiagonal()
		if (deplacement.estVertical()) return deplacement.getCheminVertical()
		if (deplacement.estHorizontal()) return deplacement.getCheminHorizontal()
		throw DeplacementExeption("Déplacement invalide")
	}
}