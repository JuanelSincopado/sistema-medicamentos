package controller.login;

import javafx.scene.control.Alert;
import model.User;
import state.GlobalState;
import utils.Alerts;

import java.sql.*;

import static db.Database.conn;
import static utils.Utils.hash;

public class LoginController {

    static Connection connection = conn();
    static GlobalState globalState = GlobalState.getInstance();

    static public void loginUser(String username, String password) {
        User userX = new User(0, "", "", "", "", 0);

        if (!username.isEmpty() && !password.isEmpty()) {

            try {
                Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY);

                ResultSet rs = st.executeQuery("SELECT * FROM users WHERE user = '" + username + "'");

                while (rs.next()) {
                    int user_id = rs.getInt("user_id");
                    String user = rs.getString("user");
                    String first_name = rs.getString("first_name");
                    String last_name = rs.getString("last_name");
                    String pass = rs.getString("pass");
                    int rol = rs.getInt("rol");
                    userX = new User(user_id, user, first_name, last_name, pass, rol);
                }

                if (userX.getUser().isEmpty()) {
                    Alerts.alertWarnig(Alert.AlertType.WARNING, "El usuario no existe");
                    return;
                }

                String passwordHash = hash(password.toCharArray());

                if (!passwordHash.equals(userX.getPass())) {
                    Alerts.alertWarnig(Alert.AlertType.WARNING, "Las contraseñas no coinciden");
                    return;
                }

                globalState.setUser(userX);
                return;

            } catch (SQLException e) {
                System.out.println(e);
            }
        }

        Alerts.alertWarnig(Alert.AlertType.WARNING, "Los campos son obligatorios");
        return;
    }
}
