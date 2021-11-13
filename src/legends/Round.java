package legends;

import legends.characters.heroes.Hero;
import legends.items.Potion;
import legends.characters.monsters.Monster;
import legends.items.spells.Spell;
import legends.utilities.Printer;
import legends.utilities.ScannerParser;

import java.util.ArrayList;
import java.util.HashMap;

public class Round {

    public Round() {

    }

    public void playRound(Fight f, int index, Hero h, Monster m) {
        ArrayList<Hero> heroes = f.getHeroes();
        ArrayList<Monster> monsters = f.getMonsters();

        if (index % 2 == 0) {
            playOffense(h, m, heroes, monsters);
        } else {
            playDefense(h, m, heroes, monsters);
        }

    }

    // NEED TO COMPLETE
    public void playRound(Fight f, int index, ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        Printer printer = new Printer();
        System.out.println("===============================Current Status=======================================");
        System.out.println("Heroes:");
        printer.printHeroes(heroes);
        System.out.println("Monsters:");
        printer.printMonsters(monsters);

        ArrayList<Hero> unfaintedH = new ArrayList<Hero>();
        ArrayList<Monster> unfaintedM = new ArrayList<Monster>();

        for (int i = 0; i < heroes.size(); i++) {
            if (allAliveH(heroes) && allAliveM(monsters)) {
                if (index % 2 == 0) {
                    playOffense(heroes.get(i), monsters.get(i), heroes, monsters);
                } else {
                    playDefense(heroes.get(i), monsters.get(i), heroes, monsters);
                }
            }
            if (heroes.get(i).isFaint()) {
                System.out.println("Your hero" + heroes.get(i).getName() + "is fainted. You shall not take any actions with this hero until the end of the fight.");
            } else {
                unfaintedH.add(heroes.get(i));
            }
            if (monsters.get(i).isFaint()) {
                System.out.println("Monster" + monsters.get(i).getName() + "is fainted. It won't take any actions until the end of the fight.");
            } else {
                unfaintedM.add(monsters.get(i));
            }

        }
        if (isOver(heroes, monsters)) {
            winOrLose(heroes, monsters);
        }


    }

    public boolean allAliveH(ArrayList<Hero> heroes) {
        for (Hero h : heroes) {
            if (h.isFaint()) {
                return false;
            }
        }
        return true;
    }

    public boolean allAliveM(ArrayList<Monster> monsters) {
        for (Monster m : monsters) {
            if (m.isFaint()) {
                return false;
            }
        }
        return true;
    }

