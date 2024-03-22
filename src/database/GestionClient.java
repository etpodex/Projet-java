package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.util.UUID;
import java.util.Arrays;


public class GestionClient implements GestionBDD {
    // Implémentation des méthodes de GestionUtilisateur pour les clients
    @Override
    public List<String> connecter(String email, String password) {
        List<String> userInfo = new ArrayList<>();

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM Utilisateur WHERE email = ? AND password = ?")) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // Si l'utilisateur existe, ajouter ses informations à la liste
            if (rs.next()) {
                userInfo.add("UUID: " + rs.getString("uuid")); // Utiliser getString pour l'UUID
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
    @Override
    public List<String> ajouter(String... details) {
        String email = details[0];
        String password = details[1];
        String nom = details[2];
        String prenom = details[3];
        int age = Integer.parseInt(details[4]);
        int nvAvantage = Integer.parseInt(details[5]);
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID

        if (outildatabase.emailExists(email)) {
            return Arrays.asList("Échec de l'inscription : l'email existe déjà.");
        }

        String query = "INSERT INTO Clients (uuid, email, password, nom, prenom, age, nvAvantage) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // Enlever Statement.RETURN_GENERATED_KEYS

            pstmt.setString(1, uuid.toString()); // UUID converti en String
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, nom);
            pstmt.setString(5, prenom);
            pstmt.setInt(6, age);
            pstmt.setInt(7, nvAvantage);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return Arrays.asList("Inscription réussie ! ID client: " + uuid.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Arrays.asList("Échec de l'inscription : erreur inconnue.");
    }



    public void modifier(String email, String champ, String nouvelleValeur) {
        String query = "UPDATE Clients SET " + champ + " = ? WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set nouvelle valeur
            pstmt.setString(1, nouvelleValeur);
            // Set email
            pstmt.setString(2, email);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("L'information du client a été modifiée avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec cet email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void retirer(String clientemail) {
        String query = "DELETE FROM Clients WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, clientemail);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Le client avec l'email " + clientemail + " a été supprimé avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec l'email " + clientemail + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> rechercher(String critere) {
        List<String> utilisateurs = new ArrayList<>();
        String query = "SELECT uuid, email, nom, prenom, age, nvAvantage,password FROM Clients WHERE email LIKE ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + critere + "%"); // Définir le critère de recherche pour l'email
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String utilisateur = " UUID: " + rs.getString("uuid") +
                        ", Email: " + rs.getString("email") +
                        ", Nom: " + rs.getString("nom") +
                        ", Prénom: " + rs.getString("prenom") +
                        ", Age: " + rs.getInt("age") +
                        ", Niveau Avantage: " + rs.getInt("nvAvantage")+
                        ", password " +rs.getString("password");
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            utilisateurs.add("Erreur lors de la récupération des utilisateurs : " + e.getMessage());
        }

        if (utilisateurs.isEmpty()) {
            utilisateurs.add("Aucun utilisateur trouvé.");
        }
        return utilisateurs;
    }
}
