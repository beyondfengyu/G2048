package com.game.main;

import javax.sound.sampled.*;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * 用于播放音效的线程
 *
 * @author laochunyu
 * @version 1.0
 * @date 2016/9/23
 */
public class WaveThread extends Thread {
    private String filename;
    private final int EXTERNAL_BUFFER_SIZE = 524288; // 128Kb

    public WaveThread(String wavfile) {
        filename = wavfile;
    }

    public void run() {
        AudioInputStream audioInputStream = null;
        SourceDataLine auline = null;
        URL url = Thread.currentThread().getContextClassLoader().getResource(filename);
        try {
            File soundFile = new File(url.toURI());
            audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            AudioFormat format = audioInputStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
            auline.start();

            int nBytesRead = 0;
            byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
            while (nBytesRead != -1) {
                nBytesRead = audioInputStream.read(abData, 0, abData.length);
                if (nBytesRead >= 0)
                    auline.write(abData, 0, nBytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (auline != null) {
                auline.drain();
                auline.close();
            }
        }
    }
}

