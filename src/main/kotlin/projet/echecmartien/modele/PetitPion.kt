package projet.echecmartien.modele

class PetitPion(): Pion() {
    override fun getScore(): Int {
        return 1
    }

    override fun getDeplacement(deplacement: Deplacement): List<Coordonnee> {
        if (deplacement.estDiagonal()&&deplacement.longueur()<=1) return deplacement.getCheminDiagonal()
        throw DeplacementExeption("Déplacement invalide")
    }
}