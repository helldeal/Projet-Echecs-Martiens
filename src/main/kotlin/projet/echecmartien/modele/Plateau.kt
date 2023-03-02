package projet.echecmartien.modele

import projet.echecmartien.librairie.GeneralData
import projet.echecmartien.librairie.TAILLEHORIZONTALE
import projet.echecmartien.librairie.TAILLEVERTICALE


class Plateau {

    private var tailleHorizontale= TAILLEHORIZONTALE
    private var tailleVerticale= TAILLEVERTICALE
    private var cases:Array<Array<Case>> = Array(tailleVerticale){Array(tailleHorizontale) {Case()} }

    init {
        for (i in 0 until tailleVerticale){
            for (j in 0 until tailleHorizontale){
                if (j!=0 && i!=0)
                    cases[i][j]=Case()
            }
        }
    }

    /**
     * initialise le plateau de jeu avec les pions
     */
    fun initialiser() {
        val ref = GeneralData().tableau
        for (i in 0 until tailleVerticale) {
            for (j in 0 until tailleHorizontale) {
                if (ref[j][i].valeur=="G")cases[i][j].setPion(GrandPion())
                if (ref[j][i].valeur=="P")cases[i][j].setPion(PetitPion())
                if (ref[j][i].valeur=="M")cases[i][j].setPion(MoyenPion())
            }
        }
    }

    fun chargetableau(plat:String){
        val mutplat=plat.split(",")
        for (i in 0 until tailleVerticale) {
            for (j in 0 until tailleHorizontale) {
                cases[i][j].setPion(null)
                if (mutplat[i*4+j]=="projet.echecmartien.modele.GrandPion")cases[i][j].setPion(GrandPion())
                if (mutplat[i*4+j]=="projet.echecmartien.modele.PetitPion")cases[i][j].setPion(PetitPion())
                if (mutplat[i*4+j]=="projet.echecmartien.modele.MoyenPion")cases[i][j].setPion(MoyenPion())
            }
        }
    }



    /**
     * donne la taille horizontale du plateau
     * @return la taille horizontale du plateau
     */
    fun getTailleHorizontale(): Int {
        return cases[0].size
    }


    /**
     * donne la taille verticale du plateau
     * @return la taille verticale du plateau
     */
    fun getTailleVerticale(): Int {
       return cases.size
    }


    /**
     * donne le tableau des cases du plateau
     * @return les cases du plateau
     */
    fun getCases(): Array<Array<Case>> {
        return cases
    }


}