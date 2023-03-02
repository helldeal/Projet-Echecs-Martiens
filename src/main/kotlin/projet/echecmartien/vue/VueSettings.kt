package projet.echecmartien.vue

import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*
import javafx.scene.paint.Color


class VueSettings(): BorderPane() {
    val top:VBox
    val haut:BorderPane
    val bas:VBox
    val ljeu:Label
    //val blauch:Button
    //val bcharge:Button
    val bretour:Button
    val bset:Button //TODO
    //val brule:Button
    val screenSizeBox:VBox
    var screenSizeFull:Image
    var screenSizeSmall:Image
    var a:ImageView
    var b:ImageView
    var empty:VBox
    var hautetbas:VBox

    init {
        this.hautetbas=VBox()
        this.empty= VBox()
        this.top= VBox()
        this.haut = BorderPane()
        this.bas = VBox()
        this.ljeu= Label("Paramètres")
        ljeu.textFill=Color.WHITE
        //this.blauch= Button("Commencer la partie")
        //this.bcharge= Button("Charger une partie")
        this.bset= Button("Paramètres")  //TODO
        //this.brule= Button("Règles du Jeu")
        this.bretour= Button("Retour")
        this.screenSizeBox=VBox()
        screenSizeBox.alignment=Pos.TOP_LEFT
        this.screenSizeFull= Image("file:src/main/resources/projet/echecmartien/fullscreen.png")
        this.screenSizeSmall=Image("file:src/main/resources/projet/echecmartien/smallscreen.png")
        a=ImageView(screenSizeFull)
        b=ImageView(screenSizeSmall)
        a.fitHeight=30.0
        a.fitWidth=30.0
        b.fitHeight=30.0
        b.fitWidth=30.0
        screenSizeBox.children.add(a)
        haut.top=screenSizeBox
        screenSizeBox.maxWidth=35.0
        screenSizeBox.alignment=Pos.BASELINE_RIGHT
        hautetbas.children.addAll(haut,bas)

        ljeu.style="-fx-font-size:60px;"
        //blauch.style="-fx-background-color: None ; -fx-background-radius: 5px; -fx-border-radius: 5px;"
        //blauch.textFill=Color.WHITE

        //bcharge.style="-fx-background-color: None; -fx-background-radius: 5px; -fx-border-radius: 5px;"
        //bcharge.textFill=Color.WHITE

        bretour.style="-fx-background-color: None; -fx-background-radius: 5px; -fx-border-radius: 5px;"
        bretour.textFill=Color.WHITE

        //brule.style="-fx-background-color: None; -fx-background-radius: 5px; -fx-border-radius: 5px;"
        //brule.textFill=Color.WHITE

        //bset.style="-fx-background-color: None; -fx-background-radius: 5px; -fx-border-radius: 5px;"
        //bset.textFill=Color.WHITE //TODO

        this.style= ("-fx-background-image: url('file:src/main/resources/projet/echecmartien/space2.png'); -fx-background-size:cover;")

        this.right=screenSizeBox
        this.center=hautetbas
        this.left=empty
        bas.children.addAll(/*blauch,bcharge,brule,bset,bquit*/bretour) //TODO
        haut.center=ljeu
        screenSizeBox.maxHeight=a.fitHeight
        screenSizeBox.padding= Insets(10.0)
        hautetbas.alignment=Pos.CENTER
        hautetbas.spacing=200.0

        screenSizeBox.alignment=Pos.TOP_RIGHT

        bas.alignment=Pos.BOTTOM_CENTER
        bas.spacing=20.0

        //blauch.prefWidth=200.0
        //bcharge.prefWidth=200.0
        //brule.prefWidth=200.0
        bset.prefWidth=200.0
        bretour.prefWidth=200.0

        //blauch.prefHeight=40.0
        //bcharge.prefHeight=40.0
        //brule.prefHeight=40.0
        bset.prefHeight=40.0
        bretour.prefHeight=40.0

    }

}