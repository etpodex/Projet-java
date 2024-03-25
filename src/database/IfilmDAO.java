package database;
import java.util.List;

public interface IfilmDAO {
    public List<String> ajouter(String... details);
    public List<String> rechercher(String critere);
    public void retirer(String identifiant);
    public void modifier(String identifiant, String champ, String nouvelleValeur);

    }
