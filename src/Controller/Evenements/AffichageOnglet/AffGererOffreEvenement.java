package Controller.Evenements.AffichageOnglet;

import Model.Offre;

public class AffGererOffreEvenement extends AffPVEvenement {
    Offre[] offres;
    public AffGererOffreEvenement() {

    }

    public Offre[] getOffres() {
        return offres;
    }

    public void setOffres(Offre[] offres) {
        this.offres = offres;
    }
}
