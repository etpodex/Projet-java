package Controller.Evenements.AffichageOnglet;

import Model.Billet;

public class AffMesBilletsEvenement extends AffPVEvenement {
    private Billet[] billets;

    public AffMesBilletsEvenement() {

    }

    public Billet[] getBillets() {
        return billets;
    }

    public void setBillets(Billet[] billets) {
        this.billets = billets;
    }
}
