package legends.characters.heroes;

import legends.characters.Character;
import legends.gameplay.Inventory;
import legends.items.Armor;
import legends.items.Item;
import legends.items.Potion;
import legends.items.Weapon;
import legends.characters.monsters.Monster;
import legends.items.spells.Spell;

public abstract class Hero extends Character {
    private int mana;
    private int strength;
    private int agility;
    private int dexterity;
    private int money;
    private int experience;
    private Inventory armedInventory;
    private Inventory inventory;
    private Weapon currentWeapon;
    private Armor currentArmor;

    public Hero(String name, int level, int HP, int mana, int strength, int agility, int dexterity, int money, int experience) {
        super(name, level, HP);
        this.mana = mana;
        this.strength = strength;
        this.agility = agility;
        this.dexterity = dexterity;
        this.money = money;
        this.experience = experience;
        armedInventory = new Inventory();
        inventory = new Inventory();
    }

    public abstract void levelUp();


    public void buy(Item item) {
        inventory.addItem(item);
        money -= item.getPrice();
    }

    public void sell(Item item) {
        inventory.removeItem(item);
        money += item.getPrice();
    }

    //TODO: need to view hero stats at any moment of the game
    public void viewHeroStats() {

    }


    public void equip(Item i) {
        if (i instanceof Weapon) {
            for (Weapon w : inventory.getWeapons()) {
                if (i.getName().equals(w.getName())) {
                    w.equipItem();
                    currentWeapon = w;
                    return;
                }
            }
        } else if (i instanceof Armor) {
            for (Armor a : inventory.getArmors()) {
                if (i.getName().equals(a.getName())) {
                    a.equipItem();
                    currentArmor = a;
                    return;
                }
            }

        } else {
            System.out.println("You shall not equip such item.");
        }
    }


    public void changeWeapon(Weapon orig, Weapon wear) {
        unequip(orig);
        equip(wear);
        setCurrentWeapon(wear);
    }

    public void changeArmor(Armor orig, Armor wear){
        unequip(orig);
        equip(wear);
        setCurrentArmor(wear);
    }

    public void unequip(Item i) {
        for (Item item : getInventory().getArmors()) {
            if (item.getName().equals(i.getName())) {
                if (item instanceof Weapon) {
                    ((Weapon) item).equipItem();
                    currentWeapon = null;
                } else if (item instanceof Armor) {
                    ((Armor) item).equipItem();
                    currentArmor = null;
                }
            }
        }
    }

    public void use(Potion p) {
        int[] uses = p.calcUse();
        setHP(getHP() + p.getIncrease() * uses[0]);
        setMana(getMana() + p.getIncrease() * uses[1]);
        setStrength(getStrength() + p.getIncrease() * uses[2]);
        setDexterity(getDexterity() + p.getIncrease() * uses[3]);
        setAgility(getAgility() + p.getIncrease() * uses[4]);
    }

    public void attack(Monster m, Spell spell) {
        int dmg = 0;
        int newHP;
        if (spell == null) {
            for (Weapon w : getInventory().getWeapons()) {
                if (w.isArmed()) {
                    dmg = w.calcAttack(strength, m);
                    break;
                }
            }
            System.out.println("Hero" + getName() + " has dealt " + dmg + " damage to " + m.getName());
            if(m.getHP() <=dmg){
                m.setHP(0);
                m.setFaint(true);
                System.out.println("Monster "+ m.getName()+" fainted!");

            }else{
            newHP = m.getHP() - dmg;
            m.setHP(newHP);
            }
        } else {
            mana -= spell.getMana();
            dmg = spell.calcAttack(dexterity, m);
            if(m.getHP() <=dmg){
                m.setHP(0);
                System.out.println("Monster "+ m.getName()+" fainted!");
                m.setFaint(true);
            }else{
                newHP = m.getHP() - dmg;
                m.setHP(newHP);
            }
        }
    }


    public void takeDamage(int dmg) {
        int actualdmg = dmg;
        for (Armor a : getInventory().getArmors()) {
            if (a.isArmed()) {
                actualdmg -= a.getReduction();
                break;
            }
        }
        System.out.println("Monster" + getName() + " has dealt " + dmg + " damage to " + getName());
        if (getHP() <= actualdmg) {
            setHP(0);
            setFaint(true);
            System.out.println("Hero "+ getName()+" fainted!");

        } else {
            setHP(getHP() - actualdmg);
        }
    }


    public Inventory getArmedInventory() {
        return armedInventory;
    }

    public void setArmedInventory(Inventory armedInventory) {
        this.armedInventory = armedInventory;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }


    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }


    public Armor getCurrentArmor() {
        return currentArmor;
    }

    public void setCurrentArmor(Armor currentArmor) {
        this.currentArmor = currentArmor;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
