package legends.utilities;

import legends.gameplay.Inventory;
import legends.characters.heroes.Hero;
import legends.items.Armor;
import legends.items.Potion;
import legends.items.Weapon;
import legends.characters.monsters.Monster;
import legends.items.spells.Spell;

import java.util.ArrayList;
import java.util.HashMap;

public class Printer {

    public Printer(){}

    // TODO: Print hero type and monster types when printing!!!

    public void printHeroes(ArrayList<Hero> heroes){
        System.out.println("\tID\t\t\t\tName\t\t\tLevel\t\tHP\t\tMana\t\tStrength\t\tAgility\t\tDexterity\t\tMoney\t\tExperience\t\tCurrent lane");
        System.out.println("============================================================================================================================================================================");
        int id = 1;
        for(Hero h: heroes){
            System.out.format("%5d%24s%9d%13d%9d%13d%15d%15d%13d%13d%17s", id,h.getName(),h.getLevel(),h.getHP(),h.getMana(),h.getStrength(),h.getAgility()
            ,h.getDexterity(),h.getMoney(),h.getExperience(), h.getCurrLane().getName());
            System.out.println("\n");
            id++;
        }
    }

    public void printHero(Hero h){
        System.out.println("\t  Name\t\tLevel\t\tHP\t\tMana\t\tStrength\t\tAgility\t\tDexterity\t\tMoney\t\tExperience\t\tCurrent Lane");
        System.out.println("===================================================================================================================================");
        System.out.format("%24s%7d%8d%8d%12d%11d%13d%18d%12d%17s",h.getName(),h.getLevel(),h.getHP(),h.getMana(),h.getStrength(),h.getAgility()
                ,h.getDexterity(),h.getMoney(),h.getExperience(), h.getCurrLane().getName());
        System.out.println("\n");
    }

    //TODO: print name of the lane in the end
    public void printMonsters(ArrayList<Monster> monsters){
        System.out.println("\t ID  \t  Name\t\tLevel\t  Damage\t  Defense\t  Dodge Chance");
        System.out.println("=================================================================================================================");
        int id = 1;
        for(Monster m: monsters){
            System.out.format("%7d%12s%7d%10d%10d%12d", id,m.getName(),m.getLevel(),m.getDamage(), m.getDefense(), m.getDodge());
            System.out.println("\n");
            id++;
        }
    }


    public void printShop(Inventory inventory, int type){
        int id = -1;
        switch(type){
            case 0:
                ArrayList<Weapon> weapons = inventory.getWeapons();
                System.out.println("Shop Weapons:");
                printWeapons(weapons);
                break;

            case 1:
                ArrayList<Armor> armors = inventory.getArmors();
                System.out.println("Shop Armors:");
                printArmors(armors);
                break;

            case 2:
                HashMap<Potion, Integer> potions = inventory.getPotions();
                System.out.println("Shop Potions:");
                printPotions(potions);
                break;

            case 3:
                ArrayList<Spell> spells = inventory.getSpells();
                System.out.println("Shop Spells:");
                printSpells(spells);
                break;
        }
    }

    //TODO: finish printing the rules
    public static void printBattleRules(){
        System.out.println("============================================================================");
        System.out.println("                              Battle Rules                                  ");
        System.out.println("============================================================================");

    }

    public void printArmors(ArrayList<Armor> armors){
        System.out.println("\t ID  \t  Name\t\t  Cost\t  Required Level\t  Damage Reduction");
        System.out.println("=======================================================================================");
        int id = 1;
        for(Armor a: armors){
            System.out.format("%7d%12s%7d%8d%13s", id,a.getName(), a.getPrice(), a.getMinLevel(), a.getReduction());
            System.out.println("\n");
            id++;
        }
    }

    public void printPotions(HashMap<Potion, Integer> potions){
        Potion[] keys = (Potion[])potions.keySet().toArray();
        System.out.println("\t ID  \t  Name\t\tRequired Level\t  Attribute Increase\t  Attributes Affected");
        System.out.println("=======================================================================================");
        int id = 1;
        for(Potion p: keys){
            System.out.format("%7d%12s%7d%8d%13s", id,p.getName(), p.getMinLevel(), p.getIncrease(), p.getAffectedAttr());
            System.out.println("\n");
            id++;
        }
    }

    public void printSpells(ArrayList<Spell> spells){
        System.out.println("\t ID  \t  Name\t\t  Cost\t  Required Level\t  Damage\t Mana Cost");
        System.out.println("=========================================================================================");
        int id = 1;
        for(Spell s: spells){
            System.out.format("%7d%12s%10d%7d%10d%13d", id, s.getName(), s.getPrice(), s.getMinLevel(), s.getDamage(), s.getMana());
            System.out.println("\n");
            id++;
        }
    }

    public void printWeapons(ArrayList<Weapon> weapons){
        System.out.println("\t ID  \t  Name\t\t  Cost\t  Required Level\t  Damage Reduction");
        System.out.println("=======================================================================================");
        int id = 1;
        for(Weapon w: weapons){
            System.out.format("%7d%12s%10d%7d%8d", id,w.getName(), w.getPrice(), w.getMinLevel(), w.getDamage());
            System.out.println("\n");
            id++;
        }

    }


}
