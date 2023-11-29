import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    // public static void ConnectDatabase(String dbid, String userid, String passwd)
    // {
    // try (Connection conn = DriverManager.getConnection(
    // "jdbc:oracle:thin:@db.yale.edu:2000:univdb", userid = "root", passwd =
    // "12345");
    // Statement stmt = conn.createStatement();) {
    // } catch (SQLException sqle) {
    // System.out.println("SQLException : " + sqle);
    // }
    // }

    public static void ConnectDatabase(String dbid, String userid, String passwd) {
        try {
            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Construct the connection URL
            String url = "jdbc:postgresql://localhost:5433/" + dbid;

            // Establish the connection
            try (Connection conn = DriverManager.getConnection(url, userid, passwd);
                    Statement stmt = conn.createStatement()) {
                // You can perform database operations here if needed
                System.out.println("Connected to the database");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Error loading PostgreSQL JDBC driver: " + e.getMessage());
        } catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle);
        }
    }

    public static void main(String[] args) {
        // Replace these values with your PostgreSQL database credentials
        String dbid = "your-database-name";
        String userid = "pg_read_all_data";
        String passwd = "your-password";

        ConnectDatabase(dbid, userid, passwd);
    }

}