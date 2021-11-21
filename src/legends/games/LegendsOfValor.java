package legends.games;

import legends.LovMap;
import legends.characters.heroes.Hero;
import legends.characters.heroes.Warrior;
import legends.characters.monsters.Dragon;
import legends.characters.monsters.Monster;
import legends.gameplay.Round;
import legends.grids.HeroNexus;
import legends.grids.MonsterNexus;
import legends.grids.lanes.Lane;
import legends.utilities.*;

import java.util.ArrayList;


public class LegendsOfValor extends RPGGame {
    private ArrayList<Hero> heroes;
    private ArrayList<Monster> monsters;
    private Graphic graphic;
    private boolean play;
    private Lane topLane;
    private Lane midLane;
    private Lane botLane;
    private Colors colors;
    private int numRounds;
    private ArrayList<Lane> lanes;

    public LegendsOfValor() {
        heroes = new ArrayList<Hero>();
        monsters = new ArrayList<Monster>();
        this.play = true;
        graphic = new Graphic();
        colors = new Colors();
        topLane = new Lane("Top");
        midLane = new Lane("Mid");
        botLane = new Lane("Bot");
        topLane.setLeftCol(0);
        midLane.setLeftCol(3);
        botLane.setLeftCol(6);
        numRounds = 0;
        lanes = new ArrayList<Lane>();
        lanes.add(topLane);
        lanes.add(midLane);
        lanes.add(botLane);
    }

    public void playGame() {
        graphic.printBanner();
        System.out.println(colors.addColor("cyan", "Here is the game map you are going to play:"));
        Factory fac = new Factory();
        LovMap grid = new LovMap(this);
        initHeroes(grid);
        initMonsters(grid);
        Round round = new Round();
        //-----------all good up till here
        while (play) {
            if(numRounds==8){
                System.out.println("New 3 monsters are spawned!");
                initMonsters(grid);
            }
            for (int i = 0; i < heroes.size(); i++) {
                play = round.playRound(heroes.get(i), monsters.get(i), grid, this, i);
                if(!play){
                    break;
                }

            }
            numRounds++;
        }
    }



    public void initMonsters(LovMap grid) {
        MonsterNexus monsterNexus = new MonsterNexus();
        for (int i = 0; i < heroes.size(); i++) {
            Monster monster = (Monster)monsterNexus.spawn(lanes.get(i));
            grid.getCells()[monster.getRow()][monster.getCol()].setHasMonster(true);
            addMonster(monster);
        }
    }

    public void initHeroes(LovMap grid) {
        HeroNexus heroNexus = new HeroNexus();
        for(int i=0; i<lanes.size(); i++){
            System.out.println(colors.addColor("purple", "What type of hero is your " +lanes.get(i).getName()+" lane hero?"));
            System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
            Hero hero = (Hero) heroNexus.spawn(lanes.get(i));
            grid.getCells()[hero.getRow()][hero.getCol()].setHasHero(true);
            addHero(hero);
        }
        System.out.println(colors.addColor("blue", "Please see your heroes below ----\n"));
        Printer printer = new Printer();
        printer.printHeroes(heroes);
        System.out.println(colors.addColor("cyan", "Now start your journey!"));
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

    public void addHero(Hero hero) {
        heroes.add(hero);
    }

    public void addMonster(Monster monster) {
        monsters.add(monster);
    }

    public Lane getTopLane() {
        return topLane;
    }

    public void setTopLane(Lane topLane) {
        this.topLane = topLane;
    }

    public Lane getMidLane() {
        return midLane;
    }

    public void setMidLane(Lane midLane) {
        this.midLane = midLane;
    }

    public Lane getBotLane() {
        return botLane;
    }

    public void setBotLane(Lane botLane) {
        this.botLane = botLane;
    }

    public Lane getLane(String name) {
        if (name.equals(topLane.getName())) {
            return topLane;
        } else if (name.equals(midLane.getName())) {
            return midLane;
        } else {
            return botLane;
        }
    }
}
