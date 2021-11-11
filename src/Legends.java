import java.util.ArrayList;

/**
 * Legends class. Runs the game.
 */
public class Legends extends RPGGame{

    private boolean play;
    public Legends(){
        play = true;
    }

    @Override
    public void playGame(){
        System.out.println("Welcome to Legends!");
        LegendsGrid grid = new LegendsGrid();
        LegendsPlayer p = initPlayer();
        System.out.println("========================================================================================");
        System.out.println("'P' = Your position\n" +
                "'M' = Market. You can buy or sell items here\n" +
                "'#' = Inaccessible space. You cannot land on this space\n" +
                "' ' = Common space. This space might be safe or you might encounter some monsters");
        grid.initGrid();

        while(play){
//            grid.printGrid(p);
            //p.makeMove(grid);
            play = p.makeMove(grid);

        }
    }


    public LegendsPlayer initPlayer(){
        System.out.println("Please enter your name -- ");
        String name = ScannerParser.parseString();
        LegendsPlayer p = new LegendsPlayer(name, "P");
        System.out.println("How many heroes would you like to add to your team? (between 1 and 3)");
        int numHeroes = ScannerParser.parseInt();
        while(numHeroes>3 || numHeroes<1){
            numHeroes = ScannerParser.tryInt();
        }
        for(int i=0; i<numHeroes; i++){
            System.out.println("What type of hero is your hero "+(i+1)+" ?");
            System.out.println("0: Paladin\n1: Sorcerer\n2: Warrior");
            int type = ScannerParser.parseInt();
            while(type !=0 &&type !=1&&type !=2){
                type = ScannerParser.tryInt();
            }
            chooseHeroType(type, p);
        }

        System.out.println(numHeroes+" Heroes are added to your team.");
        Printer printer = new Printer();
        printer.printHeroes(p.getHeroes());
        System.out.println("Now start our journey!");
        return p;
    }

    public void chooseHeroType(int type, LegendsPlayer p){
        FileParser fp = new FileParser();
        Hero h;
        switch(type){
            case 0:
                ArrayList<Hero> paladins = fp.parsePaladins();
                h = paladins.get(ScannerParser.getRandNum(paladins.size()));
                p.addHero(h);
                break;

            case 1:
                ArrayList<Hero> sorcerers = fp.parseSorcerers();
                h = sorcerers.get(ScannerParser.getRandNum(sorcerers.size()));
                p.addHero(h);
                break;

            case 2:
                ArrayList<Hero> warriors = fp.parseWarriors();
                h = warriors.get(ScannerParser.getRandNum(warriors.size()));
                p.addHero(h);
                break;

        }
    }

}
