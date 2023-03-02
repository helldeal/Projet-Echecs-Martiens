package projet.echecmartien.modele

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class CoordonneeTest {
    val a=Coordonnee(2,3)

    @Test
    fun getX() {
        assertEquals(2,a.getX())
    }

    @Test
    fun getY() {
        assertEquals(3,a.getY())
        assertNotEquals(2,a.getY())
    }@Test
    fun String() {
        assertEquals("X=2, Y=3",a.toString())
    }
}