package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.grids.cells.Cell;

public class PlainCell extends Cell {
    private final String type = "PlainCell";

    public PlainCell(int row, int col){
        super("P", row, col);
    }

//    public void land(){
//        increaseHeroCount();
//    }

    public void land(Hero hero){
        hasHero=true;
    }

    public void leave(Hero hero){
        hasHero=false;
    }

}
