package projet.echecmartien.modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class JeuTest {
    val jeu = Jeu()

    @Test
    fun getCoordOrigineDeplacement() {
        jeu.setCoordOrigineDeplacement(Coordonnee(2,1))
        assertEquals(2,jeu.getCoordOrigineDeplacement()!!.getX())
        assertEquals(1,jeu.getCoordOrigineDeplacement()!!.getY())
    }

    @Test
    fun getCoordDestinationDeplacement() {
        jeu.setCoordDestinationDeplacement(Coordonnee(2,1))
        assertEquals(2,jeu.getCoordDestinationDeplacement()!!.getX())
        assertEquals(1,jeu.getCoordDestinationDeplacement()!!.getY())
    }



    @Test
    fun changeJoueurCourant() {
        jeu.initialiserPartie(Joueur("1"),Joueur("2"),10)
        val joueur1 = jeu.getJoueurCourant()
        jeu.changeJoueurCourant()
        val joueur2 = jeu.getJoueurCourant()
        assertNotEquals(joueur2,joueur1)
        jeu.changeJoueurCourant()
        assertEquals(joueur1,jeu.getJoueurCourant())
    }


    @Test
    fun initialiserPartie() {
        jeu.initialiserPartie(Joueur("1"),Joueur("2"),10)
    }


    @Test
    fun Arret() {
        jeu.initialiserPartie(Joueur("1"),Joueur("2"),0)
        jeu.arretPartie()
        assertEquals(null,jeu.joueurVainqueur())
    }

    @Test
    fun GAME() {
        jeu.initialiserPartie(Joueur("1"),Joueur("2"),10)
        val joueur1 = jeu.getJoueurCourant()
        jeu.changeJoueurCourant()
        val joueur2 = jeu.getJoueurCourant()
        assertNotEquals(joueur2,joueur1)
        jeu.changeJoueurCourant()
        assertEquals(joueur1,jeu.getJoueurCourant())
        assertThrows(DeplacementExeption::class.java) {
            jeu.deplacer(1,5,4,0)
        }
        assertThrows(DeplacementExeption::class.java) {
            jeu.deplacer(0,2,1,4)
        }
        assertThrows(DeplacementExeption::class.java) {
            jeu.deplacer(1,1,3,1)
        }
        assertThrows(DeplacementExeption::class.java) {
            jeu.deplacer(0,0,0,7)
        }
        assertThrows(DeplacementExeption::class.java) {
            jeu.deplacer(0,0,0,0)
        }
        /*jeu.deplacer(0,2,1,3)
        jeu.deplacer(2,5,1,4)
        jeu.deplacer(0,1,0,2)
        jeu.deplacer(3,6,2,5)
        jeu.deplacer(0,2,0,4)
        jeu.deplacer(2,5,2,2)*/
        assertEquals(joueur1,jeu.getJoueurCourant())
        jeu.deplacer(0,2,0,4)
        assertEquals(joueur2,jeu.getJoueurCourant())
        jeu.deplacer(1,5,2,4)
        jeu.deplacer(0,1,0,2)
        jeu.deplacer(0,4,0,2)
        jeu.deplacer(2,2,3,3)
        jeu.deplacer(2,4,1,5)
        jeu.deplacer(3,3,2,2)
        jeu.deplacer(1,5,2,4)
        jeu.deplacer(2,2,3,3)
        jeu.deplacer(2,4,1,5)
        jeu.deplacer(3,3,2,2)
        jeu.deplacer(1,5,2,4)
        jeu.deplacer(2,2,3,3)
        jeu.deplacer(2,4,1,5)
        assertEquals(joueur2,jeu.joueurVainqueur())
    }

}