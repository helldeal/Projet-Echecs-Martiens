package projet.echecmartien.modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CaseTest {

    @Test
    fun estLibre() {
        var case=Case()
        var pion=PetitPion()
        assertTrue(case.estLibre())
        case.setPion(pion)
        assertFalse(case.estLibre())

    }

    @Test
    fun getJoueur() {
        var case=Case()
        var joueur=Joueur("")
        case.setJoueur(joueur)
        assertEquals(case.getJoueur(),joueur)

    }


    @Test
    fun getPion() {
        var case=Case()
        var pion=PetitPion()
        case.setPion(pion)
        assertEquals(case.getPion(),pion)

    }

}