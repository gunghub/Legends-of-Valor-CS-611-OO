package legends.games;

import legends.characters.heroes.Hero;
import legends.characters.heroes.Warrior;
import legends.characters.monsters.Dragon;
import legends.characters.monsters.Monster;

import java.util.ArrayList;
import java.util.List;


public class LegendsOfValor extends RPGGame {
    private ArrayList<Hero> heroes;
    private ArrayList<Monster> monsters;
    public void playGame(){
        //TODO
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }
}
