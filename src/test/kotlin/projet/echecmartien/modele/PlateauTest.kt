package projet.echecmartien.modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import projet.echecmartien.librairie.TAILLEHORIZONTALE
import projet.echecmartien.librairie.TAILLEVERTICALE

internal class PlateauTest {

    @Test
    fun initialiser() {
        var plateau=Plateau()
        plateau.initialiser()
        plateau.getCases()
    }

    @Test
    fun getTailleHorizontale() {
        var plateau=Plateau()
        plateau.initialiser()
        assertEquals(plateau.getTailleHorizontale(), TAILLEHORIZONTALE)
    }

    @Test
    fun getTailleVerticale() {
        var plateau=Plateau()
        plateau.initialiser()
        assertEquals(plateau.getTailleVerticale(), TAILLEVERTICALE)
    }

}