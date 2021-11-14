public class Sorcerer extends Hero{
    private final String type = "Sorcerer";

    public Sorcerer(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience){
        super(name, level, HP, mana, strength, agility, dexterity, money, experience);
        graphic = new Graphic();
        colors = new Colors();
    }

    public String getType() {
        return type;
    }

    public void levelUp(){
        while(getExperience()>=getLevel()*10){
            setLevel(getLevel()+1);
            setMana((int)(getMana()*1.1));
            setHP(getLevel()*100);
            setAgility((int)(getAgility()*1.1));
            setDexterity((int)(getDexterity()*1.1));
            setStrength((int)(getStrength()*1.05));
            graphic.printLevelup();
            System.out.println(colors.addColor("red", "Your hero "+getName()+" leveled up! It's now level "+getLevel()));
        }
    }
}
