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
        this.routes = new ArrayList<Lane>();

    }

    @Override
    public boolean isSafe(Case c) {
        return false;
    }

    @Override
    public boolean isWinningPosition(Case c) {
        return false;
    }

    @Override
    public void update() {

    }

    //TODO

}
