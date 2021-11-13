package legends.cells;

import legends.players.LegendsPlayer;

/**
 * Inaccessible cells.
 */
public class Inaccessible extends Cell {
    private final String type = "Inaccessible";
    public Inaccessible(int row, int col){
        super("#", row, col);
    }

    public String getType() {
        return type;
    }

    public void land(String move, LegendsPlayer p){
        switch(move){
            case "W":
            case "w":
                p.setpRow(p.getpRow() + 1);
                break;

            case "A":
            case "a":
                p.setpCol(p.getpCol() + 1);
                break;

            case "S":
            case "s":
                p.setpRow(p.getpRow() - 1);
                break;

            case "D":
            case "d":
                p.setpCol(p.getpCol() - 1);
                break;
        }
        System.out.println("This space is inaccassible. Please try move another direction!\n");
    }
}
