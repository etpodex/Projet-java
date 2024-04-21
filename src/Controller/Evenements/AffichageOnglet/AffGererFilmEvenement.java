package Controller.Evenements.AffichageOnglet;

import Model.Film;

public class AffGererFilmEvenement extends AffPVEvenement {

    private Film[] films;

    public AffGererFilmEvenement() {}

    public void setFilms(Film[] films) {
        this.films = films;
    }

    public Film[] getFilms() {
        return films;
    }

}
