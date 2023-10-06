package view;

import static layout.HomeLayout.navbar;
import static layout.HomeLayout.sideBar;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import layout.HomeLayout;
import state.GlobalState;
import utils.CircularProgressBar;

public class HomeFX {
    CircularProgressBar circularProgressBar = new CircularProgressBar();
    static GlobalState globalState = GlobalState.getInstance();

    public static void home() {

        Stage stage = new Stage();

        VBox root = new VBox();

        HBox body = new HBox();
        VBox.setVgrow(body, Priority.ALWAYS);

        Label prueba = new Label("Prueba");

        if (globalState.getPageValue() == "home") {
            body.getChildren().addAll(sideBar(stage), HomeLayout.containerBody());
        } else if (globalState.getPageValue() == "products") {
            body.getChildren().addAll(sideBar(stage), prueba);
        }

        root.getChildren().addAll(navbar(), body);

        Scene scene = new Scene(root);
        stage.setMaximized(true);
        stage.setTitle("Home");
        stage.setScene(scene);
        stage.show();
    }
}
