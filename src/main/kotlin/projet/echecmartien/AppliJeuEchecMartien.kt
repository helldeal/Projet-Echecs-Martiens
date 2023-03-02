package projet.echecmartien

import com.google.gson.JsonArray
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import javafx.application.Application
import javafx.application.Platform
import javafx.event.ActionEvent
import javafx.scene.Scene
import javafx.scene.input.KeyEvent
import javafx.scene.input.MouseEvent
import javafx.stage.Screen
import javafx.stage.Stage
import javafx.stage.StageStyle
import projet.echecmartien.controleurs.*
import projet.echecmartien.modele.Jeu
import projet.echecmartien.modele.Joueur
import projet.echecmartien.modele.Skins
import projet.echecmartien.modele.Timer
import projet.echecmartien.vue.*
import java.io.*
import java.text.ParseException


@Suppress("RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class AppliJeuEchecMartien: Application() {


    fun createStageMenu(stage: Stage):VueMenu{
        val vue=VueMenu()
        vue.blauch.setOnAction {
            stage.scene.root=createStageNewGame(stage)
        }
        vue.bcharge.setOnAction {
            stage.scene.root=createStageCharge(stage)
        }
        vue.brule.setOnAction {
            stage.scene.root=createStageRules(stage)
        }

        vue.bset.setOnAction {
            stage.scene.root=createSettings(stage)
        }

        vue.blauch.addEventFilter(MouseEvent.ANY, EcouteurHoverButton(vue, vue.blauch))
        vue.brule.addEventFilter(MouseEvent.ANY, EcouteurHoverButton(vue, vue.brule))
        vue.bquit.addEventFilter(MouseEvent.ANY, EcouteurHoverButton(vue, vue.bquit))
        vue.bcharge.addEventFilter(MouseEvent.ANY, EcouteurHoverButton(vue, vue.bcharge))
        vue.bset.addEventFilter(MouseEvent.ANY, EcouteurHoverButton(vue, vue.bset))
        vue.blauch.styleClass.add("backrules")
        vue.bquit.addEventFilter(ActionEvent.ACTION,ControleurQuitGame(stage, createStageQuit()))
        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        stage.title="ECHECS MARTIENS - MENU"
        return vue
    }

    fun createSettings(stage: Stage): VueSettings{
        val vue=VueSettings()
        return vue
    }

    fun createStageNewGame(stage: Stage):VueNewJeu{
        val vue=VueNewJeu()
        stage.scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        BindingName(vue).bindNomPlayer()
        vue.nameP1.addEventHandler(KeyEvent.KEY_TYPED,FormName(vue))
        vue.nameP2.addEventHandler(KeyEvent.KEY_TYPED,FormName(vue))
        vue.leftPicP1.addEventHandler(ActionEvent.ACTION,ControleurPictureLeft(vue,Skins(),vue.skinsP1))
        vue.rightPicP1.addEventHandler(ActionEvent.ACTION,ControleurPictureRight(vue,Skins(),vue.skinsP1))
        vue.leftPicP2.addEventHandler(ActionEvent.ACTION,ControleurPictureLeft(vue,Skins(),vue.skinsP2))
        vue.rightPicP2.addEventHandler(ActionEvent.ACTION,ControleurPictureRight(vue,Skins(),vue.skinsP2))
        vue.back.setOnAction {
            stage.scene.root=createStageMenu(stage)
        }
        vue.IAb.styleClass.add("IAb")
        vue.play.styleClass.add("play")
        vue.back.styleClass.add("backnew")
        vue.rightPicP1.styleClass.add("fleches")
        vue.rightPicP2.styleClass.add("fleches")
        vue.leftPicP1.styleClass.add("fleches")
        vue.leftPicP2.styleClass.add("fleches")
        vue.play.setOnAction {
            JSONWRITE(vue.labP1.text,vue.cpt1,0,vue.labP2.text,vue.cpt2,0,"",0,"","src/main/resources/projet/echecmartien/current.json",vue.IAcheck)
            stage.scene.root=createStageJeu(stage,"src/main/resources/projet/echecmartien/current.json")
        }
        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        stage.title="ECHECS MARTIENS - NOUVELLE PARTIE"
        return vue
    }

    fun createStageCharge(stage: Stage):VueCharge{
        val vue=VueCharge()
        val list1=JSONREAD("src/main/resources/projet/echecmartien/Save1.json").split(",")
        val list2=JSONREAD("src/main/resources/projet/echecmartien/Save2.json").split(",")
        val list3=JSONREAD("src/main/resources/projet/echecmartien/Save3.json").split(",")
        val list4=JSONREAD("src/main/resources/projet/echecmartien/Save4.json").split(",")
        if (list1[0].isNotBlank()){
            vue.del1.isDisable=false
            vue.charge1.isDisable=false
            vue.nomP1.text="Charger la partie"
            vue.dureP1.text="duree: "+list1[7]+"s"
            vue.j1P1.text=list1[0]+" : "+list1[4]
            vue.j2P1.text=list1[1]+" : "+list1[5]
        }
        if (list2[0].isNotBlank()){
            vue.del2.isDisable=false
            vue.charge2.isDisable=false
            vue.nomP2.text="Charger la partie"
            vue.dureP2.text="Duree: "+list2[7]+"s"
            vue.j1P2.text=list2[0]+" : "+list2[4]
            vue.j2P2.text=list2[1]+" : "+list2[5]
        }
        if (list3[0].isNotBlank()){
            vue.del3.isDisable=false
            vue.charge3.isDisable=false
            vue.nomP3.text="Charger la partie"
            vue.dureP3.text="duree: "+list3[7]+"s"
            vue.j1P3.text=list3[0]+" : "+list3[4]
            vue.j2P3.text=list3[1]+" : "+list3[5]
        }
        if (list4[0].isNotBlank()){
            vue.del4.isDisable=false
            vue.charge4.isDisable=false
            vue.nomP4.text="Charger la partie"
            vue.dureP4.text="duree: "+list4[7]+"s"
            vue.j1P4.text=list4[0]+" : "+list4[4]
            vue.j2P4.text=list4[1]+" : "+list4[5]
        }

        vue.back.setOnAction {
            stage.scene.root=createStageMenu(stage)
        }
        vue.del1.addEventHandler(ActionEvent.ACTION,ControleurQuitGame(stage,createStageConfirmDelete(stage,1)))
        vue.del2.addEventHandler(ActionEvent.ACTION,ControleurQuitGame(stage,createStageConfirmDelete(stage,2)))
        vue.del3.addEventHandler(ActionEvent.ACTION,ControleurQuitGame(stage,createStageConfirmDelete(stage,3)))
        vue.del4.addEventHandler(ActionEvent.ACTION,ControleurQuitGame(stage,createStageConfirmDelete(stage,4)))
        vue.charge1.setOnMouseClicked {
            stage.scene.root=createStageJeu(stage,"src/main/resources/projet/echecmartien/Save1.json")
        }
        vue.charge2.setOnMouseClicked {
            stage.scene.root=createStageJeu(stage,"src/main/resources/projet/echecmartien/Save2.json")
        }
        vue.charge3.setOnMouseClicked {
            stage.scene.root=createStageJeu(stage,"src/main/resources/projet/echecmartien/Save3.json")
        }
        vue.charge4.setOnMouseClicked {
            stage.scene.root=createStageJeu(stage,"src/main/resources/projet/echecmartien/Save4.json")
        }
        stage.scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        vue.back.styleClass.add("backrules")
        vue.del1.styleClass.add("backrules")
        vue.del2.styleClass.add("backrules")
        vue.del3.styleClass.add("backrules")
        vue.del4.styleClass.add("backrules")
        vue.nomP1.styleClass.add("nom")
        vue.nomP2.styleClass.add("nom")
        vue.nomP3.styleClass.add("nom")
        vue.nomP4.styleClass.add("nom")
        vue.j1P1.styleClass.add("joueur")
        vue.j1P2.styleClass.add("joueur")
        vue.j1P3.styleClass.add("joueur")
        vue.j1P4.styleClass.add("joueur")
        vue.j2P1.styleClass.add("joueur")
        vue.j2P2.styleClass.add("joueur")
        vue.j2P3.styleClass.add("joueur")
        vue.j2P4.styleClass.add("joueur")
        vue.dateP1.styleClass.add("duree")
        vue.dateP2.styleClass.add("duree")
        vue.dateP3.styleClass.add("duree")
        vue.dateP4.styleClass.add("duree")
        vue.dureP1.styleClass.add("duree")
        vue.dureP2.styleClass.add("duree")
        vue.dureP3.styleClass.add("duree")
        vue.dureP4.styleClass.add("duree")
        vue.titre.styleClass.add("titrecharge")
        vue.charge1.styleClass.add("charge")
        vue.charge2.styleClass.add("charge")
        vue.charge3.styleClass.add("charge")
        vue.charge4.styleClass.add("charge")
        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        stage.title="ECHECS MARTIENS - CHARGER UNE PARTIE"
        return vue
    }

    fun createStageSave(stage: Stage):VueSave{
        val vue=VueSave()
        val list1=JSONREAD("src/main/resources/projet/echecmartien/Save1.json").split(",")
        val list2=JSONREAD("src/main/resources/projet/echecmartien/Save2.json").split(",")
        val list3=JSONREAD("src/main/resources/projet/echecmartien/Save3.json").split(",")
        val list4=JSONREAD("src/main/resources/projet/echecmartien/Save4.json").split(",")
        if (list1[0].isNotBlank()){
            vue.nomP1.text="Remplacer la partie"
            vue.dureP1.text="duree: "+list1[7]+"s"
            vue.j1P1.text=list1[0]+" : "+list1[4]
            vue.j2P1.text=list1[1]+" : "+list1[5]
        }
        if (list2[0].isNotBlank()){
            vue.nomP2.text="Remplacer la partie"
            vue.dureP2.text="Duree: "+list2[7]+"s"
            vue.j1P2.text=list2[0]+" : "+list2[4]
            vue.j2P2.text=list2[1]+" : "+list2[5]
        }
        if (list3[0].isNotBlank()){
            vue.nomP3.text="Remplacer la partie"
            vue.dureP3.text="duree: "+list3[7]+"s"
            vue.j1P3.text=list3[0]+" : "+list3[4]
            vue.j2P3.text=list3[1]+" : "+list3[5]
        }
        if (list4[0].isNotBlank()){
            vue.nomP4.text="Remplacer la partie"
            vue.dureP4.text="duree: "+list4[7]+"s"
            vue.j1P4.text=list4[0]+" : "+list4[4]
            vue.j2P4.text=list4[1]+" : "+list4[5]
        }

        vue.back.setOnAction {
            stage.scene.root=createStageJeu(stage,"src/main/resources/projet/echecmartien/current.json")
        }

        stage.scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        vue.back.styleClass.add("backrules")
        vue.nomP1.styleClass.add("nom")
        vue.nomP2.styleClass.add("nom")
        vue.nomP3.styleClass.add("nom")
        vue.nomP4.styleClass.add("nom")
        vue.j1P1.styleClass.add("joueur")
        vue.j1P2.styleClass.add("joueur")
        vue.j1P3.styleClass.add("joueur")
        vue.j1P4.styleClass.add("joueur")
        vue.j2P1.styleClass.add("joueur")
        vue.j2P2.styleClass.add("joueur")
        vue.j2P3.styleClass.add("joueur")
        vue.j2P4.styleClass.add("joueur")
        vue.dateP1.styleClass.add("duree")
        vue.dateP2.styleClass.add("duree")
        vue.dateP3.styleClass.add("duree")
        vue.dateP4.styleClass.add("duree")
        vue.dureP1.styleClass.add("duree")
        vue.dureP2.styleClass.add("duree")
        vue.dureP3.styleClass.add("duree")
        vue.dureP4.styleClass.add("duree")
        vue.titre.styleClass.add("titrecharge")
        vue.charge1.styleClass.add("charge")
        vue.charge2.styleClass.add("charge")
        vue.charge3.styleClass.add("charge")
        vue.charge4.styleClass.add("charge")
        vue.charge1.setOnMouseClicked {
            val stage2 = createStageConfirmSave(stage,1)
            stage2.width=600.0
            stage2.height=250.0
            val rect = Screen.getPrimary().bounds
            stage2.x=rect.width/3
            stage2.y=rect.height/3
            stage2.show()
        }
        vue.charge2.setOnMouseClicked {
            val stage2 = createStageConfirmSave(stage,2)
            stage2.width=600.0
            stage2.height=250.0
            val rect = Screen.getPrimary().bounds
            stage2.x=rect.width/3
            stage2.y=rect.height/3
            stage2.show()
        }
        vue.charge3.setOnMouseClicked {
            val stage2 = createStageConfirmSave(stage,3)
            stage2.width=600.0
            stage2.height=250.0
            val rect = Screen.getPrimary().bounds
            stage2.x=rect.width/3
            stage2.y=rect.height/3
            stage2.show()
        }
        vue.charge4.setOnMouseClicked {
            val stage2 = createStageConfirmSave(stage,4)
            stage2.width=600.0
            stage2.height=250.0
            val rect = Screen.getPrimary().bounds
            stage2.x=rect.width/3
            stage2.y=rect.height/3
            stage2.show()
        }
        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        stage.title="ECHECS MARTIENS - SAUVERGARDER LA PARTIE"
        return vue
    }

    fun createStageJeu(stage: Stage,fichier:String):VueJeu{
        val modele=Jeu()
        var j1=Joueur("")
        var j2=Joueur("")
        var cpt1=0
        var cpt2=0
        var pnt1=0
        var pnt2=0
        var IA = false
        var jc=""
        var timepassed=0
        var plat=""
        val jsonParser = JsonParser()
        try {
            FileReader(fichier).use { reader ->
                //Read JSON file
                val obj: Any = jsonParser.parse(reader)
                val employeeList: JsonArray = obj as JsonArray
                println(employeeList)
                j1= Joueur(employeeList[0].toString().substringAfter("\"Nom\":\"").substringBefore("\""))
                j2= Joueur(employeeList[1].toString().substringAfter("\"Nom\":\"").substringBefore("\""))
                cpt1 = employeeList[0].toString().substringAfter("\"Skin\":").substringBefore(",\"").toInt()
                cpt2 = employeeList[1].toString().substringAfter("\"Skin\":").substringBefore(",\"").toInt()
                pnt1 = employeeList[0].toString().substringAfter("\"Point\":").substringBefore("}").toInt()
                pnt2 = employeeList[1].toString().substringAfter("\"Point\":").substringBefore("}").toInt()
                jc=employeeList[2].toString().substringAfter("\"Joueur\":\"").substringBefore("\"")
                timepassed = employeeList[3].toString().substringAfter("\"Chrono\":").substringBefore("}").toInt()
                plat=employeeList[4].toString().substringAfter("\"Tableau\":\"").substringBefore("\"}")
                IA=employeeList[5].toString().substringAfter("\"IA\":").substringBefore("}").toBoolean()

                //Iterate over employee array
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        if (j1.getPseudo().isBlank())j1=Joueur("Joueur 1")
        if (j2.getPseudo().isBlank())j2=Joueur("Joueur 2")
        modele.initialiserPartie(j1,j2,20)
        if (jc.isNotBlank()){
            if (j2.getPseudo()==jc)modele.changeJoueurCourant()
        }
        if (plat.isNotBlank()){
            modele.plateau.chargetableau(plat)
        }
        val vue=VueJeu(modele,j1,j2,cpt1,cpt2,pnt1,pnt2,IA)
        vue.update()
        val a=System.currentTimeMillis()/1000-timepassed
        val timer = Timer(0.1,EcouteurChrono(vue,a))
        timer.start()

        vue.setOnMouseMoved {
            if (modele.arretPartie())stage.scene.root=createStageVictory(stage, j1,j2,cpt1,cpt2,j2.calculerScore()+pnt2,j1.calculerScore()+pnt1)
        }

        vue.quit.addEventFilter(ActionEvent.ACTION,ControleurQuitGame(stage, createStageQuitJeu(stage)))
        vue.quit.styleClass.add("backrules")
        vue.quit.setOnAction {
            var stringplat = ""
            for (i in 0 until vue.plateau.getTailleVerticale()) {
                for (y in 0 until vue.plateau.getTailleHorizontale()) {
                    val case = vue.plateau.getCases()[i][y]
                    stringplat+=case.getPion().toString().substringBefore("@")+","
                }
            }
            JSONWRITE(vue.j1.getPseudo(),vue.cpt1, vue.lj1point.text.substringBefore(" Point").toInt(),
                vue.j2.getPseudo(),vue.cpt2,vue.lj2point.text.substringBefore(" Point").toInt(),modele.getJoueurCourant()!!.getPseudo()
                    ,(System.currentTimeMillis()/1000-a).toInt(),stringplat,"src/main/resources/projet/echecmartien/current.json",IA)
        }
        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        stage.title="ECHECS MARTIENS - EN TRAIN DE JOUER"
        return vue

    }

    fun createStageRules(stage: Stage):VueRules{
        val vue=VueRules()
        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        vue.back.setOnAction {
            stage.scene.root=createStageMenu(stage)
        }
        stage.scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        vue.back.styleClass.add("backrules")
        vue.styleClass.add("thisrules")
        vue.text.styleClass.add("textrules")
        vue.title.styleClass.add("titlerules")
        stage.title="ECHECS MARTIENS - REGLES DU JEU"
        return vue
    }

    fun createStageQuit():Stage{
        val stageQuit=Stage(StageStyle.UNDECORATED)
        val vue = VueQuit()
        vue.buttonQuit.setOnAction {
            Platform.exit()
        }
        vue.buttonAnnul.setOnAction {
            stageQuit.close()
        }
        vue.primary.styleClass.add("primary")
        vue.buttonQuit.styleClass.add("buttonquit")
        vue.buttonAnnul.styleClass.add("buttonannul")
        vue.styleClass.add("thisquit")

        stageQuit.title="ECHECS MARTIENS - QUITTER"
        val scene=Scene(vue,1200.0,700.0)
        scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        stageQuit.scene=scene
        return stageQuit

    }

    fun createStageQuitJeu(stage: Stage):Stage{
        val stageQuitJeu=Stage(StageStyle.UNDECORATED)
        val vue = VueQuitJeu()

        vue.buttonQuit.setOnAction {
            stage.scene.root=createStageSave(stage)
            stageQuitJeu.close()
        }
        vue.buttonAnnul.setOnAction {
            stageQuitJeu.close()
        }
        vue.buttonQuitNoSave.setOnAction {
            stage.scene.root=createStageMenu(stage)
            stageQuitJeu.close()
        }
        vue.primary.styleClass.add("primary")
        vue.buttonQuit.styleClass.add("buttonquitsave")
        vue.buttonAnnul.styleClass.add("buttonannul")
        vue.styleClass.add("thisquit")
        vue.primarylab2.styleClass.add("primaryjeu2")
        vue.buttonQuitNoSave.styleClass.add("buttonquit")

        stageQuitJeu.title="ECHECS MARTIENS - QUITTER"
        val scene=Scene(vue,1200.0,700.0)
        scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        stageQuitJeu.scene=scene
        return stageQuitJeu

    }
    fun createStageConfirmSave(stage: Stage,n:Int):Stage{
        val stageConfirmSave=Stage(StageStyle.UNDECORATED)
        val vue = VueConfirmSave()
        var fichier=""
        if (n==1)fichier="src/main/resources/projet/echecmartien/Save1.json"
        if (n==2)fichier="src/main/resources/projet/echecmartien/Save2.json"
        if (n==3)fichier="src/main/resources/projet/echecmartien/Save3.json"
        if (n==4)fichier="src/main/resources/projet/echecmartien/Save4.json"
        vue.buttonSave.setOnAction {
            stage.scene.root=createStageMenu(stage)
            val src = File("src/main/resources/projet/echecmartien/current.json")
            val dest = File(fichier)
            val fr = FileReader(src)
            val br = BufferedReader(fr)
            val fw = FileWriter(dest)
            var str: String? = null
            while (br.readLine().also { str = it } != null) {
                fw.write(str)
                fw.write("\n")
                fw.flush()
            }
            fw.close()
            stageConfirmSave.close()
        }
        vue.buttonAnnul.setOnAction {
            stageConfirmSave.close()
        }
        vue.primary.styleClass.add("primary")
        vue.buttonSave.styleClass.add("buttonquitsave")
        vue.buttonAnnul.styleClass.add("buttonannul")
        vue.styleClass.add("thisquit")
        vue.primarylab2.styleClass.add("primaryjeu2")

        stageConfirmSave.title="MARTIAN CHESS - SAUVEGARDER LA PARTIE"
        val scene=Scene(vue,1200.0,700.0)
        scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        stageConfirmSave.scene=scene
        return stageConfirmSave

    }
    fun createStageConfirmDelete(stage: Stage,n:Int):Stage{
        val stageConfirmDelete=Stage(StageStyle.UNDECORATED)
        val vue = VueConfirmDelete()
        var fichier=""
        if (n==1)fichier="src/main/resources/projet/echecmartien/Save1.json"
        if (n==2)fichier="src/main/resources/projet/echecmartien/Save2.json"
        if (n==3)fichier="src/main/resources/projet/echecmartien/Save3.json"
        if (n==4)fichier="src/main/resources/projet/echecmartien/Save4.json"
        vue.buttonSave.setOnAction {
            JSONWRITE("",0,0,"",0,0,"",0,"",fichier,false)
            stage.scene.root=createStageCharge(stage)
            stageConfirmDelete.close()
        }
        vue.buttonAnnul.setOnAction {
            stageConfirmDelete.close()
        }
        vue.primary.styleClass.add("primary")
        vue.buttonSave.styleClass.add("buttonquit")
        vue.buttonAnnul.styleClass.add("buttonannul")
        vue.styleClass.add("thisquit")
        stageConfirmDelete.title="MARTIAN CHESS - QUIT"
        val scene=Scene(vue,1200.0,700.0)
        scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        stageConfirmDelete.scene=scene
        return stageConfirmDelete
    }

    fun createStageVictory(stage: Stage, j1:Joueur,j2:Joueur,cpt1: Int,cpt2: Int,pnt2: Int,pnt1: Int):VueVictory{
        stage.scene.stylesheets.add(AppliJeuEchecMartien::class.java.getResource("style.css").toExternalForm())
        val modele=Jeu()
        val vue=VueVictory(modele,j1,j2,cpt1,cpt2,pnt1,pnt2)

        vue.screenSizeBox.addEventFilter(MouseEvent.MOUSE_CLICKED,EcouteurScreenSize(stage,vue))
        vue.styleClass.add("thisquit")
        vue.victoire.styleClass.add("titrevictoire")
        vue.BoutonMenu.styleClass.add("butMenu")
        vue.BoutonRejouer.styleClass.add("butMenu")
        vue.player1.styleClass.add("p1")
        vue.player2.styleClass.add("p1")
        vue.ScoreP2.styleClass.add("Vscore")
        vue.ScoreP1.styleClass.add("Vscore")
        vue.BoutonRejouer.setOnAction {
            stage.scene.root=createStageNewGame(stage)
        }
        vue.BoutonMenu.setOnAction {
            vue.BoutonMenu.scene.root=createStageMenu(stage)
        }

        stage.title="ECHECS MARTIENS - VICTOIRE!"
        return vue
    }

    fun JSONWRITE(pn1:String,cpt1:Int,pnt1:Int,pn2:String,cpt2:Int,pnt2:Int,pnc:String,timerpass:Int,plat:String,fichier: String,IA:Boolean){
        val Player1 = JsonObject()
        Player1.addProperty("Nom", pn1)
        Player1.addProperty("Skin", cpt1)
        Player1.addProperty("Point", pnt1)

        val PlayerObject = JsonObject()
        PlayerObject.add("Player1", Player1)

        val Player2 = JsonObject()
        Player2.addProperty("Nom", pn2)
        Player2.addProperty("Skin", cpt2)
        Player2.addProperty("Point", pnt2)

        val PlayerObject2 = JsonObject()
        PlayerObject2.add("Player2", Player2)

        val JoueurCourant = JsonObject()
        JoueurCourant.addProperty("Joueur",pnc)
        val JoueurCObject = JsonObject()
        JoueurCObject.add("JoueurCourant",JoueurCourant)

        val Time = JsonObject()
        Time.addProperty("Chrono",timerpass)
        val TimeObject = JsonObject()
        TimeObject.add("Temps",Time)

        val Plateau = JsonObject()
        Plateau.addProperty("Tableau",plat)
        val PlateauObject = JsonObject()
        PlateauObject.add("Plateau",Plateau)

        val Ordi = JsonObject()
        Ordi.addProperty("IA",IA)
        val OrdiObejct = JsonObject()
        OrdiObejct.add("active",Ordi)

        val Current = JsonArray()
        Current.add(PlayerObject)
        Current.add(PlayerObject2)
        Current.add(JoueurCObject)
        Current.add(TimeObject)
        Current.add(PlateauObject)
        Current.add(OrdiObejct)
        try {
            FileWriter(fichier).use { file ->
                file.write(Current.toString())
                file.flush()
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    fun JSONREAD(fichier:String):String{
        var j1=Joueur("")
        var j2=Joueur("")
        var cpt1=0
        var cpt2=0
        var pnt1=0
        var pnt2=0
        var jc=""
        var timepassed=0
        var plat=""
        var IA=false
        val jsonParser = JsonParser()
        try {
            FileReader(fichier).use { reader ->
                //Read JSON file
                val obj: Any = jsonParser.parse(reader)
                val employeeList: JsonArray = obj as JsonArray
                j1= Joueur(employeeList[0].toString().substringAfter("\"Nom\":\"").substringBefore("\""))
                j2= Joueur(employeeList[1].toString().substringAfter("\"Nom\":\"").substringBefore("\""))
                cpt1 = employeeList[0].toString().substringAfter("\"Skin\":").substringBefore(",\"").toInt()
                cpt2 = employeeList[1].toString().substringAfter("\"Skin\":").substringBefore(",\"").toInt()
                pnt1 = employeeList[0].toString().substringAfter("\"Point\":").substringBefore("}").toInt()
                pnt2 = employeeList[1].toString().substringAfter("\"Point\":").substringBefore("}").toInt()
                jc=employeeList[2].toString().substringAfter("\"Joueur\":\"").substringBefore("\"")
                timepassed = employeeList[3].toString().substringAfter("\"Chrono\":").substringBefore("}").toInt()
                plat=employeeList[4].toString().substringAfter("\"Tableau\":\"").substringBefore("\"}")
                IA=employeeList[5].toString().substringAfter("\"IA\":").substringBefore("}").toBoolean()

                //Iterate over employee array
            }
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return "${j1.getPseudo()},${j2.getPseudo()},$cpt1,$cpt2,$pnt1,$pnt2,$jc,$timepassed,$plat,$IA"
    }

    override fun start(primaryStage: Stage) {

        //CONTROLEURS
        val stage1=Stage(StageStyle.DECORATED)
        stage1.title="ECHECS MARTIENS - MENU"
        val scene=Scene(createStageMenu(stage1),1200.0,700.0)
        stage1.scene=scene

        stage1.show()

    }

}

fun main(){
    Application.launch(AppliJeuEchecMartien::class.java)
}



