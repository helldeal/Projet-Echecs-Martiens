package projet.echecmartien.modele

import kotlin.math.abs


/**
 * cette classe permet de tester les déplacements sur le plateau de jeu
 *
 */

class Deplacement(origine:Coordonnee,destination:Coordonnee) {

    private var origine:Coordonnee
    private var destination:Coordonnee
    /**
     * dans le constructeur la validité du déplacement dans la grille est testée
     *@throws DeplacementException si le déplacement n'est ni horizontal, ni vertical est ni diagonal
     * les autres cas lèvent une IllegalArgumentException (peut être mis en place avec "require")
     */
    init {
        this.origine=origine
        this.destination=destination
        if (!estHorizontal()&&!estDiagonal()&&!estVertical())throw DeplacementExeption("Déplacement invalide (direction)")
    }

    /**
     * getter
     * @return la destination de ce déplacement
     */
    fun getDestination():Coordonnee{
        return destination
    }


    /**
     * getter
     * @return l'origine de ce déplacement
     */
    fun getOrigine():Coordonnee{
       return origine
    }

    /**
     *méthode qui permet de tester si le déplacement est horizontal
     * @return true si le déplacement est horizontal, false sinon
     */
    fun estHorizontal() : Boolean {
        if (destination.getY()==origine.getY()&&destination.getX()!=origine.getX()) return true
        return false
    }

    /**
     *méthode qui permet de tester si le déplacement est vertical
     * @return true si le déplacement est vertical, false sinon
     */
    fun estVertical(): Boolean {
        if (destination.getX()==origine.getX()&&destination.getY()!=origine.getY()) return true
        return false
    }

    /**
     * méthode qui permet de tester si le déplacement est diagonal
     * @return true si le déplacement est diagonal, false sinon
     */
    fun estDiagonal():Boolean {
       if (abs(destination.getY()-origine.getY()) == abs(destination.getX()-origine.getX()) ) return true
        return false
    }

    /**
     *méthode qui permet de calculer le nombre de case d'un déplacement
     * @return le nombre de case que le pion sera déplacée
     */
    fun longueur(): Int {
        if (estDiagonal()) return abs(destination.getY()-origine.getY())
        if (estHorizontal()) return abs(destination.getX()-origine.getX())
        return abs(destination.getY()-origine.getY())
    }


    /**
     * méthode qui permet de déterminer le sens d'un déplacement vertical
     *
     *@return true si le déplacement est positif, false sinon
     */
    fun estVerticalPositif():Boolean{
        return estVertical()&&destination.getY()-origine.getY()>0
    }

    /**
     * méthode qui permet de déterminer le sens d'un déplacement horizontal
     *
     * @return true si le déplacement est positif, false sinon
     */
    fun estHorizontalPositif():Boolean{
        return estHorizontal()&&destination.getX()-origine.getX()>0
    }

    /**
     * méthode qui permet de déterminer si le sens d'un déplacement diagonal est positif en X et en Y
     *
     * @return true si le déplacement est positif en X et Y, false sinon
     */
    fun estDiagonalPositifXPositifY(): Boolean{
        return estDiagonal()&&destination.getX()-origine.getX()>0&&destination.getY()-origine.getY()>0
    }
    /**
     * méthode qui permet de déterminer si le sens d'un déplacement diagonal est négatif en X et positif en Y
     *
     * @return true si le déplacement est négatif en X et positif en Y, false sinon
     */
    fun estDiagonalNegatifXPositifY(): Boolean{
        return estDiagonal()&&destination.getX()-origine.getX()<0&&destination.getY()-origine.getY()>0
    }

    /**
     *
     * méthode qui permet de déterminer si le sens d'un déplacement diagonal est positif en X et négatif en Y
     *
     * @return true si le déplacement est positif en X et négatif en Y, false sinon
     */
    fun estDiagonalPositifXNegatifY(): Boolean{
        return estDiagonal()&&destination.getX()-origine.getX()>0&&destination.getY()-origine.getY()<0
    }

    /**
     * méthode qui permet de déterminer si le sens d'un déplacement diagonal est négatif en X et négatif en Y
     *
     * @return true si le déplacement est négatif en X et négatif en Y, false sinon
     */
    fun estDiagonalNegatifXNegatifY(): Boolean{
        return estDiagonal()&&destination.getX()-origine.getX()<0&&destination.getY()-origine.getY()<0
    }

    /**
     * donne le chemin de coordonnées que constitue le déplacement
     * du point de départ vers le point d'arrivée si le déplacement demandé est vertical.
     *
     * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée
     * si le déplacement est vertical. Le point de départ n'est pas stocké dans la liste.
     * @throws DeplacementException est levée si le déplacement n'est pas vertical
     */
    fun getCheminVertical(): List<Coordonnee> {
        if (!estVertical())throw DeplacementExeption("déplacement n'est pas vertical")
        var list= listOf<Coordonnee>()
        for (i in 0..longueur()){
            if (estVerticalPositif()) list+=Coordonnee(origine.getX(),origine.getY()+i)
            else list+=Coordonnee(origine.getX(),origine.getY()-i)
        }
        return list
    }


    /**
     * donne le chemin de coordonnées que constitue le déplacement
     * du point de départ vers le point d'arrivée si le déplaceme{"origine Y dépasse"}nt demandé est horizontal.
     *
     * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée.
     * Le point de départ n'est pas stocké dans la liste.
     * si le déplacement est horizontal
     * @throws DeplacementException est levée si le déplacement n'est pas horizontal
     */
    fun getCheminHorizontal(): List<Coordonnee> {
        if (!estHorizontal())throw DeplacementExeption("déplacement n'est pas horizontal")
        var list= listOf<Coordonnee>()
        for (i in 0..longueur()){
            if (estHorizontalPositif()) list+=Coordonnee(origine.getX()+i,origine.getY())
            else list+=Coordonnee(origine.getX()-i,origine.getY())

        }
        return list
    }


    /**
     * donne le chemin de coordonnées que constitue le déplacement
     * du point de départ vers le point d'arrivée si le déplacement demandé est diagonal.
     * Le point de départ n'est pas stocké dans la liste.
     *
     * @return une liste de coordonnées qui constitue le déplacement du point de départ vers le point d'arrivée
     * si le déplacement est diagonal
     * @throws DeplacementException est levée si le déplacement n'est pas diagonal
     */
    fun getCheminDiagonal(): List<Coordonnee> {
        if (!estDiagonal())throw DeplacementExeption("déplacement n'est pas diagonal")
        var list= listOf<Coordonnee>()
        for (i in 0..longueur()){
            if (estDiagonalNegatifXNegatifY()) list+=Coordonnee(origine.getX()-i,origine.getY()-i)
            if (estDiagonalNegatifXPositifY()) list+=Coordonnee(origine.getX()-i,origine.getY()+i)
            if (estDiagonalPositifXNegatifY()) list+=Coordonnee(origine.getX()+i,origine.getY()-i)
            if (estDiagonalPositifXPositifY()) list+=Coordonnee(origine.getX()+i,origine.getY()+i)

        }
        return list
    }


}
