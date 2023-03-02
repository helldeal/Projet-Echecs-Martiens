package projet.echecmartien.modele



import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class JoueurTest{

    private val joueur1= Joueur("toto")

    @Test
    fun testPseudo() {
        assertEquals("toto", joueur1.getPseudo())
    }

    @Test
    fun getPionsCaptures() {
        joueur1.ajouterPionCaptures(GrandPion())
        assertEquals(GrandPion().getScore(),joueur1.getPionsCaptures().elementAt(0).getScore())
    }
    @Test
    fun getNbPionsCaptures() {
        joueur1.ajouterPionCaptures(GrandPion())
        joueur1.ajouterPionCaptures(GrandPion())
        joueur1.ajouterPionCaptures(GrandPion())
        assertEquals(3,joueur1.getNbPionsCaptures())
    }
    @Test
    fun calculerScore() {
        joueur1.ajouterPionCaptures(GrandPion())
        joueur1.ajouterPionCaptures(MoyenPion())
        joueur1.ajouterPionCaptures(PetitPion())
        assertEquals(6,joueur1.calculerScore())
    }




}