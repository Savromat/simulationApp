package simulationGame.entities;

import simulationGame.core.Coordinates;
import simulationGame.enums.*;

public class Grass extends Entity {

    public Grass(Coordinates coordinates) {
        this.color = Color.COLOR_GRASS;
        this.symbol = Symbol.SYMBOL_GRASS;
        this.coordinates = coordinates;
    }

    @Override
    public String getTypeName() {
        return "Grass";
    }
}
