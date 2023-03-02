package projet.echecmartien.vue

import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.geometry.VPos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.*

class VueCharge():GridPane() {
    val titre:Label
    val back:Button


    // FULL SCREEN
    val screenSizeBox: VBox
    var screenSizeFull: Image
    var screenSizeSmall: Image
    var a: ImageView
    var b: ImageView


    // CONSTRAINT
    val col12:ColumnConstraints
    val col11:ColumnConstraints
    val col13:ColumnConstraints
    val col1:ColumnConstraints
    val col2:ColumnConstraints
    val col3:ColumnConstraints
    val row1:RowConstraints
    val row2:RowConstraints
    val row3:RowConstraints


    // LOAD 1
    val charge1:GridPane
    val nomP1:Label
    val j1P1:Label
    val j2P1:Label
    val dateP1:Label
    val dureP1:Label
    val del1:Button



    // LOAD 2

    val charge2:GridPane
    val nomP2:Label
    val j1P2:Label
    val j2P2:Label
    val dateP2:Label
    val dureP2:Label
    val del2:Button

    // LOAD 3

    val charge3:GridPane
    val nomP3:Label
    val j1P3:Label
    val j2P3:Label
    val dateP3:Label
    val dureP3:Label
    val del3:Button

    // LOAD 4

    val charge4:GridPane
    val nomP4:Label
    val j1P4:Label
    val j2P4:Label
    val dateP4:Label
    val dureP4:Label
    val del4:Button





    init {
        this.style= ("-fx-background-image: url('file:src/main/resources/projet/echecmartien/spacegif2.gif'); -fx-background-size:cover;")
        this.row1= RowConstraints()
        this.row2= RowConstraints()
        this.row3= RowConstraints()
        this.col1= ColumnConstraints()
        this.col2= ColumnConstraints()
        this.col3= ColumnConstraints()
        this.col13= ColumnConstraints()
        this.col11= ColumnConstraints()
        this.col12= ColumnConstraints()



        this.screenSizeBox=VBox()
        this.titre= Label("Chargez votre partie")
        this.back= Button("Retour")

        // LOAD 1
        this.charge1= GridPane()
        this.nomP1= Label("Emplacement Vide")
        this.j1P1= Label("")
        this.j2P1=Label("")
        this.dateP1=Label("")
        this.dureP1=Label("")
        this.del1=Button("Supprimer")


        // LOAD 2
        this.charge2= GridPane()
        this.nomP2= Label("Emplacement Vide")
        this.j1P2= Label("")
        this.j2P2=Label("")
        this.dateP2=Label("")
        this.dureP2=Label("")
        this.del2=Button("Supprimer")


        // LOAD 3
        this.charge3= GridPane()
        this.nomP3= Label("Emplacement Vide")
        this.j1P3= Label("")
        this.j2P3=Label("")
        this.dateP3=Label("")
        this.dureP3=Label("")
        this.del3=Button("Supprimer")


        // LOAD 4
        this.charge4= GridPane()
        this.nomP4= Label("Emplacement Vide")
        this.j1P4= Label("")
        this.j2P4=Label("")
        this.dateP4=Label("")
        this.dureP4=Label("")
        this.del4=Button("Supprimer")

        del1.isDisable=true
        del2.isDisable=true
        del3.isDisable=true
        del4.isDisable=true
        charge1.isDisable=true
        charge2.isDisable=true
        charge3.isDisable=true
        charge4.isDisable=true


        screenSizeBox.padding=Insets(10.0)
        screenSizeBox.alignment=Pos.TOP_RIGHT
        this.screenSizeFull= Image("file:src/main/resources/projet/echecmartien/fullscreen.png")
        this.screenSizeSmall=Image("file:src/main/resources/projet/echecmartien/smallscreen.png")
        a=ImageView(screenSizeFull)
        b=ImageView(screenSizeSmall)
        a.fitHeight=30.0
        a.fitWidth=30.0
        b.fitHeight=30.0
        b.fitWidth=30.0
        screenSizeBox.children.add(a)




            setMargin(charge1, Insets(5.0))
            setMargin(charge2, Insets(5.0))
            setMargin(charge3, Insets(5.0))
            setMargin(charge4, Insets(5.0))
            setMargin(back, Insets(0.0,70.0,0.0,0.0))

            dateP1.padding= Insets(0.0,0.0,0.0,50.0)
            dateP4.padding= Insets(0.0,0.0,0.0,50.0)
            dateP2.padding= Insets(0.0,0.0,0.0,50.0)
            dateP3.padding= Insets(0.0,0.0,0.0,50.0)

            setMargin(nomP1, Insets(20.0))
            setMargin(nomP2, Insets(20.0))
            setMargin(nomP3, Insets(20.0))
            setMargin(nomP4, Insets(20.0))

        fun rowconstraint(){
            row1.percentHeight=20.0
            row2.percentHeight=15.0
            row3.percentHeight=10.0
            row2.valignment=VPos.TOP
            row3.valignment=VPos.CENTER
            this.rowConstraints.addAll(row3,row2,row1,row1,row1,row1,row3)
        }
        rowconstraint()

        fun colconstraint(){
            col1.halignment=HPos.CENTER
            col1.percentWidth=15.0
            col2.percentWidth=70.0
            col2.halignment=HPos.CENTER
            col3.percentWidth=15.0

            this.columnConstraints.addAll(col1,col2,col3)

            col11.percentWidth=50.0
            col12.percentWidth=17.5
            col13.percentWidth=15.0

            charge3.prefHeight=150.0
            charge3.columnConstraints.addAll(col11,col12,col12,col13)

            charge4.prefHeight=150.0
            charge4.columnConstraints.addAll(col11,col12,col12,col13)

            charge2.prefHeight=150.0
            charge2.columnConstraints.addAll(col11,col12,col12,col13)

            charge1.prefHeight=150.0
            charge1.columnConstraints.addAll(col11,col12,col12,col13)
        }
        colconstraint()



        fun addGrid(){

            charge1.add(nomP1,0,0)
            charge1.add(j1P1,1,0)
            charge1.add(j2P1,2,0)
            charge1.add(dateP1,0,1)
            charge1.add(dureP1,1,1)
            charge1.add(del1,3,0)

            charge2.add(nomP2,0,0)
            charge2.add(j1P2,1,0)
            charge2.add(j2P2,2,0)
            charge2.add(dateP2,0,1)
            charge2.add(dureP2,1,1)
            charge2.add(del2,3,0)

            charge3.add(nomP3,0,0)
            charge3.add(j1P3,1,0)
            charge3.add(j2P3,2,0)
            charge3.add(dateP3,0,1)
            charge3.add(dureP3,1,1)
            charge3.add(del3,3,0)

            charge4.add(nomP4,0,0)
            charge4.add(j1P4,1,0)
            charge4.add(j2P4,2,0)
            charge4.add(dateP4,0,1)
            charge4.add(dureP4,1,1)
            charge4.add(del4,3,0)

            this.add(screenSizeBox,2,0)
            this.add(titre,1,1)
            this.add(charge1,1,2)
            this.add(charge2,1,3)
            this.add(charge3,1,4)
            this.add(charge4,1,5)
            this.add(back,0,6)
        }
        addGrid()

    }
}