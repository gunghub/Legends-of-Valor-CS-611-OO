package legends.grids.lanes;


import legends.grids.cells.Cell;

public class Lane {

    private int maxMonsterRow;
    private String name;
    private int maxExplored;

    public Lane(){

    }
    public Lane(String name){
        this.name = name;
        maxMonsterRow = 0;
        maxExplored = 7;

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
}
