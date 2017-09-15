package GUI.CellViews;

import GUI.Controllers.ChatController;
import Model.DataHolder;
import Model.Message;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;

/**
 * Created by sklar on 3/15/2017.
 */
public class ChatViewCell extends ListCell<Message> {
    @Override
    public void updateItem(Message message, boolean empty) {
        super.updateItem(message, empty);
        if (message != null) {
            this.setMaxWidth(120);
            ChatController chatController = new ChatController();
            chatController.setInfo(message);
            if (message.getSender().equals(DataHolder.getInstance().getMainUser().getUsername())) {
                setAlignment(Pos.CENTER_RIGHT);
            } else {
                setAlignment(Pos.CENTER_LEFT);
            }
            setGraphic(chatController.getBox());
        } else {
            setGraphic(null);
        }
    }
}
