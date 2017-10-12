package GUI.CellViews;

import GUI.Controllers.UserController;
import Model.User;
import javafx.scene.control.ListCell;

/**
 * Created by sklar on 3/16/2017.
 */
public class UserViewCell extends ListCell<User> {
    private UserController userController = new UserController();
    @Override
    public void updateItem(User user, boolean empty) {
        super.updateItem(user, empty);
        if (user != null) {
            userController.setInfo(user);
            setGraphic(userController.getVbox());
        } else {
            setGraphic(null);
        }
    }

    public UserController getUserController() {
        return userController;
    }
}
