package projet.echecmartien.vue


import javafx.geometry.Insets
import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout.BorderPane
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.scene.shape.Circle
import javafx.scene.text.TextAlignment
import projet.echecmartien.modele.Player
import projet.echecmartien.modele.Skins

class VueNewJeu():BorderPane() {

    //MAIN
    var p1:VBox
    var p2:VBox
    var ctr:VBox


    //PLAYER1
    var player1:Player
    var setP1:VBox
    var labP1:Label
    var nameP1:TextField
    var picP1:HBox
    var skinsP1:VBox
    var pionsP1:HBox
    var GP1:Circle
    var MP1:Circle
    var PP1:Circle
    var emptyTop:VBox
    var leftPicP1:Button
    var rightPicP1 : Button

    //PLAYER2
    var IAcheck:Boolean
    var IAb:Button
    var player2:Player
    var setP2:VBox
    var labP2:Label
    var nameP2:TextField
    var picP2:HBox
    var skinsP2:VBox
    var leftPicP2:Button
    var rightPicP2 : Button
    var pionsP2:HBox
    var GP2:Circle
    var MP2:Circle
    var PP2:Circle


    //OTHERS
    val screenTop:VBox
    val screenSizeBox:VBox
    var screenSizeFull:Image
    var screenSizeSmall:Image
    var a:ImageView
    var b:ImageView
    val play:Button
    val back: Button
    var cpt1=0
    var cpt2=1
    var str:String=""


