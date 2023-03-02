package projet.echecmartien.vue

import javafx.geometry.Pos
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox

class VueConfirmDelete(): VBox() {
    val primary:Label
    val secondary:HBox
    val buttonAnnul:Button
    val buttonSave:Button

    init {
        this.primary=Label("Etes vous sûre de vouloir supprimer la sauvegarde ? ")
        this.alignment=Pos.CENTER
        primary.alignment=Pos.TOP_CENTER
        this.secondary=HBox()

        this.children.addAll(primary, secondary)
        this.style=("-fx-background-color: #0e1f2f;")

        this.buttonSave=Button("Supprimer")
        this.buttonAnnul=Button("Annuler")
        secondary.children.addAll(buttonAnnul,buttonSave)
        secondary.alignment=Pos.BOTTOM_CENTER
        secondary.prefHeight=60.0
        secondary.spacing=30.0
    }
}