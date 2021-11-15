package legends.grids.cells;

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

    public void land(String move, LegendsPlayer p){
        switch(move){
            case "W":
            case "w":
                p.setPRow(p.getPRow() + 1);
                break;

            case "A":
            case "a":
                p.setPCol(p.getPCol() + 1);
                break;

            case "S":
            case "s":
                p.setPRow(p.getPRow() - 1);
                break;

            case "D":
            case "d":
                p.setPCol(p.getPCol() - 1);
                break;
        }
        System.out.println("This space is inaccassible. Please try move another direction!\n");
    }
}
