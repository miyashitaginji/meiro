public class Cell {
    private CellType type;

    public Cell() {
        this.type = CellType.WALL;
    }

    public CellType getType() {
        return type;
    }

    public void setType(CellType type) {
        this.type = type;
    }
}
