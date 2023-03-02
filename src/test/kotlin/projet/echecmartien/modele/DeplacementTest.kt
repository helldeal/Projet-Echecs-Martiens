package projet.echecmartien.modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DeplacementTest {

    @Test
    fun getDestination() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,1)
        val depl=Deplacement(a,b)
        assertEquals(b,depl.getDestination())
    }

    @Test
    fun getOrigine() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,1)
        val depl=Deplacement(a,b)
        assertEquals(a,depl.getOrigine())
    }

    @Test
    fun estHorizontal() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,0)
        val depl=Deplacement(a,b)
        assertTrue(depl.estHorizontal())
        assertFalse(depl.estVertical())
        assertFalse(depl.estDiagonal())

    }

    @Test
    fun estVertical() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(0,1)
        val depl=Deplacement(a,b)
        assertFalse(depl.estHorizontal())
        assertTrue(depl.estVertical())
        assertFalse(depl.estDiagonal())
    }

    @Test
    fun estDiagonal() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,1)
        val depl=Deplacement(a,b)
        assertFalse(depl.estHorizontal())
        assertFalse(depl.estVertical())
        assertTrue(depl.estDiagonal())
    }

    @Test
    fun longueur() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,1)
        val depl=Deplacement(a,b)
        assertEquals(1,depl.longueur())
    }

    @Test
    fun estVerticalPositif() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(0,1)
        var depl=Deplacement(a,b)
        assertTrue(depl.estVerticalPositif())
        depl =Deplacement(b,a)
        assertFalse(depl.estVerticalPositif())
    }

    @Test
    fun estHorizontalPositif() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,0)
        var depl=Deplacement(a,b)
        assertTrue(depl.estHorizontalPositif())
        depl =Deplacement(b,a)
        assertFalse(depl.estVerticalPositif())
    }

    @Test
    fun estDiagonalPositifXPositifY() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(1,1)
        val depl=Deplacement(a,b)
        assertTrue(depl.estDiagonalPositifXPositifY())
    }

    @Test
    fun estDiagonalNegatifXPositifY() {
        val a=Coordonnee(1,1)
        val b=Coordonnee(0,2)
        val depl=Deplacement(a,b)
        assertTrue(depl.estDiagonalNegatifXPositifY())
    }

    @Test
    fun estDiagonalPositifXNegatifY() {
        val a=Coordonnee(1,1)
        val b=Coordonnee(2,0)
        val depl=Deplacement(a,b)
        assertTrue(depl.estDiagonalPositifXNegatifY())
    }

    @Test
    fun estDiagonalNegatifXNegatifY() {
        val a=Coordonnee(1,1)
        val b=Coordonnee(0,0)
        val depl=Deplacement(a,b)
        assertTrue(depl.estDiagonalNegatifXNegatifY ())
    }

    @Test
    fun getCheminVertical() {
        val a=Coordonnee(1,1)
        val b=Coordonnee(1,4)
        var depl=Deplacement(a,b)
        var chemin = listOf(Coordonnee(1,1),Coordonnee(1,2),Coordonnee(1,3),Coordonnee(1,4))
        var chemindepl = depl.getCheminVertical()
        for (i in chemin.indices){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(b,a)
        chemin = listOf(Coordonnee(1,4),Coordonnee(1,3),Coordonnee(1,2),Coordonnee(1,1))
        chemindepl = depl.getCheminVertical()
        for (i in chemin.indices){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
    }

    @Test
    fun getCheminHorizontal() {
        val a=Coordonnee(0,1)
        val b=Coordonnee(3,1)
        var depl=Deplacement(a,b)
        var chemin = listOf(Coordonnee(0,1),Coordonnee(1,1),Coordonnee(2,1),Coordonnee(3,1))
        var chemindepl = depl.getCheminHorizontal()
        for (i in chemin.indices){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(b,a)
        chemin = listOf(Coordonnee(3,1),Coordonnee(2,1),Coordonnee(1,1),Coordonnee(0,1))
        chemindepl = depl.getCheminHorizontal()
        for (i in chemin.indices){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
    }

    @Test
    fun getCheminDiagonal() {
        val a=Coordonnee(0,0)
        val b=Coordonnee(3,3)
        var depl=Deplacement(a,b)
        var chemin = listOf(Coordonnee(0,0),Coordonnee(1,1),Coordonnee(2,2),Coordonnee(3,3))
        var chemindepl = depl.getCheminDiagonal()
        for (i in chemin.indices){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
        depl=Deplacement(b,a)
        chemin = listOf(Coordonnee(3,3),Coordonnee(2,2),Coordonnee(1,1),Coordonnee(0,0))
        chemindepl = depl.getCheminDiagonal()
        for (i in chemin.indices){
            assertEquals(chemin[i].getX(),chemindepl[i].getX())
            assertEquals(chemin[i].getY(),chemindepl[i].getY())
        }
    }
}