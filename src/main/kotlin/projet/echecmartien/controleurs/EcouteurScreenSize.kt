package projet.echecmartien.controleurs


import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import javafx.stage.Stage
import projet.echecmartien.vue.*

class EcouteurScreenSize(stage: Stage, vue:Any):EventHandler<MouseEvent> {

    private var stage: Stage
    var vue:Any

    init {
        this.stage=stage
        this.vue=vue
    }

    override fun handle(p0: MouseEvent?) {
        try {
            if (vue is VueMenu){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueMenu).screenSizeBox.children.remove((vue as VueMenu).a)
                    (vue as VueMenu).screenSizeBox.children.add((vue as VueMenu).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueMenu).screenSizeBox.children.remove((vue as VueMenu).b)
                    (vue as VueMenu).screenSizeBox.children.add((vue as VueMenu).a)
                }
            }
            else if (vue is VueCharge){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueCharge).screenSizeBox.children.remove((vue as VueCharge).a)
                    (vue as VueCharge).screenSizeBox.children.add((vue as VueCharge).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueCharge).screenSizeBox.children.remove((vue as VueCharge).b)
                    (vue as VueCharge).screenSizeBox.children.add((vue as VueCharge).a)
                }
            }
            else if (vue is VueNewJeu){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueNewJeu).screenSizeBox.children.remove((vue as VueNewJeu).a)
                    (vue as VueNewJeu).screenSizeBox.children.add((vue as VueNewJeu).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueNewJeu).screenSizeBox.children.remove((vue as VueNewJeu).b)
                    (vue as VueNewJeu).screenSizeBox.children.add((vue as VueNewJeu).a)

                }
            }
            else if (vue is VueRules){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueRules).screenSizeBox.children.remove((vue as VueRules).a)
                    (vue as VueRules).screenSizeBox.children.add((vue as VueRules).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueRules).screenSizeBox.children.remove((vue as VueRules).b)
                    (vue as VueRules).screenSizeBox.children.add((vue as VueRules).a)
                }
            }
            else if (vue is VueSave){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueSave).screenSizeBox.children.remove((vue as VueSave).a)
                    (vue as VueSave).screenSizeBox.children.add((vue as VueSave).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueSave).screenSizeBox.children.remove((vue as VueSave).b)
                    (vue as VueSave).screenSizeBox.children.add((vue as VueSave).a)
                }
            }
            else if (vue is VueJeu){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueJeu).screenSizeBox.children.remove((vue as VueJeu).a)
                    (vue as VueJeu).screenSizeBox.children.add((vue as VueJeu).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueJeu).screenSizeBox.children.remove((vue as VueJeu).b)
                    (vue as VueJeu).screenSizeBox.children.add((vue as VueJeu).a)
                }
            }
            else if (vue is VueVictory){
                if (!stage.isFullScreen){
                    stage.isFullScreen=true
                    (vue as VueVictory).screenSizeBox.children.remove((vue as VueVictory).a)
                    (vue as VueVictory).screenSizeBox.children.add((vue as VueVictory).b)
                }
                else if (stage.isFullScreen){
                    stage.isFullScreen=false
                    (vue as VueVictory).screenSizeBox.children.remove((vue as VueVictory).b)
                    (vue as VueVictory).screenSizeBox.children.add((vue as VueVictory).a)
                }
            }
        }
        catch (_:java.lang.NullPointerException){}
        catch (_:java.lang.IllegalArgumentException){}

    }
}