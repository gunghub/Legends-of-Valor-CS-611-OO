package legends.grids;

import java.util.ArrayList;
import legends.grids.cells.NexusCell;
import legends.characters.monsters.Monster;

public class MonsterNexus extends Nexus{
    public MonsterNexus(){

    }


    public void spawn(Character c, NexusCell nc){
        // set index to the index of the nexusCell
        Monster m = (Monster) c;
        m.setRow(nc.getRow());
        m.setCol(nc.getCol());
    }


}
