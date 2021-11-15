//package legends.grids.cells;
//
//import legends.utilities.Colors;
//import legends.gameplay.Fight;
//import legends.players.LegendsPlayer;
//
//import java.util.Random;
//
//public class CommonSpace extends Cell {
//    private boolean hasMonster;
//
//    private final String type = "CommonSpace";
//    public CommonSpace(int row, int col){
//        super(" ", row, col);
//        colors = new Colors();
//    }
//
//    public boolean makeRandom(){
//        Random r = new Random();
//        int n = r.nextInt(2);
//        if(n == 1){
//            return false;
//        }else{
//            return true;
//        }
//    }
//
//    public void makeHasMonster(){
//        boolean hasMonster = makeRandom();
//        this.hasMonster = hasMonster;
//    }
//
//    public void land(LegendsPlayer p){
//        makeHasMonster();
//        if(hasMonster){
//            Fight f = new Fight();
//            f.battle(p);
//        }else{
//            System.out.println(colors.addColor("red","Congrats! You landed on a safe space. Please choose your next move.\n"));
//        }
//    }
//
//
//    public String getType() {
//        return type;
//    }
//
//}
