package projet.echecmartien.controleurs

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.stage.Screen
import javafx.stage.Stage

class ControleurQuitGame(stage1:Stage,stage2:Stage):EventHandler<ActionEvent?> {

    private val stage1:Stage
    private val stage2:Stage


    init {
        this.stage1=stage1
        this.stage2=stage2
    }

    override fun handle(p0: ActionEvent?) {

        stage2.width=600.0
        stage2.height=250.0
        val rect =Screen.getPrimary().bounds
        stage2.x=rect.width/3
        stage2.y=rect.height/3
        stage2.show()


    }
}