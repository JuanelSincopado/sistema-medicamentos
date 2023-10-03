package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import layout.LoginLayout;

public class LoginFX {

    public static void login(){

        Stage stage = new Stage();

        HBox root = new HBox();
        root.getChildren().addAll(LoginLayout.loginContainerLeft(stage), LoginLayout.containerRigth());
        root.setAlignment(Pos.TOP_CENTER);

        HBox.setHgrow(LoginLayout.loginContainerLeft(stage), Priority.ALWAYS);
        HBox.setHgrow(LoginLayout.containerRigth(), Priority.ALWAYS);

        Scene scene = new Scene(root, 820, 503);

        stage.setTitle("login");
        stage.setScene(scene);
        stage.show();
    }

    public static void register(){

        Stage stage = new Stage();

        HBox root = new HBox();
        root.getChildren().addAll(LoginLayout.registerContainerLeft(stage), LoginLayout.containerRigth());
        root.setAlignment(Pos.TOP_CENTER);

        HBox.setHgrow(LoginLayout.registerContainerLeft(stage), Priority.ALWAYS);
        HBox.setHgrow(LoginLayout.containerRigth(), Priority.ALWAYS);

        Scene scene = new Scene(root, 820, 503);

        stage.setTitle("Registrar");
        stage.setScene(scene);
        stage.show();
    }
}
