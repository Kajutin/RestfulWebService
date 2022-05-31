package lt.viko.eif.kkvmavva.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 */
public class MySQL {
    public static void main(String[] args) {
        //jdbc:mysql://localhost:3306/DATABASE_NAME_GOES_HERE
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "root";

        try {
            //Connecting to database
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Connected to database");
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


