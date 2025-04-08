package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/exam_gestion_entreprise";
    private static final String USERNAME = "ETU003105";
    private static final String PASSWORD = "rLU7QMuz";

    public static Connection getConnection() throws SQLException {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Pilote JDBC MySQL non trouvé", e);
        }
    }
    public static void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void testConnection() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            System.out.println(" Connexion à la base réussie");
        } catch (SQLException e) {
            System.err.println(" Échec de connexion à la base");
            e.printStackTrace();
        }
    }
}