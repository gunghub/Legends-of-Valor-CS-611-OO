package legends.players;

public class Player {
    public String name;
    public String pIcon;

    public Player(String name, String icon){
        this.name = name;
        this.pIcon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPIcon() {
        return pIcon;
    }

    public void setPIcon(String pIcon) {
        this.pIcon = pIcon;
    }


}
