package legends.grids.lanes;


import legends.grids.cells.Cell;

public class Lane {

    private int maxMonsterRow;
    private String name;

    public Lane(String name){
        this.name = name;
        this.maxMonsterRow = maxMonsterRow;

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
