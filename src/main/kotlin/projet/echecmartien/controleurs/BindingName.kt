package projet.echecmartien.controleurs

import projet.echecmartien.vue.VueNewJeu

class BindingName(vue:VueNewJeu) {
    var vue:VueNewJeu
    init {
        this.vue=vue
    }
    fun bindNomPlayer(){
        vue.nameP1.isEditable=true
        vue.labP1.textProperty().bind(vue.nameP1.textProperty())
        vue.nameP2.isEditable=true
        vue.labP2.textProperty().bind(vue.nameP2.textProperty())

    }
}