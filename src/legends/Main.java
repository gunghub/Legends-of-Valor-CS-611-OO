package legends;

import legends.games.Game;
import legends.games.LegendsOfValor;
import legends.utilities.AudioUtility;
import legends.utilities.Colors;
import legends.utilities.FileParser;


public class Main {

    public static void main(String[] args) {

	// write your code here
        Game game = new LegendsOfValor();
        game.playGame();

    }
}
