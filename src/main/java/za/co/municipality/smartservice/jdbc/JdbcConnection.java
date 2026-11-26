package za.co.municipality.smartservice.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** JDBC example required for Question 3. Configure credentials for your local MySQL server. */
public final class JdbcConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/municipal_service_db";
    private static final String USER = "root";
    private static final String PASSWORD = "change_me";

    private JdbcConnection() { }

    public static Connection getConnection() throws SQLException {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException exception) {
            System.err.println("Database connection failed: " + exception.getMessage());
            throw exception;
        }
    }
}
