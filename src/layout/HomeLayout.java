package layout;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.User;
import state.GlobalState;
import utils.Colors;
import view.LoginFX;

import java.util.Objects;

import static utils.Colors.green_dark;

public class HomeLayout {

    static GlobalState globalState = GlobalState.getInstance();

    public static Node navbar() {
        StackPane nameSistem = new StackPane();
        nameSistem.setStyle("-fx-background-color: " + green_dark + ";");
        nameSistem.setPrefHeight(70);
        nameSistem.setMinWidth(190);
        Label name = new Label("Invetory");
        name.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        name.setTextFill(Color.WHITE);
        StackPane.setAlignment(name, Pos.CENTER);
        nameSistem.getChildren().add(name);

        // Pane para las opciones del navbar
        BorderPane optionsNavbar = new BorderPane();
        optionsNavbar.setPrefHeight(70);
        Label date = new Label("03/10/2023 1:30 am");
        date.setTextFill(Paint.valueOf(Colors.black_light));
        Label userName = new Label(globalState.getUser().getFirstName() + " " + globalState.getUser().getLastName());
        userName.setStyle("-fx-font-size: 16; -fx-text-fill: " + Colors.black_light + ";");

        optionsNavbar.setStyle("-fx-background-color: white;");
        optionsNavbar.setLeft(date);
        optionsNavbar.setRight(userName);
        optionsNavbar.setPadding(new Insets(25, 40, 0, 40));

        // BorderPane para contener ambos elementos
        BorderPane navbar = new BorderPane();
        navbar.setLeft(nameSistem); // Nombre de usuario en la parte izquierda
        navbar.setCenter(optionsNavbar); // Opciones del navbar en el centro

        // Configura que optionsNavbar ocupe todo el espacio horizontal disponible
        BorderPane.setAlignment(optionsNavbar, Pos.CENTER);

        return navbar;
    }

    public static Node sideBar(Stage stage) {
        VBox sideBar = new VBox();

        Button buttonHome = createIconButtonWithText("Inicio", "/image/icons/casa.png");
        Button buttonProduct = createIconButtonWithText("Medicinas", "/image/icons/capsula.png");
        Button buttonUser = createIconButtonWithText("Usuarios", "/image/icons/usuario.png");
        Button buttonlogOut = createIconButtonWithText("Cerrar sesión", "/image/icons/cerrar-sesion.png");

        buttonlogOut.setOnAction(e -> {
            LoginFX.login();
            stage.close();
        });

        VBox.setMargin(buttonProduct, new Insets(20, 0, 0, 0));
        VBox.setMargin(buttonUser, new Insets(20, 0, 0, 0));
        VBox.setMargin(buttonlogOut, new Insets(20, 0, 0, 0));

        if (globalState.getUser().getRol() == 1) {
            sideBar.getChildren().addAll(buttonHome, buttonProduct, buttonUser, buttonlogOut);
        } else {
            sideBar.getChildren().addAll(buttonHome, buttonProduct, buttonlogOut);

        }

        sideBar.setStyle("-fx-background-color: " + Colors.side_background_color + ";");

        VBox.setVgrow(sideBar, Priority.ALWAYS);
        sideBar.setPrefWidth(190);
        sideBar.setPadding(new Insets(50, 20, 0, 20));

        return sideBar;
    }

    private static Button createIconButtonWithText(String title, String iconFileName) {
        // Cargar la imagen del icono
        Image icon = new Image(Objects.requireNonNull(HomeLayout.class.getResourceAsStream(iconFileName)));

        // Crear un ImageView para mostrar el icono
        ImageView iconView = new ImageView(icon);
        iconView.setFitHeight(22);
        iconView.setFitWidth(22);

        // Crear un Label para el texto
        Label label = new Label(title);
        label.setTextFill(Paint.valueOf(Colors.side_color));
        label.setFont(new Font(16));

        // Crear un contenedor HBox para colocar el icono y el texto horizontalmente
        HBox hbox = new HBox(15); // Espacio entre el icono y el texto
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.getChildren().addAll(iconView, label);

        // Crear un botón y establecer el HBox como su contenido gráfico
        Button button = new Button();
        button.setGraphic(hbox);

        button.setStyle("-fx-background-color: transparent; -fx-font-weight: bold; -fx-cursor: hand");
        button.setMaxWidth(Double.MAX_VALUE);
        button.setMaxHeight(20);

        return button;
    }
}
