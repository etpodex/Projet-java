package Controller.Evenements;

/**
 * Cette classe représente un événement déclenché lorsqu'un film doit être effacé.
 */
public class EffacerFilmEvenement {
    private String idFilm;

    /**
     * Constructeur de la classe EffacerFilmEvenement.
     *
     * @param idFilm L'identifiant du film à effacer.
     */
    public EffacerFilmEvenement(String idFilm) {
        this.idFilm = idFilm;
    }

    /**
     * Obtient l'identifiant du film à effacer.
     *
     * @return L'identifiant du film à effacer.
     */
    public String getIdFilm() {
        return idFilm;
    }
}
