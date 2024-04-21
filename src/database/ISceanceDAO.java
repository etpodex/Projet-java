package database;

import Model.Billet;
import Model.Sceance;

import java.util.List;

public interface ISceanceDAO {

    public int ajouter(Sceance sceance);
    public Sceance[] rechercher(String id_film);

    public int supprimer(String id_sceance);
}
