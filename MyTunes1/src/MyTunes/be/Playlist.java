/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyTunes.be;

import java.util.ArrayList;

/**
 *
 * @author Christian Hussmann
 */
public class Playlist
{

    private int playlistID; // the playlist's unique id
    private String playlistName; // the name of the playlist

    public Playlist(int playlistID, String playlistName)
    {
        this.playlistID = playlistID;
        this.playlistName = playlistName;
    }
    
    /**
     * Gets the playlistID variable of the playlist.
     * @return the playlistID
     */
    public int getPlaylistID()
    {
        return playlistID;
    }

    /**
     * Sets the id of the playlist
     * @param playlistID 
     */
    public void setPlaylistID(int playlistID)
    {
        this.playlistID = playlistID;
    }

    /**
     * Gets the playlistName variable of the playlist
     * @return playlistName variable 
     */
    public String getPlaylistName()
    {
        return playlistName;
    }

    /**
     * Changes the playlistName to the given parameter.
     * @param playlistName 
     */
    public void setPlaylistName(String playlistName)
    {
        this.playlistName = playlistName;
    }

    /**
     * 
     * @return how many songs the current playlist contains 
     */
    public int songCount()
    {
        return -1;
    }

    /**
     * 
     * @return a more readable string of the playlist object 
     */
    @Override
    public String toString()
    {
        return "Playlist: " + playlistName;
    }

}

