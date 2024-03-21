package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public interface GestionBDD {
    List<String> connecter(String email, String motDePasse);
    List<String> ajouter(String... details);
    void retirer(String email);
    void modifier(String email, String champ, String nouvelleValeur);
    public List<String> rechercher(String critere);
}
