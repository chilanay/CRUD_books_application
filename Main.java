import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void ConnectDatabase(String dbid, String userid, String passwd) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@db.yale.edu:2000:univdb", userid = "root", passwd = "12345");
                Statement stmt = conn.createStatement();) {
        } catch (SQLException sqle) {
            System.out.println("SQLException : " + sqle);
        }
    }
}