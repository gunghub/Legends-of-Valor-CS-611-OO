package legends.characters.monsters;

import legends.LovMap;
import legends.characters.Character;
import legends.characters.heroes.Hero;
import legends.grids.cells.Cell;

public abstract class Monster extends Character {
    private int defense;
    private int damage;
    private int dodge;
    private int row;
    private int col;

    public Monster(String name, int level, int HP, int defense, int damage, int dodge){
        super(name, level, HP);
        this.defense = defense;
        this.damage =damage;
        this.dodge = dodge;
    }

    public void makeMove(Hero hero, LovMap grid, int index){
        if(withinRange(grid)){
            hero.takeDamage(damage);
        }else{
            grid.getCells()[row][col].decreaseMonsterCount();
            row++;
            grid.getCells()[row][col].increaseMonsterCount();
            System.out.println("Monster's turn ---\nM" +(index+1)+" moved forward.");
        }
    }

    // return boolean indicating whether there is a hero within the monster's attacking range
    public boolean withinRange(LovMap grid) {
        Cell[][] grids = grid.getCells();
        if (grids[Math.max(row - 1, 0)][Math.max(col - 1, 0)].getHeroCount()>0 || grids[Math.max(row - 1, 0)][col].getHeroCount()>0 || grids[Math.max(row - 1, 0)][Math.min(col + 1, 7)].getHeroCount()>0 ||
                grids[row][Math.max(col - 1, 0)].getHeroCount()>0 || grids[row][col].getHeroCount()>0|| grids[row][Math.min(col + 1, 7)].getHeroCount()>0 ||
                grids[Math.min(row + 1, 7)][Math.max(col - 1, 0)].getHeroCount()>0 || grids[Math.min(row + 1, 7)][col].getHeroCount()>0|| grids[Math.min(row + 1, 7)][Math.min(col + 1, 7)].getHeroCount()>0) {
            return true;
        } else {
            return false;
        }
    }

    public int getDefense() { return defense;}

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
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

    public void setPosition(int row, int col){
        this.row = row;
        this.col = col;
    }

//
//    public Hero getNeighborHero(LovMap grid, LegendsOfValor legendofvalor){
//        Cell[][] grids = grid.getGrid();
//        if (grids[Math.max(row - 1, 0)][Math.max(col-1,0)].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == Math.max(row - 1, 0) && legendofvalor.getHeroes().get(i).getCol() == Math.max(col-1,0)){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//
//        }
//        else if (grids[Math.max(row-1,0)][col].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == Math.max(row-1,0) && legendofvalor.getHeroes().get(i).getCol() == col){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else if (grids[Math.max(row-1,0)][Math.min(col+1,7)].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == Math.max(row-1,0) && legendofvalor.getHeroes().get(i).getCol() == Math.min(col+1,7)){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else if (grids[row][Math.min(col-1,0)].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == row && legendofvalor.getHeroes().get(i).getCol() == Math.min(col-1,0)){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else if (grids[row][col].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == row && legendofvalor.getHeroes().get(i).getCol() == col){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else if (grids[row][Math.min(col+1,7)].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == row && legendofvalor.getHeroes().get(i).getCol() == Math.min(col+1,7)){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else if (grids[Math.min(row+1,7)][Math.max(col-1,0)].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == Math.min(row+1,7) && legendofvalor.getHeroes().get(i).getCol() == Math.max(col-1,0)){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else if (grids[Math.min(row+1,7)][col].isHashero()){
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == Math.min(row+1,7) && legendofvalor.getHeroes().get(i).getCol() == col){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        else {
//            for (int i = 0; i < legendofvalor.getHeroes().size(); i++){
//                if (legendofvalor.getHeroes().get(i).getRow() == Math.min(row+1,7) && legendofvalor.getHeroes().get(i).getCol() == Math.min(col+1,7)){
//                    return legendofvalor.getHeroes().get(i);
//                }
//            }
//        }
//        return null;
//    }


}
