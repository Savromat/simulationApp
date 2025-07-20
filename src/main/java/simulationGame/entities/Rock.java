package simulationGame.entities;

import simulationGame.core.Coordinates;
import simulationGame.enums.*;

public class Rock extends Entity {

    public Rock(Coordinates coordinates) {
        this.color = Color.COLOR_ROCK;
        this.symbol = Symbol.SYMBOL_ROCK;
        this.coordinates = coordinates;
    }

    @Override
    public String getTypeName() {
        return "Rock";
    }
}
