package legends.grids.lanes;


import legends.grids.cells.Cell;

public class Lane {

    private int maxMonsterRow;
    private String name;
    private int maxExplored;
    private int leftCol;

    public Lane(){

    }
    public Lane(String name){
        this.name = name;
        maxMonsterRow = 0;
        maxExplored = 7;
        leftCol = 0;

    }

    public void increaseMaxMonsterRow(){
        maxMonsterRow++;
    }

    public void increaseMaxExplored(){
        maxExplored++;
    }


    public int getMaxMonsterRow() {
        return maxMonsterRow;
    }

    public void setMaxMonsterRow(int maxMonsterRow) {
        this.maxMonsterRow = maxMonsterRow;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxExplored() {
        return maxExplored;
    }

    public void setMaxExplored(int maxExplored) {
        this.maxExplored = maxExplored;
    }

    public int getLeftCol() {
        return leftCol;
    }

    public void setLeftCol(int leftCol) {
        this.leftCol = leftCol;
    }
}
