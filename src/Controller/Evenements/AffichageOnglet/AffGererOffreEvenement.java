package Controller.Evenements.AffichageOnglet;

import Model.Offre;

/**
 * La classe AffGererOffreEvenement sert à afficher la page de gestion des offres en transmettant les variables necessaires.
 */
public class AffGererOffreEvenement extends AffPVEvenement {
    Offre[] offres;
    public AffGererOffreEvenement() {

    }

    /**
     * Méthode pour obtenir les offres à afficher.
     * @return Les offres à afficher.
     */
    public Offre[] getOffres() {
        return offres;
    }

    /**
     * Méthode pour définir les offres à afficher.
     * @param offres Les offres à afficher.
     */
    public void setOffres(Offre[] offres) {
        this.offres = offres;
    }
}
