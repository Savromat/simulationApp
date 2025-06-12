package simulation;

public class Coordinates {

    // координаты - x = row - горизонталь - буква (как в шахматах) -> нет, пока сделаю цифру,
    // ряд; y = col - колонка, вертикаль - цифра (как в шахматах)
    public final Integer row;
    public final Integer cell;

    //поля - final, т.е. объекты класса Coordinates будут immutable - можно использовать как ключ в HashMap

    public Coordinates(Integer row, Integer cell) {
        this.row = row;
        this.cell = cell;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;
        return row.equals(that.row) && cell.equals(that.cell);
    }

    @Override
    public int hashCode() {
        int result = row.hashCode();
        result = 31 * result + cell.hashCode();
        return result;
    }
}
