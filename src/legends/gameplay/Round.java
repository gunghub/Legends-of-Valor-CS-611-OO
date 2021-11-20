package legends.gameplay;

import legends.LovMap;
import legends.characters.heroes.Hero;
import legends.games.LegendsOfValor;
import legends.items.Potion;
import legends.characters.monsters.Monster;
import legends.items.spells.Spell;
import legends.utilities.Printer;
import legends.utilities.ScannerParser;
import legends.utilities.Colors;
import java.util.ArrayList;
import java.util.HashMap;

public class Round {
    Colors colors = new Colors();
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
        while (play) {
            for (int i = 0; i < heroes.size(); i++) {
                grid.display();
//                if(heroes.get(i).getRow()==7){
//                    Markets market = new Markets();
//                    market.storeConsole(heroes.get(i));
//                }
                heroes.get(i).setHP((int)1.1*heroes.get(i).getHP());
                heroes.get(i).setMana((int)1.1*heroes.get(i).getMana());
                Printer printer = new Printer();
                System.out.println(colors.addColor("cyan", "Please choose an action for H" + (i + 1)+"----"));
                play = heroes.get(i).takeAction(grid, game);
                if (play == false) {
                    break;
                }
                if(monsters.get(i).isFaint()){
                    monsters.remove(i);
                }else {
                    monsters.get(i).makeMove(heroes.get(i), grid, i);
                }
            }
        }
        if (isOver(heroes, monsters)) {
            winOrLose(heroes, monsters);
            play = false;
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
