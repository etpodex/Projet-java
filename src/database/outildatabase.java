package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * This class provides utility methods for database operations.
 */
public class outildatabase {

    /**
     * Checks if an email exists in the database.
     *
     * @param email The email to check.
     * @return True if the email exists in the database, false otherwise.
     */
    public static boolean emailExists(String email) {
        // SQL query to select UUID from the 'utilisateur' table where email matches
        String query = "SELECT uuid FROM utilisateur WHERE email = ?";
        try (Connection conn = Databaseconnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Set the parameter for the query
            pstmt.setString(1, email);

            // Execute the query and return true if a result is found, false otherwise
            return pstmt.executeQuery().next();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
