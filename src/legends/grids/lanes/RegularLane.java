package legends.grids.lanes;


public class RegularLane extends Lane {
    private final String type = "Regular";

    public RegularLane(String name, int maxMonsterRow){
        super("Regular", maxMonsterRow);
    }

    public String getType() {
        return type;
    }
    public void initCells(){
        //todo
    }
}


