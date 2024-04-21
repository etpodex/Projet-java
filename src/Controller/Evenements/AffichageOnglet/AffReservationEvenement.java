package Controller.Evenements.AffichageOnglet;

import Model.Film;
import Model.Offre;
import Model.Sceance;

/**
 * La classe AffReservationEvenement sert à afficher la page de réservation en transmettant les variables necessaires.

 */
public class AffReservationEvenement extends AffPVEvenement {
    private Sceance[] liste_seance;
    private Offre[] liste_offre;
    private Film film;

    /**
     * Méthode pour obtenir le film concerné.
     * @return Le film à afficher.
     */
    public Film getFilm (){
        return film;
    }

    /**
     * Méthode pour obtenir les séances à afficher.
     * @return Les séances à afficher.
     */
    public Sceance[] getSeances (){
        return liste_seance;
    }

    /**
     * Méthode pour obtenir les offres à afficher.
     * @return Les offres à afficher.
     */
    public Offre[] getOffres (){
        return liste_offre;
    }

    /**
     * Méthode pour définir les séances à afficher.
     * @param liste_seance Les séances à afficher.
     */
    public void setReservation(Sceance[] liste_seance){
        this.liste_seance = liste_seance;
    }

    /**
     * Méthode pour définir le film à afficher.
     * @param film Le film à afficher.
     */
    public void setFilm(Film film){
        this.film = film;
    }

    /**
     * Méthode pour définir les offres à afficher.
     * @param liste_offre Les offres à afficher.
     */
    public void setOffre(Offre[] liste_offre){
        this.liste_offre = liste_offre;
    }
}
