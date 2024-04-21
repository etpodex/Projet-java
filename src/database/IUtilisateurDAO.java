package database;
import Model.Utilisateur;
import java.util.List;
public interface IUtilisateurDAO {
    abstract Utilisateur connecter(String email, String motDePasse);
    int ajouter(Utilisateur utilisateur);
    void retirer(String email);
    void modifier(Utilisateur utilisateur);
    List<Utilisateur> rechercher(String... details);
}
