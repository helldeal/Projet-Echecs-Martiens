package projet.echecmartien.modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class MoyenPionTest {
    private val pion=MoyenPion()

    @Test
    fun getScore() {
        assertEquals(2,pion.getScore())
    }

    @Test
    fun getDeplacement() {
        val a=Coordonnee(1,1)
        val b=Coordonnee(2,2)
        val c=Coordonnee(3,1)
        val d=Coordonnee(1,3)
        val h=Coordonnee(4,1)
        var depl=Deplacement(a,b)
        var chemin = listOf<Coordonnee>(Coordonnee(1,1),Coordonnee(2,2))
        var chemindepl = pion.getDeplacement(depl)
        for (i in 0 until chemin.size){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(a,c)
        chemin = listOf<Coordonnee>(Coordonnee(1,1),Coordonnee(2,1),Coordonnee(3,1))
        chemindepl = pion.getDeplacement(depl)
        for (i in 0 until chemin.size){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(a,d)
        chemin = listOf<Coordonnee>(Coordonnee(1,1),Coordonnee(1,2),Coordonnee(1,3))
        chemindepl = pion.getDeplacement(depl)
        for (i in 0 until chemin.size){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(a,h)
        var exception = assertThrows(DeplacementExeption::class.java) {
            chemindepl = pion.getDeplacement(depl)
        }
        assertEquals("Déplacement invalide", exception.message)
    }
}