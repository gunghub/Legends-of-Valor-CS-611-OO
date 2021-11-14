public class CaveCell extends LOVCell {
    public CaveCell(){
        super();
        border = "C";
    }

    public String getBorder(){
        return border;
    }

    public void addBuff(Hero hero){
        hero.setAgility((int) (hero.getAgility() * (1 + 0.1)));
    }
}
