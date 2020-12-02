package environment;

import gameCommons.Game;
import util.Case;

import java.util.ArrayList;

public class Lane {
	private Game game;
	private int ord;
	private int speed;
	private ArrayList<Car> cars = new ArrayList<>();
	private boolean leftToRight;
	private double density;

	//TODdO : Constructeur(s)
	public Lane(Game game, int ord, double density) {
		this.game = game;
		this.ord = ord;
		this.density = density;
		//this.cars = new ArrayList<Car>(); pas nécessaire car redon
		this.leftToRight = game.randomGen.nextBoolean();
		this.speed = game.randomGen.nextInt(game.minSpeedInTimerLoops) + 1;
	}

	public Lane(Game game, int ord) {

	}

	public void update() {

		// toDDo

		// Toutes les voitures se d�placent d'une case au bout d'un nombre "tic
		// d'horloge" �gal � leur vitesse
		// Notez que cette m�thode est appel�e � chaque tic d'horloge

		// Les voitures doivent etre ajoutes a l interface graphique meme quand
		// elle ne bougent pas

		// A chaque tic d'horloge, une voiture peut �tre ajout�e

	}

	// TOdDO : ajout de methodes

	public void removeCar() {
		ArrayList<Car> oldCars = new ArrayList<Car>();
		for (Car c : this.cars) {
			if (c.outOfBounds()) {
				oldCars.add(c);
			}
		}
		for (Car c : oldCars) {
			this.cars.remove(c);
		}
	}

	public boolean isSafe(Case k) {
		for (Car c : cars) {
			if (k.ord != c.getLeftPos().ord || k.absc < c.getLeftPos().absc || k.absc >= c.getLeftPos().absc + c.getLength()) {
				return true;
			}
		}
		return false;
	}

	public void moveCars(boolean b){
		for (Car c : cars){
			c.move(b);
		}
		removeCar();
	}

	public String toString() { //avoir

		return "Lane [ord=" + this.ord + ", cars=" + this.cars + "]";
	}


	/*
	 * Fourni : mayAddCar(), getFirstCase() et getBeforeFirstCase() 
	 */

	/**
	 * Ajoute une voiture au d�but de la voie avec probabilit� �gale � la
	 * densit�, si la premi�re case de la voie est vide
	 */
	private void mayAddCar() {
		if (isSafe(getFirstCase()) && isSafe(getBeforeFirstCase())) {
			if (game.randomGen.nextDouble() < density) {
				cars.add(new Car(game, getBeforeFirstCase(), leftToRight));
			}
		}
	}

	private Case getFirstCase() {
		if (leftToRight) {
			return new Case(0, ord);
		} else
			return new Case(game.width - 1, ord);
	}

	private Case getBeforeFirstCase() {
		if (leftToRight) {
			return new Case(-1, ord);
		} else
			return new Case(game.width, ord);
	}

}