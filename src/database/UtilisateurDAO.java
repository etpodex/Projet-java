package database;
import Model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Arrays;


public class UtilisateurDAO implements IUtilisateurDAO {
    // Implémentation des méthodes de GestionUtilisateur pour les clients
    @Override
    public List<String> connecter(String email, String password) {
        List<String> listeinfo = new ArrayList<>();

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?")) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // Si l'utilisateur existe, ajouter ses informations à la liste
            if (rs.next()) {
                listeinfo.add("UUID: " + rs.getString("uuid")); // Utiliser getString pour l'UUID
                listeinfo.add("Email: " + rs.getString("email"));
                listeinfo.add("Nom: " + rs.getString("nom"));
                listeinfo.add("Prénom: " + rs.getString("prenom"));
                listeinfo.add("Age: " + rs.getInt("age"));
                listeinfo.add("Niveau Avantage: " + rs.getInt("nvAvantage"));
                return listeinfo; // Renvoyer la liste des informations
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

        String query = "INSERT INTO utilisateur (uuid, email, password, nom, prenom, age, nvAvantage) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonnee = conn.prepareStatement(query)) { // Enlever Statement.RETURN_GENERATED_KEYS

            recupdonnee.setString(1, uuid.toString()); // UUID converti en String
            recupdonnee.setString(2, email);
            recupdonnee.setString(3, password);
            recupdonnee.setString(4, nom);
            recupdonnee.setString(5, prenom);
            recupdonnee.setInt(6, age);
            recupdonnee.setInt(7, nvAvantage);

            int affectedRows = recupdonnee.executeUpdate();
            if (affectedRows > 0) {
                return Arrays.asList("Inscription réussie ! ID client: " + uuid.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Arrays.asList("Échec de l'inscription : erreur inconnue.");
    }



    public void modifier(String email, String champ, String nouvelleValeur) {
        String query = "UPDATE utilisateur SET " + champ + " = ? WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonnee = conn.prepareStatement(query)) {

            // Set nouvelle valeur
            recupdonnee.setString(1, nouvelleValeur);
            // Set email

            recupdonnee.setString(2, email);

            int affectedRows = recupdonnee.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("L'information du client a été modifiée avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec cet email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void retirer(String usermail) {
        String query = "DELETE FROM utilisateur WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonnee = conn.prepareStatement(query)) {

            recupdonnee.setString(1, usermail);

            int affectedRows = recupdonnee.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Le client avec l'email " + usermail + " a été supprimé avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec l'email " + usermail + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Utilisateur> rechercher(String... details) {
        String critere = details[0];
        int nivadmin = Integer.parseInt(details[1]);
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String query = "SELECT uuid, email, nom, prenom, age, nvAvantage, password FROM utilisateur WHERE email LIKE ? AND nvAvantage = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonnee = conn.prepareStatement(query)) {

            recupdonnee.setString(1, "%" + critere + "%");
            recupdonnee.setInt(2, nivadmin);
            ResultSet rs = recupdonnee.executeQuery();

            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setUuid(rs.getString("uuid"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setAge(rs.getInt("age"));
                utilisateur.setNvAvantage(rs.getInt("nvAvantage"));
                // Ajoutez le mot de passe si nécessaire ou approprié
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Gérer l'erreur comme souhaité
        }

        if (utilisateurs.isEmpty()) {
            // Peut-être retourner null ou une liste vide en fonction de la logique de votre application
        }
        return utilisateurs;
    }
}
