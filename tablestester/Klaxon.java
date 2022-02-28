package tablestester;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Klaxon implements LineListener {
	
    boolean playCompleted;

	public void playSound(String sound)  {

		
	    // open the sound file as a Java input stream
	    File audioFile = new File(sound);
        try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			
			AudioFormat format = audioStream.getFormat();

			DataLine.Info info = new DataLine.Info(Clip.class, format);

			Clip audioClip = (Clip) AudioSystem.getLine(info);

			audioClip.addLineListener(this);

			audioClip.open(audioStream);
			 
			audioClip.start();
			 
			while (!playCompleted) {
			    // wait for the playback completes
			    try {
			        Thread.sleep(1000);
			    } catch (InterruptedException ex) {
			        ex.printStackTrace();
			    }
			}
			 
			audioClip.close();
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
        
	}
	
    /**
     * Listens to the START and STOP events of the audio line.
     */
    @Override
    public void update(LineEvent event) {
        LineEvent.Type type = event.getType();
         
        if (type == LineEvent.Type.START) {
             
        } else if (type == LineEvent.Type.STOP) {
            playCompleted = true;
        }
 
    }

}
