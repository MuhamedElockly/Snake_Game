package snakeproject;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Sounds {

    public void startBackgroundSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("./src\\snakeproject\\Sounds\\Snake Game - Theme Song.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
        clip.loop(Integer.MAX_VALUE);
    }

    public void startEatSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File file = new File("./src\\snakeproject\\Sounds\\Eat Apple.wav");
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }
}
