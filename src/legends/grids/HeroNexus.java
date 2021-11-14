package legends.grids;

import legends.grids.cells.NexusCell;
import legends.characters.heroes.Hero;
import legends.gameplay.Markets;
import legends.players.LegendsPlayer;
import legends.utilities.Factory;
import legends.characters.Character;

public class HeroNexus extends Nexus{

    public HeroNexus(){

    }

    public void spawn(Character c, NexusCell nc){
        // set index to the index of the nexusCell
        Hero h = (Hero) c;
        h.setRow(nc.getRow());
        h.setCol(nc.getCol());
    }

    public void shop(Hero h){
        Factory fac = new Factory();
        Markets m = fac.newMarkets();
        m.storeConsole(h);
    }
}
