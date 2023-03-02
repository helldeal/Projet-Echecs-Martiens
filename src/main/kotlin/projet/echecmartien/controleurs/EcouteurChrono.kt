package projet.echecmartien.controleurs

import javafx.event.ActionEvent
import javafx.event.EventHandler
import projet.echecmartien.vue.VueJeu

class EcouteurChrono(vue:VueJeu,a:Long) : EventHandler<ActionEvent> {
    private val vue:VueJeu
    private val a:Long

    //--- Constructeur ---------------------------------
    init {
        this.vue=vue
        this.a=a
    }

    //--- Code exécuté lorsque l'événement survient ----
    override  fun handle(event: ActionEvent) {
        val minutes = ((System.currentTimeMillis()/1000)-a) / 60
        val seconde= ((System.currentTimeMillis()/1000)-a)-minutes*60
        vue.timer.text=String.format("%02d:%02d",minutes, seconde)
    }

}