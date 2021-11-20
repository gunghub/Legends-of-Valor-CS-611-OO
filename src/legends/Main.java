package legends;

import legends.games.Game;
import legends.games.LegendsOfValor;
import legends.utilities.AudioUtility;
import legends.utilities.Colors;


public class Main {

    public static void main(String[] args) {

       // AudioUtility.playSound(AudioUtility.BGM_THE_GREAT_BATTLE);

	// write your code here
        Game game = new LegendsOfValor();
        game.playGame();
    }
}
