package environment;

import gameCommons.Game;
import graphicalElements.Element;
import util.Case;

import java.awt.*;

public class Car {
	private Game game;
	private Case leftPosition;
	private boolean leftToRight;
	private int length;
	private final Color colorLtR = Color.BLACK;
	private final Color colorRtL = Color.BLUE;

	//TODdO Constructeur(s) IL EST NORMALEMENT BON
	public Car(Game game, Case frontPosision, boolean leftToRight){
		this.game = game;
		this.length = game.randomGen.nextInt(4) + 1; //ALEA ENTRE 1 et 3 inclu
		this.leftToRight = leftToRight;
		if(leftToRight){
			this.leftPosition = new Case(frontPosision.absc-this.length, frontPosision.ord);
		}else {
			this.leftPosition = new Case(frontPosision.absc, frontPosision.ord);
		}

	}
	//TODdO : ajout de methodes

	//bouge de gauche a droite ou de droite a gauche en foncion des if et addgraph
	public void move(boolean b){
		if (b && this.leftToRight) {
			this.leftPosition = new Case(this.leftPosition.absc + 1, this.leftPosition.ord);
		}
		if(b && !this.leftToRight){
			this.leftPosition = new Case(this.leftPosition.absc - 1, this.leftPosition.ord);
		}
		addToGraphics();
	}

	// si la position est dans l'affichage de la voiture c'est bon non sinon
	public boolean outOfBounds(){
		return !(this.leftPosition.absc + this.length >= 0 && this.leftPosition.absc <= this.game.width);
	}

	public Case getLeftPos(){
		return this.leftPosition;
	}
	public int getLength(){
		return this.length;
	}
	//public boolean coverCases(Case pos){} jsp elle fait quoi
	
	
	/* Fourni : addToGraphics() permettant d'ajouter un element graphique correspondant a la voiture*/
	private void addToGraphics() {
		for (int i = 0; i < length; i++) {
			Color color = colorRtL;
			if (this.leftToRight){
				color = colorLtR;
			}
			game.getGraphic()
					.add(new Element(leftPosition.absc + i, leftPosition.ord, color));
		}
	}

}
