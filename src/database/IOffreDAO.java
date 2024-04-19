package database;

import Model.Offre;

import java.util.List;

public interface IOffreDAO {
    public int ajouter(String nom_offre, int reduction, String code_promo);

    public Offre[] rechercher(String id_promo);
}
