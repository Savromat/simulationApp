package simulationGame.core;

import simulationGame.entities.Herbivore;
import simulationGame.entities.Predator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Simulation {

    private final GameField field;
    private final ConsoleRenderer renderer = new ConsoleRenderer();
    private final int delayMs;
    private final int maxSteps;

    private volatile boolean isPaused = false;

    public Simulation(GameField field, int delayMs, int maxSteps) {
        this.field = field;
        this.delayMs = delayMs;
        this.maxSteps = maxSteps;
        startPauseListener(); // запускаем отдельный поток слушателя
    }

    public void gameLoop() throws InterruptedException {
        System.out.println("Симуляция запущена. \nppНажмите P, чтобы поставить/снять паузу.");
        int step = 0;

        while (field.hasHerbivores() && step < maxSteps) {
            waitIfPaused(); // ждём, если нажата пауза
            performStep(step);
            Thread.sleep(delayMs);
            step++;
        }

        if (!field.hasHerbivores()) {
            System.out.println("Все травоядные съедены. Симуляция завершена.");
        } else {
            System.out.println("Симуляция завершена по лимиту шагов (" + maxSteps + ").");
        }
    }

    private void performStep(int step) throws InterruptedException  {
        List<String> logs = new ArrayList<>();
        field.resetAllEntities();

        field.moveCreatures(Herbivore.class, logs);
        field.moveCreatures(Predator.class, logs);

        renderer.render(field, step, logs);
    }

    private void waitIfPaused() {
        while (isPaused) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void startPauseListener() {
        Thread inputThread = new Thread(() -> {
            try {
                while (true) {
                    int input = System.in.read();
                    if (input == 'p' || input == 'P') {
                        isPaused = !isPaused;
                        System.out.println(isPaused ? "ПАУЗА" : "ПРОДОЛЖЕНИЕ");
                    }
                }
            } catch (IOException e) {
                System.out.println("Ошибка ввода: " + e.getMessage());
            }
        });

        inputThread.setDaemon(true); // поток завершится с программой
        inputThread.start();
    }
}
