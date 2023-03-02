package projet.echecmartien.modele

class Joueur(pseudo:String) {

    private val pseudo:String
    private var pions= setOf<Pion>()

    init {
        this.pseudo=pseudo
    }

    /**
     * récupére la liste des pions capturés
     * @return la liste des pions capturés qui est vide si aucun pion n'a été capturé
     */
    fun getPionsCaptures(): Set<Pion> {
        return this.pions
    }

    /**
     * ajout à la liste d'un pion qui a été capturé
     * @param pion à ajouter
     */
    fun ajouterPionCaptures(pion: Pion) {
        this.pions+=pion
    }


    /**
     * permet de connaître le nombre de pions capturés
     * @return le nombre de pions capturés
     */
    fun getNbPionsCaptures(): Int {
       return this.pions.size
    }


    /**
     * récupère la valeur du pseudo
     *
     * @return la valeur du pseudo
     */
    fun getPseudo(): String {
        return pseudo
    }



    /**
     * calcule le score du joueur
     * @return le score du joueur
     */
    fun calculerScore(): Int {
        var score=0
        for (i in getPionsCaptures()){
            score+=i.getScore()
        }
        return score
    }

}
