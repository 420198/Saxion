package GUI.Controllers;

import GUI.CellViews.ChatViewCell;
import GUI.CellViews.GroupViewCell;
import GUI.CellViews.UserViewCell;
import Model.*;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.IOException;
import java.net.*;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by sklar on 3/15/2017.
 */
public class MainViewController implements Initializable, MessageHandleI {
    @FXML
    private TextField userNameToSendTo, username, message, groupname, usernameToAdd, ipFromUser;
    @FXML
    private Button sendMessageButton, friendsButton, onlineButton, addgroup;
    @FXML
    private ListView<Message> chatList;
    @FXML
    private Pane infopane, channelpane, addgrouppane, adduserpane, addnodepane;
    @FXML
    private ListView<User> friendsList, onlineList, listToAddToGroup, newUsersList;
    @FXML
    private ListView<Channel> grouplist;


    private ObservableList<Message> chatMessages = FXCollections.observableArrayList();//create observablelist for listview
    private ObservableList<User> friendsUsers = FXCollections.observableArrayList(),
            onlineUsers = FXCollections.observableArrayList(),
            usersToAddToGroup = FXCollections.observableArrayList(),
            newUsersObsl = FXCollections.observableArrayList();//create observablelist for listview

    private ObservableList<Channel> groups = FXCollections.observableArrayList();//create observablelist for listview

    private DataHolder holder = DataHolder.getInstance();

    private Channel textChannel;

    private UserViewCell prevuvc;
    private GroupViewCell prevgvc;

