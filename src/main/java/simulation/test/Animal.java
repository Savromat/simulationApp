package simulation.test;

public enum Animal {

    HERBIVORE(2, 50),
    PREDATOR(3, 20, 10);

    final int speed;
    final int healthPoints;
    int damage;

    Animal(int speed, int healthPoints) {
        this.speed = speed;
        this.healthPoints = healthPoints;
    }

    Animal(int speed, int healthPoints, int damage) {
        this.speed = speed;
        this.healthPoints = healthPoints;
        this.damage = damage;
    }
}
