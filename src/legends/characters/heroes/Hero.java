package legends.characters.heroes;

import legends.LOVGrid;
import legends.characters.Character;
import legends.gameplay.Inventory;
import legends.games.LegendsOfValor;
import legends.grids.cells.Cell;
import legends.grids.lanes.Lane;
import legends.items.Armor;
import legends.items.Item;
import legends.items.Potion;
import legends.items.Weapon;
import legends.characters.monsters.Monster;
import legends.items.spells.Spell;
import legends.utilities.Colors;
import legends.utilities.Graphic;
import legends.utilities.Printer;
import legends.utilities.ScannerParser;

import java.util.ArrayList;

public abstract class Hero extends Character {
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private int experience;
    private Inventory armedInventory;
    private Inventory inventory;
    private Weapon currentWeapon;
    private Armor currentArmor;

    protected Graphic graphic;
    protected Colors colors;
    private int row;
    private int col;
    private Lane currLane;
    private Lane initLane;

    public Hero(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience, Lane initLane) {
        super(name, level, HP);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = money;
        this.experience = experience;
        this.initLane = initLane;
        armedInventory = new Inventory();
        inventory = new Inventory();
        currLane = initLane;
    }

    public abstract void levelUp();


    // hero chooses to attack, cast a spell, move, teleport, back, or quit game
    //return the play boolean which indicates whether player wants to quit the game
    public boolean takeAction(LOVGrid grid, LegendsOfValor lovgame) {
        boolean play = true;
        System.out.println("Please choose an action:");
        System.out.println(" 1: Attack\n 2: Cast spell\n 3: Move\n 4: Teleport\n 5: Back\n 6: Quit game\n");
        int move = ScannerParser.parseInt();
        while (move < 1 || move > 5) {
            move = ScannerParser.tryInt();
        }
        switch (move) {
            case 1:
                if (withinRange(grid)) {
                    attack(getNeighborMonster(grid, lovgame), null);
                }
                break;

            case 2:
                if (withinRange(grid)) {
                    Printer printer = new Printer();
                    ArrayList<Spell> spells = inventory.getSpells();
                    if (spells.size() != 0) {
                        System.out.println("Please choose a spell to cast (enter ID):");
                        printer.printSpells(spells);
                        int chosenSpell = ScannerParser.parseInt() - 1;
                        while (chosenSpell > inventory.getSpells().size()) {
                            chosenSpell = ScannerParser.tryInt() - 1;
                        }
                        attack(getNeighborMonster(grid, lovgame), inventory.getSpells().get(chosenSpell));
                    } else {
                        System.out.println("Your hero does not have any spell in their inventory! Choose another move!\n");
                        takeAction(grid, lovgame);
                    }
                }
                break;

            case 3:
                makeMove(grid);
                break;

            case 4: //teleport
                System.out.println("Please choose a lane you wish to teleport to :");
                System.out.println(" 1: Top\n 2: Mid\n 3: Bot\n");
                String input = ScannerParser.parseString();
                while(input.equals("Top") || input.equals("Mid") || input.equals("Bot")){
                    input = ScannerParser.tryString();
                }
                currLane.setName(input);
                System.out.println("Which row would you like to land on?(Between 1~8. You shall not land on a row that surpass any monster" +
                        "or land on the same cell as another hero)");
                int currrow = ScannerParser.parseInt();
                while(currrow>8 || currrow<1 || currLane.getMaxMonsterRow()>currrow || grid.getGrid()[currrow][2].getIcon().equals("I") ||grid.getGrid()[currrow][5].getIcon().equals("I")){
                    if(grid.getGrid()[currrow][2].getIcon().equals("I") ||grid.getGrid()[currrow][5].getIcon().equals("I")){
                        System.out.println("You shall not land on Inaccessible space!");
                    }
                    currrow = ScannerParser.tryInt();
                }
                row = currrow-1;
                System.out.println("Would you like to land on left or right column?(Between 1~8. You shall not land on the same cell as another hero)");
                int currcol = ScannerParser.parseInt();
                while(currcol>8 || currcol<1 || grid.getGrid()[currrow][currcol].isHashero()){
                    currcol = ScannerParser.tryInt();
                }
                col = currcol-1;
                break;

            case 5: //back
                if(initLane.getName().equals("Top")){
                    row = 0;
                    col = 7;
                }else if(initLane.getName().equals("Mid")){
                    row = 3;
                    col = 7;
                }else{
                    row = 6;
                    col = 7;
                }
                break;

            case 6: //quit
                System.out.println("Thanks for playing! Exiting program...");
                play = false;
                break;
        }
        return play;
    }

