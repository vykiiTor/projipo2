package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;

import java.util.ArrayList;

public class Environment implements IEnvironment {
    private Game game;
    private ArrayList<Lane> routes = new ArrayList<>();

    public Environment(Game game) {
        this.game = game;
        this.routes.add(new Lane(game, 0, 0));
        for (int i = 1; i < this.game.height - 1; i++) {
            this.routes.add(new Lane(game, i, this.game.defaultDensity));
        }
        this.routes.add(new Lane(game, game.height, 0));
    }

    @Override
    public boolean isSafe(Case c) {
        return this.routes.get(c.ord).isSafe(c);
    } //car le get prend qu'un int

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }

    @Override
    public void update() {
        for (Lane lane : this.routes)
            lane.update();
    }
}
