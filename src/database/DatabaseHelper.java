package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {
    private static final String URL = "jdbc:mysql://localhost:3306/cinemaprojet"; // Remplacez avec votre URL de DB
    private static final String USER = "root"; // Remplacez avec votre utilisateur de DB
    private static final String PASSWORD = "ethaN1945!"; // Remplacez avec votre mot de passe de DB

    // Charger le driver JDBC et établir une connexion
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    // Méthode pour récupérer les informations d'un client par ID
    public void getClientInfo(int clientId) {
        String query = "SELECT * FROM Clients WHERE id = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, clientId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Niveau Avantage: " + rs.getInt("nvAvantage"));
                System.out.println("Nom: " + rs.getString("nom"));
                System.out.println("Prénom: " + rs.getString("prenom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    // Méthode pour ajouter un nouveau client
    public void addClient(int id, String email, String password, int age, int nvAvantage, String nom, String prenom) {
        String query = "INSERT INTO Clients (id, email, password, age, nvAvantage, nom, prenom) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setInt(4, age);
            pstmt.setInt(5, nvAvantage);
            pstmt.setString(6, nom);
            pstmt.setString(7, prenom);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Un nouveau client a été ajouté avec succès.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteClient(int clientId) {
        String query = "DELETE FROM Clients WHERE id = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, clientId);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Le client avec l'ID " + clientId + " a été supprimé avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec l'ID " + clientId + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
