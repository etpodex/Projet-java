package database;
import Model.Utilisateur;
import java.util.List;
public interface IUtilisateurDAO {
    abstract List<String> connecter(String email, String motDePasse);
    List<String> ajouter(String... details);
    void retirer(String email);
    void modifier(String email, String champ, String nouvelleValeur);
    List<Utilisateur> rechercher(String... details);
}
