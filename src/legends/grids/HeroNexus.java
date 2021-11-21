package legends.grids;

import legends.games.LegendsOfValor;
import legends.grids.cells.NexusCell;
import legends.characters.heroes.Hero;
import legends.gameplay.Markets;
import legends.grids.lanes.Lane;
import legends.players.LegendsPlayer;
import legends.utilities.*;
import legends.characters.Character;

import java.util.ArrayList;

public class HeroNexus extends Nexus {


    public HeroNexus() {
    }

    /**
     * initialize heroes to be spawned
     */
    public Character spawn(Lane lane) {
        int type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            System.out.println("Please input a number within the given range:");
            type = ScannerParser.parseInt();
        }
        Hero hero = chooseHeroType(type);
        hero.setPosition(7, lane.getLeftCol());
        hero.setInitLane(lane);
        return hero;
    }

    public Hero chooseHeroType(int type) {
        FileParser fp = new FileParser();
        Hero h = null;
        switch (type) {
            case 1:
                ArrayList<Hero> paladins = fp.parsePaladins();
                h = paladins.get(ScannerParser.getRandNum(paladins.size()));
                break;

            case 2:
                ArrayList<Hero> sorcerers = fp.parseSorcerers();
                h = sorcerers.get(ScannerParser.getRandNum(sorcerers.size()));
                break;

            case 3:
                ArrayList<Hero> warriors = fp.parseWarriors();
                h = warriors.get(ScannerParser.getRandNum(warriors.size()));
                break;

        }
        return h;
    }


    public void shop(Hero h) {
        Factory fac = new Factory();
        Markets m = fac.newMarkets();
        m.storeConsole(h);
    }
}
