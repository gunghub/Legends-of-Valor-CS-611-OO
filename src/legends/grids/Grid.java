package legends.grids;

import legends.grids.cells.Cell;

/**
 * Grid for the game.
 */
public class Grid {
    protected Cell[][] grids;
    protected int numRows;
    protected int numCols;
    protected String symbol;

    public Grid(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
//        grid = new Cell[numRows][numCols];
//        grid = new legends.LOVCell[numRows][numCols];
    }

    public Cell[][] getGrid() {
        return grids;
    }

    public void setGrid(Cell[][] grids) {
        this.grids = grids;
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }



}
