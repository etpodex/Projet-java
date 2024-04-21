package database;


import Model.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Arrays;

public class FilmDAO implements IfilmDAO {
    @Override
    public int ajouter(String... details) {
        String nom = details[0];
        String synopsis = details[1];
        float note = Float.parseFloat(details[2]);
        String URL_image = details[3];
        int PrixFilm = Integer.parseInt(details[4]);
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID

        String query = "INSERT INTO Films (uuid,nom,Synopsis,note,URL_image,PrixFilm) VALUES (?,?,?,?,?,?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {

            recupdonne.setString(1, uuid.toString()); // UUID converti en String
            recupdonne.setString(2, nom);
            recupdonne.setString(3, synopsis);
            recupdonne.setFloat(4, note);
            recupdonne.setString(5, URL_image);
            recupdonne.setInt(6, PrixFilm);


            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {
                List<String> successResponse = new ArrayList<>();
                successResponse.add("film ajoute !");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> failureResponse = new ArrayList<>();
        failureResponse.add("Échec de l'ajout.");
        return 1;
    }

    @Override
    public int retirer(String identifiant) {
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
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }


    @Override
    public int modifier(String identifiant, String champ, String nouvelleValeur) {
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
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }


    @Override
    public Film[] rechercher(String champ, String critere) {
        List<Film> filmList = new ArrayList<>();
        // Utilisation de "champ" pour dynamiser la requête SQL
        String query = String.format("SELECT * FROM Films WHERE %s LIKE ? ORDER BY %s ASC", champ, champ);

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, "%" + critere + "%");
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Film film = new Film();

                film.setUuid(rs.getString("uuid"));
                film.setNom(rs.getString("nom"));
                film.setSynopsis(rs.getString("synopsis"));  // Assurez-vous que la casse du "Synopsis" soit correcte selon votre base de données
                film.setNote(rs.getFloat("note"));

                filmList.add(film);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert List to Array
        Film[] filmsArray = new Film[filmList.size()];
        filmsArray = filmList.toArray(filmsArray);

        return filmsArray;
    }
}