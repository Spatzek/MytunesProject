/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTunes.be;
import javazoom.jl.player.Player;
import java.io.FileInputStream;
import java.io.InputStream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.AudioDevice;


/**
 *
 * @author kasper, Nicklas, Christian Og Jonas
 */
public class MusicPlayer
{
    public final static int NOTSTARTED = 0;
    public final static int PLAYING = 1;
    public final static int PAUSED = 2;
    public final static int FINISHED = 3;

    // the player actually doing all the work
    public Player player;

    // locking object used to communicate with player thread
    public Object playerLock = new Object();

    // status variable what player thread is doing/supposed to do
    public int playerStatus = NOTSTARTED;

    
    public MusicPlayer(InputStream inputStream) throws JavaLayerException 
    {
        this.player = new Player(inputStream);
    }

    public MusicPlayer(InputStream inputStream, AudioDevice audioDevice) throws JavaLayerException 
    {
        this.player = new Player(inputStream, audioDevice);
    }

    
    /**
     * Play current song
     */
    public void play() throws JavaLayerException 
    {
        synchronized (playerLock) 
        {
            switch (playerStatus) 
            {
                case NOTSTARTED:
                    Runnable r = new Runnable() 
                    {
                        public void run() 
                        {
                            playInternal();
                        }
                    };
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    t.setPriority(Thread.MAX_PRIORITY);
                    playerStatus = PLAYING;
                    t.start();
                    break;
                case PAUSED:
                    resume();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * Pauses playback. Returns true if new state is PAUSED.
     */
    public boolean pause() 
    {
        synchronized (playerLock) 
        {
            if (playerStatus == PLAYING) 
            {
                playerStatus = PAUSED;
            }
            return playerStatus == PAUSED;
        }
    }

    /**
     * Resumes playback. Returns true if the new state is PLAYING.
     */
    public boolean resume() 
    {
        synchronized (playerLock) 
        {
            if (playerStatus == PAUSED) 
            {
                playerStatus = PLAYING;
                playerLock.notifyAll();
            }
            return playerStatus == PLAYING;
        }
    }

    /**
     * Stops playback. If not playing, does nothing
     */
    public void stop() 
    {
        synchronized (playerLock) 
        {
            playerStatus = FINISHED;
            playerLock.notifyAll();
        }
    }

    private void playInternal() 
    {
        while (playerStatus != FINISHED) 
        {
            try 
            {
                if (!player.play(1)) {
                    break;
                }
            } 
            catch (final JavaLayerException e) 
            {
                break;
            }
            // check if paused or terminated
            synchronized (playerLock) 
            {
                while (playerStatus == PAUSED) 
                {
                    try 
                    {
                        playerLock.wait();
                    }
                    catch (final InterruptedException e) 
                    {
                        // terminate player
                        break;
                    }
                }
            }
        }
        close();
    }

    /**
     * Closes the player, regardless of current state.
     */
    public void close() 
    {
        synchronized (playerLock) 
        {
            playerStatus = FINISHED;
        }
        try {
            player.close();
        } catch (final Exception e) 
        
    
}
}
}
