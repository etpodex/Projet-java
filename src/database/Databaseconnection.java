package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Databaseconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cinemajava"; // Remplacez avec votre URL de DB
    private static final String USER = "root"; // Remplacez avec votre utilisateur de DB
    private static final String PASSWORD = "rootroot"; // Remplacez avec votre mot de passe de DB

    // Méthode pour établir et retourner une connexion à la base de données
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
