package view;

import static layout.HomeLayout.navbar;
import static layout.HomeLayout.sideBar;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.User;
import state.GlobalState;
import utils.CircularProgressBar;

public class HomeFX {

    static GlobalState globalState = GlobalState.getInstance();
    CircularProgressBar circularProgressBar = new CircularProgressBar();

    public void home() {

        Stage stage = new Stage();

        VBox root = new VBox();

        globalState.setPage("home");

        Label title = new Label("Home");

        HBox body = new HBox();
        VBox.setVgrow(body, Priority.ALWAYS);

        body.getChildren().addAll(sideBar(stage), title);

        root.getChildren().addAll(navbar(), body);

        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }

}
