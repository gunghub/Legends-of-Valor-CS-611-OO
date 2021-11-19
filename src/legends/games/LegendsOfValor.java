package legends.games;

import legends.LovMap;
import legends.characters.heroes.Hero;
import legends.characters.monsters.Monster;
import legends.gameplay.Round;
import legends.grids.lanes.Lane;
import legends.utilities.Factory;
import legends.utilities.FileParser;
import legends.utilities.Printer;
import legends.utilities.ScannerParser;

import java.util.ArrayList;


public class LegendsOfValor extends RPGGame {
    private ArrayList<Hero> heroes;
    private ArrayList<Monster> monsters;
    private boolean play;


    public LegendsOfValor() {
        heroes = new ArrayList<Hero>();
        monsters = new ArrayList<Monster>();
        this.play = true;
    }

    public void playGame() {
        System.out.println("Welcome to Legends of Valor!");
        Factory fac = new Factory();
        LovMap grid = new LovMap(this);
        initHeroes();
        initMonsters();
        grid.display();

        Round round = new Round();
        round.playRound(heroes, monsters, play, grid, this);


    }

    //    public void playGame(){
////        System.out.println("Welcome to Legends!");
//        graphic.printBanner();
//        LOVGrid grid = new LOVGrid(8, 8);
//        LegendsPlayer p = initPlayer();
//        System.out.println("========================================================================================");
//        System.out.println(colors.addColor("blue","'P' = Your position\n" +
//                "'M' = Market. You can buy or sell items here\n" +
//                "'#' = Inaccessible space. You cannot land on this space\n" +
//                "' ' = Common space. This space might be safe or you might encounter some monsters"));
////        grid.initGrid();
//
////        while(play){
////            play = p.makeMove(grid);
////
////        }
//    }

    public void initMonsters(){
        FileParser fp = new FileParser();
        for(int i=0; i<heroes.size(); i++){
            Monster monster = fp.chooseRandMonster();
            addMonster(monster);
        }
    }

    public void initHeroes() {
        System.out.println("What type of hero is your top lane hero?");
        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
        int type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            type = ScannerParser.tryInt();
        }
        chooseHeroType(type);

        System.out.println("What type of hero is your middle lane hero?");
        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
        type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            type = ScannerParser.tryInt();
        }
        chooseHeroType(type);

        System.out.println("What type of hero is your bottom lane hero?");
        System.out.println(" 1: Paladin\n 2: Sorcerer\n 3: Warrior");
        type = ScannerParser.parseInt();
        while (type != 1 && type != 2 && type != 3) {
            type = ScannerParser.tryInt();
        }
        chooseHeroType(type);

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
                hero.setRow(0);
                hero.setCol(7);
                break;

            case 1:
                lane.setName("Mid");
                hero.setRow(3);
                hero.setCol(7);
                break;

            case 2:
                lane.setName("Bot");
                hero.setRow(6);
                hero.setCol(7);
                break;
        }
        lane.setMaxMonsterRow(0);
        hero.setInitLane(lane);
        hero.setCurrLane(lane);

    }

    public void chooseHeroType(int type){
        FileParser fp = new FileParser();
        Hero h;
        switch(type){
            case 1:
                ArrayList<Hero> paladins = fp.parsePaladins();
                h = paladins.get(ScannerParser.getRandNum(paladins.size()));
                addHero(h);
                break;

            case 2:
                ArrayList<Hero> sorcerers = fp.parseSorcerers();
                h = sorcerers.get(ScannerParser.getRandNum(sorcerers.size()));
                addHero(h);
                break;

            case 3:
                ArrayList<Hero> warriors = fp.parseWarriors();
                h = warriors.get(ScannerParser.getRandNum(warriors.size()));
                addHero(h);
                break;

        }
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
