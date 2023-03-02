package projet.echecmartien.modele



class MoyenPion():GrandPion() {
    override fun getScore(): Int {
        return 2
    }
    override fun getDeplacement(deplacement: Deplacement):List<Coordonnee> {
        if (deplacement.estDiagonal()&&deplacement.longueur()<=2) return deplacement.getCheminDiagonal()
        if (deplacement.estVertical()&&deplacement.longueur()<=2) return deplacement.getCheminVertical()
        if (deplacement.estHorizontal()&&deplacement.longueur()<=2) return deplacement.getCheminHorizontal()
        throw DeplacementExeption("Déplacement invalide")
    }


}