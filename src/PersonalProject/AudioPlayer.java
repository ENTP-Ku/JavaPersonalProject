package PersonalProject;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AudioPlayer {
    private Clip clip;

    public void play(String filePath) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            clip.loop(Clip.LOOP_CONTINUOUSLY); // 음악을 반복 재생
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    
    public void playOnce(String fileName) {
        try {
            InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);
            if (inputStream == null) {
                System.err.println("File not found: " + fileName);
                return;
            }

            AudioInputStream audioStream = AudioSystem.getAudioInputStream(inputStream);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start(); // 소리 재생 시작
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }
}
