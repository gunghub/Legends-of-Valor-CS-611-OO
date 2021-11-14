package legends.grids;

import legends.grids.cells.Cell;

/**
 * Grid for the game.
 */
public class Grid {
<<<<<<< Updated upstream
    private Cell[][] grid;
    private int numRows;
    private int numCols;
=======
    protected Cell[][] grids;
    protected int numRows;
    protected int numCols;
    protected String symbol;
>>>>>>> Stashed changes

    public Grid(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
        grid = new Cell[numRows][numCols];
    }

    public Cell[][] getGrid() {
<<<<<<< Updated upstream
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
=======
        return grids;
    }

    public void setGrid(Cell[][] grid) {
        this.grids = grid;
>>>>>>> Stashed changes
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
