package legends.grids.lanes;


public class RegularLane extends Lane {
    private final String type = "Regular";

    public RegularLane(String name){
        super("Regular");
    }

    public String getType() {
        return type;
    }
    public void initCells(){
        //todo
    }
}


