package GUI.Controllers;

import Model.Channel;
import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by sklar on 3/16/2017.
 */
public class GroupController {

    @FXML
    private Text groupname,names;

    @FXML private VBox vbox;

    private Channel channel;
    public GroupController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/GroupCell.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(Channel channel) {
        this.channel = channel;
        groupname.setText(channel.getName());
        String s = "";
        for (User user: channel.getUsers()) {
            s+=user.getUsername() +", ";
        }
        names.setText(s.substring(0, s.length() - 2));
    }

    public VBox getVbox() {
        return vbox;
    }

    public Channel getChannel() {
        return channel;
    }
}
