package projet.echecmartien.vue

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.ColumnConstraints
import javafx.scene.layout.GridPane
import javafx.scene.layout.RowConstraints
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import projet.echecmartien.modele.Jeu
import projet.echecmartien.modele.Joueur
import projet.echecmartien.modele.Skins

class VueVictory(modele: Jeu, j1: Joueur, j2: Joueur, cpt1:Int, cpt2:Int, pnt1:Int, pnt2:Int):GridPane() {



    // FULL SCREEN
    val screenSizeBox: VBox
    var screenSizeFull: Image
    var screenSizeSmall: Image
    var a: ImageView
    var b: ImageView



    //constraint
    var rowgridinfo1:RowConstraints
    var rowgridinfo2:RowConstraints
    var rowgridinfo3:RowConstraints
    var rowgridinfo4:RowConstraints
    var colgridinfo:ColumnConstraints

    var thisrow1:RowConstraints
    var thisrow2:RowConstraints
    var thisrow3:RowConstraints
    var thiscol1:ColumnConstraints
    var thiscol2:ColumnConstraints

    var BoutonRejouer:Button
    var BoutonMenu:Button
    var player1:Label
    var player2:Label
    var ScoreP1:Label
    var ScoreP2:Label
    var victoire:Label
    var skinP1:ImageView
    var skinP2:ImageView

    var constr1:ColumnConstraints
    var constr2:ColumnConstraints

    var gridinfo:GridPane

    init {

        // FULL SCREEN
        this.style= ("-fx-background-image: url('file:src/main/resources/projet/echecmartien/victory.png'); -fx-background-size:cover;")
        this.screenSizeBox=VBox()
        screenSizeBox.padding= Insets(10.0)
        screenSizeBox.alignment= Pos.TOP_RIGHT
        this.screenSizeFull= Image("file:src/main/resources/projet/echecmartien/fullscreen.png")
        this.screenSizeSmall=Image("file:src/main/resources/projet/echecmartien/smallscreen.png")
        a=ImageView(screenSizeFull)
        b=ImageView(screenSizeSmall)
        a.fitHeight=30.0
        a.fitWidth=30.0
        b.fitHeight=30.0
        b.fitWidth=30.0
        screenSizeBox.children.add(a)

        this.victoire= Label("Victoire!")
        skinP1=Skins().getSkin(cpt1,300.0,300.0)
        skinP2=Skins().getSkin(cpt2,100.0,100.0)
        if(pnt1>pnt2){

            skinP1=Skins().getSkin(cpt1,300.0,300.0)
            skinP2=Skins().getSkin(cpt2,100.0,100.0)

            victoire.textFill=Skins().getColor(cpt1)
        }else if (pnt1<pnt2){

            skinP1=Skins().getSkin(cpt1,100.0,100.0)
            skinP2=Skins().getSkin(cpt2,300.0,300.0)

            victoire.textFill=Skins().getColor(cpt2)
        }else if (pnt1==pnt2){

            skinP1=Skins().getSkin(cpt1,200.0,200.0)
            skinP2=Skins().getSkin(cpt2,200.0,200.0)
            victoire.text="Egalité"
            victoire.textFill= Color.WHITE
        }

        this.ScoreP2=Label("Score : $pnt2")
        this.ScoreP1=Label("Score : $pnt1")
        this.player1=Label(j1.getPseudo())
        this.player2=Label(j2.getPseudo())
        player1.textFill=Skins().getColor(cpt1)
        player2.textFill=Skins().getColor(cpt2)
        this.BoutonMenu= Button("Menu")
        this.BoutonRejouer= Button("Rejouer")


        this.gridinfo=GridPane()
        constr1= ColumnConstraints()
        constr2= ColumnConstraints()

        constr1.percentWidth=80.0
        constr2.percentWidth=20.0

        gridinfo.add(skinP1,0,0)
        gridinfo.add(skinP2,1,0)
        gridinfo.add(player1,0,1)
        gridinfo.add(player2,1,1)
        gridinfo.add(ScoreP1,0,2)
        gridinfo.add(ScoreP2,1,2)
        gridinfo.add(BoutonMenu,1,3)
        gridinfo.add(BoutonRejouer,0,3)
        this.add(victoire,1,1)
        this.add(screenSizeBox,2,0)
        //this.add(feuRouge,2,1)
        //this.add(feuBleu,0,1)
        this.add(gridinfo,1,2)

        colgridinfo=ColumnConstraints()
        thiscol1= ColumnConstraints()
        thiscol2= ColumnConstraints()
        thisrow1= RowConstraints()
        thisrow2= RowConstraints()
        thisrow3= RowConstraints()
        rowgridinfo1= RowConstraints()
        rowgridinfo2=RowConstraints()
        rowgridinfo3=RowConstraints()
        rowgridinfo4=RowConstraints()


        rowgridinfo3.valignment=VPos.CENTER
        rowgridinfo4.valignment=VPos.CENTER
        rowgridinfo2.valignment=VPos.CENTER
        rowgridinfo1.valignment=VPos.BOTTOM

        rowgridinfo1.percentHeight=60.0
        rowgridinfo2.percentHeight=10.0
        rowgridinfo3.percentHeight=5.0
        rowgridinfo4.percentHeight=25.0

        thiscol1.halignment=HPos.RIGHT
        thiscol1.percentWidth=20.0
        thiscol2.percentWidth=60.0
        thiscol2.halignment=HPos.CENTER
        thisrow1.percentHeight=10.0
        thisrow2.percentHeight=20.0
        thisrow3.percentHeight=70.0

        colgridinfo.halignment=HPos.CENTER
        colgridinfo.percentWidth=35.0


        gridinfo.rowConstraints.addAll(rowgridinfo1,rowgridinfo2,rowgridinfo3,rowgridinfo4)
        gridinfo.columnConstraints.addAll(colgridinfo,colgridinfo)
        victoire.padding= Insets(0.0,0.0,20.0,0.0)
        this.rowConstraints.addAll(thisrow1,thisrow2,thisrow3)
        this.columnConstraints.addAll(thiscol1,thiscol2,thiscol1)
        this.alignment=Pos.TOP_CENTER
        screenSizeBox.alignment=Pos.TOP_RIGHT
        gridinfo.alignment=Pos.CENTER
    }
}