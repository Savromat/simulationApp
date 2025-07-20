package simulationGame.entities;

import simulationGame.core.BFS;
import simulationGame.core.Coordinates;
import simulationGame.core.GameField;
import simulationGame.enums.*;

import java.util.List;
import java.util.Optional;

public class Predator extends Creature {

    private static final int ATTACK_POWER = 1;

    public Predator(Coordinates coordinates) {
        this.color = Color.COLOR_PREDATOR;
        this.symbol = Symbol.SYMBOL_PREDATOR;
        this.coordinates = coordinates;
    }

    @Override
    public String getTypeName() {
        return "Predator";
    }

    @Override
    public void makeMove(GameField field, Coordinates currentPosition, List<String> logs) {
        setCoordinates(currentPosition);
        if (hasMoved()) return;

        Optional<List<Coordinates>> pathOpt = BFS.findPathToTarget(field, currentPosition,
                entity -> entity instanceof Herbivore, this);

        if (pathOpt.isEmpty() || pathOpt.get().isEmpty()) return;

        Coordinates nextStep = pathOpt.get().get(0);
        Entity entity = field.getEntityAt(nextStep);

        if (entity instanceof Herbivore herbivore) {
            boolean isDead = herbivore.takeDamage(ATTACK_POWER);
            if (isDead) {
                logs.add(getTypeName() + " убил " + herbivore.getTypeName() + " на " + nextStep);
                field.removeEntity(nextStep);
            } else {
                logs.add(getTypeName() + " атаковал " + herbivore.getTypeName() + " на " + nextStep);
            }
        }

        field.removeEntity(currentPosition);
        field.setEntity(nextStep, this);
        setCoordinates(nextStep);
        markMoved();
    }
}
