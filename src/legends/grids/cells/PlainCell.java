package legends.grids.cells;

import legends.grids.cells.Cell;

public class PlainCell extends Cell {
    private final String type = "PlainCell";

    public PlainCell(int row, int col){
        super("P", row, col);
    }

//    public void land(){
//        increaseHeroCount();
//    }

}
