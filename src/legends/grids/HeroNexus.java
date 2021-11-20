package legends.grids;

import legends.games.LegendsOfValor;
import legends.grids.cells.NexusCell;
import legends.characters.heroes.Hero;
import legends.gameplay.Markets;
import legends.grids.lanes.Lane;
import legends.players.LegendsPlayer;
import legends.utilities.Factory;
import legends.characters.Character;
import legends.utilities.Printer;
import legends.utilities.ScannerParser;

public class HeroNexus extends Nexus{

    public HeroNexus(){

    }

    /**
     * initialize hero position
     */
    public void spawn(Character character, int index){
            switch(index){
                case 0:
                    ((Hero)character).setPosition(7,0);
                    break;

                case 1:
                    ((Hero)character).setPosition(7,3);
                    break;

                case 2:
                    ((Hero)character).setPosition(7,6);
                    break;
            }

    }
//        // set index to the index of the nexusCell
//        System.out.println("What type of hero is your top lane hero?");
//        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
//        int type = ScannerParser.parseInt();
//        while (type != 1 && type != 2 && type != 3) {
//            type = ScannerParser.tryInt();
//        }
//        game.chooseHeroType(type);
//
//        System.out.println("What type of hero is your middle lane hero?");
//        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
//        type = ScannerParser.parseInt();
//        while (type != 1 && type != 2 && type != 3) {
//            type = ScannerParser.tryInt();
//        }
//        game.chooseHeroType(type);
//
//        System.out.println("What type of hero is your bottom lane hero?");
//        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
//        type = ScannerParser.parseInt();
//        while (type != 1 && type != 2 && type != 3) {
//            type = ScannerParser.tryInt();
//        }
//        game.chooseHeroType(type);
//
//        for(int i=0; i<game.getHeroes().size(); i++){
//            initNewHero(game.getHeroes().get(i), i);
//        }
//        System.out.println("Please see your heroes below ----\n");
//        Printer printer = new Printer();
//        printer.printHeroes(game.getHeroes());
//        System.out.println("Now start your journey!");
//    }
//
//    public void initNewHero(Hero hero, int index){
//        Lane lane = new Lane(null);
//        switch(index){
//            case 0:
//                lane.setName("Top");
//                hero.setRow(7);
//                hero.setCol(0);
//                break;
//
//            case 1:
//                lane.setName("Mid");
//                hero.setRow(7);
//                hero.setCol(3);
//                break;
//
//            case 2:
//                lane.setName("Bot");
//                hero.setRow(7);
//                hero.setCol(6);
//                break;
//        }
//        lane.setMaxMonsterRow(0);
//        hero.setInitLane(lane);
//        hero.setCurrLane(lane);
//
//    }

    public void shop(Hero h){
        Factory fac = new Factory();
        Markets m = fac.newMarkets();
        m.storeConsole(h);
    }
}
