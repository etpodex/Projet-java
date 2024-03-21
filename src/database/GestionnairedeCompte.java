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
    public List<String> inscriptionclient(String email, String password, String nom, String prenom, int age, int nvAvantage) {
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
    public static void retirerUtilisateur(String email) {
        // Premièrement, essayons de supprimer de la table Clients
        String queryClients = "DELETE FROM Clients WHERE email = ?";
        // Ensuite, de la table Employe
        String queryEmploye = "DELETE FROM Employe WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmtClients = conn.prepareStatement(queryClients);
             PreparedStatement pstmtEmploye = conn.prepareStatement(queryEmploye)) {

            pstmtClients.setString(1, email);//defini le ? dans la requete sql
            pstmtEmploye.setString(1, email);//defini le ? dans la requete sql

            // Exécute la commande SQL et donne le nb de ligne affecté
            int affectedRowsClients = pstmtClients.executeUpdate();

            if (affectedRowsClients > 0) {
                System.out.println("Le client avec l'email " + email + " a été supprimé avec succès.");
            } else {
                // Si aucun client n'est supprimé, vérifiez les employés
                int affectedRowsEmploye = pstmtEmploye.executeUpdate();

                if (affectedRowsEmploye > 0) {
                    System.out.println("L'employé avec l'email " + email + " a été supprimé avec succès.");
                } else {
                    System.out.println("Aucune personne trouvée avec l'email " + email + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}