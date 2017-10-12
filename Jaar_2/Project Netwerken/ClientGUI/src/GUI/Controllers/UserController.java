package GUI.Controllers;

import Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;

/**
 * Created by sklar on 3/16/2017.
 */
public class UserController {

    @FXML
    private Text name, ip;

    @FXML private VBox vbox;

    private User user;
    public UserController() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/UserCell.fxml"));
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setInfo(User user) {
        this.user = user;
        ip.setText(user.getIp());
        name.setText(user.getUsername());
    }

    public VBox getVbox() {
        return vbox;
    }

    public User getUser() {
        return user;
    }
}
