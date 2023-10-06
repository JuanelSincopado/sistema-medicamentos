package layout;

import java.io.InputStream;

import controller.login.LoginController;
import controller.user.UserController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import state.GlobalState;
import utils.CircularProgressBar;
import view.HomeFX;
import view.LoginFX;

public class LoginLayout {

    static CircularProgressBar circularProgressBar = new CircularProgressBar();
    static GlobalState globalState = GlobalState.getInstance();

    public static Node containerRigth() {
        VBox containerRight = new VBox();

        ImageView imageLogo;

        InputStream inputStream;

        inputStream = LoginLayout.class.getResourceAsStream("/image/logo.png");
        assert inputStream != null;
        Image image = new Image(inputStream);

        imageLogo = new ImageView(image);
        containerRight.getChildren().add(imageLogo);

        containerRight.setPrefWidth(422);
        containerRight.setAlignment(Pos.CENTER);
        containerRight.setBackground(
                new Background(new BackgroundFill(Color.web("#30373e"), CornerRadii.EMPTY, Insets.EMPTY)));
        return containerRight;
    }

    public static Node loginContainerLeft(Stage stage) {
        VBox containerLeft = new VBox();

        Label labelTitle = new Label("Bienvenido");
        labelTitle.setFont(new Font(30));
        labelTitle.setAlignment(Pos.CENTER);
        VBox.setMargin(labelTitle, new Insets(40, 0, 0, 0));

        VBox containerLogin = new VBox();

        // INPUTS
        TextField txtUserName = new TextField();
        txtUserName.setMaxWidth(250);
        txtUserName.setFont(new Font(18));
        txtUserName.setPromptText("Nombre de usuario");

        PasswordField txtPass = new PasswordField();
        txtPass.setMaxWidth(250);
        txtPass.setFont(new Font(18));
        txtPass.setPromptText("Contraseña");

        Button submit = new Button("Entrar");
        submit.setMaxWidth(250);
        submit.setCursor(Cursor.HAND);
        submit.maxWidth(Double.MAX_VALUE);
        VBox.setMargin(submit, new Insets(40, 0, 0, 0));
        submit.setOnAction(e -> {
            LoginController.loginUser(txtUserName.getText(), txtPass.getText());
            if (globalState.getUser().getUser() != null) {
                HomeFX.home();
                stage.close();
            }
        });

        VBox.setMargin(txtUserName, new Insets(10, 0, 0, 0));
        VBox.setMargin(txtPass, new Insets(10, 0, 0, 0));

        containerLogin.getChildren().addAll(txtUserName, txtPass, submit);
        containerLogin.setAlignment(Pos.CENTER);

        containerLeft.getChildren().addAll(labelTitle, containerLogin);
        containerLeft.setPrefWidth(422);
        containerLeft.setAlignment(Pos.CENTER);
        VBox.setMargin(labelTitle, new Insets(0, 0, 10, 0));

        return containerLeft;
    }

    public static Node registerContainerLeft(Stage stage) {
        VBox containerLeft = new VBox();

        Label labeltitle = new Label("Bienvenido");
        labeltitle.setFont(new Font(30));
        labeltitle.setAlignment(Pos.CENTER);
        VBox.setMargin(labeltitle, new Insets(40, 0, 0, 0));

        VBox containerLogin = new VBox();

        // INPUTS
        TextField txtUserName = new TextField();
        txtUserName.setMaxWidth(250);
        txtUserName.setFont(new Font(18));
        txtUserName.setPromptText("Nombre de usuario");

        TextField txtFirstName = new TextField();
        txtFirstName.setMaxWidth(250);
        txtFirstName.setFont(new Font(18));
        txtFirstName.setPromptText("Nombres");

        TextField txtLastName = new TextField();
        txtLastName.setMaxWidth(250);
        txtLastName.setFont(new Font(18));
        txtLastName.setPromptText("Apellidos");

        ComboBox<String> dropdown = new ComboBox<>();
        ObservableList<String> items = FXCollections.observableArrayList("Administrador", "Usuario");
        dropdown.setItems(items);
        dropdown.setMaxWidth(250);
        dropdown.setMaxHeight(18);
        dropdown.setPromptText("Privilegios");

        PasswordField txtPass1 = new PasswordField();
        txtPass1.setMaxWidth(250);
        txtPass1.setFont(new Font(18));
        txtPass1.setPromptText("Contraseña");

        PasswordField txtPass2 = new PasswordField();
        txtPass2.setMaxWidth(250);
        txtPass2.setFont(new Font(18));
        txtPass2.setPromptText("Repetir contraseña");

        Button submit = new Button("Entrar");
        submit.setMaxWidth(250);
        submit.setCursor(Cursor.HAND);
        submit.maxWidth(Double.MAX_VALUE);
        VBox.setMargin(submit, new Insets(40, 0, 0, 0));
        submit.setOnAction(e -> {
            boolean x = UserController.createUser(txtUserName.getText(), txtFirstName.getText(), txtLastName.getText(),
                    txtPass1.getText(), txtPass2.getText(), dropdown.getValue());

            if (x) {
                LoginFX.login();
                stage.close();
            }
            ;
        });

        VBox.setMargin(txtUserName, new Insets(10, 0, 0, 0));
        VBox.setMargin(txtFirstName, new Insets(10, 0, 0, 0));
        VBox.setMargin(txtLastName, new Insets(10, 0, 0, 0));
        VBox.setMargin(dropdown, new Insets(10, 0, 0, 0));
        VBox.setMargin(txtPass1, new Insets(10, 0, 0, 0));
        VBox.setMargin(txtPass2, new Insets(10, 0, 0, 0));

        containerLogin.getChildren().addAll(txtUserName, txtFirstName, txtLastName, dropdown, txtPass1, txtPass2,
                submit);
        containerLogin.setAlignment(Pos.CENTER);

        containerLeft.getChildren().addAll(labeltitle, containerLogin);
        containerLeft.setPrefWidth(422);
        containerLeft.setAlignment(Pos.CENTER);
        VBox.setMargin(labeltitle, new Insets(0, 0, 10, 0));

        return containerLeft;
    }
}
