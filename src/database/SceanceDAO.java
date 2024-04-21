package database;

import Model.Billet;
import Model.Sceance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class SceanceDAO implements ISceanceDAO {
    public int ajouter(String... details) {
        String idFilm = details[0];
        String horaire = details[1];
        String idSalle = details[2];
        String date = details[3];
        int nbPlaceRestante = Integer.parseInt(details[4]);
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID


        String query = "INSERT INTO sceance (id_sceance,id_film, horaire, id_salle, date, nb_place_restante) VALUES (?,?, ?, ?, ?, ?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {
            recupdonne.setString(1, uuid.toString()); // UUID converti en String

            recupdonne.setString(2, idFilm);
            recupdonne.setString(3, horaire);
            recupdonne.setString(4, idSalle);
            recupdonne.setString(5, date);
            recupdonne.setInt(6, nbPlaceRestante);

            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {
                return 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Sceance[] rechercher(String id_film) {
        List<Sceance> seances = new ArrayList<>();
        // Commencer avec une requête de base
        String query = "SELECT * FROM sceance";
        // Ajouter une condition WHERE seulement si id_film n'est pas vide
        if (id_film != null && !id_film.isEmpty()) {
            query += " WHERE id_film = ?";
        }

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement donneerecup = conn.prepareStatement(query)) {

            // On ne définit le paramètre que si id_film n'est pas vide
            if (id_film != null && !id_film.isEmpty()) {
                donneerecup.setString(1, id_film);
            }

            ResultSet rs = donneerecup.executeQuery();

            while (rs.next()) {
                Sceance seance = new Sceance(0, "0", null, 0, null, 0);
                seance.setIdSceance(rs.getInt("id_sceance"));
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

        // Convert the list to an array
        return seances.toArray(new Sceance[0]);
    }

}