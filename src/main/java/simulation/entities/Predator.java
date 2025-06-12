package simulation.entities;

import simulation.Coordinates;

public class Predator extends Creature {

    public final int speed = 2;
    public int healthPoints;
    public int damage;

    Coordinates coordinates;

    public Predator(int speed, int healthPoints, Coordinates coordinates, int damage) {
        super(speed, healthPoints, coordinates);
        this.damage = damage;
    }


    @Override
    public void makeMove() {

    }
}
