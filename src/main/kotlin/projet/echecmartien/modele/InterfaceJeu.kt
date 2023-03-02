package projet.echecmartien.modele



interface InterfaceJeu {
    /**
     * initialise la partie
     * @param joueur1 le premier joueur
     * @param joueur2 le second joueur
     * @param nombreCoupsSansPriseMax utilisé pour arrêter le jeu
     */
    fun initialiserPartie(joueur1: Joueur, joueur2: Joueur, nombreCoupsSansPriseMax: Int)

    /**
     * teste si le pion dont on passe en paramètre les coordonnées est éligible à un déplacement
     * @param coordOrigineX la coordonnee x du pion
     * @param coordOrigineY la coordonnee y du pion
     *@return true si le pion peut se déplacer, false sinon
     */
    fun deplacementPossible(coordOrigineX: Int,
                            coordOrigineY: Int    ): Boolean



    /**
     * Teste les préconditions relatives au déplacement d'un pion dans la grille de jeu <br></br>
     *
     *
     * @param coordOrigineX coordonnée horizontale du point de départ
     * @param coordOrigineY coordonnée verticale du point de départ
     * @param coordDestinationX coordonnée horizontale du point d'arrivée
     * @param coordDestinationY coordonnée verticale du point d'arrivée
     * @param joueur le joueur qui demande le déplacement
     * @return true si les préconditions de déplacement sont vérifiées
     * @throws DeplacementException si le déplacement n'est pas possible
     */
    fun deplacementPossible(
        coordOrigineX: Int,
        coordOrigineY: Int, coordDestinationX: Int, coordDestinationY: Int,
        joueur: Joueur?
    ): Boolean

    /**
     * Effectue le déplacement d'un pion en modifiant ses coordonnées (coordonnées de départ) qui prennent pour valeur les coordonnées d'arrivée. <br></br>Si un pion adverse a pour coordonnées, les coordonnées d'arrivée du pion déplacé alors il est capturé.
     * <br></br>préconditions: le déplacement est potentiellement possible dans la grille de jeu
     *
     * @param coordOrigineX
     * la coordonnée horizontale de la case dont le joueur veut
     * déplacer le pion
     * @param coordOrigineY
     * la coordonnée verticale de la case dont le joueur veut déplacer le pion
     * @param coordDestinationX
     * la coordonnée horizontale de la case où le joueur veut déplacer le pion
     * @param coordDestinationY
     * la coordonnée verticale de la case où le joueur veut déplacer le pion
     *
     *
     */
    fun deplacer(
        coordOrigineX: Int, coordOrigineY: Int,
        coordDestinationX: Int, coordDestinationY: Int
    )
    /**
     * donne le joueur gagnant
     *
     * @return le joueur gagnant ou null si les 2 joueurs sont ex aequo
     */
    fun joueurVainqueur(): Joueur?


}