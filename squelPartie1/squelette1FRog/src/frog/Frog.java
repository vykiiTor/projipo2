package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
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

	}
}
