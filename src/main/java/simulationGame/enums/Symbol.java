package simulationGame.enums;

public enum Symbol {

    SYMBOL_ROCK("\u26F0"),
    SYMBOL_TREE("\uD83C\uDF33"),
    SYMBOL_GRASS("\uD83C\uDF3F"),
    SYMBOL_HERBIVORE("\uD83D\uDC11"),
    SYMBOL_PREDATOR("\uD83D\uDC3A");

    private final String symbol;

    Symbol(String symbol) {
        this.symbol = symbol;
    }

    public String getCodeSymbol() {
        return symbol;
    }
}
