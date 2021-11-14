package legends;

import legends.characters.heroes.Hero;

public class BushCell extends LOVCell {
    public BushCell(){
        super();
        border = "B";
    }

    public String getBorder(){
        return border;
    }

    public void addBuff(Hero hero){
        hero.setDexterity((int) (hero.getDexterity() * (1 + 0.1)));
    }
}
