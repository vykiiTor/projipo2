package environment;

import gameCommons.Game;
import gameCommons.IEnvironment;
import util.Case;
import util.Direction;

import java.util.ArrayList;

public class EnvInf implements IEnvironment {
    //Attributs
    private Game game;
    private ArrayList<Lane> routes = new ArrayList<>();

    @Override
    public boolean isWinningPosition(Case c) {
        return c.ord == this.game.height - 1;
    }



    //------------------ modif par rapport a la part 2
    //Dans les Attributs
    private Case frogLastPos;
    private int score;

    public EnvInf(Game game) {
        //add S
        this.game = game;
        this.routes.add(new Lane(this.game, 0, 0)); //lane sans voitures

        for (int i = 1; i < this.game.height; i++) {
            this.routes.add(new Lane(this.game, i, this.game.defaultDensity));
        }
        this.frogLastPos = game.getFrog().getPosition(); //recupere l'ancienne pos de frog
        this.score = 0;

    }

    @Override
    public boolean isSafe(Case c) {
        //return this.routes.get(c.ord).isSafe(c); (Avant)
        return this.routes.get(score).isSafe(c);
    }

    //retourne le score
    public int getScore() {
        return this.score;
    }

    public void addLane() {
        Case fPos = game.getFrog().getPosition();
        if (game.getFrog().getDirection() == Direction.up && fPos != frogLastPos) {

            routes.add(new Lane(this.game, game.height + score, this.game.defaultDensity));
            this.score += 1;
            frogLastPos = fPos;
        } else if (game.getFrog().getDirection() == Direction.down &&
                fPos != frogLastPos) {
            this.score -= 1;
            frogLastPos = fPos;
        }

    }

    //this.addLane(); en plus
    @Override
    public void update() {
        this.addLane();
        for (Lane lane : this.routes)
            lane.update();
    }

}
