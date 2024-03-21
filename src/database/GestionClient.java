package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionClient implements GestionBDD {
    // Implémentation des méthodes de GestionUtilisateur pour les clients
    @Override
    public List<String> connecter(String email, String password) {
        {
            String query = "SELECT * FROM Clients WHERE email = ? AND password = ?";
            List<String> userInfo = new ArrayList<>();

            try (Connection conn = Databaseconnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, email);
                pstmt.setString(2, password);
                ResultSet rs = pstmt.executeQuery();

                // Si l'utilisateur existe, ajouter ses informations à la liste
                if (rs.next()) {
                    userInfo.add("ID: " + rs.getInt("id"));
                    userInfo.add("Email: " + rs.getString("email"));
                    userInfo.add("Nom: " + rs.getString("nom"));
                    userInfo.add("Prénom: " + rs.getString("prenom"));
                    userInfo.add("Age: " + rs.getInt("age"));
                    userInfo.add("Niveau Avantage: " + rs.getInt("nvAvantage"));
                    return userInfo; // Renvoyer la liste des informations
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            // Retourner null si l'utilisateur n'existe pas
            return null;

        }
    }

    @Override
    public List<String> ajouter(String email, String password, String nom, String prenom, int age, int nvAvantage) {
        if (outildatabase.emailExists(email)) {
            List<String> response = new ArrayList<>();
            response.add("Échec de l'inscription : l'email existe déjà.");
            return response;
        }
        System.out.println("ok");
        String query = "INSERT INTO Clients (email, password, nom, prenom, age, nvAvantage) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, email);
            pstmt.setString(2, password);
            pstmt.setString(3, nom);
            pstmt.setString(4, prenom);
            pstmt.setInt(5, age);
            pstmt.setInt(6, nvAvantage);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                List<String> successResponse = new ArrayList<>();
                successResponse.add("Inscription réussie !");
                return successResponse;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<String> failureResponse = new ArrayList<>();
        failureResponse.add("Échec de l'inscription : erreur inconnue.");
        return failureResponse;
    }

    public void modifier(String email, String champ, String nouvelleValeur) {
        String query = "UPDATE Clients SET " + champ + " = ? WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set nouvelle valeur
            pstmt.setString(1, nouvelleValeur);
            // Set email
            pstmt.setString(2, email);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("L'information du client a été modifiée avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec cet email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void retirer(String clientemail) {
        String query = "DELETE FROM Clients WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, clientemail);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Le client avec l'email " + clientemail + " a été supprimé avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec l'email " + clientemail + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    /*
    public void retirer(String email) {

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
    }*/
}
