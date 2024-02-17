package kz.bitlab.academy.db;

import java.sql.Connection;
import java.sql.DriverManager;

public interface DBManager {
    static Connection getConnection() {
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/bitlab",
                    "postgres", "postgres"
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        return connection;
    }
}
