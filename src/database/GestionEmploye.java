package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GestionEmploye implements GestionBDD {
    // Les employés n'ont peut-être pas les mêmes champs ou méthodes d'inscription et de connexion que les clients
    @Override
    public List<String> connecter(String email, String motDePasse) {
        {
            String query = "SELECT * FROM employes WHERE email = ? AND password = ?";
            List<String> userInfo = new ArrayList<>();

            try (Connection conn = Databaseconnection.getConnection();
                 PreparedStatement pstmt = conn.prepareStatement(query)) {

                pstmt.setString(1, email);
                pstmt.setString(2, motDePasse);
                ResultSet rs = pstmt.executeQuery();

                // Si l'utilisateur existe, ajouter ses informations à la liste
                if (rs.next()) {
                    userInfo.add("Email: " + rs.getString("email"));
                    userInfo.add("Nom: " + rs.getString("nom"));
                    userInfo.add("Prénom: " + rs.getString("prenom"));
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

    /*@Override
    public void retirer(String email) {
        // Ici, implémenter la logique pour retirer un employé de la base de données
        // Partie de la méthode retirerUtilisateur() de GestionnairedeCompte spécifique aux employés
    }*/

    public void modifier(String email, String champ, String nouvelleValeur) {
        String query = "UPDATE Employes SET " + champ + " = ? WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set nouvelle valeur
            pstmt.setString(1, nouvelleValeur);
            // Set email
            pstmt.setString(2, email);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("L'information de l'employe a été modifiée avec succès.");
            } else {
                System.out.println("Aucun employe trouvé avec cet email.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void retirer(String employeemail) {
        String query = "DELETE FROM Employes WHERE email = ?";

        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, employeemail);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Le client avec l'email " + employeemail + " a été supprimé avec succès.");
            } else {
                System.out.println("Aucun client trouvé avec l'email " + employeemail + ".");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}