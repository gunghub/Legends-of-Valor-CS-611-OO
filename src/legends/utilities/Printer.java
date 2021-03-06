package legends.utilities;

import legends.gameplay.Inventory;
import legends.characters.heroes.Hero;
import legends.items.Armor;
import legends.items.Potion;
import legends.items.Weapon;
import legends.characters.monsters.Monster;
import legends.items.spells.Spell;
import legends.utilities.Colors;
import java.util.ArrayList;
import java.util.HashMap;

public class Printer {
    private Colors colors = new Colors();
    public Printer(){}

    // TODO: Print hero type and monster types when printing!!!

    public void printHeroes(ArrayList<Hero> heroes){
        System.out.println(colors.addColor("blue", "\tID\t\t\t\tName\t\t\tLevel\t\tHP\t\tMana\t\tStrength\t\tAgility\t\tDexterity\t\tMoney\t\tExperience\t\tCurrent lane"));
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
        System.out.println(colors.addColor("blue", "Name\t\t\t\t\t\tLevel\t\tHP\t\tMana\t\tStrength\t\tAgility\t\tDexterity\t   Money\t\tExperience\t\tCurrent Lane"));
        System.out.println("=======================================================================================================================================================");
        System.out.format("%-20s%9d%13d%9d%13d%15d%15d%13d%13d%17s",h.getName(),h.getLevel(),h.getHP(),h.getMana(),h.getStrength(),h.getAgility()
                ,h.getDexterity(),h.getMoney(),h.getExperience(), h.getCurrLane().getName());
        System.out.println("\n");
        if(h.getCurrentWeapon()!=null && h.getCurrentArmor()!=null) {
            System.out.println("Hero's current armor is " + h.getCurrentArmor().getName() + " ------ gives " + h.getCurrentArmor().getReduction() + " extra reduction");
            System.out.println("Hero's current weapon is " + h.getCurrentArmor().getName() + " ------ gives " + h.getCurrentWeapon().getDamage() + " extra damages");
        }else if(h.getCurrentWeapon()!=null && h.getCurrentArmor()==null){
            System.out.println("Hero's current weapon is " + h.getCurrentArmor().getName() + " ------ gives " + h.getCurrentWeapon().getDamage() + " extra damages");
        }else if(h.getCurrentWeapon()==null && h.getCurrentArmor()!=null){
            System.out.println("Hero's current armor is " + h.getCurrentArmor().getName() + " ------ gives " + h.getCurrentArmor().getReduction() + " extra reduction");
        }else{
            System.out.println("Hero is not armed with any weapon or armor");

        }
        System.out.println("\n");
    }

    public void printMonsters(ArrayList<Monster> monsters){
        System.out.println(colors.addColor("blue", "\t ID  \t  Name\t\tLevel\t  Damage\t  Defense\t  Dodge Chance"));
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
            case 1:
                ArrayList<Weapon> weapons = inventory.getWeapons();
                System.out.println(colors.addColor("green", "Shop Weapons:"));
                printWeapons(weapons);
                break;

            case 2:
                ArrayList<Armor> armors = inventory.getArmors();
                System.out.println("Shop Armors:");
                printArmors(armors);
                break;

            case 3:
                HashMap<Potion, Integer> potions = inventory.getPotions();
                System.out.println("Shop Potions:");
                printPotions(potions);
                break;

            case 4:
                ArrayList<Spell> spells = inventory.getSpells();
                System.out.println("Shop Spells:");
                printSpells(spells);
                break;
        }
    }

//    public static void printBattleRules(){
//        System.out.println("============================================================================");
//        System.out.println("                              Battle Rules                                  ");
//        System.out.println("============================================================================");
//
//    }

    public void printArmors(ArrayList<Armor> armors){
        System.out.println(colors.addColor("blue", "\tID\t\t\t\tName\t\t\t\tCost\t\t\tRequired Level\t\t\tDamage Reduction"));
        System.out.println("==================================================================================================");
        int id = 1;
        for(Armor a: armors){
            System.out.format("%5d%24s%14d%20d%24d", id, a.getName(), a.getPrice(), a.getMinLevel(), a.getReduction());
            System.out.println("\n");
            id++;
        }
    }

    public void printPotions(HashMap<Potion, Integer> potions){
//        Potion[] keys = (Potion[])potions.keySet().toArray();
//
//        System.out.println(colors.addColor("blue","\t ID  \t  Name\t\tRequired Level\t  Attribute Increase\t  Attributes Affected"));
//        System.out.println("=======================================================================================");
//        int id = 1;
//        for(Potion p: keys){
//            System.out.format("%7d%12s%7d%8d%13s", id,p.getName(), p.getMinLevel(), p.getIncrease(), p.getAffectedAttr());
//            System.out.println("\n");
//            id++;
//        }
        System.out.println(colors.addColor("blue","\tID\t\t\t\tName\t\t\t\tRequired Level\t\t\tAttribute Increase\t\t\t\t\tAttributes Affected"));
        System.out.println("================================================================================================================================");
        int id = 1;
        for(Potion p :potions.keySet()){
            System.out.format("%5d%24s%17d%27d%40s", id,p.getName(), p.getMinLevel(), p.getIncrease(), p.getAffectedAttr());
            System.out.println("\n");
            id++;
        }
    }

    public void printSpells(ArrayList<Spell> spells){
        System.out.println(colors.addColor("blue","\tID\t\t\t\tName\t\t\t\tCost\t\t\tRequired Level\t\t\tDamage\t\t\tMana Cost"));
        System.out.println("==============================================================================================================");
        int id = 1;
        for(Spell s: spells){
            System.out.format("%5d%24s%14d%20d%22d%18d", id, s.getName(), s.getPrice(), s.getMinLevel(), s.getDamage(), s.getMana());
            System.out.println("\n");
            id++;
        }
    }

    public void printWeapons(ArrayList<Weapon> weapons){
        System.out.println(colors.addColor("blue","\t ID  \t  Name\t\t  Cost\t  Required Level\t  Damage Reduction"));
        System.out.println("=======================================================================================");
        int id = 1;
        for(Weapon w: weapons){
            System.out.format("%7d%12s%10d%11d%22d", id,w.getName(), w.getPrice(), w.getMinLevel(), w.getDamage());
            System.out.println("\n");
            id++;
        }

    }


}
