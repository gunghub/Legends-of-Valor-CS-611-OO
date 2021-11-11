public abstract class Monster extends Character{
    private int defense;
    private int damage;
    private int dodge;

    public Monster(String name, int level, int HP, int defense, int damage, int dodge){
        super(name, level, HP);
        this.defense = defense;
        this.damage =damage;
        this.dodge = dodge;
    }

    public int getDefense() { return defense;}

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDodge() {
        return dodge;
    }

    public void setDodge(int dodge) {
        this.dodge = dodge;
    }


}
