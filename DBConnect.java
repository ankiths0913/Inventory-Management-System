import java.sql.*;

public class DBConnect {
    private static Connection conn;

    public static Connection getConnection() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/inventory_db", "root", "your_password");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
