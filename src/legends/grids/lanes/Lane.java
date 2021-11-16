package legends.grids.lanes;


import legends.grids.cells.Cell;

public class Lane {

    private int numRows;
    private int numCols;
    private int maxMonsterRow;

    public Lane(){

    }
    public Lane(int numRows, int numCols){
        this.numRows = numRows;
        this.numCols = numCols;
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

    public int getMaxMonsterRow() {
        return maxMonsterRow;
    }

    public void setMaxMonsterRow(int maxMonsterRow) {
        this.maxMonsterRow = maxMonsterRow;
    }
}
