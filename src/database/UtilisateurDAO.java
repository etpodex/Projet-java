package database;

import Model.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class provides methods to interact with the database for managing users (utilisateurs).
 */
public class UtilisateurDAO implements IUtilisateurDAO {

    /**
     * Connects a user using email and password.
     *
     * @param email    The email of the user.
     * @param password The password of the user.
     * @return The user object if login successful, otherwise null.
     */
    @Override
    public Utilisateur connecter(String email, String password) {
        Utilisateur utilisateur = new Utilisateur();

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM utilisateur WHERE email = ? AND password = ?")) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();

            // If user exists, add their information to the user object
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
        // Return null if user does not exist
        return null;
    }

    /**
     * Adds a new user to the database.
     *
     * @param nouv_utilisateur The user object to add.
     * @return 0 if addition successful, 1 if email already exists, 2 if addition failed for other reasons.
     */
    @Override
    public int ajouter(Utilisateur nouv_utilisateur) {
        String email = nouv_utilisateur.getEmail();
        String password = nouv_utilisateur.getPassword();
        String nom = nouv_utilisateur.getNom();
        String prenom = nouv_utilisateur.getPrenom();
        int age = nouv_utilisateur.getAge();
        int nvAvantage = nouv_utilisateur.getNvAvantage();
        UUID uuid = UUID.randomUUID(); // Generate a new UUID

        if (outildatabase.emailExists(email)) {
            return 1;
        }

        String query = "INSERT INTO utilisateur (uuid, email, password, nom, prenom, age, nvAvantage) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonnee = conn.prepareStatement(query)) {

            recupdonnee.setString(1, uuid.toString()); // Convert UUID to String
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

    /**
     * Modifies user information in the database.
     *
     * @param utilisateur The user object with updated information.
     */
    public void modifier(Utilisateur utilisateur) {
        String query = "UPDATE utilisateur SET nom = ?, prenom = ?, age = ?, nvAvantage = ?, password = ? WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setInt(3, utilisateur.getAge());
            pstmt.setInt(4, utilisateur.getNvAvantage());
            pstmt.setString(5, utilisateur.getPassword());
            pstmt.setString(6, utilisateur.getEmail());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("User information updated successfully.");
            } else {
                System.out.println("No user found with this email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a user from the database based on their email.
     *
     * @param usermail The email of the user to delete.
     */
    public void retirer(String usermail) {
        String query = "DELETE FROM utilisateur WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonnee = conn.prepareStatement(query)) {

            recupdonnee.setString(1, usermail);

            int affectedRows = recupdonnee.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("User with email " + usermail + " deleted successfully.");
            } else {
                System.out.println("No user found with email " + usermail + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Searches for users based on the given criteria.
     *
     * @param details The search criteria.
     * @return A list of users matching the search criteria.
     */
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
                // Add password if necessary or appropriate
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle the error as desired
        }

        if (utilisateurs.isEmpty()) {
            // Maybe return null or an empty list depending on your application logic
        }
        return utilisateurs;
    }
}
