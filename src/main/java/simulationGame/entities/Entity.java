package simulationGame.entities;

import simulationGame.core.*;
import simulationGame.enums.*;

public abstract class Entity {

    protected Color color;
    protected Symbol symbol;
    protected Coordinates coordinates;
    protected boolean hasMoved = false;

    public Color getColor() {
        return color;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void resetMoved() {
        hasMoved = false;
    }

    public void markMoved() {
        hasMoved = true;
    }

    public boolean hasMoved() {
        return hasMoved;
    }

    public abstract String getTypeName();
}
