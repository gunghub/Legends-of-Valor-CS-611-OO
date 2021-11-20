package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.grids.cells.Cell;

public class CaveCell extends Cell {
    private final String type = "CaveCell";

    public CaveCell(int row, int col){
        super("C", row, col);
    }

    public void land(Hero hero){
        System.out.println("Hero landed on Cave cell -- gains 10% of agility for this round\n");
        hero.setAgility((int) (hero.getAgility() * (1 + 0.1)));
    }
}
