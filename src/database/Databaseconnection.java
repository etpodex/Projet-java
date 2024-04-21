package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class provides a utility method to establish a connection to the database.
 */
public class Databaseconnection {
    private static final String URL = "jdbc:mysql://localhost:3306/cinemaprojet"; // Replace with your DB URL
    private static final String USER = "root"; // Replace with your DB username
    private static final String PASSWORD = "Direct1963!"; // Replace with your DB password

    private static final Logger LOGGER = Logger.getLogger(Databaseconnection.class.getName());

    /**
     * Establishes a connection to the database.
     *
     * @return A Connection object representing the connection to the database.
     *         Returns null if an error occurs during the connection process.
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error connecting to the database", e);
        }
        return connection;
    }
}
