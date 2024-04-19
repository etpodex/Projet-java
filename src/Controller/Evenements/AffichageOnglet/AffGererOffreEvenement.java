package Controller.Evenements.AffichageOnglet;

import Model.Offre;

public class AffGererOffreEvenement extends AffPVEvenement {
    Offre[] offres;
    public AffGererOffreEvenement() {

    }

    public Offre[] getFilms() {
        return offres;
    }

    public void setFilms(Offre[] films) {
        this.offres = films;
    }
}
