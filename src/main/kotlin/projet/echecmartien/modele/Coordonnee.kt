package projet.echecmartien.modele

class Coordonnee(x:Int,y:Int) {

    private val x:Int
    private val y:Int

    init {
        this.x=x
        this.y=y
    }

    /**
     *@return la coordonnée en x
     */
    fun getX(): Int{
        return x
    }


    /**
     *@return la coordonnée en y
     */
    fun getY(): Int{
       return y
    }


    override fun toString():String{
       return "X=$x, Y=$y"
    }




}