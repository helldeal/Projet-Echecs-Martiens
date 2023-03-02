package projet.echecmartien.vue

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import projet.echecmartien.controleurs.ControleurJeuDeplacement
import projet.echecmartien.modele.*

class VueJeu(modele: Jeu, j1: Joueur, j2: Joueur,cpt1:Int,cpt2:Int,pnt1:Int,pnt2:Int,IA:Boolean): BorderPane() {
    var j1=j1
    var j2=j2
    var cpt1=cpt1
    var cpt2=cpt2
    var pnt1=pnt1
    var pnt2=pnt2
    var IA=IA
    var timer:Label
    var modele =modele
    var lj1point:Label
    var lj2point:Label
    var plateau=modele.plateau
    var GrilleDeJeu:GridPane
    var originep:Boolean=false
    var destp:Boolean=false
    var panneaudroite:GridPane
    var panneaugauche:GridPane
    var lj1:Label
    var lj2:Label
    var vs:Label
    var quit:Button
    val screenSizeBox:VBox
    var screenSizeFull: Image
    var screenSizeSmall: Image
    var a: ImageView
    var b: ImageView

    init {
        this.quit= Button("Quitter")
        this.timer=Label("00:00")
        val row1droite= RowConstraints()
        val row2droite=RowConstraints()
        val row3droite=RowConstraints()
        val row4droite=RowConstraints()
        val col1droite= ColumnConstraints()
        val col2droite=ColumnConstraints()
        this.lj1point=Label("")
        this.lj2point=Label("")
        lj1point.text="${j1.calculerScore()+pnt1} Point(s)"
        lj2point.text="${j2.calculerScore()+pnt2} Point(s)"
        GrilleDeJeu= GridPane()
        panneaudroite= GridPane()
        panneaugauche=GridPane()
        this.screenSizeBox=VBox()
        this.screenSizeFull= Image("file:src/main/resources/projet/echecmartien/fullscreen.png")
        this.screenSizeSmall=Image("file:src/main/resources/projet/echecmartien/smallscreen.png")
        a=ImageView(screenSizeFull)
        b=ImageView(screenSizeSmall)
        a.fitHeight=30.0
        a.fitWidth=30.0
        b.fitHeight=30.0
        b.fitWidth=30.0
        screenSizeBox.maxWidth=35.0
        screenSizeBox.alignment=Pos.BASELINE_RIGHT
        screenSizeBox.children.add(a)
        this.left=panneaugauche
        this.right=panneaudroite
        panneaugauche.style=("-fx-background-color: rgb(0,0,0,0.3)")
        panneaudroite.style=("-fx-background-color: rgb(0,0,0,0.3)")
        this.style= ("-fx-background-image: url('file:src/main/resources/projet/echecmartien/spacegif1.gif'); -fx-background-size:cover;")
        lj1=Label(j1.getPseudo())
        lj1.textFill=Skins().getColor(cpt1)
        lj2=Label(j2.getPseudo())
        lj2.textFill=Skins().getColor(cpt2)
        vs= Label("VS")
        vs.textFill=Color.WHITE
        lj1.style=("-fx-font-size:30.0")
        lj2.style=("-fx-font-size:30.0")
        vs.style=("-fx-font-size:60.0")
        timer.textFill=Color.WHITE
        lj1point.textFill=Color.WHITE
        lj2point.textFill=Color.WHITE
        lj2point.style=("-fx-font-size:30.0")
        lj1point.style=("-fx-font-size:30.0")
        timer.style=("-fx-font-size:60.0")
        panneaugauche.alignment=Pos.CENTER
        val pgc = ColumnConstraints()
        pgc.halignment=HPos.CENTER
        val pgl1=RowConstraints()
        pgl1.percentHeight=40.0
        val pgl2=RowConstraints()
        pgl2.percentHeight=20.0
        col1droite.halignment=HPos.CENTER
        col2droite.halignment=HPos.RIGHT
        row1droite.percentHeight=30.0
        row1droite.valignment=VPos.CENTER
        row2droite.percentHeight=30.0
        row2droite.valignment=VPos.CENTER
        row3droite.percentHeight=5.0
        row3droite.valignment=VPos.TOP
        row4droite.percentHeight=5.0
        row4droite.valignment=VPos.BOTTOM
        panneaudroite.padding= Insets(10.0,10.0,10.0,60.0)
        panneaugauche.padding= Insets(100.0)
        panneaugauche.columnConstraints.add(pgc)
        panneaugauche.rowConstraints.addAll(pgl1,pgl2,pgl1)
        panneaudroite.rowConstraints.addAll(row4droite,row2droite,row2droite,row2droite,row3droite)
        panneaudroite.columnConstraints.addAll(col1droite,col2droite)
        panneaugauche.add(lj1,0,0)
        panneaugauche.add(vs,0,1)
        panneaugauche.add(lj2,0,2)
        panneaudroite.add(screenSizeBox,1,0)
        panneaudroite.add(lj1point,0,1)
        panneaudroite.add(timer,0,2)
        panneaudroite.add(lj2point,0,3)
        panneaudroite.add(quit,1,4)

    }

