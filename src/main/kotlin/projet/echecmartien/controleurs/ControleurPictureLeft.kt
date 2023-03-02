package projet.echecmartien.controleurs

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.scene.layout.VBox
import projet.echecmartien.modele.Skins
import projet.echecmartien.vue.VueNewJeu

class ControleurPictureLeft(vue:VueNewJeu, players:Skins,skin:VBox):EventHandler<ActionEvent> {

    var vue:VueNewJeu
    var players:Skins
    var skin:VBox

    init {
        this.vue=vue
        this.players=players
        this.skin=skin
    }
    override fun handle(p0: ActionEvent?) {
        if (skin==vue.skinsP1){
            if (vue.cpt1==0){
                if (vue.cpt2==players.getSize()-1){
                    vue.cpt1=players.getSize()-2
                }else{
                    vue.cpt1=players.getSize()-1
                }
            }
            else if(vue.cpt1-1==vue.cpt2){
                if (vue.cpt1-1==0){
                    vue.cpt1=players.getSize()-1
                }else{
                    vue.cpt1-=2
                }
            }
            else{
                vue.cpt1-=1
            }
            vue.picP1.children.remove(vue.picP1.children[1])
            vue.picP1.children.add(1,players.getSkin(vue.cpt1, 300.0, 300.0))
            vue.player1.setColor(vue.cpt1)
            vue.GP1.fill=vue.player1.getColor()
            vue.MP1.fill=vue.player1.getColor()
            vue.PP1.fill=vue.player1.getColor()
        }
        if (skin==vue.skinsP2){
            if (vue.cpt2==0){
                if (vue.cpt1==players.getSize()-1){
                    vue.cpt2=players.getSize()-2
                }else{
                    vue.cpt2=players.getSize()-1
                }
            }
            else if(vue.cpt2-1==vue.cpt1){
                if (vue.cpt2-1==0){
                    vue.cpt2=players.getSize()-1
                }else{
                    vue.cpt2-=2
                }
            }
            else{
                vue.cpt2-=1
            }
            vue.picP2.children.remove(vue.picP2.children[1])
            vue.picP2.children.add(1,players.getSkin(vue.cpt2,300.0,300.0))
            vue.player1.setColor(vue.cpt2)
            vue.GP2.fill=vue.player1.getColor()
            vue.MP2.fill=vue.player1.getColor()
            vue.PP2.fill=vue.player1.getColor()
        }

    }
}