    public MainViewController(Window window) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXML/mainview.fxml"));
        fxmlLoader.setController(this);
        try {
            Parent parent = fxmlLoader.load();
            Scene scene = new Scene(parent, 1200, 750);
            ((Stage) window).setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        onlineList.setVisible(false);

        for (int i = 0; i < holder.getGroups().size(); i++) {
            groups.add(holder.getGroups().get(i));
        }
        grouplist.setItems(groups);
        grouplist.setCellFactory(new Callback<ListView<Channel>, ListCell<Channel>>() {
            @Override
            public ListCell<Channel> call(ListView<Channel> param) {
                GroupViewCell gvc = new GroupViewCell();
                gvc.setOnMouseClicked(event -> {
                    textChannel = holder.getGroupByName(gvc.getGroupController().getChannel().getName());
                    chatMessages.setAll(textChannel.getMessages());
                    if (!channelpane.isVisible()) {
                        channelpane.setVisible(true);
                        infopane.setVisible(false);
                    }
                    if (addgrouppane.isVisible()) {
                        removeGroupPane();
                    }
                    if (adduserpane.isVisible()) {
                        removeUserPane();
                    }
                    if (addnodepane.isVisible()) {
                        removeNodePane();
                    }
                    if (prevgvc == null) {
                        prevgvc = gvc;
                    }
                    setUsername();
                    prevgvc.setStyle("-fx-background-color: transparent;");
                    prevuvc.setStyle("-fx-background-color: transparent;");
                    gvc.setStyle("-fx-background-color:#2c3548; ");
                    prevgvc = gvc;
                });
                return gvc;
            }
        });
        chatList.setItems(chatMessages);//attach the observablelist to the listview
        chatList.setCellFactory(listView -> new ChatViewCell());

        chatMessages.addListener((ListChangeListener<Message>) c -> Platform.runLater(() -> chatList.scrollTo(chatList.getItems().size() - 1)));
        onlineUsers.setAll(holder.getUsers());
        onlineList.setItems(onlineUsers);
        onlineList.setCellFactory(listView -> {
            UserViewCell uvc = new UserViewCell();
            uvc.setOnMouseClicked(event -> {
                if (holder.getChannelByname(uvc.getUserController().getUser().getUsername()) == null) {
                    ArrayList<User> users = new ArrayList<>();
                    users.add(uvc.getUserController().getUser());
                    Channel channel = new Channel(users);
                    holder.addChannelMultipleUsers(channel);
                }
                textChannel = holder.getChannelByname(uvc.getUserController().getUser().getUsername());
                chatMessages.setAll(textChannel.getMessages());
                if (!channelpane.isVisible()) {
                    channelpane.setVisible(true);
                    infopane.setVisible(false);
                }
                if (addgrouppane.isVisible() && addgrouppane.getOpacity() == 1) {
                    removeGroupPane();
                }
                if (adduserpane.isVisible() && addgrouppane.getOpacity() == 1) {
                    removeUserPane();
                }
                if (addnodepane.isVisible() && addgrouppane.getOpacity() == 1) {
                    removeNodePane();
                }
                if (prevuvc == null) {
                    prevuvc = uvc;
                }
                setUsername();
                if (prevgvc != null) {
                    prevgvc.setStyle("-fx-background-color: transparent;");
                }
                prevuvc.setStyle("-fx-background-color: transparent;");
                uvc.setStyle("-fx-background-color:#2c3548; ");
                prevuvc = uvc;
            });
            return uvc;
        });
        newUsersObsl.addListener(new ListChangeListener<User>() {
            @Override
            public void onChanged(Change<? extends User> c) {
                newUsersList.scrollTo(newUsersList.getItems().size() - 1);
            }
        });
        newUsersList.setItems(newUsersObsl);
        newUsersList.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> param) {
                UserViewCell uvc = new UserViewCell();
                return uvc;
            }
        });

        usersToAddToGroup.setAll(holder.getUsers());
        listToAddToGroup.setItems(usersToAddToGroup);
        listToAddToGroup.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public ListCell<User> call(ListView<User> param) {
                UserViewCell uvc = new UserViewCell();

                uvc.setOnMouseClicked(event -> {
                    for (User user : newUsersList.getItems()) {
                        if (user.getUsername().equals(uvc.getItem().getUsername())) {
                            return;
                        }
                    }
                    newUsersObsl.add(uvc.getItem());
                });
                return uvc;
            }
        });

        friendsList.setItems(friendsUsers);
        friendsList.setCellFactory(new Callback<ListView<User>, ListCell<User>>() {
            @Override
            public UserViewCell call(ListView<User> listView) {
                UserViewCell uvc = new UserViewCell();
                uvc.setOnMouseClicked(event -> {

                });
                return uvc;
            }
        });
        System.out.println(holder.getMainUser().getPb());
    }

    @FXML
    public void sendMessage() throws IOException {
        Message messageToSend = new Message(holder.getMainUser().getUsername(), message.getText());
        textChannel.addMessage(messageToSend);
        chatMessages.add(messageToSend);
        DatagramSocket socket = new DatagramSocket();
        for (User u : textChannel.getUsers()) {
            String m = "";
            if (textChannel.getUsers().size() > 1) {
                m = "\"sender\":\"" + u.getUsername() + "\"," +
                        "\"groupname\":\"" + textChannel.getName() + "\"," +
                        "\"members\":\"" + groupMessage() + "\"," +
                        "\"body\":\"" + message.getText() + "\"," +
                        "\"message\":\"true\"";
            }
            //TODO:: END 2 END ENCRYPT

            String ipu = u.getIp();
            int l = 16 - ipu.length();
            for (int i = 0; i < l; i++) {
                ipu += " ";
            }
            Pair<String, String> nodeMessage = holder.nodeEncryption(new StringBuilder(ipu + m));

            InetAddress ip = InetAddress.getByName("localhost");

            String message2 = m;
            System.out.println(message2);
            byte[] buf = message2.getBytes();
            DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 27015);
            socket.send(packet);
        }
        socket.close();

        message.setText("");
    }

    @FXML
    public void createGroup() {
        if (!groupname.getText().isEmpty()) {
            ArrayList<User> users = new ArrayList<>(newUsersObsl);
            Channel channel = new Channel(users, groupname.getText());
            holder.addGroup(channel);
            groups.add(channel);
            newUsersObsl.clear();
            newUsersList.refresh();
            groupname.setText("");
            removeGroupPane();
        }
    }

    @FXML
    public void addUser() {
        if (usernameToAdd.getText().length() > 3 && usernameToAdd.getText().length() < 10 && holder.validIp(ipFromUser.getText())) {
            User user = new User(usernameToAdd.getText(), ipFromUser.getText());
            if (holder.addUser(user)) {
                try {
                    DatagramSocket socket = new DatagramSocket();
                    String key = "\"sender\":\"" + holder.getMainUser().getUsername() + "\"," +
                            "\"ip\":\"" + holder.getMainUser().getIp() + "\"," +
                            "\"mykey\":\"" + holder.getMainUser().getPublicKeyString() + "\"," +
                            "\"keyclient\":\" true\"";
                    String ipu = user.getIp();
                    int l = ipu.length();
                    for (int i = 0; i < l; i++) {
                        ipu += " ";
                    }
                    Pair<String, String> nodeMessage = holder.nodeEncryption(new StringBuilder(ipu + key));

                    InetAddress ip = InetAddress.getByName("localhost");

                    String message2 = nodeMessage.getValue();
                    System.out.println(message2);
                    byte[] buf = message2.getBytes();
                    DatagramPacket packet = new DatagramPacket(buf, buf.length, ip, 27015);
                    socket.send(packet);
                } catch (GeneralSecurityException e) {
                    e.printStackTrace();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                } catch (SocketException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                //TODO:: User exists, show a message?, probably
            }
        } else {
            System.out.println("fail bitch");
        }

    }

    @FXML
    public void onEnter(ActionEvent ae) throws IOException {
        sendMessage();
    }

    @FXML
    public void friendsVisible() {
        if (!friendsList.isVisible()) {
            friendsList.setVisible(true);
            onlineButton.setStyle("-fx-background-color:  #596f8b;");
            friendsButton.setStyle("-fx-background-color:   #353e53;");
            onlineList.setVisible(false);
        }
    }

    @FXML
    public void onlineVisible() {
        if (!onlineList.isVisible()) {
            onlineList.setVisible(true);
            friendsButton.setStyle("-fx-background-color:  #596f8b;");
            onlineButton.setStyle("-fx-background-color:   #353e53;");
            friendsList.setVisible(false);
        }
    }

    @FXML
    public void openAddGroupPane() {
        addPane(addgrouppane);
    }

    @FXML
    public void openAddUserPane() {
        addPane(adduserpane);
    }

    public void openAddNodePane() {
        addPane(addnodepane);
    }

    public void removeGroupPane() {
        removePane(addgrouppane);
    }

    public void removeUserPane() {
        removePane(adduserpane);
    }

    public void removeNodePane() {
        removePane(addnodepane);
    }


    private void addPane(Pane pane) {

        pane.setVisible(true);
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), pane);
        translateTransition.setFromX(1201);
        translateTransition.setFromY(750);
        translateTransition.setByX(664);
        translateTransition.setToX(0);
        translateTransition.setToY(0);

        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);

        fadeTransition.play();
        translateTransition.play();
    }

    public void removePane(Pane pane) {
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), pane);
        TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(1), pane);
        translateTransition.setFromX(0);
        translateTransition.setFromY(0);
        translateTransition.setToX(1201);
        translateTransition.setToY(750);

        fadeTransition.setFromValue(1);
        fadeTransition.setToValue(0);

        fadeTransition.play();
        translateTransition.play();
        fadeTransition.setOnFinished(event -> {
            pane.setVisible(false);
        });
    }

    private void setUsername() {
        if (textChannel.getUsers().size() == 1) {
            userNameToSendTo.setText(textChannel.getName());
        } else {
            StringBuilder builder = new StringBuilder();
            for (User user : textChannel.getUsers()) {
                builder.append(user.getUsername() + ", ");
            }
            String channelname = builder.toString();
            userNameToSendTo.setText(channelname.substring(0, channelname.length() - 2));
        }
    }

    private String onePersonMessage() {
        return message.getText();
    }

    private String groupMessage() {
        StringBuilder builder = new StringBuilder();
        for (User u : textChannel.getUsers()) {
            builder.append(u.getUsername() + "," + u.getIp() + ";");
        }
        return builder.toString();
    }

    @Override
    public void handleGroupMessage(String m) {
        String[] split = m.split("[\"]");
        Message message = new Message(split[3], split[15]);
        Channel channel = holder.getGroupByName(split[7]);
        if (channel != null) {
            if (textChannel.getName().equals(channel.getName())) {
                textChannel.addMessage(message);
                chatMessages.add(message);
            }else{
                channel.addMessage(message);
            }
        } else {
            String[] splitUsers = split[11].split("[;]");
            ArrayList<User> users = new ArrayList<>();
            for (int i = 0; i < splitUsers.length; i++) {
                String[] userSplitted = splitUsers[i].split("[,]");
                User u = holder.getUserByIp(userSplitted[1]);
                if (u != null) {
                    users.add(u);
                } else {
                    User newUser = new User(userSplitted[0], userSplitted[1]);
                    holder.getUsers().add(newUser);
                    users.add(newUser);
                    onlineUsers.add(newUser);
                }
            }
            Channel newChannel = new Channel(users, split[7]);
            groups.add(newChannel);
            holder.addGroup(newChannel);
        }
    }

    @Override
    public void handleOnePersonMessage(String m) {

    }
}