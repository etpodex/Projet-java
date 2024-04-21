package Controller.Evenements.AffichageOnglet;

import Model.Film;
import Model.Sceance;

public class AffReservationEvenement extends AffPVEvenement {
    private Sceance[] liste_seance;
    private Film film;

    public Film getFilm (){
        return film;
    }

    public Sceance[] getSeances (){
        return liste_seance;
    }

    public void setReservation(Sceance[] liste_seance){
        this.liste_seance = liste_seance;
    }

    public void setFilm(Film film){
        this.film = film;
    }
}
