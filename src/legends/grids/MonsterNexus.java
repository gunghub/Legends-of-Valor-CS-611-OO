package legends.grids;

import legends.characters.monsters.Monster;

import legends.grids.cells.NexusCell;
import legends.characters.Character;


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
