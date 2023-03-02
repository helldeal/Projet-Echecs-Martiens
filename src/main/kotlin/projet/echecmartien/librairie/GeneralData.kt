package projet.echecmartien.librairie



const val TAILLEHORIZONTALE=4
const val TAILLEVERTICALE=8

enum class EnumPion(var valeur: String) {
    GRANDPION("G"),
    MOYENPION("M"),
    PETITPION("P"),
    LIBRE("  ");
}

class GeneralData {
    val tableau = Array(TAILLEHORIZONTALE) { Array(TAILLEVERTICALE, { EnumPion.LIBRE }) }

    init {

        tableau[2][0]= EnumPion.MOYENPION
        tableau[1][1]= EnumPion.MOYENPION
        tableau[0][2]= EnumPion.MOYENPION
        tableau[3][5]= EnumPion.MOYENPION
        tableau[2][6]= EnumPion.MOYENPION
        tableau[1][7]= EnumPion.MOYENPION
        tableau[0][0]= EnumPion.GRANDPION
        tableau[1][0]= EnumPion.GRANDPION
        tableau[0][1]= EnumPion.GRANDPION
        tableau[3][6]= EnumPion.GRANDPION
        tableau[3][7]= EnumPion.GRANDPION
        tableau[2][7]= EnumPion.GRANDPION
        tableau[1][2]= EnumPion.PETITPION
        tableau[2][2]= EnumPion.PETITPION
        tableau[2][1]= EnumPion.PETITPION
        tableau[2][5]= EnumPion.PETITPION
        tableau[1][6]= EnumPion.PETITPION
        tableau[1][5]= EnumPion.PETITPION
    }
}