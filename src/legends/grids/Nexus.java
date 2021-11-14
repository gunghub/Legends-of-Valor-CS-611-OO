package legends.grids;


import legends.grids.cells.NexusCell;

public abstract class Nexus {


    public Nexus(){
    }


    // spawn a monster or hero to the given legends.grids.cells.NexusCell

    abstract public void spawn(Character c, NexusCell nc);
}
