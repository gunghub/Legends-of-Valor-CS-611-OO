package legends.utilities;

import legends.LOVGrid;
import legends.characters.heroes.Paladin;
import legends.characters.heroes.Sorcerer;
import legends.characters.heroes.Warrior;
import legends.characters.monsters.Dragon;
import legends.characters.monsters.Exoskeleton;
import legends.characters.monsters.Spirit;
import legends.gameplay.Fight;
import legends.gameplay.Inventory;
import legends.gameplay.Markets;
import legends.gameplay.Round;
import legends.grids.cells.InaccessibleCell;
import legends.items.Armor;
import legends.items.Potion;
import legends.items.Weapon;
import legends.items.spells.FireSpell;
import legends.items.spells.IceSpell;
import legends.items.spells.LightningSpell;
import legends.players.LegendsPlayer;

public class Factory {

//    public LOVGrid newLegendsGrid(){
//        return new LOVGrid(8, 8);
//    }

    public Inventory newInventory(){
        return new Inventory();
    }

    public Markets newMarkets(){
        return new Markets();
    }

    public Fight newFight(){
        return new Fight();
    }

    public Round newRound(){
        return new Round();
    }

    public ScannerParser newScannerParser(){
        return new ScannerParser();
    }

    public FileParser newFileParser(){
        return new FileParser();
    }

    public Paladin newPaladin(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience){
        return new Paladin(name, level, HP, mana, strength, agility, dexterity, money, experience);
    }

    public Sorcerer newSorcerer(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience){
        return new Sorcerer(name, level, HP, mana, strength, agility, dexterity, money, experience);
    }

    public Warrior newWarrior(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience){
        return new Warrior(name, level, HP, mana, strength, agility, dexterity, money, experience);
    }

    public Exoskeleton newExoskeleton(String name, int level, int HP, int defense, int damage, int dodge){
        return new Exoskeleton(name, level, HP, defense, damage, dodge);
    }

    public Dragon newDragon(String name, int level, int HP, int defense, int damage, int dodge){
        return new Dragon(name, level, HP, defense, damage, dodge);
    }

    public Spirit newSpirit(String name, int level, int HP, int defense, int damage, int dodge){
        return new Spirit(name, level, HP, defense, damage, dodge);
    }

    public Weapon newWeapon(String name, int price, int minLevel, int damage){
        return new Weapon(name, price, minLevel, damage);
    }

    public Armor newArmor(String name, int price, int minLevel, int reduction){
        return new Armor(name, price, minLevel, reduction);
    }

    public Potion newPotion(String name, int price, int minLevel, int increase, String affectedAttr){
        return new Potion(name, price, minLevel, increase, affectedAttr);
    }

    public FireSpell newFireSpell(String name, int price, int minLevel, int mana, int damage){
        return new FireSpell(name, price, minLevel, mana, damage);
    }

    public IceSpell newIceSpell(String name, int price, int minLevel, int mana, int damage){
        return new IceSpell(name, price, minLevel, mana, damage);
    }

    public LightningSpell newLightningSpell(String name, int price, int minLevel, int mana, int damage){
        return new LightningSpell(name, price, minLevel, mana, damage);
    }

    public InaccessibleCell newInaccessible(int row, int col){
        return new InaccessibleCell(row, col);
    }

    public LegendsPlayer newLegendsPlayer(String name, String icon){
        return new LegendsPlayer(name, icon);
    }

}


