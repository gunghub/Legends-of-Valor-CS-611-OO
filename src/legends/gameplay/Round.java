package legends.gameplay;

import legends.LovMap;
import legends.characters.heroes.Hero;
import legends.games.LegendsOfValor;
import legends.grids.HeroNexus;
import legends.grids.MonsterNexus;
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


    /**
     * play one round
     * @param heroes
     * @param monsters
     * @param play
     * @param grid
     * @param game
     * @return
     */
    public boolean playRound(ArrayList<Hero> heroes, ArrayList<Monster> monsters, boolean play, LovMap grid, LegendsOfValor game) {
       int numRound = 0;
        while (play) {
            if(numRound==8){
                System.out.println("New monsters are spawned!");
                game.initMonsters();
            }
            for (int i = 0; i < heroes.size(); i++) {
                grid.display();
//                if(heroes.get(i).getRow()==7){
//                    Markets market = new Markets();
//                    market.storeConsole(heroes.get(i));
//                }
                Printer printer = new Printer();
                printer.printHero(heroes.get(i));
                heroes.get(i).setHP((int)1.1*heroes.get(i).getHP());
                heroes.get(i).setMana((int)1.1*heroes.get(i).getMana());
                System.out.println("Please choose an action for H" + (i + 1)+"----");
                play = heroes.get(i).takeAction(grid, game);
                if (play == false) {
                    break;
                }
                if(monsters.get(i).isFaint()){
                    grid.getCells()[monsters.get(i).getRow()][monsters.get(i).getCol()].setHasMonster(false);

                }else {
                    monsters.get(i).makeMove(heroes.get(i), grid, i);
                }
                heroes.get(i).levelUp();
                if (isOver(heroes, monsters)) {
                    winOrLose(heroes, monsters);
                    play = false;
                }
            }
            numRound++;
        }
        return play;
    }

    public void levelUps(ArrayList<Hero> heroes) {
        for (Hero h : heroes) {
            h.levelUp();
        }
    }



    /**
     * check if a game is over
     *
     * @return
     */
    public boolean isOver(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        for (Hero hero : heroes) {
            if (hero.getRow() == 0) {
                return true;
            }
        }
        for (Monster monster : monsters) {
            if (monster.getRow() == 7) {
                return true;
            }
        }
        return false;
    }


    /**
     * if hero wins, give the rewards; if lose, deduct the
     *
     * @param heroes
     */
    public void winOrLose(ArrayList<Hero> heroes, ArrayList<Monster> monsters) {
        for (Hero hero : heroes) {
            if (hero.getRow() == 0) {
                System.out.println("You won the game!");
                return;
            }
        }
        for (Monster monster : monsters) {
            if (monster.getRow() == 7) {
                System.out.println("A monster landed on your Nexus. You lost!");
                return;
            }
        }
    }


}
