package simulationGame.entities;

import simulationGame.core.*;
import java.util.List;

public abstract class Creature extends Entity {

    public abstract void makeMove(GameField field, Coordinates currentPosition, List<String> logs);
}