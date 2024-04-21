package Controller.Evenements;

import Model.Offre;

/**
 * Cet événement représente l'ajout d'une offre dans le système.
 */
public class AjouterOffreEvenement {
    private Offre offre;  // L'offre à ajouter dans le système

    /**
     * Constructeur par défaut de l'événement d'ajout d'une offre.
     */
    public AjouterOffreEvenement() {

    }

    /**
     * Obtient l'offre à ajouter dans le système.
     *
     * @return L'offre à ajouter
     */
    public Offre getOffre() {
        return offre;
    }

    /**
     * Définit l'offre à ajouter dans le système.
     *
     * @param offre L'offre à ajouter
     */
    public void setOffre(Offre offre) {
        this.offre = offre;
    }
}
