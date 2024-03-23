package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Arrays;

public class FilmDAO implements IfilmDAO{
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
}
