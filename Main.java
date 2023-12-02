import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) {
        final String DB_URL = "jdbc:postgresql://localhost:5433/Books";

        final String USERNAME = "postgres";
        final String PASSWORD = "12345";

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            System.out.println("Connected to database successfully...");

            stmt = conn.createStatement();
            String sql = "INSERT INTO customers (customerID, customername, address, phonenumber)"
                    + "VALUES ('2', 'Someone2', '46 B street', '234123123')";

            ((java.sql.Statement) stmt).executeUpdate(sql);
            System.out.println("Inserted records into the table...");
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
