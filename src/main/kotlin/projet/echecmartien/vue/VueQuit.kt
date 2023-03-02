package projet.echecmartien.vue

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class VueQuit(): VBox() {
    val primary:Label
    val secondary:HBox
    val buttonAnnul:Button
    val buttonQuit:Button

    init {
        this.primary=Label("Voulez-vous quitter le jeu ?")
        this.alignment=Pos.CENTER
        primary.alignment=Pos.TOP_CENTER
        this.secondary=HBox()

        this.children.addAll(primary,secondary)

        this.buttonQuit=Button("Quitter")
        this.buttonAnnul=Button("Annuler")
        secondary.children.addAll(buttonAnnul,buttonQuit)
        secondary.alignment=Pos.BOTTOM_CENTER
        secondary.prefHeight=60.0
        secondary.spacing=30.0
    }
}