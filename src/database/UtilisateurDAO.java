package database;
import Model.Utilisateur;
import jdk.jshell.execution.Util;

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
    public Utilisateur connecter(String email, String password) {
        Utilisateur utilisateur = new Utilisateur();

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?")) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // Si l'utilisateur existe, ajouter ses informations à la liste
            if (rs.next()) {
                utilisateur.setUuid(rs.getString("uuid"));
                utilisateur.setEmail(rs.getString("email"));
                utilisateur.setNom(rs.getString("nom"));
                utilisateur.setPrenom(rs.getString("prenom"));
                utilisateur.setAge(rs.getInt("age"));
                utilisateur.setNvAvantage(rs.getInt("nvAvantage"));

                return utilisateur;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        // Retourner null si l'utilisateur n'existe pas
        return null;
    }
    @Override
    public int ajouter(Utilisateur nouv_utilisateur) {
        String email = nouv_utilisateur.getEmail();
        String password = nouv_utilisateur.getPassword();
        String nom = nouv_utilisateur.getNom();
        String prenom = nouv_utilisateur.getPrenom();
        int age = nouv_utilisateur.getAge();
        int nvAvantage = nouv_utilisateur.getNvAvantage();
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID

        if (outildatabase.emailExists(email)) {
            return 1;
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
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 2;
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
