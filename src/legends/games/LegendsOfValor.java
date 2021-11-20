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


    public LegendsOfValor() {
        heroes = new ArrayList<Hero>();
        monsters = new ArrayList<Monster>();
        this.play = true;
        graphic = new Graphic();
        topLane = new Lane("Top");
        midLane = new Lane("Mid");
        botLane = new Lane("Bot");
    }

    public void playGame() {
        graphic.printBanner();
        System.out.println("Here is the game map you are going to play:");
        Factory fac = new Factory();
        LovMap grid = new LovMap( this);
        initHeroes();
        initMonsters();
        Round round = new Round();
        round.playRound(heroes, monsters, play, grid, this);


    }

    public void initMonsters(){
        FileParser fp = new FileParser();
        for(int i=0; i<heroes.size(); i++){
            Monster monster = fp.chooseRandMonster();
            monster.setPosition(0,i*3+1);
            addMonster(monster);
        }
//        MonsterNexus monsterNexus = new MonsterNexus();
//        for(int i=0; i<heroes.size(); i++){
//            monsterNexus.spawn(this);
//            addMonster(monster);
//        }
    }

    public void initHeroes() {
        System.out.println("What type of hero is your top lane hero?");
        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
        int type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            type = ScannerParser.tryInt();
        }
        Hero hero = chooseHeroType(type);
        hero.setInitLane(topLane);
        addHero(hero);

        System.out.println("What type of hero is your middle lane hero?");
        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
        type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            type = ScannerParser.tryInt();
        }
        hero = chooseHeroType(type);
        hero.setInitLane(midLane);
        addHero(hero);

        System.out.println("What type of hero is your bottom lane hero?");
        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
        type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            type = ScannerParser.tryInt();
        }
        hero = chooseHeroType(type);
        hero.setInitLane(botLane);
        addHero(hero);

        for(int i=0; i<heroes.size(); i++){
            initNewHero(heroes.get(i), i);
        }
        System.out.println("Please see your heroes below ----\n");
        Printer printer = new Printer();
        printer.printHeroes(heroes);
        System.out.println("Now start your journey!");
    }

    public void initNewHero(Hero hero, int index){
        Lane lane = new Lane(null);
        switch(index){
            case 0:
                lane.setName("Top");
                hero.setRow(7);
                hero.setCol(0);
                break;

            case 1:
                lane.setName("Mid");
                hero.setRow(7);
                hero.setCol(3);
                break;

            case 2:
                lane.setName("Bot");
                hero.setRow(7);
                hero.setCol(6);
                break;
        }
        lane.setMaxMonsterRow(0);
        hero.setInitLane(lane);
        hero.setCurrLane(lane);

    }


    public Hero chooseHeroType(int type){
        FileParser fp = new FileParser();
        Hero h = null;
        switch(type){
            case 1:
                ArrayList<Hero> paladins = fp.parsePaladins();
                h = paladins.get(ScannerParser.getRandNum(paladins.size()));
//                addHero(h);
                break;

            case 2:
                ArrayList<Hero> sorcerers = fp.parseSorcerers();
                h = sorcerers.get(ScannerParser.getRandNum(sorcerers.size()));
//                addHero(h);
                break;

            case 3:
                ArrayList<Hero> warriors = fp.parseWarriors();
                h = warriors.get(ScannerParser.getRandNum(warriors.size()));
//                addHero(h);
                break;

        }
        return h;
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

    public void addHero(Hero hero){
        heroes.add(hero);
    }

    public void addMonster(Monster monster){
        monsters.add(monster);
    }
}