    init {
        this.style= ("-fx-background-image: url('file:src/main/resources/projet/echecmartien/spacegif5.gif'); -fx-background-size:cover;")
        IAcheck=false

        //PLAYER1
        player1=Player(1)
        player1.setSkin(0)
        player1.setColor(0)
        this.setP1=VBox()
        this.emptyTop=VBox()
        emptyTop.prefHeight=50.0
        p1=VBox()
        p1.minWidth=450.0
        this.left=p1
        p1.alignment=Pos.TOP_CENTER
        p1.spacing=30.0
        labP1=Label()
        labP1.textFill=Color.WHITE
        labP1.alignment=Pos.TOP_LEFT
        labP1.textAlignment=TextAlignment.CENTER
        labP1.style="-fx-font-size:22.0;"
        picP1=HBox()
        picP1.alignment=Pos.CENTER
        val logo1=Skins().getSkin(0)
        logo1.fitHeight=300.0
        logo1.fitWidth=300.0
        rightPicP1= Button(">")
        leftPicP1=Button("<")
        rightPicP1.prefHeight=300.0
        leftPicP1.prefHeight=300.0
        picP1.children.addAll(leftPicP1,logo1,rightPicP1)
        nameP1=TextField()
        nameP1.promptText="YOUR PSEUDO HERE"
        !nameP1.isFocused
        skinsP1=VBox()
        nameP1.style=("-fx-background-color:rgb(0,0,0,0.6);-fx-text-fill:white;")
        pionsP1=HBox()
        GP1= Circle(25.0)
        GP1.fill=player1.getColor()
        MP1=Circle(20.0)
        MP1.fill=player1.getColor()
        PP1=Circle(15.0)
        PP1.fill=player1.getColor()
        skinsP1.children.add(pionsP1)
        skinsP1.spacing=10.0
        skinsP1.alignment=Pos.CENTER
        pionsP1.children.addAll(GP1,MP1,PP1)
        pionsP1.alignment=Pos.CENTER
        pionsP1.spacing=10.0
        pionsP1.padding= Insets(10.0)
        p1.children.addAll(emptyTop,setP1)
        setP1.children.addAll(labP1,picP1,nameP1,skinsP1)
        setP1.padding=Insets(30.0)
        setP1.spacing=20.0
        setP1.alignment=Pos.CENTER

        p1.style="-fx-background-color: rgb(0,0,0,0.3);"
        skinsP1.style="-fx-background-color: rgb(0,0,0,0.5);"



        //PLAYER2
        player2=Player(2)
        player2.setSkin(1)
        player2.setColor(1)
        this.setP2=VBox()
        p2=VBox()
        p2.minWidth=450.0
        this.right=p2
        p2.alignment=Pos.TOP_CENTER
        p2.spacing=30.0
        labP2=Label()
        labP2.textFill=Color.WHITE
        labP2.alignment=Pos.TOP_RIGHT
        labP2.textAlignment=TextAlignment.CENTER
        labP2.style="-fx-font-size:22.0;"
        picP2=HBox()
        picP2.alignment=Pos.CENTER
        val logo2=Skins().getSkin(1)
        logo2.fitHeight=300.0
        logo2.fitWidth=300.0

        nameP2=TextField()

        nameP2.style=("-fx-background-color:rgb(0,0,0,0.6);-fx-text-fill:white;")
        nameP2.promptText="YOUR PSEUDO HERE"
        skinsP2=VBox()
        skinsP2.padding=Insets(30.0)

        leftPicP2=Button("<")
        rightPicP2= Button((">"))
        leftPicP2.prefHeight=300.0
        rightPicP2.prefHeight=300.0

        this.screenSizeBox=VBox()

        screenSizeBox.alignment=Pos.TOP_RIGHT
        screenSizeBox.padding= Insets(10.0)
        this.screenSizeFull= Image("file:src/main/resources/projet/echecmartien/fullscreen.png")
        this.screenSizeSmall=Image("file:src/main/resources/projet/echecmartien/smallscreen.png")
        a=ImageView(screenSizeFull)
        b=ImageView(screenSizeSmall)
        a.fitHeight=30.0
        a.fitWidth=30.0
        b.fitHeight=30.0
        b.fitWidth=30.0
        screenSizeBox.children.add(a)

        pionsP2=HBox()
        GP2= Circle(25.0)
        GP2.fill=player2.getColor()
        MP2=Circle(20.0)
        MP2.fill=player2.getColor()
        PP2=Circle(15.0)
        PP2.fill=player2.getColor()
        skinsP2.children.add(pionsP2)
        skinsP2.spacing=10.0
        skinsP2.alignment=Pos.CENTER
        pionsP2.children.addAll(GP2,MP2,PP2)
        pionsP2.alignment=Pos.CENTER
        pionsP2.spacing=10.0
        pionsP2.padding= Insets(10.0)
        this.screenTop=VBox()
        p2.children.addAll(screenTop,setP2)
        screenTop.children.add(screenSizeBox)
        screenTop.alignment=Pos.TOP_CENTER
        setP2.children.addAll(labP2,picP2,nameP2,skinsP2)
        setP2.alignment=Pos.BOTTOM_CENTER
        setP2.padding=Insets(30.0)
        setP2.spacing=20.0
        p2.style="-fx-background-color: rgb(0,0,0,0.3);"
        skinsP2.style="-fx-background-color: rgb(0,0,0,0.5);"
        picP2.children.addAll(leftPicP2,logo2,rightPicP2)

        //CENTER
        ctr=VBox()
        this.center=ctr
        back = Button("Retour")
        back.padding=Insets(10.0)
        this.play=Button("Jouer")
        IAb= Button("IA")
        IAb.padding=Insets(15.0)
        ctr.children.addAll(play,IAb,back)
        ctr.spacing= 75.0
        ctr.padding=Insets(0.0,0.0,50.0,0.0)
        play.prefWidth=200.0
        play.prefHeight=70.0
        back.padding=Insets(10.0)

        BorderPane.setAlignment(ctr,Pos.BOTTOM_CENTER)
        ctr.alignment=Pos.BOTTOM_CENTER
        nameP1.alignment=Pos.CENTER
        nameP2.alignment=Pos.CENTER
        IAb.setOnAction {
            IAcheck=!IAcheck
            nameP2.isEditable=!nameP2.isEditable
            if (IAcheck){
                nameP2.text="IA"
                IAb.style= "-fx-background-color:  rgb( 0, 110, 186, 0.5);"
            }
            else {
                nameP2.text=""
                IAb.style= "-fx-background-color:  rgb( 0, 0, 0, 0.6);"
            }
        }
/*        //BONUS
        this.setOnKeyPressed {

            if (it.code== KeyCode.R) {
                str = "r"
            }
            else if (it.code== KeyCode.E && str=="r") {
                str = "re"
            }
            else if (it.code== KeyCode.M && (str=="re" || str=="rem")) {
                str += "m"
            }
            else{
                str=""
            }
            if (str=="remm"){
                Skins().evolute()
                println("yesssssss")
                println(Skins().getSkinf(Skins().getSize()-1))
            }
        }*/
    }
}