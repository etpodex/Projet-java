package Controller.Evenements.AffichageOnglet;

import Model.Sceance;

public class AffGererSeanceEvenement extends AffPVEvenement {

    Sceance[] sceances;

    public AffGererSeanceEvenement() {}

    public Sceance[] getSceances() {
        return sceances;
    }

    public void setSceances(Sceance[] sceances) {
        this.sceances = sceances;
    }
}
