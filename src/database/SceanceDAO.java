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
    public int ajouter(String... details){
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
    public Sceance[] rechercher(String id_Sceance) {
        List<Sceance> sceances = new ArrayList<>();
        String query = "SELECT * FROM sceance WHERE id_sceance = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement donneerecup = conn.prepareStatement(query)) {

            donneerecup.setString(1, id_Sceance);
            ResultSet rs = donneerecup.executeQuery();

            while (rs.next()) {
                Sceance sceance = new Sceance(0, 0, null, 0, null, 0);
                sceance.setIdSceance(rs.getInt("id_sceance"));
                sceance.setIdFilm(rs.getInt("id_film"));
                sceance.setHoraire(rs.getString("horaire"));
                sceance.setIdSalle(rs.getInt("id_salle"));
                sceance.setDate(rs.getString("date"));
                sceance.setNbPlaceRestante(rs.getInt("nb_place_restante"));

                sceances.add(sceance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert the list to an array
        return sceances.toArray(new Sceance[0]);
    }
}
