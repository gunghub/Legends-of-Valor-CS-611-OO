Shaolin Xie
CS611 - Legends

This is the Legends game.

------------Class Hierarchy-------------
Main() ----- main class
Game() ----- abstract class
    RPGGame() ----- abstract class extends Game
        Legends() ----- class extends RPGGame

Attackable() ----- interface
Equipable() ----- interface
Usable() ----- interface

Item(String name, double price, int minLevel)
----- abstract class
    Armor(String name, int price, int minLevel, int reduction)
    ----- extends Item implements Equipable
    Weapon(String name, int price, int minLevel, int damage)
    ----- extends Item implements Equipable, Attackable
    Potion(String name, int price, int minLevel, int increase, String affectedAttr)
    ----- extends Item implements Usable
    Spell(String name, int price, int minLevel, int mana, int damage)
    ----- extends Item Attackable
        IceSpell(String name, int price, int minLevel, int mana, int damage)
        ----- extends Spell
        FireSpell(String name, int price, int minLevel, int mana, int damage)
        ----- extends Spell
        LightningSpell(String name, int price, int minLevel, int mana, int damage)
        ----- extends Spell

Grid(int numRows, int numCols)
----- abstract class
    LegendsGrid()
    ----- class extends Grid

Cell(String icon, int row, int col)
----- abstract class
    CommonSpace(int row, int col)
    ----- class extends Cell
    MarketCell(int row, int col)
    ----- class extends Cell
    Inaccessible(int row, int col)
    ----- class extends Cell
    PlayerCell(int row, int col)   // we can delete this class
    ----- class extends Cell

Character(String name, int level, int HP)
----- abstract class
    Hero(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience)
    ----- abstract class
        Sorcerer(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience)
        ----- extends Hero
        Warrior(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience)
        ----- extendsHero
        Paladin(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience)
        ----- extends Hero
    Monster(String name, int level, int HP, int defense, int damage, int dodge)
    ----- extends Character
        Exoskeleton(String name, int level, int HP, int defense, int damage, int dodge)
        ----- extends Monster
        Dragon(String name, int level, int HP, int defense, int damage, int dodge)
        ----- extends Monster
        Spirit(String name, int level, int HP, int defense, int damage, int dodge)
        ----- extends Monster

Inventory() ----- class contains ArrayList of weapon, armor, spell and HashMap of potion
Markets() ----- class that represents the market

Player(String name, String icon)
----- class
    LegendsPlayer(String name, String icon)
    ----- extends Player

Fight() ----- class represents a fight
Round() ----- class

ScannerParser() ----- class to parse scanner inputs. All functions are static
FileParser() ------ class to parse input files into objects
Printer() ------ class to print shop/ heroes/ monsters/ weapon/ spell/ potion/ armor and other info
Colors() ------ class for console colors
Factory() ----- class to create objects

