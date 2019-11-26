/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunes1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author jonas
 */
public class MyTunesController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button Last;
    @FXML
    private Button Stop;
    @FXML
    private Button Pause;
    @FXML
    private Button btnPlay;
    @FXML
    private Button Next;
    @FXML
    private TextArea SongName;
    @FXML
    private ListView<?> Playlist;
    @FXML
    private ListView<?> Favorites;
    @FXML
    private ListView<?> Search;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
    }    

    @FXML
    private void playSong(ActionEvent event) 
    {
        
    }

}
