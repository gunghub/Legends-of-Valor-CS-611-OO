package legends.games;

import legends.characters.heroes.Hero;
import legends.characters.heroes.Warrior;
import legends.characters.monsters.Dragon;
import legends.characters.monsters.Monster;

import java.util.ArrayList;
import java.util.List;


public class LegendsOfValor extends RPGGame {
    public void playGame(){
        //TODO
    }

    public List<Hero> getHeroes(){

        //todo

        List<Hero> heroes =new ArrayList<>();
        heroes.add(new Warrior("sdf",1,1,1,1,1,1,1,1));
        Hero hero=new Warrior("sdf",1,1,1,1,1,1,1,1);
        hero.setRow(3);
        hero.setCol(3);
        heroes.add(hero);

        return heroes;
    }
    public List<Monster> getMonsters(){

        //todo
        List<Monster> monsters =new ArrayList<>();
        monsters.add(new Dragon("sdf",1,1,1,1,1));
        return monsters;
    }
}