    fun update(){
        lj1point.text="${j1.calculerScore()+pnt1} Points"
        lj2point.text="${j2.calculerScore()+pnt2} Points"
        GrilleDeJeu= GridPane()
        this.center=GrilleDeJeu
        GrilleDeJeu.alignment=Pos.CENTER
        for (i in 0 until plateau.getTailleVerticale()){
            for (y in 0 until plateau.getTailleHorizontale()){
                val case = plateau.getCases()[i][y]
                val b=GridPane()
                b.style="-fx-background-color: rgb(0,0,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"
                b.setPrefSize(80.0,80.0)
                b.alignment=Pos.CENTER
                b.hgap=y.toDouble()
                b.vgap=i.toDouble()
                var pionaff=Circle(0.0)
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.GrandPion") {
                    pionaff=Circle(37.0)
                }
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.PetitPion"){
                    pionaff=Circle(15.0)
                }
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.MoyenPion"){
                    pionaff=Circle(25.0)
                }
                val skins = Skins()
                if (case.getJoueur()==j1)pionaff.fill=skins.getColor(cpt1)
                else pionaff.fill=skins.getColor(cpt2)
                b.add(pionaff,0,0)
                b.addEventFilter(MouseEvent.MOUSE_CLICKED,ControleurJeuDeplacement(this, modele,b))
                if (modele.getJoueurCourant()==j1&&case.getJoueur()==j1)b.style="-fx-background-color: rgb(50,50,50,0.3);-fx-border-color:rgb(100,100,100,0.1);"
                if (modele.getJoueurCourant()==j2&&case.getJoueur()==j2)b.style="-fx-background-color: rgb(50,50,50,0.3);-fx-border-color:rgb(100,100,100,0.1);"

                GrilleDeJeu.add(b,y,i)

            }
        }
    }

    fun updatelayout(cx:Int,cy:Int){
        GrilleDeJeu= GridPane()
        this.center=GrilleDeJeu
        GrilleDeJeu.alignment=Pos.CENTER
        for (i in 0 until plateau.getTailleVerticale()){
            for (y in 0 until plateau.getTailleHorizontale()){
                val case = plateau.getCases()[i][y]
                val b=GridPane()
                try {
                    if (i==cy&&y==cx)b.style="-fx-background-color: rgb(100,250,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"
                    else if (modele.deplacementPossible(cx,cy,y,i,modele.getJoueurCourant()))b.style="-fx-background-color: rgb(255,150,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"
                }
                catch (e:DeplacementExeption){
                    b.style="-fx-background-color: rgb(0,0,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"
                    if (modele.getJoueurCourant()==j1&&case.getJoueur()==j1)b.style="-fx-background-color: rgb(50,50,50,0.3);-fx-border-color:rgb(100,100,100,0.1);"
                    if (modele.getJoueurCourant()==j2&&case.getJoueur()==j2)b.style="-fx-background-color: rgb(50,50,50,0.3);-fx-border-color:rgb(100,100,100,0.1);"
                }
                b.setPrefSize(80.0,80.0)
                b.alignment=Pos.CENTER
                b.hgap=y.toDouble()
                b.vgap=i.toDouble()
                var pionaff=Circle(0.0)
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.GrandPion") {
                    pionaff=Circle(37.0)
                }
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.PetitPion"){
                    pionaff=Circle(15.0)
                }
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.MoyenPion"){
                    pionaff=Circle(25.0)
                }
                val skins = Skins()
                if (case.getJoueur()==j1)pionaff.fill=skins.getColor(cpt1)
                else pionaff.fill=skins.getColor(cpt2)
                b.add(pionaff,0,0)
                b.addEventFilter(MouseEvent.MOUSE_CLICKED,ControleurJeuDeplacement(this, modele,b))

                GrilleDeJeu.add(b,y,i)

            }
        }
    }


    fun updatelayoutIA(cx:Int,cy:Int,dx:Int,dy:Int){
        lj1point.text="${j1.calculerScore()+pnt1} Points"
        lj2point.text="${j2.calculerScore()+pnt2} Points"
        GrilleDeJeu= GridPane()
        this.center=GrilleDeJeu
        GrilleDeJeu.alignment=Pos.CENTER
        for (i in 0 until plateau.getTailleVerticale()){
            for (y in 0 until plateau.getTailleHorizontale()){
                val case = plateau.getCases()[i][y]
                val b=GridPane()
                b.style="-fx-background-color: rgb(0,0,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"
                if (modele.getJoueurCourant()==j1&&case.getJoueur()==j1)b.style="-fx-background-color: rgb(50,50,50,0.3);-fx-border-color:rgb(100,100,100,0.1);"
                if (modele.getJoueurCourant()==j2&&case.getJoueur()==j2)b.style="-fx-background-color: rgb(50,50,50,0.3);-fx-border-color:rgb(100,100,100,0.1);"
                if (i==cy&&y==cx)b.style="-fx-background-color: rgb(255,150,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"
                if (i==dy&&y==dx)b.style="-fx-background-color: rgb(255,150,0,0.3);-fx-border-color:rgb(100,100,100,0.3);"

                b.setPrefSize(80.0,80.0)
                b.alignment=Pos.CENTER
                b.hgap=y.toDouble()
                b.vgap=i.toDouble()
                var pionaff=Circle(0.0)
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.GrandPion") {
                    pionaff=Circle(37.0)
                }
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.PetitPion"){
                    pionaff=Circle(15.0)
                }
                if(case.getPion().toString().substringBefore("@")=="projet.echecmartien.modele.MoyenPion"){
                    pionaff=Circle(25.0)
                }
                val skins = Skins()
                if (case.getJoueur()==j1)pionaff.fill=skins.getColor(cpt1)
                else pionaff.fill=skins.getColor(cpt2)
                b.add(pionaff,0,0)
                b.addEventFilter(MouseEvent.MOUSE_CLICKED,ControleurJeuDeplacement(this, modele,b))

                GrilleDeJeu.add(b,y,i)

            }
        }
    }
}