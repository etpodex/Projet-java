package Controller.Evenements.AffichageOnglet;

import Model.Billet;

public class AffPaiementEvenement extends AffPVEvenement{
    Billet billet;

    public AffPaiementEvenement() {
    }

    public Billet getBillet() {
        return billet;
    }

    public void setBillet(Billet billet) {
        this.billet = billet;
    }
}
