package legends.utilities;


import legends.Main;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioUtility {
    private static final String WORKING_DIRECTORY=System.getProperty("user.dir");
    private static final String PATH_TO_AUDIOS=WORKING_DIRECTORY+"/audios/";

    private static final String FILE ="mixkit-martial-arts-fast-punch-2047.wav";


    public static synchronized void playSound() {
        new Thread(new Runnable() {
            // The wrapper thread is unnecessary, unless it blocks on the
            // Clip finishing; see comments.
            public void run() {
                try {
                    Clip clip = AudioSystem.getClip();
                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                            Main.class.getResourceAsStream(PATH_TO_AUDIOS+FILE));
                    clip.open(inputStream);
                    clip.start();
                } catch (Exception e) {
                    System.out.println(PATH_TO_AUDIOS+FILE);
                    System.err.println(e.getMessage());
                }
            }
        }).start();
    }


    public static void main(String[] args) {
        AudioUtility.playSound();
    }

}
