package simulationGame.core;

import simulationGame.entities.*;

import java.util.*;
import java.util.function.Function;

public class GameField {

    private final int rows;
    private final int cols;

    private final Map<Coordinates, Entity> field = new HashMap<>();

    private final Random random = new Random();

    public GameField(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isWithinBounds(Coordinates coordinates) {
        return coordinates.getRow() >= 0 && coordinates.getRow() < rows
                && coordinates.getCol() >= 0 && coordinates.getCol() < cols;
    }

    public boolean isPossibleToMove(Entity cellEntity, Entity mover) {
        return cellEntity == null
                || (cellEntity instanceof Grass && mover instanceof Herbivore)
                || (cellEntity instanceof Herbivore && mover instanceof Predator);
    }

    public Entity getEntityAt(Coordinates coordinates) {
        return field.get(coordinates);
    }

    public void setEntity(Coordinates coordinates, Entity entity) {
        field.put(coordinates, entity);
    }

    public void removeEntity(Coordinates coordinates) {
        field.remove(coordinates);
    }

    public void setupEntities(int grassCount, int herbivoreCount,
                              int predatorCount, int treeCount, int rockCount) {
        placeEntitiesRandomly(grassCount, Grass::new);
        placeEntitiesRandomly(herbivoreCount, Herbivore::new);
        placeEntitiesRandomly(predatorCount, Predator::new);
        placeEntitiesRandomly(treeCount, Tree::new);
        placeEntitiesRandomly(rockCount, Rock::new);
    }

    public boolean hasHerbivores() {
        return field.values().stream().anyMatch(entity -> entity instanceof Herbivore);
    }

    public void resetAllEntities() {
        field.values().forEach(entity -> {
            if (entity instanceof Creature) entity.resetMoved();
        });
    }

    public <T extends Entity> List<T> getEntitiesOfType(Class<T> type) {
        return field.values().stream()
                .filter(type::isInstance)
                .map(type::cast)
                .toList();
    }

    public void moveCreatures(Class<? extends Creature> type, List<String> logs) {
        List<Creature> creatures = (List<Creature>) getEntitiesOfType(type);
        for (Creature creature : creatures) {
            Coordinates coordinates = creature.getCoordinates();
            if (!creature.hasMoved()) {
                creature.makeMove(this, coordinates, logs);
            }
        }
    }

    private void placeEntitiesRandomly(int count, Function<Coordinates, Entity> function) {
        List<Coordinates> emptyCells = getEmptyCells();
        Collections.shuffle(emptyCells);

        int limit = Math.min(count, emptyCells.size());
        for (int i = 0; i < limit; i++) {
            Coordinates coordinates = emptyCells.get(i);
            field.put(coordinates, function.apply(coordinates));
        }
    }

    private List<Coordinates> getEmptyCells() {
        List<Coordinates> emptyCells = new ArrayList<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                Coordinates coordinates = new Coordinates(row, col);
                if (!field.containsKey(coordinates)) {
                    emptyCells.add(coordinates);
                }
            }
        }
        return emptyCells;
    }


}