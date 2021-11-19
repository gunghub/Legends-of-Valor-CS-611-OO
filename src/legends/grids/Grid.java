package legends.grids;

import legends.grids.cells.Cell;

/**
 * Grid for the game.
 */
public abstract class Grid {
    protected Cell[][] grid; //cells
    protected int numRows;
    protected int numCols;
    protected String symbol;


    public Grid(){}
    public Grid(int numCols,int numRows){
        this.numRows = numRows;
        this.numCols = numCols;
        grid = new Cell[numRows][numCols];
//        grid = new Cell[numRows][numCols];
//        grid = new legends.LOVCell[numRows][numCols];
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
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
