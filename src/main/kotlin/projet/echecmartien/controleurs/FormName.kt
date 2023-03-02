package projet.echecmartien.controleurs

import javafx.event.EventHandler
import javafx.scene.input.KeyEvent
import projet.echecmartien.vue.VueNewJeu

class FormName(vue: VueNewJeu):EventHandler<KeyEvent> {
    var vue:VueNewJeu

    init {
        this.vue=vue
    }

    override fun handle(p0: KeyEvent?) {
        if (vue.nameP1.length>=12){
            vue.nameP1.text=vue.nameP1.text.dropLast(1)
            vue.nameP1.positionCaret(12)
        }
        if (vue.nameP2.length>=12){
            vue.nameP2.text=vue.nameP2.text.dropLast(1)
            vue.nameP2.positionCaret(12)
        }
    }
}