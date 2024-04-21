package database;

import Model.Sceance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class provides methods to interact with the database for managing movie showtimes (séances).
 */
public class SceanceDAO implements ISceanceDAO {

    /**
     * Adds a new movie showtime (séance) to the database.
     *
     * @param sceance The movie showtime object to add.
     * @return 1 if the addition is successful, otherwise 0.
     */
    public int ajouter(Sceance sceance) {
        // Extract information from the sceance object
        String idFilm = sceance.getIdFilm();
        String horaire = sceance.getHoraire();
        String idSalle = String.valueOf(sceance.getIdSalle());
        String date = sceance.getDate();
        int nbPlaceRestante = sceance.getNbPlaceRestante();
        UUID uuid = UUID.randomUUID(); // Generate a new UUID

        // SQL query to insert the sceance into the database
        String query = "INSERT INTO sceance (id_sceance, id_film, horaire, id_salle, date, nb_place_restante) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {
            recupdonne.setString(1, uuid.toString()); // Convert UUID to String
            recupdonne.setString(2, idFilm);
            recupdonne.setString(3, horaire);
            recupdonne.setString(4, idSalle);
            recupdonne.setString(5, date);
            recupdonne.setInt(6, nbPlaceRestante);

            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {
                return 1; // Successful addition
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Addition failed
    }

    /**
     * Searches for movie showtimes (séances) based on the given film ID.
     *
     * @param id_film The ID of the film to search for showtimes.
     * @return An array of movie showtimes matching the search criteria.
     */
    @Override
    public Sceance[] rechercher(String id_film) {
        List<Sceance> seances = new ArrayList<>();

        // Start with a basic query
        String query = "SELECT * FROM sceance";

        // Add a WHERE condition only if id_film is not empty
        if (id_film != null && !id_film.isEmpty()) {
            query += " WHERE id_film = ?";
        }

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement donneerecup = conn.prepareStatement(query)) {

            // Set the parameter only if id_film is not empty
            if (id_film != null && !id_film.isEmpty()) {
                donneerecup.setString(1, id_film);
            }

            ResultSet rs = donneerecup.executeQuery();

            while (rs.next()) {
                // Create a new Sceance object and populate it with data from the database
                Sceance seance = new Sceance("", "0", null, 0, null, 0);
                seance.setIdSceance(rs.getString("id_sceance"));
                seance.setIdFilm(rs.getString("id_film"));
                seance.setHoraire(rs.getString("horaire"));
                seance.setIdSalle(rs.getInt("id_salle"));
                seance.setDate(rs.getString("date"));
                seance.setNbPlaceRestante(rs.getInt("nb_place_restante"));

                seances.add(seance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert the list to an array before returning
        return seances.toArray(new Sceance[0]);
    }

    /**
     * Deletes a movie showtime (séance) from the database based on the given showtime ID.
     *
     * @param id_sceance The ID of the showtime to delete.
     * @return 1 if the deletion is successful, otherwise 0.
     */
    @Override
    public int supprimer(String id_sceance) {
        String query = "DELETE FROM sceance WHERE id_sceance = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement donneerecup = conn.prepareStatement(query)) {
            donneerecup.setString(1, id_sceance);

            int affectedRows = donneerecup.executeUpdate();
            if (affectedRows > 0) {
                return 1; // Deletion successful
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0; // Deletion failed
    }
}
