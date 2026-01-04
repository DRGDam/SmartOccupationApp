package Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BDconfig {

private static final String URL = "jdbc:mariadb://localhost:3306/smart_occupation"; 
    private static final String USER = "root";
    private static final String PASSWORD = "root123";

    static {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Error: No se encontró el driver de MariaDB", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            return false;
        }
    }
}