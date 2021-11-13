package legends.utilities;

import java.util.Random;
import java.util.Scanner;

public class ScannerParser {

    private static Scanner sc = new Scanner(System.in);

    public ScannerParser(){

    }

    public static String parseString(){
        String s = sc.next();
        return s;
    }

    public static int parseInt(){
        int i = sc.nextInt();
        return i;
    }

    //TODO: Need to constraint the input
    public static boolean parseBoolean(){
        boolean b = false;
        String s = parseString();
        if(s.equals("Y") || s.equals("y")){
            b= true;
        }else{
            b= false;
        }
        return b;
    }

    public static int tryInt(){
        System.out.println("Input not valid! Please try again and input your option as an integer given in the list:");
        int newint = parseInt();
        return newint;
    }

    public static String tryString(){
        System.out.println("Input not valid! Please try again and input your option as an character given in the list:");
        String newString = parseString();
        return newString;
    }

    public static int getRandNum(int bound){
        Random r = new Random();
        int n = r.nextInt(bound);
        return n;
    }


}
