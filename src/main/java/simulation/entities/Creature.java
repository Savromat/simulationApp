package simulation.entities;

import simulation.Coordinates;

public abstract class Creature extends Entity {

    public final int speed;
    public int healthPoints;

    public Coordinates coordinates;

    public Creature(int speed, int healthPoints, Coordinates coordinates) {
        this.speed = speed;
        this.healthPoints = healthPoints;
        this.coordinates = coordinates;
    }

    public abstract void makeMove();
}


// Абстрактный класс, наследуется от Entity.
// Существо, имеет скорость (сколько клеток может пройти за 1 ход), количество HP.
// Имеет метод makeMove() - сделать ход.