    /**
     * player choose to move a hero a certain direction. The hero then land on the cell and prompt the corresponding
     * scenarios
     *
     * @param
     * @return
     */
    public void makeMove(LOVGrid grid) {
        grid.display();
        System.out.println("Please choose a move:");
        System.out.println("W/w: move up\nA/a: move left\nS/s: move down\nD/d: move right\n");
        String move = ScannerParser.parseString();
        while (move.equals("W") && move.equals("w") && move.equals("A") && move.equals("a") && move.equals("S") && move.equals("s") &&
                move.equals("D") && move.equals("d")) {
            move = ScannerParser.tryString();
        }
        while (!isValidMove(move, grid)) {
            move = ScannerParser.tryString();
        }
        switch (move) {
            case "W":
            case "w":
                setRow(row - 1);
                grid.land(row, col, this, grid.getGrid()[row][col], move);
                break;

            case "A":
            case "a":
                setCol(col - 1);
                grid.land(row, col, this, grid.getGrid()[row][col], move);
                break;

            case "S":
            case "s":
                setRow(row + 1);
                grid.land(row, col, this, grid.getGrid()[row][col], move);
                break;

            case "D":
            case "d":
                setCol(col + 1);
                grid.land(row, col, this, grid.getGrid()[row][col], move);
                break;
        }
//        grid.printGrid(this);
    }

    public boolean isValidMove(String move, LOVGrid grid) {
        boolean isValid = true;
        Cell[][] grids = grid.getGrid();
        switch (move) {
            case "W":
            case "w":
                if (grids[row - 1][col].isHashero()) {
                    System.out.println("You shall not land in the same cell with another hero! Please try again!");
                    isValid = false;
                }
                if (row == currLane.getMaxMonsterRow()) {
                    System.out.println("You shall not bypass an monser without killing it! Please try again!");
                    isValid = false;
                }
                break;

            case "A":
            case "a":
                if (grids[row][col - 1].isHashero()) {
                    System.out.println("You shall not land in the same cell with another hero! Please try again!");
                    isValid = false;
                }
                break;

            case "S":
            case "s":
                if (grids[row + 1][col].isHashero()) {
                    System.out.println("You shall not land in the same cell with another hero! Please try again!");
                    isValid = false;
                }
                break;

            case "D":
            case "d":
                if (grids[row][col + 1].isHashero()) {
                    System.out.println("You shall not land in the same cell with another hero! Please try again!");
                    isValid = false;
                }
                break;
        }
        return isValid;
    }

