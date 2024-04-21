package database;

import Model.Offre;

import java.util.List;

public interface IOffreDAO {
    public int ajouter(Offre offre);
    public Offre[] rechercher(String id_promo);
    public int retirer(String id_promo);
}
