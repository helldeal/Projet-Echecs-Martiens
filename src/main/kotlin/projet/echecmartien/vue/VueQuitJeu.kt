package projet.echecmartien.vue

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class VueQuitJeu(): VBox() {
    val primary:Label
    val primarylab2:Label
    val secondary:HBox
    val buttonAnnul:Button
    val buttonQuit:Button
    val buttonQuitNoSave:Button

    init {
        this.primary=Label("Voulez-vous quitter la partie ?" )
        this.primarylab2=Label("Toutes données non sauvegardées seront supprimées")
        this.alignment=Pos.CENTER
        primary.alignment=Pos.TOP_CENTER
        this.secondary=HBox()

        this.children.addAll(primary,primarylab2, secondary)

        this.buttonQuit=Button("Sauvegarder et quitter")
        this.buttonQuitNoSave=Button("Quitter sans sauvegarder")
        this.buttonAnnul=Button("Annuler")
        secondary.children.addAll(buttonAnnul,buttonQuit,buttonQuitNoSave)
        secondary.alignment=Pos.BOTTOM_CENTER
        secondary.prefHeight=60.0
        secondary.spacing=30.0
    }
}