package projet.echecmartien.modele

import javafx.scene.image.ImageView
import javafx.scene.paint.Color

class Player(number:Int) {

    private var playerNumber:Int
    private var name:String?
    private var skin:ImageView
    private var colorSkin:Color

    init {
        this.name=null
        this.playerNumber=number
        this.skin=Skins().getSkin(playerNumber)
        this.colorSkin=Skins().getColor(playerNumber)
    }


    fun setSkin(skinnumber:Int){
        this.skin=Skins().getSkin(skinnumber)
    }

    fun getSkin():ImageView{
        return this.skin
    }

    fun setColor(skinnumber: Int){
        this.colorSkin=Skins().getColor(skinnumber)
    }

    fun getColor():Color{
        return this.colorSkin
    }

    fun setName(name:String){
        this.name=name
    }

    fun getName():String{
        if (this.name==null){
            return ("Player ${playerNumber}")
        } else{
            return this.name!!
        }
    }

}