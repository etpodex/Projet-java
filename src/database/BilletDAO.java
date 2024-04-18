package database;

import Model.Billet;
import Model.Film;
import Model.Utilisateur;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BilletDAO implements IBilletDAO{
    @Override
    public int ajouter(String... details) {
        String id_utilisateur = details[0];
        String id_sceance = details[1];
        String id_film = details[2];
        float prix_commande =Float.parseFloat(details[3]);
        int nombreBilletSenior = Integer.parseInt(details[4]);
        int nombreBilletEnfant = Integer.parseInt(details[5]);
        int nombreBilletAdulte = Integer.parseInt(details[6]);
        String siegeBillet = details[7];
        UUID uuid = UUID.randomUUID(); // Générer un nouvel UUID

        String query = "INSERT INTO billet (id_billet,id_sceance,id_film,id_utilisateur,prixcommande,nombreBilletSenior,nombreBilletEnfant,nombreBilletAdulte,siegeBillet) VALUES (?,?,?,?,?,?,?,?,?)";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement recupdonne = conn.prepareStatement(query)) {

            recupdonne.setString(1, uuid.toString()); // UUID converti en String
            recupdonne.setString(2, id_sceance);
            recupdonne.setString(3, id_film);
            recupdonne.setString(4, id_utilisateur);
            recupdonne.setFloat(5, prix_commande);
            recupdonne.setFloat(6, nombreBilletSenior);
            recupdonne.setFloat(7, nombreBilletEnfant);
            recupdonne.setFloat(8, nombreBilletAdulte);
            recupdonne.setString(9, siegeBillet);


            int affectedRows = recupdonne.executeUpdate();
            if (affectedRows > 0) {
                List<String> successResponse = new ArrayList<>();
                successResponse.add("Billet ajoute !");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 1;
    }


    @Override
    public Billet[] rechercher(String id_client) {
        List<Billet> billetsList = new ArrayList<>();

        String query = "SELECT id_sceance, id_film, id_utilisateur,id_billet, nombreBilletAdulte, nombreBilletEnfant, nombreBilletSenior, prixcommande,siegeBillet FROM billet WHERE id_utilisateur = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, id_client);
            ResultSet rsCommande = pstmt.executeQuery();

            while (rsCommande.next()) {
                String id_film = rsCommande.getString("id_film");
                String id_billet = rsCommande.getString("id_billet");
                int id_sceance = rsCommande.getInt("id_sceance");
                String id_utilisateur = rsCommande.getString("id_utilisateur");
                int nombreBilletAdulte = rsCommande.getInt("nombreBilletAdulte");
                int nombreBilletEnfant = rsCommande.getInt("nombreBilletEnfant");
                int nombreBilletSenior = rsCommande.getInt("nombreBilletSenior");
                String siegeBillet = rsCommande.getString("siegeBillet");

                String queryFilm = "SELECT nom, URL_image FROM films WHERE uuid = ?";
                String querySceance = "SELECT horaire, date FROM sceance WHERE id_sceance = ?";

                Billet billet = new Billet();

                try (PreparedStatement pstmtFilm = conn.prepareStatement(queryFilm);
                     PreparedStatement pstmtSceance = conn.prepareStatement(querySceance)) {
                    pstmtFilm.setString(1, id_film);
                    ResultSet rsFilm = pstmtFilm.executeQuery();

                    if (rsFilm.next()) {
                        billet.setTitreFilm(rsFilm.getString("nom"));
                        billet.setUrlImageFilm(rsFilm.getString("URL_image"));
                    }

                    pstmtSceance.setInt(1, id_sceance);
                    ResultSet rsSceance = pstmtSceance.executeQuery();

                    if (rsSceance.next()) {
                        billet.setHeureSeance(rsSceance.getString("horaire"));
                        billet.setDateSeance(rsSceance.getString("date"));
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                billet.setNombreBilletSenior(nombreBilletSenior);
                billet.setNombreBilletAdulte(nombreBilletAdulte);
                billet.setNombreBilletEnfant(nombreBilletEnfant);
                billet.setsiegeBillet(siegeBillet);

                billetsList.add(billet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Convert the list to an array before returning
        Billet[] billetsArray = new Billet[billetsList.size()];
        return billetsList.toArray(billetsArray);
    }

}
