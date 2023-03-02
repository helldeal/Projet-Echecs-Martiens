package projet.echecmartien.controleurs

import javafx.event.EventHandler
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import projet.echecmartien.vue.VueMenu

class EcouteurHoverButton(vue: VueMenu, button:Button): EventHandler<MouseEvent> {
    var vue:VueMenu
    var button:Button

    init{
        this.vue=vue
        this.button=button
    }

    override fun handle(p0: MouseEvent?) {
        if (p0?.eventType  == MouseEvent.MOUSE_ENTERED) {
            button.style = "-fx-background-color:  rgb( 0, 110, 186, 0.5)  ;"
        }
        if (p0?.eventType  == MouseEvent.MOUSE_EXITED)
            button.style="-fx-background-color: None;"
    }
}