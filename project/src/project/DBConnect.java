package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.SQLException;

public class DBConnect {

    public static Connection connect() {
        Connection conn = null;
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/oopproject", "root", "");

        } catch (ClassNotFoundException | SQLException e) {
            // Print any exception details for debugging
            System.out.println(e);
            
        }

        return conn;
    }
}
