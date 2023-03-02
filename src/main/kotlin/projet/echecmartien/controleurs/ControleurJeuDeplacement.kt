package projet.echecmartien.controleurs

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent
import javafx.scene.layout.GridPane
import projet.echecmartien.modele.Coordonnee
import projet.echecmartien.modele.DeplacementExeption
import projet.echecmartien.modele.Jeu
import projet.echecmartien.vue.VueJeu

class ControleurJeuDeplacement(vue:VueJeu, modele:Jeu,b:GridPane):EventHandler<MouseEvent> {

    var vue:VueJeu
    var modele:Jeu
    var b:GridPane

    init {
        this.vue=vue
        this.modele=modele
        this.b=b
    }

    override fun handle(p0: MouseEvent?) {
        val x= p0!!.source.toString().substringAfter("hgap=").substringBefore(", vgap").toDouble().toInt()
        val y= p0.source.toString().substringAfter("vgap=").substringBefore(", alignment").toDouble().toInt()

        if(!modele.arretPartie()){
            if (!modele.plateau.getCases()[y][x].estLibre()&&
                modele.plateau.getCases()[y][x].getJoueur()==modele.getJoueurCourant()){
                modele.setCoordOrigineDeplacement(Coordonnee(x,y))
                vue.originep=true
                vue.destp=false
                vue.updatelayout(x,y)
                println("Origine select en $x,$y")
            }
            else if (vue.originep) {
                modele.setCoordDestinationDeplacement(Coordonnee(x, y))
                vue.destp=true
                println("Destination select en $x,$y")
            }

            if (vue.originep&&vue.destp){
                val jc=modele.getJoueurCourant()
                try{
                    modele.deplacer(modele.getCoordOrigineDeplacement()!!.getX(),modele.getCoordOrigineDeplacement()!!.getY(),
                        modele.getCoordDestinationDeplacement()!!.getX(),modele.getCoordDestinationDeplacement()!!.getY())
                }
                catch (e:DeplacementExeption){
                    println("Déplacement impossible")
                }
                vue.update()
                vue.destp=false
                vue.originep=false

                if (vue.IA&&jc!=modele.getJoueurCourant()&&!modele.arretPartie()){
                    val listdepl= mutableListOf<Array<Int>>()
                    loop@
                    for (cy in 0 until modele.plateau.getTailleVerticale()) {
                        for (cx in 0 until modele.plateau.getTailleHorizontale()) {
                            for (dy in 0 until modele.plateau.getTailleVerticale()) {
                                for (dx in 0 until modele.plateau.getTailleHorizontale()) {
                                    try{
                                        if (modele.deplacementPossible(cx, cy, dx, dy, modele.getJoueurCourant())
                                                &&modele.plateau.getCases()[cy][cx].getJoueur()!=jc) {
                                            listdepl.add(arrayOf(cx,cy,dx,dy))
                                        }
                                        if (modele.deplacementPossible(cx, cy, dx,dy, modele.getJoueurCourant())&&
                                                modele.plateau.getCases()[dy][dx].getPion()!=null
                                                &&modele.plateau.getCases()[cy][cx].getJoueur()==modele.getJoueurCourant()){
                                            modele.deplacer(cx,cy,dx,dy)
                                            break@loop
                                        }
                                    }
                                    catch (_:DeplacementExeption){}
                                }
                            }
                        }
                    }
                    var depl=listdepl[(0 until listdepl.size).random()]
                    if (modele.getJoueurCourant()!=jc){
                        modele.deplacer(depl[0],depl[1],depl[2],depl[3])
                        vue.updatelayoutIA(depl[0],depl[1],depl[2],depl[3])
                    }
                    else {
                        depl=listdepl[listdepl.size-1]
                        vue.updatelayoutIA(depl[0],depl[1],depl[2],depl[3])
                    }
                }
            }
        }

        if(modele.arretPartie()) println("Partie finie, Gagnant : ${modele.joueurVainqueur()?.getPseudo()}")

    }
}