package database;
import java.util.List;
import Model.Film;

public interface IfilmDAO {
    public int ajouter(String... details);
    public Film[] rechercher(String critere);
    public int retirer(String identifiant);
    public int modifier(String identifiant, String champ, String nouvelleValeur);

    }
