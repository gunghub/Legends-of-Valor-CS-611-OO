package legends.utilities;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.util.Scanner;

/**
 * @author
 *
 * A utility for audios and sounds
 *
 * reference: https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java
 *
 */
public class AudioUtility {
    private static final String WORKING_DIRECTORY=System.getProperty("user.dir");
    private static final String PATH_TO_AUDIOS_FROM_WORKING_DIRECTORY =WORKING_DIRECTORY+"/audios/";



    public static final String DRAGON_ROAR ="dragon_roar.wav";
    public static final String GAME_AWARD="F5YUGD6-game-award.wav";

    /**
     * Background music
     */
    public static final String BGM_THE_GREAT_BATTLE="alexander-nakarada-the-great-battle.wav";


    /**
     * Demo entry for this utility
     *
     * @param args
     */
    public static void main(String[] args) {
        AudioUtility.playSound(DRAGON_ROAR); // DEMO play the dragon roar once.
        //AudioUtility.playSound(GAME_AWARD);
        AudioUtility.playSound(BGM_THE_GREAT_BATTLE,true); //DEMO play the bgm repeatedly.




        Scanner scanner=new Scanner(System.in);
        if(scanner.hasNext()){
            scanner.next();
        };
    }

    /**
     * @param audioFileName Name of the audio file e.g. "dragon_roar.wav".
     * @param loop if you want to loop infinitely, set loop as true, otherwise false.
     *
     */
    public synchronized static void playSound(String audioFileName, boolean loop ) {
        Thread thread=new Thread(new Runnable() {
            public void run() {
                try
                {

                    AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_TO_AUDIOS_FROM_WORKING_DIRECTORY + audioFileName));
                    Clip clip = AudioSystem.getClip();
                    clip.open(audioInputStream);
                    if(loop) clip.loop(Clip.LOOP_CONTINUOUSLY);
                    clip.start();

                    // If you want the playSound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
                    // If you want to stop the playSoundOnce, then use clip.stop();

                } catch (
                        Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        thread.start();

    }

    public static void playSound(String audioFileName){
        playSound(audioFileName, false);
    }

}
