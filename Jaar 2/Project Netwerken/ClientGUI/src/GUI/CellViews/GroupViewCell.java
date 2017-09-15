package GUI.CellViews;

import GUI.Controllers.GroupController;
import Model.Channel;
import javafx.scene.control.ListCell;

/**
 * Created by sklar on 3/16/2017.
 */
public class GroupViewCell extends ListCell<Channel> {
    private GroupController groupController = new GroupController();

    @Override
    public void updateItem(Channel channel, boolean empty) {
        super.updateItem(channel, empty);
        if (channel != null) {
            groupController.setInfo(channel);
            setGraphic(groupController.getVbox());
        } else {
            setGraphic(null);
        }
    }

    public GroupController getGroupController() {
        return groupController;
    }
}
