package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionnairedeCompte {
    // Méthode pour connecter un utilisateur et retourner ses informations sous forme de liste
    public List<String> login(String email, String password) {
        String query = "SELECT * FROM Clients WHERE email = ? AND password = ?";
        List<String> userInfo = new ArrayList<>();

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // Si l'utilisateur existe, ajouter ses informations à la liste
            if (rs.next()) {
                userInfo.add("ID: " + rs.getInt("id"));
                userInfo.add("Email: " + rs.getString("email"));
                userInfo.add("Nom: " + rs.getString("nom"));
                userInfo.add("Prénom: " + rs.getString("prenom"));
                userInfo.add("Age: " + rs.getInt("age"));
                userInfo.add("Niveau Avantage: " + rs.getInt("nvAvantage"));
                return userInfo; // Renvoyer la liste des informations
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Retourner null si l'utilisateur n'existe pas
        return null;
    }
    public List<String> register(String email, String password, String nom, String prenom, int age, int nvAvantage) {
        // Vérifiez d'abord si l'email existe déjà
        if (emailExists(email)) {
            List<String> response = new ArrayList<>();
            response.add("Échec de l'inscription : l'email existe déjà.");
            return response;
        }

        String query = "INSERT INTO Clients (email, password, nom, prenom, age, nvAvantage) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, nom);
            pstmt.setString(4, prenom);
            pstmt.setInt(5, age);
            pstmt.setInt(6, nvAvantage);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                List<String> successResponse = new ArrayList<>();
                successResponse.add("Inscription réussie !");
                return successResponse;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> failureResponse = new ArrayList<>();
        failureResponse.add("Échec de l'inscription : erreur inconnue.");
        return failureResponse;
    }

    // Méthode pour vérifier si un email existe déjà
    private boolean emailExists(String email) {
        String query = "SELECT id FROM Clients WHERE email = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            return pstmt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}