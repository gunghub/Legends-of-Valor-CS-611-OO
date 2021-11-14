public class KoulouCell extends LOVCell {
    public KoulouCell(){
        super();
        border = "K";
    }

    public String getBorder(){
        return border;
    }

    public void addBuff(Hero hero){
        hero.setStrength((int) (hero.getStrength() * (1 + 0.1)));
    }
}
