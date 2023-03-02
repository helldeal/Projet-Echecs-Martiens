package projet.echecmartien.modele


class Jeu():InterfaceJeu{
    /**
     * getter
     * @return la coordonnée origine du déplacement
     */
    private var coordOrigine:Coordonnee?=null
    private var nombreCoupsSansPrise:Int
    private var nombreCoupsSansPriseMax:Int
    private var coordDest:Coordonnee?=null
    private var joueurCourant:Joueur?=null
    private var player1:Joueur?=null
    private var player2:Joueur?=null
    private var pionArriveDeZone:Pion?=null
    var plateau:Plateau= Plateau()

    init {
        plateau.initialiser()
        nombreCoupsSansPrise=0
        nombreCoupsSansPriseMax=0
    }

    fun getCoordOrigineDeplacement(): Coordonnee?{
        return coordOrigine
    }
    /**
     * getter
     * @return la coordonnée destination du déplacement
     */
    fun getCoordDestinationDeplacement(): Coordonnee?{
        return coordDest
    }


    /**
     * setter
     * @param origine la coordonnée origine du déplacement
     */
    fun setCoordOrigineDeplacement(origine: Coordonnee){
       coordOrigine=origine
    }


    /**
     * setter
     * @param destination la coordonnée destination du déplacement
     */
    fun setCoordDestinationDeplacement(destination: Coordonnee){
        coordDest=destination
    }


    /** retourne le joueur courant
     * @return le joueur courant
     */
    fun getJoueurCourant(): Joueur? {
       return joueurCourant
    }


/**
     * affectation des joueurs aux cases
     * @param joueur1 premier joueur
     * @paral joueur2 second joueur
     */
    private fun initialiserJoueur(joueur1: Joueur, joueur2: Joueur) {
        player1=joueur1
        player2=joueur2
    }

    /**
     * permet de savoir si la partie est finie ou non
     * @return true si la partie est finie, false sinon
     */
    fun arretPartie(): Boolean {
        if (nombreCoupsSansPrise>=nombreCoupsSansPriseMax){
            return true
        }
        var cptj1=0
        var cptj2=0
        for (i in 0..3){
            for (y in 0..3){
                if (!plateau.getCases()[y][i].estLibre()){
                    cptj1+=1
                }
                if (!plateau.getCases()[y+4][i].estLibre()){
                    cptj2+=1
                }
            }
        }
        if (cptj1==0||cptj2==0) return true
        return false
    }

    /**
     * modifie le joueur courant
     *
     */
    fun changeJoueurCourant() {
        if (getJoueurCourant()==player1)joueurCourant=player2
        else joueurCourant=player1

    }

    override fun deplacementPossible(coordOrigineX: Int, coordOrigineY: Int): Boolean {
        val cases=plateau.getCases()
        if (cases[coordOrigineY][coordOrigineX].getJoueur()!=joueurCourant)throw DeplacementExeption("La case n'appartient pas au joueur courant")
        val pion = cases[coordOrigineY][coordOrigineX].getPion()
        if (pion==null) throw DeplacementExeption("La case n'a pas de pion")
        return true
    }

    override fun joueurVainqueur(): Joueur? {
        if (arretPartie()) {
            if (player1!!.calculerScore()<player2!!.calculerScore())return player2
            if (player1!!.calculerScore()>player2!!.calculerScore())return player1
        }
        return null
    }

    override fun initialiserPartie(joueur1: Joueur, joueur2: Joueur, nombreCoupsSansPriseMax: Int) {
        initialiserJoueur(joueur1,joueur2)
        this.nombreCoupsSansPriseMax=nombreCoupsSansPriseMax
        joueurCourant= player1
        for (i in 0 until plateau.getTailleVerticale()) {
            for (j in 0 until plateau.getTailleHorizontale()) {
                if (i < 4) plateau.getCases()[i][j].setJoueur(joueur1)
                else plateau.getCases()[i][j].setJoueur(joueur2)
            }
        }

    }

    override fun deplacer(coordOrigineX: Int, coordOrigineY: Int, coordDestinationX: Int, coordDestinationY: Int) {
        if (arretPartie()) println("Partie déja finie")
        else{
            val cases=plateau.getCases()
            val pion = cases[coordOrigineY][coordOrigineX].getPion()
            println("$pion $coordOrigineX,$coordOrigineY se dirige vers $coordDestinationX,$coordDestinationY")
            if (deplacementPossible(coordOrigineX,coordOrigineY,coordDestinationX,coordDestinationY,joueurCourant)){
                println("------------- valide")
                val pionCapturable = cases[coordDestinationY][coordDestinationX].getPion()
                if (pionCapturable!=null){
                    joueurCourant!!.ajouterPionCaptures(pionCapturable)
                    cases[coordDestinationY][coordDestinationX].setPion(pion)
                    cases[coordOrigineY][coordOrigineX].setPion(null)
                    nombreCoupsSansPrise=0
                    pionArriveDeZone=cases[coordDestinationY][coordDestinationX].getPion()
                    println("------------- Déplacement éffectué, Pion capturé")
                }else {
                    cases[coordDestinationY][coordDestinationX].setPion(pion)
                    cases[coordOrigineY][coordOrigineX].setPion(null)
                    nombreCoupsSansPrise+=1
                    pionArriveDeZone=cases[coordDestinationY][coordDestinationX].getPion()
                    println("------------- Déplacement éffectué, CSP=$nombreCoupsSansPrise")
                }
                changeJoueurCourant()
                println("Nouveau Joueur : ${getJoueurCourant()}")
                if (arretPartie()) println("Partie finie, Victoire de ${joueurVainqueur()?.getPseudo()}")

            }
        }
    }

    override fun deplacementPossible(
        coordOrigineX: Int,
        coordOrigineY: Int,
        coordDestinationX: Int,
        coordDestinationY: Int,
        joueur: Joueur?
    ): Boolean {
        val cases=plateau.getCases()
        if (deplacementPossible(coordOrigineX,coordOrigineY)){
            if (pionArriveDeZone==cases[coordOrigineY][coordOrigineX].getPion()&&cases[coordDestinationY][coordDestinationX].getJoueur()!=joueurCourant)throw DeplacementExeption("Le pion venant d'arriver ne peut repartir")
            val pion = cases[coordOrigineY][coordOrigineX].getPion()
            val chemindepl = pion!!.getDeplacement(Deplacement(Coordonnee(coordOrigineX,coordOrigineY),Coordonnee(coordDestinationX,coordDestinationY)))
            if (chemindepl.size==1){
                if (cases[coordDestinationY][coordDestinationX].estLibre())return true
                if (cases[coordDestinationY][coordDestinationX].getJoueur()!=joueur)return true

            }
            if (chemindepl.size >1){
                for (i in 1 until (chemindepl.size-1)) {
                    if (!cases[chemindepl[i].getY()][chemindepl[i].getX()].estLibre())throw DeplacementExeption("Déplacement pas possible (obstruction)")
                }
                if (cases[coordDestinationY][coordDestinationX].estLibre())return true
                if (cases[coordDestinationY][coordDestinationX].getJoueur()!=joueur)return true
            }
        }
        throw DeplacementExeption("Déplacement pas possible")
    }


}