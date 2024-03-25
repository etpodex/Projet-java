package database;

import java.util.List;

public interface IBilletDAO {
    public List<String> ajouter(String... details);
    public List<String> rechercher(String critere);

}
