import static controller.user.UserController.getAllUsers;

import java.util.List;

import javafx.application.Application;
import javafx.stage.Stage;
import model.User;
import view.LoginFX;

public class MainJavaFX extends Application {

    List<User> userList;

    @Override
    public void init() {
        userList = getAllUsers();
    }

    @Override
    public void start(Stage primaryStage) {
        if (userList.isEmpty()) {
            LoginFX.register();
        } else {
            LoginFX.login();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
