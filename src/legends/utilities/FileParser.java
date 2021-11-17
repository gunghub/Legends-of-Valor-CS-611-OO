package legends.utilities;

import legends.characters.heroes.Hero;
import legends.characters.heroes.Paladin;
import legends.characters.heroes.Sorcerer;
import legends.characters.heroes.Warrior;
import legends.items.Armor;
import legends.items.Potion;
import legends.items.Weapon;
import legends.characters.monsters.Dragon;
import legends.characters.monsters.Exoskeleton;
import legends.characters.monsters.Monster;
import legends.items.spells.FireSpell;
import legends.items.spells.Spell;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class FileParser {

    public FileParser(){
    }

    public ArrayList<String[]> readFile(String fileName) {
        String absPath = new File("").getAbsolutePath();
        File f = new File(absPath+fileName);
        ArrayList<String[]> file = new ArrayList<String[]>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line = br.readLine();
            line = br.readLine();
            while(line!= null){
                String[] s = line.split("\\s+");
                file.add(s);
                line = br.readLine();
            }
        }catch (IOException e){
            System.out.println(e);
        }
        return file;
    }

    public int parseint(String s){
        return Integer.parseInt(s);
    }

    /**
     * choose a random monster who has the input level from all monsters
     * @param level
     * @return
     */
    public Monster chooseRandMonster(int level) {
        ArrayList<Monster> am = parseMonsters();
        Random r = new Random();
        int n = r.nextInt(am.size());
        return am.get(n);
    }


    public ArrayList<Armor> parseArmor(){
        ArrayList<Armor> armors = new ArrayList<Armor>();
        ArrayList<String[]> file = readFile("/inputs/Armory.txt");
        for(String[] string: file){
            Armor a = new Armor(string[0], parseint(string[1]), parseint(string[2]), Integer.parseInt(string[3]));
            armors.add(a);
        }
        return armors;
    }

    public ArrayList<Spell> parseSpells(){
        ArrayList<Spell> spells = new ArrayList<Spell>();
        ArrayList<String[]> file = readFile("/inputs/FireSpells.txt");
        for(String[] string: file){
            Spell s = new FireSpell(string[0], parseint(string[1]),
                    parseint(string[2]),parseint(string[4]),parseint(string[3]));
            spells.add(s);
        }
        file = readFile("/inputs/IceSpells.txt");
        for(String[] string: file){
            Spell s = new FireSpell(string[0], parseint(string[1]),
                    parseint(string[2]),parseint(string[4]),parseint(string[3]));
            spells.add(s);
        }
        file = readFile("/inputs/LightningSpells.txt");
        for(String[] string: file){
            Spell s = new FireSpell(string[0], parseint(string[1]),
                    parseint(string[2]),parseint(string[4]),parseint(string[3]));
            spells.add(s);
        }
        return spells;
    }

    public HashMap<Potion, Integer> parsePotions(){
        HashMap<Potion, Integer> potions = new HashMap<Potion,Integer>();
        ArrayList<String[]> file = readFile("/inputs/Potions.txt");
        for(String[] string: file){
            Potion p = new Potion(string[0], parseint(string[1]),
                    parseint(string[2]),parseint(string[3]),string[4]);
            potions.put(p,0);
        }
        return potions;
    }

    public ArrayList<Weapon> parseWeapons(){
        ArrayList<Weapon> weapons = new ArrayList<Weapon>();
        ArrayList<String[]> file = readFile("/inputs/Weaponry.txt");
        for(String[] string: file){
            Weapon w = new Weapon(string[0], parseint(string[1]),
                    parseint(string[2]),parseint(string[3]));
            weapons.add(w);
        }
        return weapons;
    }

    public ArrayList<Monster> parseMonsters(){
        ArrayList<Monster> monsters = new ArrayList<Monster>();
        ArrayList<String[]> file = readFile("/inputs/Dragons.txt");
        for(String[] string: file){
            Monster m = new Dragon(string[0], parseint(string[1]),
                    parseint(string[1])*100,parseint(string[3]),
                    parseint(string[2]),parseint(string[4]));
            monsters.add(m);
        }
        file = readFile("/inputs/Exoskeletons.txt");
        for(String[] string: file){
            Monster m = new Exoskeleton(string[0], parseint(string[1]),
                    parseint(string[1])*100,parseint(string[3]),
                    parseint(string[2]),parseint(string[4]));
            monsters.add(m);
        }
        file = readFile("/inputs/Spirits.txt");
        for(String[] string: file){
            Monster m = new Exoskeleton(string[0], parseint(string[1]),
                    parseint(string[1])*100,parseint(string[3]),
                    parseint(string[2]),parseint(string[4]));
            monsters.add(m);
        }
        return monsters;
    }


    public ArrayList<Hero> parsePaladins(){
        ArrayList<Hero> paladins = new ArrayList<Hero>();
        ArrayList<String[]> file = readFile("/inputs/Paladins.txt");
        for(String[] string: file){
            Hero h = new Paladin(string[0], 1,
                    100, parseint(string[1]),
                    parseint(string[2]),parseint(string[3]),parseint(string[4]),
                    parseint(string[5]), parseint(string[6]), null);
            paladins.add(h);
//            for(String s: string) {
//                System.out.printf(s+" ");
//            }
        }
        return paladins;
    }

    public ArrayList<Hero> parseSorcerers(){
        ArrayList<Hero> sorcerers = new ArrayList<Hero>();
        ArrayList<String[]> file = readFile("/inputs/Sorcerers.txt");
        for(String[] string: file){
            Hero h = new Sorcerer(string[0], 1,
                    100, parseint(string[1]),
                    parseint(string[2]),parseint(string[3]),parseint(string[4]),
                    parseint(string[5]), parseint(string[6]), null);
            sorcerers.add(h);
        }
        return sorcerers;
    }

    public ArrayList<Hero> parseWarriors(){
        ArrayList<Hero> warriors = new ArrayList<Hero>();
        ArrayList<String[]> file = readFile("/inputs/Warriors.txt");
        for(String[] string: file){
            Hero h = new Warrior(string[0], 1,
                    100, parseint(string[1]),
                    parseint(string[2]),parseint(string[3]),parseint(string[4]),
                    parseint(string[5]), parseint(string[6]), null);
//            Hero h = new Warrior("A",1,2,3,4,5,6,7,8);

            warriors.add(h);
//                        for(String s: string) {
//                System.out.printf(s+" ");
//            }
        }
        return warriors;
    }



}
