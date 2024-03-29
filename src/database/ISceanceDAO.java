package database;

import Model.Billet;
import Model.Sceance;

import java.util.List;

public interface ISceanceDAO {

    public List<String> ajouter(String... details);
    public Sceance[] rechercher(String id_Sceance);
}
