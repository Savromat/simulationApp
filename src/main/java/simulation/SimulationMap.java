package simulation;

import simulation.entities.Entity;
import simulation.entities.Herbivore;
import simulation.entities.Predator;

import java.util.HashMap;

public class SimulationMap {
//ключ - координата, значение - сущность -> use HashMap
    HashMap<Coordinates, Entity> map = new HashMap<>();

    // поставить сущность на карту
    public void setEntities(Coordinates coordinates, Entity entity) {
        entity.coordinates = coordinates;
        map.put(coordinates, entity);
    }

    //стартовая расстановка сущностей
    public void setupStartEntitiesPositions() {
        for (int i = 0; i < 3; i++) {
            // 3 - магическое число = кол-ву сущностей, потом ввести константы
            setEntities(new Coordinates(i, i + 1), new Herbivore(1, 50, new Coordinates(i, i + 1)));
            setEntities(new Coordinates(i + 2, i + 3), new Predator(2, 30, new Coordinates(i + 2, i + 3), 10));
        }
    }

    // за дальнейшее движение сущности по карте будет отвечать метод makeMove()
    // !подумать - метод makeMove() реализовывает алгоритм поиска пищи и return найденную координату
    // эту координату принимает метод setEntities(Coordinates coordinates, Entity entity) и ставит сущность на новую позицию на карте


}
