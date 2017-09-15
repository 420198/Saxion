package GUI.Controllers;

import Model.DataHolder;
import Model.Message;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;

/**
 * Created by sklar on 3/15/2017.
 */
public class ChatController {
    @FXML
    private VBox vbox;
    @FXML
    private TextFlow label1;

    @FXML
    private TextField messagename;

    /**
     * Constructor
     */
    public ChatController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/ChatCell.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Set all the data for the chat
     */
    public void setInfo(Message message) {
        Text text = new Text(message.getBody());
        label1.getChildren().add(text);
        if (DataHolder.getInstance().getMainUser().getUsername().equals(message.getSender())) {
            vbox.getChildren().remove(messagename);
        } else {
            messagename.setText(message.getSender());
            messagename.setStyle("-fx-background-color:white;-fx-background-insets: 0;-fx-border-radius: 0;");
            label1.setStyle("-fx-background-color: white;");
            vbox.setStyle("-fx-border-color: white; -fx-border-radius: 5; -fx-border-width: 5;-fx-border-style: solid inside;");
        }
    }

    /**
     * gettter
     * @return the container
     */
    public VBox getBox() {
        return vbox;
    }

}
