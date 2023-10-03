package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection conn(){

        Connection connect = null;

        String url = "jdbc:mysql://localhost:3306/sistema";
        String user = "root";
        String password = "";

        try {
            connect = DriverManager.getConnection(url, user, password);

        } catch (SQLException e){
            System.out.println(e);
        }

        return connect;
    }
}
