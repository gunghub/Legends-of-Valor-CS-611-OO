package legends.utilities;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

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

    private static final String AUDIO_FILE_NAME ="mixkit-martial-arts-fast-punch-2047.wav";

    /**
     * Test entry for this utility
     * @param args
     */
    public static void main(String[] args) {
        AudioUtility.playSoundOnce(AUDIO_FILE_NAME);
    }

    

    /**
     * @param audioFileName Name of the audio file e.g. "mixkit-martial-arts-fast-punch-2047.wav"
     */
    public synchronized static void playSoundOnce(String audioFileName) {
        try {
            //System.out.println(PATH_TO_AUDIOS_FROM_WORKING_DIRECTORY+AUDIO_FILE_NAME);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_TO_AUDIOS_FROM_WORKING_DIRECTORY + audioFileName));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // If you want the playSoundOnce to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the playSoundOnce, then use clip.stop();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
