package simulationGame.core;

import simulationGame.entities.Entity;

import java.util.List;

public class ConsoleRenderer {

    private static final String RESET = "\033[0m";
    private static final String SYMBOL_EMPTY_CELL = "\u2591";

    public void render(GameField field, int step, List<String> logs) {
        System.out.print("\033[H\033[2J");
        System.out.flush();

        System.out.println("Step " + step);

        System.out.print("    ");
        for (int col = 0; col < field.getCols(); col++) {
            System.out.printf(" %-3d", col);
        }
        System.out.println();

        String line = "   +" + "---+".repeat(field.getCols());

        for (int row = field.getRows() - 1; row >= 0; row--) {
            System.out.println(line);
            System.out.printf("%-3d|", row);

            for (int col = 0; col < field.getCols(); col++) {
                Coordinates coordinates = new Coordinates(row, col);
                Entity entity = field.getEntityAt(coordinates);
                if (entity != null) {
                    System.out.printf(" %s%s%s|", entity.getColor().getCodeColor(),
                            entity.getSymbol().getCodeSymbol(), RESET);
                } else {
                    System.out.printf(" %s |", SYMBOL_EMPTY_CELL.trim());
                }
            }
            System.out.println();
        }
        System.out.println(line);

        logs.forEach(System.out::println);
    }
}


