package legends.grids;

public abstract class Nexus {


    public Nexus(){

    }

    // spawn a monster or hero to the given NexusCell
    abstract public void spawn(Character c, NexusCell nc);
}
