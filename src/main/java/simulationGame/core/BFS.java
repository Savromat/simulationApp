package simulationGame.core;

import simulationGame.entities.Entity;

import java.util.*;
import java.util.function.Predicate;

public class BFS {

    public static Optional<List<Coordinates>> findPathToTarget(GameField field,
                                                               Coordinates start,
                                                               Predicate<Entity> targetCondition,
                                                               Entity mover) {
        Queue<Coordinates> queue = new LinkedList<>();
        Map<Coordinates, Coordinates> predecessor = new HashMap<>();
        Set<Coordinates> visited = new HashSet<>();
        Coordinates target = null;

        queue.add(start);
        visited.add(start);

        while(!queue.isEmpty()) {
            Coordinates current = queue.poll();
            if (!current.equals(start)) {
                Entity entity = field.getEntityAt(current);
                if (entity != null && targetCondition.test(entity)) {
                    target = current;
                    break;
                }
            }

            for (Coordinates neighbor : current.getCoordinatesShift()) {
                if (!visited.contains(neighbor) && field.isWithinBounds(neighbor)) {
                    Entity neighborEntity = field.getEntityAt(neighbor);
                    if (field.isPossibleToMove(neighborEntity, mover)) {
                        queue.add(neighbor);
                        visited.add(neighbor);
                        predecessor.put(neighbor, current);
                    }
                }
            }
        }

        if (target == null) return Optional.empty();

        List<Coordinates> path = new ArrayList<>();
        Coordinates step = target;
        while (!step.equals(start)) {
            path.add(step);
            step = predecessor.get(step);
        }
        Collections.reverse(path);
        return Optional.of(path);
    }
}
