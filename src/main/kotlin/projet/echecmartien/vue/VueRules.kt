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
import javafx.scene.text.TextAlignment

class VueRules(): GridPane() {
    val back:Button
    val main:GridPane
    val title:Label
    val text:Label
    val col0:ColumnConstraints
    val col1:ColumnConstraints
    val col2:ColumnConstraints
    val row0:RowConstraints
    val row1:RowConstraints
    val row2:RowConstraints

    //FULLSCREEN
    val screenSizeBox:VBox
    var screenSizeFull: Image
    var screenSizeSmall: Image
    var a: ImageView
    var b: ImageView

    init {
        //FULLSCREEN
        this.back= Button("Retour")
        this.screenSizeBox=VBox()
        screenSizeBox.alignment=Pos.TOP_RIGHT
        screenSizeBox.padding= Insets(0.0,5.0,5.0,0.0)
        this.screenSizeFull= Image("file:src/main/resources/projet/echecmartien/fullscreen.png")
        this.screenSizeSmall=Image("file:src/main/resources/projet/echecmartien/smallscreen.png")
        a=ImageView(screenSizeFull)
        b=ImageView(screenSizeSmall)
        a.fitHeight=30.0
        a.fitWidth=30.0
        b.fitHeight=30.0
        b.fitWidth=30.0
        screenSizeBox.children.add(a)
        screenSizeBox.padding=Insets(10.0)
        this.main=GridPane()
        this.col0= ColumnConstraints()
        this.col1= ColumnConstraints()
        this.col2= ColumnConstraints()
        this.row2=RowConstraints()
        this.row0=RowConstraints()
        this.row1=RowConstraints()
        this.text= Label("PREPARATION\n" +
                "Disposez les 18 pions comme sur la figure ci-contre.\n" +
                "Un joueur identifie ses pièces par leur position à un instant donné.\n" +
                "Le damier est divisé en 2 zones, une pour chaque joueur. Toute pièce dans la zone d'un joueur est la sienne.\n" +
                "\n" +
                "DEROULEMENT DU JEU\n" +
                "Chaque joueur, à son tour de jeu, déplace une de ses pièces.\n" +
                "Les grands pions se déplacent verticalement, horizontalement et diagonalement de n cases (comme la dame aux Eches traditionnel).\n" +
                "Les pions moyens se déplacent verticalement, horizontalement et diagonalement de 1 ou 2 cases.\n" +
                "Les petits pions se déplacent diagonalement de 1 case.\n" +
                "A son tour de jeu un joueur peut déplacer n'importe quel pion de son camp, soit à l'intérieur de sa zone soit vers la zone adverse. \n"+
                "Exception: Il est interdit de renvoyer dans la zone adverse un pion qui vient d'arriver dans sa zone. Mais on peut déplacer ce même pion à l'intérieur de sa zone\n" +

                "On capture un pion adverse en prenant sa place (donc fatalement en prenant un pion de sa zone et en allant dans la zone adverse). Le pion capturé est retiré du damier..\n" +
                "Le saut par dessus un ou n pions adverses ou non n'est pas autorisé.\n" +"\n"+
                "FIN DE LA PARTIE\n" +
                "Une fois la partie finie (plus de pions à capturer car ils sont tous capturés ou plus aucunes prises n'est possibles), on compte 3 points par grand pion capturés, 2 par moyen et 1 par petit.\n" +

                "Le gagant est évidement le joueur qui à le plus de points.")
        text.isWrapText=true
        text.alignment=Pos.TOP_CENTER
        text.textAlignment=TextAlignment.CENTER
        text.setPrefSize(700.0, 535.0)
        this.title=Label("Règles des Échecs Martiens")
        this.add(title,1,0)
        this.add(text,1,1)
        this.add(back,0,2)
        setMargin(text, Insets(20.0) )
        col1.halignment=HPos.CENTER
        col2.percentWidth=15.0
        col0.percentWidth=15.0
        col0.halignment=HPos.CENTER
        col1.percentWidth=70.0
        col2.halignment=HPos.RIGHT
        row1.valignment=VPos.TOP
        row1.percentHeight=80.0
        row0.percentHeight=12.0
        row2.percentHeight=8.0
        row2.valignment=VPos.CENTER
        this.rowConstraints.addAll(row0,row1,row2)
        this.columnConstraints.addAll(col0,col1,col2)

        //FS
        this.add(screenSizeBox,2,0)

    }
}