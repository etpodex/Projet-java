package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GestionFilm implements GestionBDD {
    @Override
    public List<String> ajouter(String... details) {
        String nom = details[0];
        String synopsis = details[1];
        float note = Float.parseFloat(details[2]);
        String URL_image = details[3];
        int PrixFilm = Integer.parseInt(details[4]);
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID



        String query = "INSERT INTO Films (uuid,nom,Synopsis,note,URL_image,PrixFilm,) VALUES (?,?,?,?,?,?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, uuid.toString()); // UUID converti en String
            pstmt.setString(2, nom);
            pstmt.setString(3, synopsis);
            pstmt.setFloat(4, note);
            pstmt.setString(5, URL_image);
            pstmt.setInt(6, PrixFilm);



            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                List<String> successResponse = new ArrayList<>();
                successResponse.add("film ajoute !");
                return successResponse;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> failureResponse = new ArrayList<>();
        failureResponse.add("Échec de l'ajout.");
        return failureResponse;
    }

    @Override
    public void retirer(String identifiant) {
        String query = "DELETE FROM Films WHERE uuid = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, identifiant);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Film supprimé avec succès.");
            } else {
                System.out.println("Aucun film trouvé avec cet identifiant.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void modifier(String identifiant, String champ, String nouvelleValeur) {
        String query = "UPDATE Films SET " + champ + " = ? WHERE uuid = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, nouvelleValeur);
            pstmt.setString(2, identifiant);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Film modifié avec succès.");
            } else {
                System.out.println("Aucun film trouvé avec cet identifiant.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<String> rechercher(String critere) {
        List<String> films = new ArrayList<>();
        String query = "SELECT * FROM Films WHERE nom LIKE ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + critere + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                films.add("ID: " + rs.getInt("id") + ", Nom: " + rs.getString("nom") + ", Synopsis: " + rs.getString("Synopsis") + ", Note: " + rs.getFloat("note"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return films;
    }


    @Override
    public List<String> connecter(String uuid, String motDePasse) {
        {
            String query = "SELECT * FROM employes WHERE email = ? AND password = ?";
            List<String> userInfo = new ArrayList<>();

            try (Connection conn = Databaseconnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, uuid);
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
