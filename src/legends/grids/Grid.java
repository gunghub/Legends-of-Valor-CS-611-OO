package legends.grids;

import legends.LOVCell;
import legends.grids.cells.Cell;

/**
 * RegularLane for the game.
 */
public class Grid {
    protected LOVCell[][] grids;
    protected int numRows;
    protected int numCols;
    protected String symbol;

    public Grid(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
//        grid = new Cell[numRows][numCols];
//        grid = new legends.LOVCell[numRows][numCols];
    }

    public LOVCell[][] getGrid() {
        return grids;
    }

    public void setGrid(LOVCell[][] grid) {
        this.grids = grid;
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
