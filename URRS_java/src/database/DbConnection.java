package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

    public Connection Connect() {
        try {
            String driverName = "org.gjt.mm.mysql.Driver";
            String url = "jdbc:mysql://localhost:3306/URRS";
            String user = "root";
            String password = "";

            Class.forName(driverName);
            Connection conn = DriverManager.getConnection(url, user, password);

            return conn;

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Database connection error");
            e.printStackTrace();
        }

        return null;
    }
}
