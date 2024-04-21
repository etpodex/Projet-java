package database;
import Model.Film;

import java.util.List;
import Model.Film;

public interface IfilmDAO {
    public int ajouter(String... details);
    public Film[] rechercher(String champ, String critere);
    public int retirer(String identifiant);
    public int modifier(String identifiant, String champ, String nouvelleValeur);

    }
