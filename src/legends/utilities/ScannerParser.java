package legends.utilities;

import java.util.Random;
import java.util.Scanner;

public class ScannerParser {

    private static Scanner sc = new Scanner(System.in);

    public ScannerParser(){

    }

    public static String parseString(){
        String s;
        while(true){
            try {
                sc = new Scanner(System.in);
                s = sc.next();
                break;
            }catch (Exception e){
                System.out.println("Please choose the given option to make your choice: ");
            }
        }
        return s;
    }

    public static int parseInt(){
        int i;
        while(true){
            try {
                sc = new Scanner(System.in);
                i = sc.nextInt();
                break;
            }catch (Exception e){
                System.out.println("Input not valid! Please try again and input your option as an integer given in the list:");
            }
        }
        return i;
    }

    //TODO: Need to constraint the input
    public static boolean parseBoolean(){
        boolean b = false;
        String s = parseString();
        while (true){
        if(s.equals("Y") || s.equals("y")){
            b= true;
            break;
        }
        else if (s.equals("N") || s.equals("n")){
            b= false;
            break;
        }
        else {
            System.out.println("Please input Y/y or N/n to make your choice: ");
            s = parseString();
        }}
        return b;
    }

//    public static int tryInt(){
//        System.out.println("Input not valid! Please try again and input your option as an integer given in the list:");
//        int newint = parseInt();
//        return newint;
//    }

    public static String tryString(){
        String newString;
        while(true){
            try {
                newString = parseString();
                break;
            }catch (Exception e){
                System.out.println("Input not valid! Please try again and input your option as an character given in the list:");
            }
        }
        return newString;
    }

    public static int getRandNum(int bound){
        Random r = new Random();
        int n = r.nextInt(bound);
        return n;
    }


}
