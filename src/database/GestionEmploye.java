package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class GestionEmploye implements GestionBDD {
    // Les employés n'ont peut-être pas les mêmes champs ou méthodes d'inscription et de connexion que les clients
    @Override
    public List<String> connecter(String email, String motDePasse) {
        {
            String query = "SELECT * FROM employes WHERE email = ? AND password = ?";
            List<String> userInfo = new ArrayList<>();

            try (Connection conn = Databaseconnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, email);
                pstmt.setString(2, motDePasse);
                ResultSet rs = pstmt.executeQuery();

                // Si l'utilisateur existe, ajouter ses informations à la liste
                if (rs.next()) {
                    userInfo.add("Email: " + rs.getString("email"));
                    userInfo.add("Nom: " + rs.getString("nom"));
                    userInfo.add("Prénom: " + rs.getString("prenom"));
                    return userInfo; // Renvoyer la liste des informations
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Retourner null si l'utilisateur n'existe pas
            return null;

        }
    }

    @Override
    public List<String> ajouter(String... details) {
        String email = details[0];
        String password = details[1];
        String nom = details[2];
        String prenom = details[3];
        int age = Integer.parseInt(details[4]);
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID

        if (outildatabase.emailExists(email)) {
            return Arrays.asList("Échec de l'inscription : l'email existe déjà.");
        }

        String query = "INSERT INTO employes (uuid, email, password, nom, prenom, age) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) { // Enlever Statement.RETURN_GENERATED_KEYS

            pstmt.setString(1, uuid.toString()); // UUID converti en String
            pstmt.setString(2, email);
            pstmt.setString(3, password);
            pstmt.setString(4, nom);
            pstmt.setString(5, prenom);
            pstmt.setInt(6, age);

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
        String query = "UPDATE employes SET " + champ + " = ? WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set nouvelle valeur
            pstmt.setString(1, nouvelleValeur);
            // Set email
            pstmt.setString(2, email);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("L'information du employe a été modifiée avec succès.");
            } else {
                System.out.println("Aucun employe trouvé avec cet email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void retirer(String employeemail) {
        String query = "DELETE FROM employes WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employeemail);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("l'employe avec l'email " + employeemail + " a été supprimé avec succès.");
            } else {
                System.out.println("Aucun employe trouvé avec l'email " + employeemail + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<String> rechercher(String critere) {
        List<String> utilisateurs = new ArrayList<>();
        String query = "SELECT uuid, email, nom, prenom, age, password FROM employes WHERE email LIKE ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + critere + "%"); // Définir le critère de recherche pour l'email
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String utilisateur = " UUID: " + rs.getString("uuid") +
                        ", Email: " + rs.getString("email") +
                        ", Nom: " + rs.getString("nom") +
                        ", Prénom: " + rs.getString("prenom") +
                        ", Age: " + rs.getInt("age");
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            utilisateurs.add("Erreur lors de la récupération des employes : " + e.getMessage());
        }

        if (utilisateurs.isEmpty()) {
            utilisateurs.add("Aucun employe trouvé.");
        }
        return utilisateurs;
    }
}