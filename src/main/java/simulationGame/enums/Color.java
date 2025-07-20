package simulationGame.enums;

public enum Color {

    COLOR_ROCK("\033[38;5;180m"),
    COLOR_TREE("\033[38;5;94m"),
    COLOR_GRASS("\033[32m"),
    COLOR_HERBIVORE("\033[97m"),
    COLOR_PREDATOR("\033[34m");

    private final String code;

    Color(String code) {
        this.code = code;
    }

    public String getCodeColor() {
        return code;
    }
}
