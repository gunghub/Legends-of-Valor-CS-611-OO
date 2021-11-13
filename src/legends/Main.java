package legends;

import legends.games.Game;
import legends.games.Legends;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Hi, Player!");
        Game game = new Legends();
        game.playGame();
    }
}
