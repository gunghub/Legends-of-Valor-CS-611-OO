/**
 * Market cells.
 */
public class MarketCell extends Cell{
    private final String type = "Market";
    public MarketCell(int row, int col){
        super("M", row, col);
    }

    public String getType() {
        return type;
    }

    public void land(LegendsPlayer p){
        Markets m = new Markets();
        m.storeConsole(p);
    }

}
