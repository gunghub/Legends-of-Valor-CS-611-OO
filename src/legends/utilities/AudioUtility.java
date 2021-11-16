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
 *
 */
public class AudioUtility {
    private static final String WORKING_DIRECTORY=System.getProperty("user.dir");
    private static final String PATH_TO_AUDIOS=WORKING_DIRECTORY+"/audios/";

    private static final String AUDIO_FILE ="mixkit-martial-arts-fast-punch-2047.wav";


    public static void sound() {
        try {
            //System.out.println(PATH_TO_AUDIOS+AUDIO_FILE);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(PATH_TO_AUDIOS+AUDIO_FILE));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public static void main(String[] args) {
        AudioUtility.sound();
    }

}
