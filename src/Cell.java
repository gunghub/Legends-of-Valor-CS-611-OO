/**
 * abstratct class for a Cell. Extends to three types of cells.
 */
public abstract class Cell {
    private String icon;
    private int row;
    private int col;
    protected Colors colors;

    public Cell(String icon, int row, int col){
        this.icon = icon;
        this.row = row;
        this.col = col;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }


}
