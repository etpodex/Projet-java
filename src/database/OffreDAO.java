package database;


import Model.Offre;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OffreDAO implements IOffreDAO{
    @Override
    public int ajouter(String nom_offre, int reduction, String code_promo) {

        String query = "INSERT INTO billet (nom_offre,reduction,code_promoe) VALUES (?,?,?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {

            recupdonne.setString(1, nom_offre); // UUID converti en String
            recupdonne.setString(2, String.valueOf(reduction));
            recupdonne.setString(3, code_promo);

            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {

                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }


    @Override
    public Offre[] rechercher(String id_promo) {
        List<Offre> offreList = new ArrayList<>();

        // La requête de base sélectionne tout
        String query = "SELECT nom, reduction, code_promo FROM offre";

        // Si id_promo n'est pas vide, on ajoute une condition WHERE
        if (id_promo != null && !id_promo.isEmpty()) {
            query += " WHERE code_promo LIKE ?";
        }

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // On ne définit le paramètre que si id_promo n'est pas vide
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


    @Override
    public int retirer(String id_promo) {
        String query = "DELETE FROM offre WHERE code_promo = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id_promo);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("offre supprimé avec succès.");
            } else {
                System.out.println("Aucun offre trouvé avec cet identifiant.");
            }
            return 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return 1;
        }
    }
}
