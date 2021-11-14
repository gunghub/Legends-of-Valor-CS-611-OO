package legends.grids;

import legends.NexusCell;

public abstract class Nexus {


    public Nexus(){

    }

    // spawn a monster or hero to the given legends.NexusCell

    abstract public void spawn(Character c, NexusCell nc);
}
