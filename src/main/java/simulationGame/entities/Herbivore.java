package simulationGame.entities;

import simulationGame.core.BFS;
import simulationGame.core.Coordinates;
import simulationGame.core.GameField;
import simulationGame.enums.*;

import java.util.List;
import java.util.Optional;


public class Herbivore extends Creature {

    private int health = 2;

    public Herbivore(Coordinates coordinates) {
        this.color = Color.COLOR_HERBIVORE;
        this.symbol = Symbol.SYMBOL_HERBIVORE;
        this.coordinates = coordinates;
    }

    public boolean takeDamage(int damage) {
        health -= damage;
        return health <= 0;
    }

    @Override
    public String getTypeName() {
        return "Herbivore";
    }

    @Override
    public void makeMove(GameField field, Coordinates currentPosition, List<String> logs) {
        setCoordinates(currentPosition);
        if (hasMoved()) return;

        Optional<List<Coordinates>> pathOpt = BFS.findPathToTarget(field, currentPosition,
                entity -> entity instanceof Grass, this);

        if (pathOpt.isEmpty() || pathOpt.get().isEmpty()) return;

        Coordinates nextStep = pathOpt.get().get(0);
        Entity entity = field.getEntityAt(nextStep);
        if (entity instanceof Grass) {
            logs.add(getTypeName() + " съел " + entity.getTypeName() + " на " + nextStep);
            field.removeEntity(nextStep);
        }

        field.removeEntity(currentPosition);
        field.setEntity(nextStep, this);
        setCoordinates(nextStep);
        markMoved();
    }
}
