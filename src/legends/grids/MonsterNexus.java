package legends.grids;

import legends.characters.monsters.Monster;

import legends.games.LegendsOfValor;
import legends.grids.cells.NexusCell;
import legends.characters.Character;
import legends.grids.lanes.Lane;
import legends.utilities.FileParser;


public class MonsterNexus extends Nexus{
    public MonsterNexus(){

    }


    /**
     * initialize a monster to be spawned
     * @param
     * @param lane Lane of the new monster
     */
    public Character spawn(Lane lane){
        FileParser fp = new FileParser();
        Monster monster = fp.chooseRandMonster();
        monster.setPosition(0,lane.getLeftCol()+1);
        monster.setLane(lane);
        return monster;
    }


}
