package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.players.LegendsPlayer;

/**
 * Inaccessible cells.
 */
public class InaccessibleCell extends Cell {
    private final String type = "InaccessibleCell";
    public InaccessibleCell(int row, int col){
        super("I", row, col);
    }

    public String getType() {
        return type;
    }

    @Deprecated
    public void land(){
        System.out.println("This space is inaccassible. Please try move another direction!\n");

    }
}
