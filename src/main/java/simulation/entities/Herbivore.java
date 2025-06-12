package simulation.entities;

import simulation.Coordinates;

public class Herbivore extends Creature {

    public final int speed = 1;
    public int healthPoints;

    Coordinates coordinates;

    public Herbivore(int speed, int healthPoints, Coordinates coordinates) {
        super(speed, healthPoints, coordinates);
    }


    @Override
    public void makeMove() {
        // алгоритм хода Травоядного на одну (или две?) клетку
    }
}
