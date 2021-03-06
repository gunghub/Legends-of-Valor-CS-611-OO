package legends.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Graphic {

    private final StringBuilder banner;
    private final StringBuilder market;
    private final StringBuilder levelUp;
    private final StringBuilder fight;
    private final StringBuilder end;
    public static final String red = "\u001B[31m";
    public static final String green = "\u001B[32m";
    public static final String purple = "\u001B[35m";
    public static final String cyan = "\u001B[36m";

    public Graphic(){
        banner = readGraphic("./src/ConfigFiles/Banner.txt");
        banner.insert(0, purple);
        levelUp = readGraphic("./src/ConfigFiles/LevelUp.txt");
        levelUp.insert(0, cyan);
        market = readGraphic("./src/ConfigFiles/Market.txt");
        market.insert(0, green);
        fight = readGraphic("./src/ConfigFiles/Fight.txt");
        fight.insert(0, red);
        end = readGraphic("./src/ConfigFiles/End.txt");
        end.insert(0, cyan);
    }

    public StringBuilder readGraphic(String pathname) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = null;
        try {
            sc = new Scanner(new File(pathname));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            sb.append(s);
            sb.append('\n');
        }
        return sb;
    }

    public StringBuilder getBanner() {
        return banner;
    }

    public StringBuilder getLevelUp() {
        return levelUp;
    }

    public StringBuilder getMarket() {
        return market;
    }

    public StringBuilder getFight() {
        return fight;
    }

    public StringBuilder getEnd() {
        return end;
    }

    public void printBanner(){
        System.out.println(getBanner());
    }

    public void printLevelup(){
        System.out.println(getLevelUp());
    }

    public void printMarket(){
        System.out.println(getMarket());
    }

    public void printFight(){
        System.out.println(getFight());
    }

    public void printEnd(){
        System.out.println(getEnd());
    }
}