package GUI;/**
 * Created by sklar on 3/14/2017.
 */

import GUI.Controllers.MainViewController;
import GUI.Threads.INcomingthread;
import GUI.Threads.OnlineAwareness;
import Model.DataHolder;
import Model.Encryption.End2End.EncryptAndDecryptEnd2End;
import Model.User;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.SocketException;

public class Main extends Application {
    @FXML
    private TextField userNameIncorrect;

    private Scene scene;

    @FXML
    private TextField username;

    public static void main(String[] args) {
        EncryptAndDecryptEnd2End.generateKey();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Controllers/FXML/sample.fxml"));
        scene = new Scene(root, 1200, 750);

        stage.setTitle("Best chat app of the world!");
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    @FXML
    public void setUsername() {
        if (username.getText() == "" || username.getText().length() < 3 || username.getText().length()>10) {
            userNameIncorrect.setVisible(true);
        } else {
            DataHolder.getInstance().setMainUser(new User(username.getText(), "localhost"));
            DataHolder.getInstance().getMainUser().setPb(EncryptAndDecryptEnd2End.getPublicKey());
            try {
                OnlineAwareness oa = new OnlineAwareness();
                oa.start();
            } catch (SocketException e) {
                e.printStackTrace();
            }
            MainViewController mvc =new MainViewController(username.getScene().getWindow());
            try {
                INcomingthread s = new INcomingthread();
                s.addListener(mvc);
                s.start();
            } catch (SocketException e) {
                e.printStackTrace();
            }
        }
    }
}