package legends.grids.cells;

<<<<<<< Updated upstream
=======
import legends.Colors;
import legends.characters.heroes.Hero;

>>>>>>> Stashed changes
/**
 * abstratct class for a Cell. Extends to three types of cells.
 */
public abstract class Cell {
    private String icon;
    private int row;
    private int col;
<<<<<<< Updated upstream
=======
    protected Colors colors;
    protected boolean hashero;
    protected boolean hasmonster;
    protected boolean hasmarket;
>>>>>>> Stashed changes

    public Cell(String icon, int row, int col){
        this.icon = icon;
        this.row = row;
        this.col = col;
    }

    private static String getOuterCellStr(char c){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(c).append(" - ");
        }
        str.append(c).append("   ");
        return str.toString();
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

    public boolean isHashero() {
        return hashero;
    }

    public void setHashero(boolean hashero) {
        this.hashero = hashero;
    }

    public boolean isHasmonster() {
        return hasmonster;
    }

    public void setHasmonster(boolean hasmonster) {
        this.hasmonster = hasmonster;
    }

    public boolean isHasmarket() {
        return hasmarket;
    }

    public void setHasmarket(boolean hasmarket) {
        this.hasmarket = hasmarket;
    }
}
