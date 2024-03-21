package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {

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


}
