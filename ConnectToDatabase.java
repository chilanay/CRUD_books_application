import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDatabase {
    public static final String DB_PATH = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost:5433/Books";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "12345";

    public ConnectToDatabase() {
        try {
            Class.forName(DB_PATH);
        } catch (Exception e) {
            throw new RuntimeException("Something went wrong " + e);
        }
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
    }
}