    public void takeAction(Hero h, Monster m, ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        System.out.println("Choose an action for hero" + h.getName());
        System.out.println("0: Regular Attack\n1: Cast a spell\n2: Use a potion\n3: Change Armor/Weapon");
        int move = ScannerParser.parseInt();
        while (move != 0 && move != 1 && move != 2 && move != 3) {
            System.out.println("Invalid input. Please try again.");
            move = ScannerParser.parseInt();
        }
        Printer printer = new Printer();
        switch (move) {
            case 0:
                h.attack(m, null);
                break;

            case 1:
                ArrayList<Spell> spells = h.getInventory().getSpells();
                if (spells.size() != 0) {
                    System.out.println("Please choose a spell to cast (enter ID):");
                    printer.printSpells(spells);
                    int chosenSpell = ScannerParser.parseInt() - 1;
                    while (chosenSpell > h.getInventory().getSpells().size()) {
                        chosenSpell = ScannerParser.tryInt() - 1;
                    }
                    h.attack(m, h.getInventory().getSpells().get(chosenSpell));
                } else {
                    System.out.println("Your hero does not have any spell in their inventory! Choose another move!\n");
                    takeAction(h, m, heroes, monsters);
                }


                break;

            case 2:
                HashMap<Potion, Integer> potions = h.getInventory().getPotions();
                if (potions.size() != 0) {
                    System.out.println("Please choose a potion to use (enter ID):");

                    Potion[] keys = (Potion[]) potions.keySet().toArray();
                    printer.printPotions(potions);
                    int chosenPotion = ScannerParser.parseInt() - 1;
                    while (chosenPotion > h.getInventory().getPotions().size()) {
                        chosenPotion = ScannerParser.tryInt() - 1;
                    }
                    h.use(keys[chosenPotion]);
                } else {
                    System.out.println("You hero does not have any potion in their inventory! Choose another move!\n");
                    takeAction(h, m, heroes, monsters);
                }
                break;

            case 3:
                System.out.println("What would you like to change?");
                System.out.println("0: Armor\n1: Weapon");
                int type = ScannerParser.parseInt();
                while (type != 0 && type != 1) {
                    type = ScannerParser.tryInt();
                }
                switch (type) {
                    case 0:
                        System.out.println("Your current armor is:" + h.getCurrentA().getName());
                        h.unequip(h.getCurrentA());
                        System.out.println("Current armor is taken off.");
                        System.out.println("Which armor would you like to wear now?");
                        printer.printArmors(h.getInventory().getArmors());
                        int newarmor = ScannerParser.parseInt() - 1;
                        while (newarmor > h.getInventory().getArmors().size()) {
                            newarmor = ScannerParser.tryInt() - 1;
                        }
//                        h.equip(h.getInventory().getArmors().get(newarmor));
                        h.changeArmor(h.getCurrentA(), h.getInventory().getArmors().get(newarmor));
                        System.out.println("Armor " + h.getCurrentA().getName() + " is equipped now");
                        break;

                    case 1:
                        System.out.println("Your current weapon is:" + h.getCurrentW().getName());
                        h.unequip(h.getCurrentW());
                        System.out.println("Current weapon is unarmed now.");
                        System.out.println("Which weapon would you like to arm now?");
                        printer.printWeapons(h.getInventory().getWeapons());
                        int newWeapon = ScannerParser.parseInt() - 1;
                        while (newWeapon > h.getInventory().getWeapons().size()) {
                            newWeapon = ScannerParser.tryInt() - 1;
                        }
//                      h.equip(h.getInventory().getWeapons().get(newWeapon));
                        h.changeWeapon(h.getCurrentW(), h.getInventory().getWeapons().get(newWeapon));
                        System.out.println("Weapon " + h.getCurrentW().getName() + " is equipped now");
                        break;

                }
        }

    }

    /**
     * check if a game is over
     *
     * @return
     */
    public boolean isOver(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        int countH = countFaintH(heroes);
        int countM = countFaintM(monsters);
        if (countH == heroes.size() || countM == heroes.size()) {
            return true;
        }
        return false;
    }

    /**
     * count the number of fainted heroes
     *
     * @param heroes
     * @return
     */
    public int countFaintH(ArrayList<Hero> heroes) {
        int count = 0;
        for (Hero h : heroes) {
            if (h.isFaint()) {
                count++;
            }
        }
        return count;
    }

    /**
     * count the number of fainted monsters
     *
     * @param monsters
     * @return
     */
    public int countFaintM(ArrayList<Monster> monsters) {
        int count = 0;
        for (Monster m : monsters) {
            if (m.isFaint()) {
                count++;
            }
        }
        return count;
    }

    /**
     * if hero wins, give the rewards; if lose, deduct the
     *
     * @param heroes
     */
    public void winOrLose(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        if (countFaintH(heroes) == heroes.size()) {
            System.out.println("You lost the Battle! You heroes lost half of their money.");
            for (Hero h : heroes) {
                h.setMoney(h.getMoney() / 2);
            }
        } else {
            System.out.println("You won the battle!");
            for (Hero h : heroes) {
                if (h.isFaint()) {
                    h.setHP(h.getLevel() * 50);
                } else {
                    h.setMoney(h.getMoney() + 100 * monsters.get(0).getLevel());
                    h.setExperience(h.getExperience() + 2);
                }
            }
        }

    }

    public void playOffense(Hero h, Monster m, ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        takeAction(h, m, heroes, monsters);
        h.takeDamage(m.getDamage());
    }

    public void playDefense(Hero h, Monster m, ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        h.takeDamage(m.getDamage());
        takeAction(h, m, heroes, monsters);

    }

}
