package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class outildatabase {
    public static boolean emailExists(String email) {
        String query = "SELECT id FROM Clients WHERE email = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            return pstmt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void retirer(String email) {

        // Premièrement, essayons de supprimer de la table Clients
        String queryClients = "DELETE FROM Clients WHERE email = ?";
        // Ensuite, de la table Employe
        String queryEmploye = "DELETE FROM Employes WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmtClients = conn.prepareStatement(queryClients);
             PreparedStatement pstmtEmploye = conn.prepareStatement(queryEmploye)) {

            pstmtClients.setString(1, email);//defini le ? dans la requete sql
            pstmtEmploye.setString(1, email);//defini le ? dans la requete sql

            // Exécute la commande SQL et donne le nb de ligne affecté
            int affectedRowsClients = pstmtClients.executeUpdate();

            if (affectedRowsClients > 0) {
                System.out.println("Le client avec l'email " + email + " a été supprimé avec succès.");
            } else {
                // Si aucun client n'est supprimé, vérifiez les employés
                int affectedRowsEmploye = pstmtEmploye.executeUpdate();

                if (affectedRowsEmploye > 0) {
                    System.out.println("L'employé avec l'email " + email + " a été supprimé avec succès.");
                } else {
                    System.out.println("Aucune personne trouvée avec l'email " + email + ".");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
