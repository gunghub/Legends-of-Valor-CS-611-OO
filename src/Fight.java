import java.util.ArrayList;
import java.util.Random;

public class Fight {
    private boolean isOver;
    private int numHeroes;
    private ArrayList<Hero> heroes;
    private ArrayList<Monster> monsters;
    private ArrayList<Round> rounds;

    public Fight() {
        isOver = false;
        heroes = new ArrayList<Hero>();
        monsters = new ArrayList<Monster>();
        rounds = new ArrayList<Round>();

    }

    public void battle(LegendsPlayer p) {
        System.out.println("Oops! You encounter some monsters. You have to fight now!");
        System.out.println("Entering battle .........");
        Printer.printBattleRules();
        System.out.println("How many heroes would you like to enter the fight?");
        numHeroes = ScannerParser.parseInt();
        while (numHeroes > p.getHeroes().size()) {
            System.out.println("You have less than such number of heroes. Please try again.");
            numHeroes = ScannerParser.parseInt();
        }
        FileParser fp = new FileParser();
        System.out.println("Please see your heroes below:");
        p.printPlayerHeroes();
        for (int i = 0; i < numHeroes; i++) {
            System.out.println("Choose your hero" + (i + 1) + " :");
            heroes.add(p.getHeroes().get(i));
            monsters.add(chooseRandMonster(fp));
        }
        while (!isOver) {
            Round r = new Round();
            rounds.add(r);
            r.playRound(this, rounds.indexOf(r), heroes, monsters);
            isOver = r.isOver(heroes, monsters);
        }
//        p.setHeroes(heroes);
        Round r = new Round();
        r.winOrLose(heroes, monsters);
        levelUps(heroes);
    }

    public void levelUps(ArrayList<Hero> heroes) {
        for (Hero h : heroes) {
            h.levelUp();
        }
    }


    public Monster chooseRandMonster(FileParser fp) {
        ArrayList<Monster> am = fp.parseMonsters();
        Random r = new Random();
        int n = r.nextInt(am.size());
        return am.get(n);
    }


    public void setHeroes(ArrayList<Hero> heroes) {
        this.heroes = heroes;
    }


    public void setMonsters(ArrayList<Monster> monsters) {
        this.monsters = monsters;
    }


    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }


    public ArrayList<Round> getRounds() {
        return rounds;
    }

    public void setRounds(ArrayList<Round> rounds) {
        this.rounds = rounds;
    }


}
