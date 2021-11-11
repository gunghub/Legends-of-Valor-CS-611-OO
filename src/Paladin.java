public class Paladin extends Hero{
    private final String type = "Paladin";

    public Paladin(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience){
        super(name, level, HP, mana, strength, agility, dexterity, money, experience);
    }

    public String getType() {
        return type;
    }

    public void levelUp(){
        while(getExperience()>=getLevel()*10){
            setLevel(getLevel()+1);
            setMana((int)(getMana()*1.1));
            setHP(getLevel()*100);
            setAgility((int)(getAgility()*1.05));
            setDexterity((int)(getDexterity()*1.1));
            setStrength((int)(getStrength()*1.1));
            System.out.println("Your hero "+getName()+" leveled up! It's now level "+getLevel());
        }
    }

}
