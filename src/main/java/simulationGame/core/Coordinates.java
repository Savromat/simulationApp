package simulationGame.core;

import java.util.List;

public record Coordinates(int row, int col) {

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public List<Coordinates> getCoordinatesShift() {
        return List.of(
                new Coordinates(row - 1, col),
                new Coordinates(row + 1, col),
                new Coordinates(row, col - 1),
                new Coordinates(row, col + 1)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;
        return row == that.row && col == that.col;
    }

    @Override
    public int hashCode() {
        int result = row;
        result = 31 * result + col;
        return result;
    }

    @Override
    public String toString() {
        return row + ":" + col;
    }
}