    public Monster getNeighborMonster(LOVGrid grid, LegendsOfValor legendofvalor){
        Cell[][] grids = grid.getGrid();
        if (grids[Math.max(row - 1, 0)][Math.max(col-1,0)].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == Math.max(row - 1, 0) && legendofvalor.getMonsters().get(i).getCol() == Math.max(col-1,0)){
                    return legendofvalor.getMonsters().get(i);
                }
            }

        }
        else if (grids[Math.max(row-1,0)][col].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == Math.max(row-1,0) && legendofvalor.getMonsters().get(i).getCol() == col){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else if (grids[Math.max(row-1,0)][Math.min(col+1,7)].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == Math.max(row-1,0) && legendofvalor.getMonsters().get(i).getCol() == Math.min(col+1,7)){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else if (grids[row][Math.min(col-1,0)].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == row && legendofvalor.getMonsters().get(i).getCol() == Math.min(col-1,0)){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else if (grids[row][col].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == row && legendofvalor.getMonsters().get(i).getCol() == col){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else if (grids[row][Math.min(col+1,7)].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == row && legendofvalor.getMonsters().get(i).getCol() == Math.min(col+1,7)){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else if (grids[Math.min(row+1,7)][Math.max(col-1,0)].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == Math.min(row+1,7) && legendofvalor.getMonsters().get(i).getCol() == Math.max(col-1,0)){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else if (grids[Math.min(row+1,7)][col].isHasmonster()){
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == Math.min(row+1,7) && legendofvalor.getMonsters().get(i).getCol() == col){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        else {
            for (int i = 0; i < legendofvalor.getMonsters().size(); i++){
                if (legendofvalor.getMonsters().get(i).getRow() == Math.min(row+1,7) && legendofvalor.getMonsters().get(i).getCol() == Math.min(col+1,7)){
                    return legendofvalor.getMonsters().get(i);
                }
            }
        }
        return null;
    }

    // return boolean indicating whether there is a monster within the hero's attacking range
    public boolean withinRange(LOVGrid grid) {
        Cell[][] grids = grid.getGrid();
        if (grids[Math.max(row - 1, 0)][Math.max(col - 1, 0)].isHasmonster() || grids[Math.max(row - 1, 0)][col].isHasmonster() || grids[Math.max(row - 1, 0)][Math.min(col + 1, 7)].isHasmonster() ||
                grids[row][Math.min(col - 1, 0)].isHasmonster() || grids[row][col].isHasmonster() || grids[row][Math.min(col + 1, 7)].isHasmonster() ||
                grids[Math.min(row + 1, 7)][Math.max(col - 1, 0)].isHasmonster() || grids[Math.min(row + 1, 7)][col].isHasmonster() || grids[Math.min(row + 1, 7)][Math.min(col + 1, 7)].isHasmonster()) {
            return true;
        } else {
            return false;
        }
    }


    public void buy(Item item) {
        inventory.addItem(item);
        money -= item.getPrice();
    }

    public void sell(Item item) {
        inventory.removeItem(item);
        money += item.getPrice();
    }


    public void equip(Item i) {
        if (i instanceof Weapon) {
            for (Weapon w : inventory.getWeapons()) {
                if (i.getName().equals(w.getName())) {
                    w.equipItem();
                    currentWeapon = w;
                    return;
                }
            }
        } else if (i instanceof Armor) {
            for (Armor a : inventory.getArmors()) {
                if (i.getName().equals(a.getName())) {
                    a.equipItem();
                    currentArmor = a;
                    return;
                }
            }

        } else {
            System.out.println("You shall not equip such item.");
        }
    }


    public void changeWeapon(Weapon orig, Weapon wear) {
        unequip(orig);
        equip(wear);
        setCurrentWeapon(wear);
    }

    public void changeArmor(Armor orig, Armor wear) {
        unequip(orig);
        equip(wear);
        setCurrentArmor(wear);
    }

    public void unequip(Item i) {
        for (Item item : getInventory().getArmors()) {
            if (item.getName().equals(i.getName())) {
                if (item instanceof Weapon) {
                    ((Weapon) item).equipItem();
                    currentWeapon = null;
                } else if (item instanceof Armor) {
                    ((Armor) item).equipItem();
                    currentArmor = null;
                }
            }
        }
    }

    public void use(Potion p) {
        int[] uses = p.calcUse();
        setHP(getHP() + p.getIncrease() * uses[0]);
        setMana(getMana() + p.getIncrease() * uses[1]);
        setStrength(getStrength() + p.getIncrease() * uses[2]);
        setDexterity(getDexterity() + p.getIncrease() * uses[3]);
        setAgility(getAgility() + p.getIncrease() * uses[4]);
    }

    public void attack(Monster m, Spell spell) {
        int dmg = 0;
        int newHP;
        if (spell == null) {
            for (Weapon w : getInventory().getWeapons()) {
                if (w.isArmed()) {
                    dmg = w.calcAttack(strength, m);
                    break;
                }
            }
            System.out.println("Hero" + getName() + " has dealt " + dmg + " damage to " + m.getName());
            if (m.getHP() <= dmg) {
                m.setHP(0);
                m.setFaint(true);
                System.out.println("Monster " + m.getName() + " fainted!");

            } else {
                newHP = m.getHP() - dmg;
                m.setHP(newHP);
            }
        } else {
            mana -= spell.getMana();
            dmg = spell.calcAttack(dexterity, m);
            if (m.getHP() <= dmg) {
                m.setHP(0);
                System.out.println("Monster " + m.getName() + " fainted!");
                m.setFaint(true);
            } else {
                newHP = m.getHP() - dmg;
                m.setHP(newHP);
            }
        }
    }


    public void takeDamage(int dmg) {
        int actualdmg = dmg;
        for (Armor a : getInventory().getArmors()) {
            if (a.isArmed()) {
                actualdmg -= a.getReduction();
                break;
            }
        }
        System.out.println("Monster" + getName() + " has dealt " + dmg + " damage to " + getName());
        if (getHP() <= actualdmg) {
            setHP(0);
            setFaint(true);
            System.out.println("Hero " + getName() + " fainted!");

        } else {
            setHP(getHP() - actualdmg);
        }
    }


    public Inventory getArmedInventory() {
        return armedInventory;
    }

    public void setArmedInventory(Inventory armedInventory) {
        this.armedInventory = armedInventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    public Armor getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
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
}
