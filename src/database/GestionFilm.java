package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionFilm implements GestionBDD {
    @Override
    public List<String> ajouter(String... details) {
        String nom = details[0];
        String synopsis = details[1];
        float note = Float.parseFloat(details[2]);

        String query = "INSERT INTO Films (nom, Synopsis, note) VALUES (?, ?, ?)";

        try (Connection conn = Databaseconnection.getConnection(); // Assurez-vous que cette méthode existe et retourne une connexion valide
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nom);
            pstmt.setString(2, synopsis);
            pstmt.setFloat(3, note);

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

    @Override
    public void retirer(String identifiant) {
        // Retirer un film de la base de données
    }

    @Override
    public void modifier(String identifiant, String champ, String nouvelleValeur) {
        // Modifier un film dans la base de données
    }

    @Override
    public List<String> rechercher(String critere) {
        // Rechercher des films dans la base de données
        return null;
    }

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
}
