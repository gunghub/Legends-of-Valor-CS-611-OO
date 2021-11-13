package legends.players;

import legends.grids.LegendsGrid;
import legends.utilities.Printer;
import legends.utilities.ScannerParser;
import legends.characters.heroes.Hero;

import java.util.ArrayList;

public class LegendsPlayer extends Player {
    private ArrayList<Hero> heroes;
    private int pRow;
    private int pCol;

    public LegendsPlayer(String name, String icon) {
        super(name, "P");
        heroes = new ArrayList<Hero>();
        pRow = 4;
        pCol = 4;
    }


    /**
     * player chooses a move
     *
     * @param grid
     * @return
     */
    public boolean makeMove(LegendsGrid grid) {
        grid.printGrid(this);
        boolean play = true;
        System.out.println("Please choose your move:");
        System.out.println("W/w: move up\nA/a: move left\nS/s: move down\nD/d: move right\nQ/q: quit game\n" +
                "I/i: show information");
        String move = ScannerParser.parseString();
        while (move.equals("W") && move.equals("w") && move.equals("A") && move.equals("a") && move.equals("S") && move.equals("s") &&
                move.equals("D") && move.equals("d") && move.equals("Q") && move.equals("q") && move.equals("I") && move.equals("i")) {
            move = ScannerParser.tryString();
        }
        switch (move) {
            case "W":
            case "w":
                setpRow(pRow - 1);
                grid.land(pRow, pCol, this, grid.getGrid()[pRow][pCol], move);
                break;

            case "A":
            case "a":
                setpCol(pCol - 1);
                grid.land(pRow, pCol, this, grid.getGrid()[pRow][pCol], move);
                break;

            case "S":
            case "s":
                setpRow(pRow + 1);
                grid.land(pRow, pCol, this, grid.getGrid()[pRow][pCol], move);
                break;

            case "D":
            case "d":
                setpCol(pCol + 1);
                grid.land(pRow, pCol, this, grid.getGrid()[pRow][pCol], move);
                break;

            case "Q":
            case "q":
                System.out.println("Thanks for playing! Exiting program...");
                play = false;
                break;

            case "I":
            case "i":
                Printer printer = new Printer();
                printer.printHeroes(getHeroes());
                break;
        }
        grid.printGrid(this);
        return play;
    }


    public boolean isValidMove(LegendsGrid grid, int row, int col){
        boolean isValid = false;
        return false;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public void addHero(Hero newH) {
        heroes.add(newH);
    }

    public int getpRow() {
        return pRow;
    }

    public void setpRow(int pRow) {
        this.pRow = pRow;
    }

    public int getpCol() {
        return pCol;
    }

    public void setpCol(int pCol) {
        this.pCol = pCol;
    }

    public void printPlayerHeroes() {
        Printer p = new Printer();
        p.printHeroes(heroes);
    }


}
