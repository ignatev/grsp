package ru.grsp.backend.kafka;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseReader {
    public Connection returnMysql() {
        String userName = "store-connector";
        String password = "pswwd";
        String url = "jdbc:mysql://localhost:3306/ocstore";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection connection = DriverManager.getConnection(url, userName, password)) {
            return connection;
        }

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
