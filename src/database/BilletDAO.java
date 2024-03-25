package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BilletDAO implements IBilletDAO{
    @Override
    public List<String> ajouter(String... details) {
        String id_client = details[0];
        String id_sceance = details[1];
        float prix_commande =Float.parseFloat(details[2]);
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID

        String query = "INSERT INTO Commande (id_commande,id_client,id_sceance,prix_commande) VALUES (?,?,?,?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {

            recupdonne.setString(1, uuid.toString()); // UUID converti en String
            recupdonne.setString(2, id_client);
            recupdonne.setString(3, id_sceance);
            recupdonne.setFloat(4, prix_commande);

            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {
                List<String> successResponse = new ArrayList<>();
                successResponse.add("Billet ajoute !");
                return successResponse;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> failureResponse = new ArrayList<>();
        failureResponse.add("Échec billet non ajouté.");
        return failureResponse;
    }


    @Override
    public List<String> rechercher(String critere) {
        List<String> films = new ArrayList<>();
        String query = "SELECT * FROM commande WHERE id_client LIKE ?";

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
}
