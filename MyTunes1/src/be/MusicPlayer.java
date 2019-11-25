/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 *
 * @author kaspe
 */
public class MusicPlayer
{
    
    
    /**
     * Play current song
     */
    public void Play()
    {
        String bip = "bip.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.play();   
        
        
    }
    
    /*
    *Pauses current song
    */
    public void Pause()
    {
        
    }
    
    
    /**
     * Skip current song
     */       
    public void NextSong()
    {
        
    }        
    /**
     * Plays previous song
     */
    public void PreviousSong()
    {
        
    }


}
