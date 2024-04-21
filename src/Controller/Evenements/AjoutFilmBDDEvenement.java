package Controller.Evenements;

import Model.Film;

/**
 * Cet événement représente l'ajout d'un film dans la base de données.
 */
public class AjoutFilmBDDEvenement {

    private Film film;  // Film à ajouter dans la base de données

    /**
     * Définit le film à ajouter dans la base de données.
     *
     * @param film Le film à ajouter
     */
    public void setFilm(Film film) {
        this.film = film;
    }

    /**
     * Obtient le film à ajouter dans la base de données.
     *
     * @return Le film à ajouter
     */
    public Film getFilm() {
        return film;
    }
}
