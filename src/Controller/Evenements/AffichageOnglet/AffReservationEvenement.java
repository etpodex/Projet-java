package Controller.Evenements.AffichageOnglet;

import Model.Film;
import Model.Offre;
import Model.Sceance;

public class AffReservationEvenement extends AffPVEvenement {
    private Sceance[] liste_seance;
    private Offre[] liste_offre;
    private Film film;

    public Film getFilm (){
        return film;
    }

    public Sceance[] getSeances (){
        return liste_seance;
    }

    public Offre[] getOffres (){
        return liste_offre;
    }

    public void setReservation(Sceance[] liste_seance){
        this.liste_seance = liste_seance;
    }

    public void setFilm(Film film){
        this.film = film;
    }

    public void setOffre(Offre[] liste_offre){
        this.liste_offre = liste_offre;
    }
}
