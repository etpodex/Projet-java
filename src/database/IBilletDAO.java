package database;

import Model.Billet;

import java.util.List;

public interface IBilletDAO {
    public List<String> ajouter(String... details);
    public Billet[] rechercher(String id_client);
}
