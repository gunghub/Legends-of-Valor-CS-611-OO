package legends.grids.cells;

import legends.characters.heroes.Hero;
import legends.utilities.Colors;

/**
 * abstratct class for a Cell. Extends to three types of cells.
 */
public abstract class Cell {
    private String icon;
    private int row;
    private int col;

    protected Colors colors;
    protected int heroCount;
    protected int monsterCount;


    public void land(Hero hero){

    }

    public Cell(String icon, int row, int col){
        this.icon = icon;
        this.row = row;
        this.col = col;
        heroCount = 0;
        monsterCount = 0;
    }

    private static String getOuterCellStr(char c){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(c).append(" - ");
        }
        str.append(c).append("   ");
        return str.toString();
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getHeroCount() {
        return heroCount;
    }

    public void setHeroCount(int heroCount) {
        this.heroCount = heroCount;
    }

    public int getMonsterCount() {
        return monsterCount;
    }

    public void setMonsterCount(int monsterCount) {
        this.monsterCount = monsterCount;
    }

    public void increaseHeroCount(){
        this.heroCount++;
    }

    public void decreaseHeroCount(){
        this.heroCount--;
    }

    public void increaseMonsterCount(){
        this.monsterCount++;
    }

    public void decreaseMonsterCount(){
        this.monsterCount--;
    }
}
