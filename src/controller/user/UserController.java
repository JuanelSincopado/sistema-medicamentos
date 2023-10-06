package controller.user;

import javafx.scene.control.Alert;
import model.User;
import utils.Alerts;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static db.Database.conn;
import static utils.Utils.hash;

public class UserController {
    static Connection connection = conn();

    static public List<User> getAllUsers(){
        List<User> userList = new ArrayList<>();

        try {
            Statement st = connection.createStatement();

            ResultSet rs = st.executeQuery("SELECT * FROM users");

            while (rs.next()){
                int user_id = rs.getInt("user_id");
                String user = rs.getString("user");
                String first_name = rs.getString("first_name");
                String last_name = rs.getString("last_name");
                String pass = rs.getString("pass");
                int rol = rs.getInt("rol");
                User newUser = new User(user_id, user, first_name, last_name, pass, rol);
                userList.add(newUser);
            }
        } catch (SQLException e){
            System.out.println(e);
        }

        return userList;
    }

    static public boolean createUser(String username, String firstName, String lastName, String pass1, String pass2, String rol){

        if (!username.isEmpty() && !firstName.isEmpty() && !lastName.isEmpty() && !pass1.isEmpty() && !pass2.isEmpty() && !rol.isEmpty() ){
            if (!pass1.equals(pass2)) {
                Alerts.alertWarnig(Alert.AlertType.ERROR, "Las contraseñas no coinciden");
                return false;
            }

            String passwordHash = hash(pass1.toCharArray());

            try{
                int x;
                if (rol.equals("Administrador")){
                    x = 1;
                } else {
                    x = 2;
                }

                PreparedStatement ps = connection.prepareStatement("INSERT INTO users (user, first_name, last_name, pass, rol) values (?, ?, ?, ?, ?)");

                ps.setString(1, username);
                ps.setString(2, firstName);
                ps.setString(3, lastName);
                ps.setString(4, passwordHash);
                ps.setInt(5, x);

                ps.executeUpdate();

                Alerts.alertWarnig(Alert.AlertType.INFORMATION, "Usuario creado con éxito");
                return true;

            } catch (SQLException e){
                System.out.println(e);
                Alerts.alertWarnig(Alert.AlertType.ERROR, "Error al crear la cuenta");
            }
        }

        Alerts.alertWarnig(Alert.AlertType.WARNING, "Los campos son obligatorios");
        return false;
    }
}
