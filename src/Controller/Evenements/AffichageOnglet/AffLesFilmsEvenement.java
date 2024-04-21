package Controller.Evenements.AffichageOnglet;

import Model.Film;

/**
 * La classe AffLesFilmsEvenement sert à afficher la page de gestion des films en transmettant les variables necessaires.
 */
public class AffLesFilmsEvenement extends AffPVEvenement {

    // estelle
    Film[] films;
    public AffLesFilmsEvenement() {

    }

    /**
     * Méthode pour obtenir les films à afficher.
     * @return Les films à afficher.
     */
    public Film[] getFilms() {
        return films;
    }

    /**
     * Méthode pour définir les films à afficher.
     * @param films Les films à afficher.
     */
    public void setFilms(Film[] films) {
        this.films = films;
    }
}
