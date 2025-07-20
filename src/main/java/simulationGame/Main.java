package simulationGame;

import simulationGame.core.GameField;
import simulationGame.core.Simulation;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        GameField field = new GameField(6, 10);
        field.setupEntities(5, 3, 2, 3, 3);

        Simulation simulation = new Simulation(field, 1000, 30);
        simulation.gameLoop();
    }
}
