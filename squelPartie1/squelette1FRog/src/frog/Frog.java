package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game; // debut partie 1
	private Direction dir;
	private Case pos;

	public Frog (Game game){
		this.game = game;
		this.pos = new Case(game.width/2,0);
		this.dir = Direction.up;
	}


	@Override
	public Case getPosition() {
		return this.pos;
	}

	@Override
	public Direction getDirection() {
		return this.dir;
	}

	@Override
	public void move(Direction key) {
		this.dir = key;

		//association de la nouvelle pos en fonc de dir*/
		if (key == Direction.up && this.pos.ord < this.game.height - 1){
			this.pos = new Case(this.pos.absc, this.pos.ord + 1);
		}
		if (key == Direction.down && this.pos.ord > 0){
			this.pos = new Case(this.pos.absc, this.pos.ord - 1);
		}
		if (key == Direction.right && this.pos.absc < this.game.width - 1){
			this.pos = new Case(this.pos.absc + 1, this.pos.ord);
		}
		if (key == Direction.left && this.pos.absc > 0){
			this.pos = new Case(this.pos.absc - 1, this.pos.ord);
		}

		//verif de la wincon*/
		this.game.testLose();
		this.game.testWin();
	}
}
