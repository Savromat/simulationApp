package simulationGame.entities;

import simulationGame.core.Coordinates;
import simulationGame.enums.*;

public class Tree extends Entity {

    public Tree(Coordinates coordinates) {
        this.color = Color.COLOR_TREE;
        this.symbol = Symbol.SYMBOL_TREE;
        this.coordinates = coordinates;
    }

    @Override
    public String getTypeName() {
        return "Tree";
    }
}
