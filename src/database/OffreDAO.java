package database;

import Model.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class provides methods to interact with the database for managing offers.
 */
public class OffreDAO implements IOffreDAO {

    /**
     * Adds an offer to the database.
     *
     * @param offre The offer to add to the database.
     * @return 0 if the addition is successful, otherwise 1.
     */
    @Override
    public int ajouter(Offre offre) {
        // SQL query to insert an offer into the database
        String query = "INSERT INTO offre (nom, reduction, code_promo) VALUES (?, ?, ?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {

            // Set parameters for the query
            recupdonne.setString(1, offre.getNom_promo());
            recupdonne.setString(2, String.valueOf(offre.getReduction()));
            recupdonne.setString(3, offre.getCode_promo());

            // Execute the query
            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {
                return 0; // Successful addition
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1; // Failed addition
    }

    /**
     * Searches for offers in the database.
     *
     * @param id_promo The promo code to search for. If null or empty, returns all offers.
     * @return An array of offers corresponding to the search.
     */
    @Override
    public Offre[] rechercher(String id_promo) {
        List<Offre> offreList = new ArrayList<>();

        // Base query selects everything
        String query = "SELECT nom, reduction, code_promo FROM offre";

        // If id_promo is not empty, add a WHERE condition
        if (id_promo != null && !id_promo.isEmpty()) {
            query += " WHERE code_promo LIKE ?";
        }

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the parameter only if id_promo is not empty
            if (id_promo != null && !id_promo.isEmpty()) {
                pstmt.setString(1, "%" + id_promo + "%");
            }

            ResultSet rsCommande = pstmt.executeQuery();

            while (rsCommande.next()) {
                String nom = rsCommande.getString("nom");
                int reduction = rsCommande.getInt("reduction");
                String code_promo = rsCommande.getString("code_promo");

                Offre offre = new Offre();

                offre.setCode_promo(code_promo);
                offre.setReduction(reduction);
                offre.setNom_promo(nom);

                offreList.add(offre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert the list to an array before returning
        Offre[] offresArrays = new Offre[offreList.size()];
        return offreList.toArray(offresArrays);
    }

    /**
     * Removes an offer from the database.
     *
     * @param id_promo The promo code of the offer to remove.
     * @return 0 if the removal is successful, otherwise 1.
     */
    @Override
    public int retirer(String id_promo) {
        // SQL query to delete an offer from the database
        String query = "DELETE FROM offre WHERE code_promo = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the parameter for the query
            pstmt.setString(1, id_promo);

            // Execute the query
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Offer deleted successfully.");
            } else {
                System.out.println("No offer found with this identifier.");
            }
            return 0; // Successful removal
        } catch (SQLException e) {
            e.printStackTrace();
            return 1; // Failed removal
        }
    }
}
