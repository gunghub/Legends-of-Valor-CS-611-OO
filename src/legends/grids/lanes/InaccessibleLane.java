package legends.grids.lanes;


import legends.grids.cells.Cell;

public class InaccessibleLane extends Lane{
    private final String type = "Inaccessible";

    public InaccessibleLane(String name, int maxMonsterRow){
        super("Inaccessible", maxMonsterRow);
    }

    public String getType() {
        return type;
    }
}
