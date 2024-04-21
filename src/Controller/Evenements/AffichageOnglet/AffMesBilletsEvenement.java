package Controller.Evenements.AffichageOnglet;

import Model.Billet;

public class AffMesBilletsEvenement extends AffPVEvenement {
    private Billet[] billets;

    public AffMesBilletsEvenement() {

    }

    /**
     * Méthode pour obtenir les billets à afficher.
     * @return Les billets à afficher.
     */
    public Billet[] getBillets() {
        return billets;
    }

    /**
     * Méthode pour définir les billets à afficher.
     * @param billets Les billets à afficher.
     */
    public void setBillets(Billet[] billets) {
        this.billets = billets;
    }
}
