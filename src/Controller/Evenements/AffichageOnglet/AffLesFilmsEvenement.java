package Controller.Evenements.AffichageOnglet;

import Model.Film;

public class AffLesFilmsEvenement extends AffPVEvenement {

    // estelle
    Film[] films;
    public AffLesFilmsEvenement() {

    }

    public Film[] getFilms() {
        return films;
    }

    public void setFilms(Film[] films) {
        this.films = films;
    }
}
