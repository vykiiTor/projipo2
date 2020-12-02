package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private Game game;
    private ArrayList<Lane> routes;

    public Environment(Game game) {
        this.game = game;
        this.routes = new ArrayList<Lane(game, 0, 0.0)>();

    }

    @Override
    public boolean isSafe(Case c) {
        return false;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }

    @Override
    public void update() {

    }

    //TODO

}
