package Model;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionProvider implements Provider {
    static Connection connection = null;

    public static Connection getConnection() {
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(connectionUrl, userName, password);
        } catch (Exception e) {
            System.out.println(e);
        }

        return connection;
    }
}
