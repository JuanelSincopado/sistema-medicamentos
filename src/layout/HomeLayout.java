package layout;

import static utils.Colors.green_dark;

import java.util.Arrays;
import java.util.List;

import controller.product.ProductController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import model.Product;
import state.GlobalState;
import utils.Colors;
import utils.Components;
import view.HomeFX;
import view.LoginFX;

public class HomeLayout {

    static GlobalState globalState = GlobalState.getInstance();

    public static Node navbar() {
        GlobalState globalState = GlobalState.getInstance();

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
        GlobalState globalState = GlobalState.getInstance();

        VBox sideBar = new VBox();

        Button buttonHome = Components.createIconButtonWithText("Inicio", "/image/icons/casa.png");
        Button buttonProduct = Components.createIconButtonWithText("Medicinas", "/image/icons/capsula.png");
        Button buttonUser = Components.createIconButtonWithText("Usuarios", "/image/icons/usuario.png");
        Button buttonlogOut = Components.createIconButtonWithText("Cerrar sesión", "/image/icons/cerrar-sesion.png");

        buttonHome.setOnAction(e -> {
            globalState.setPage("home");
            HomeFX.home();
        });

        buttonProduct.setOnAction(e -> {
            globalState.setPage("product");
            HomeFX.home();
        });

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

    public static Node containerBody() {

        System.out.println(globalState.getPageValue());

        HBox containerHome = new HBox();
        containerHome.setPadding(new Insets(20, 40, 20, 40));
        HBox.setHgrow(containerHome, Priority.ALWAYS);
        containerHome.setSpacing(150);
        containerHome.setAlignment(Pos.CENTER);

        containerHome.getChildren().addAll(Components.tableContainerBody(), Components.tableContainerBody(),
                Components.tableContainerBody());

        return containerHome;
    }

}
