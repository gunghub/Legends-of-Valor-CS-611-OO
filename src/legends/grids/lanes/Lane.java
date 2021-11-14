package legends.grids.lanes;


import legends.grids.cells.Cell;

public class Lane {
    private Cell[][] grid;
    private int numRows;
    private int numCols;

    public Lane(){

    }
    public Lane(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
        grid = new Cell[numRows][numCols];
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
