package projet.echecmartien.modele



class Case() {

    private var pion:Pion?=null
    private var player:Joueur?=null

    /**
     * teste si une case contient un pion ou non
     * @return true si la case ne contient pas un pion, false sinon.
     */
    fun estLibre(): Boolean {
        if (pion==null)return true
        return false
    }

    /** getter
     * @return le joueur associé     à la case
     */
    fun getJoueur():Joueur? {
        return player
    }

    /** setter
     * @param joueur qui est associé à la case
     */
    fun setJoueur(joueur: Joueur?) {
        player=joueur
    }

    /** getter
     * @return le pion associé à la case
     */
    fun getPion():Pion? {
        return pion
    }

    /** setter
     * @param pion qui est associé à la case
     */
    fun setPion(pion: Pion?) {
       this.pion=pion
    }

}
