package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.grids.cells.Cell;

public class BushCell extends Cell {
    private final String type = "BushCell";

    public BushCell(int row, int col){
        super("B", row, col);
    }

    public String getType() {
        return type;
    }

    public void land(Hero hero){
        System.out.println("Hero landed on Bush cell -- gains 10% of dexterity for this round\n");
        hero.setDexterity((int) (hero.getDexterity() * (1 + 0.1)));
    }
}
