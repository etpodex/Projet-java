package Controller.Evenements.AffichageOnglet;

import Model.Billet;

/**
 * La classe AffPaiementEvenement sert à afficher la page de paiement en transmettant les variables necessaires.
 */
public class AffPaiementEvenement extends AffPVEvenement{
    Billet billet;

    public AffPaiementEvenement() {
    }

    /**
     * Méthode pour obtenir le billet à afficher.
     * @return Le billet à afficher.
     */
    public Billet getBillet() {
        return billet;
    }

    /**
     * Méthode pour définir le billet à afficher.
     * @param billet Le billet à afficher.
     */
    public void setBillet(Billet billet) {
        this.billet = billet;
    }
}
