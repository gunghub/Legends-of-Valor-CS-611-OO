package legends.grids;


import legends.games.LegendsOfValor;
import legends.grids.cells.NexusCell;
import legends.characters.Character;
import legends.grids.lanes.Lane;

public abstract class Nexus {


    public Nexus(){

    }

    // spawn a monster or hero to the given NexusCell
    abstract Character spawn(Lane lane);
}
