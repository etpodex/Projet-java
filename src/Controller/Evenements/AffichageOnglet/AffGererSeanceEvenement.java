package Controller.Evenements.AffichageOnglet;

import Model.Sceance;

/**
 * La classe AffGererSeanceEvenement sert à afficher la page de gestion des séances en transmettant les variables necessaires.
 */
public class AffGererSeanceEvenement extends AffPVEvenement {

    Sceance[] sceances;

    public AffGererSeanceEvenement() {}

    /**
     * Méthode pour obtenir les séances à afficher.
     * @return Les séances à afficher.
     */
    public Sceance[] getSceances() {
        return sceances;
    }

    /**
     * Méthode pour définir les séances à afficher.
     * @param sceances Les séances à afficher.
     */
    public void setSceances(Sceance[] sceances) {
        this.sceances = sceances;
    }
}
