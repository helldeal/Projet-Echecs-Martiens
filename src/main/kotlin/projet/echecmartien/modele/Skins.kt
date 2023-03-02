package projet.echecmartien.modele

import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.paint.Color

class Skins {

    private var skinsTable : MutableList<String>
    private var colorTable : MutableList<Color>
    init {
        val bloody="file:src/main/resources/projet/echecmartien/skins/bloodyOp.gif"
        val bluecheese="file:src/main/resources/projet/echecmartien/skins/bluecheeseOp.gif"
        val grey="file:src/main/resources/projet/echecmartien/skins/greyOp.gif"
        val ogkush="file:src/main/resources/projet/echecmartien/skins/ogkushOp.gif"
        val orange="file:src/main/resources/projet/echecmartien/skins/orangeOp.gif"
        val pink="file:src/main/resources/projet/echecmartien/skins/pinkOp.gif"
        val pray="file:src/main/resources/projet/echecmartien/skins/pray.gif"
        val purplehaze="file:src/main/resources/projet/echecmartien/skins/purplehazeOp.gif"
        val tatamis="file:src/main/resources/projet/echecmartien/skins/tatamisOp.gif"
        var twerker="file:src/main/resources/projet/echecmartien/skins/twerkerOp.gif"

        skinsTable= mutableListOf(
                bloody,
                bluecheese,
                grey,
                ogkush,
                orange,
                pink,
                pray,
                purplehaze,
                tatamis,
                twerker
        )

        colorTable= mutableListOf(
                Color.rgb(147,38,48),
                Color.rgb(29,145,182),
                Color.rgb(131,131,131),
                Color.rgb(140,195,28),
                Color.rgb(234,110,18),
                Color.rgb(211,27,123),
                Color.rgb(168,191,255),
                Color.rgb(137,73,192),
                Color.rgb(43,125,16),
                Color.rgb(35,100,95)
        )
    }

    fun getSkin(Index:Int, SizeH:Double, SizeW:Double):ImageView{

        val a=ImageView(Image(skinsTable[Index]))
        a.fitHeight=SizeH
        a.fitWidth=SizeW
        return a
    }

    fun getColor(Index: Int):Color{
        return colorTable[Index]
    }

    fun getSkin(Index: Int): ImageView {
        return ImageView(Image(skinsTable[Index]))
    }
    fun getSkinf(Index: Int): String {
        return skinsTable[Index]
    }

    fun getSize():Int{
        return skinsTable.size
    }


}