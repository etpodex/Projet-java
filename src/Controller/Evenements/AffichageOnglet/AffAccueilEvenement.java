package Controller.Evenements.AffichageOnglet;

import Model.Offre;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


/**
 * La classe AffAccueilEvenement sert à afficher la page d'accueil en transmettant les variables necessaires.
 */
public class AffAccueilEvenement extends AffPVEvenement {

    DefaultPieDataset pieDataset;
    DefaultCategoryDataset barDataset;
    Offre[] offres;

    public AffAccueilEvenement() {}

    /**
     * Méthode pour définir les offres à afficher.
     * @param offres Les offres à afficher.
     */
    public void setOffres(Offre[] offres) {
        this.offres = offres;
    }

    /**
     * Méthode pour obtenir les offres à afficher.
     * @return Les offres à afficher.
     */
    public Offre[] getOffres() {
        return offres;
    }

    /**
     * Méthode pour définir le jeu de données du graphique circulaire.
     * @param pieDataset Le jeu de données du graphique circulaire.
     */
    public void setPieDataset(DefaultPieDataset pieDataset) {
        this.pieDataset = pieDataset;
    }

    /**
     * Méthode pour définir le jeu de données du graphique à barres.
     * @param barDataset Le jeu de données du graphique à barres.
     */
    public void setBarDataset(DefaultCategoryDataset barDataset) {
        this.barDataset = barDataset;
    }

    /**
     * Méthode pour obtenir les jeux de données des graphiques.
     * @return Les jeux de données des graphiques.
     */
    public Object[] getDatasets() {
        return new Object[]{pieDataset, barDataset};
    }
}
