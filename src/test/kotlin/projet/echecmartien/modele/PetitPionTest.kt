package projet.echecmartien.modele

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import java.lang.Exception

internal class PetitPionTest {
    private val pion=PetitPion()

    @Test
    fun getScore() {
        assertEquals(1,pion.getScore())
    }

    @Test
    fun getDeplacement() {
        val a=Coordonnee(1,1)
        val b=Coordonnee(0,0)
        val c=Coordonnee(3,1)
        val d=Coordonnee(1,3)
        val f=Coordonnee(3,3)
        var depl=Deplacement(a,b)
        val chemin = listOf<Coordonnee>(Coordonnee(1,1),Coordonnee(0,0))
        var chemindepl = pion.getDeplacement(depl)
        for (i in 0 until chemin.size){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(a,c)
        var exception = assertThrows(DeplacementExeption::class.java) {
            chemindepl = pion.getDeplacement(depl)
        }
        assertEquals("Déplacement invalide", exception.message)
        depl=Deplacement(a,d)
        exception = assertThrows(DeplacementExeption::class.java) {
            chemindepl = pion.getDeplacement(depl)
        }
        assertEquals("Déplacement invalide", exception.message)
        depl=Deplacement(a,f)
        exception = assertThrows(DeplacementExeption::class.java) {
            chemindepl = pion.getDeplacement(depl)
        }
        assertEquals("Déplacement invalide", exception.message)
    }
}