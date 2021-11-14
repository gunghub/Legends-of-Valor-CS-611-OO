package legends.grids;

import legends.NexusCell;
import legends.characters.heroes.Hero;
import legends.gameplay.Markets;
import legends.players.LegendsPlayer;
import legends.utilities.Factory;

public class HeroNexus extends Nexus{

    public HeroNexus(){

    }

    public void spawn(Character c, NexusCell nc){
        // set index to the index of the nexusCell
        Hero h = (Hero) c;
        h.setRow(nc.getRow());
        h.setCol(nc.getCol());
    }

    public void shop(LegendsPlayer p){
        Factory fac = new Factory();
        Markets m = fac.newMarkets();
        m.enterStore(p);
    }
}
