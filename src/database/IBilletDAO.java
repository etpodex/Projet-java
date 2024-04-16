package database;

import Model.Billet;

import java.util.List;

public interface IBilletDAO {
    public int ajouter(String... details);
    public Billet[] rechercher(String id_client);
}
