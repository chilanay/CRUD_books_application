// The ConnectToDatabase class is responsible for establishing a connection to a PostgreSQL database.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
    // Constants representing database information.
    public static final String DB_PATH = "org.postgresql.Driver";   // JDBC driver class for PostgreSQL.
    public static final String DB_URL = "jdbc:postgresql://localhost:5433/Books";  // Database URL.
    public static final String USERNAME = "postgres";  // Database username.
    public static final String PASSWORD = "12345";     // Database password.

    // Constructor for the ConnectToDatabase class.
    public ConnectToDatabase() {
        try {
            // Load the JDBC driver for PostgreSQL.
            Class.forName(DB_PATH);
        } catch (Exception e) {
            // If there's an exception while loading the driver, throw a runtime exception.
            throw new RuntimeException("Something went wrong " + e);
        }
    }

    // Method to establish a connection to the database and return the Connection object.
    public Connection getConnection() throws SQLException {
        // DriverManager.getConnection is used to establish a connection to the database.
        // It requires the database URL, username, and password.
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}
