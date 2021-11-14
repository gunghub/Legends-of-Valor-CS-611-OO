package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.grids.cells.Cell;

public class KoulouCell extends Cell {
        private final String type = "KoulouCell";

    public KoulouCell(int row, int col){
        super("K", row, col);
    }

    public void land(Hero hero){
        hero.setStrength((int) (hero.getStrength() * (1 + 0.1)));
    }
}
