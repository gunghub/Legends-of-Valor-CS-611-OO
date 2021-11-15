package legends.grids;


import legends.grids.cells.NexusCell;
import legends.characters.Character;

public abstract class Nexus {


    public Nexus(){

    }

    // spawn a monster or hero to the given NexusCell
    abstract public void spawn(Character c, NexusCell nc);
}
