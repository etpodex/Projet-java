package Model;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class ChartModel {
    private DefaultPieDataset pieDataset;  // Ensemble de données pour le graphique en camembert
    private DefaultCategoryDataset barDataset;  // Ensemble de données pour le graphique en barres

    // Constructeur pour initialiser les ensembles de données
    public ChartModel() {
        createPieDataset();  // Créer l'ensemble de données pour le graphique en camembert
        createBarDataset();  // Créer l'ensemble de données pour le graphique en barres
    }

    // Méthode privée pour créer l'ensemble de données pour le graphique en camembert
    private void createPieDataset() {
        pieDataset = new DefaultPieDataset();  // Initialiser l'ensemble de données
        // Ajouter des valeurs à l'ensemble de données
        pieDataset.setValue("Dune", 33.2);
        pieDataset.setValue("Kung Fu Panda", 50.9);
        pieDataset.setValue("Catégorie 3", 15.9);
    }

    // Méthode privée pour créer l'ensemble de données pour le graphique en barres
    private void createBarDataset() {
        barDataset = new DefaultCategoryDataset();  // Initialiser l'ensemble de données
        // Ajouter des valeurs à l'ensemble de données
        barDataset.addValue(3.0, "Dune", "Colonne 1");
        barDataset.addValue(5.0, "Kung Fu Panda", "Colonne 2");
        barDataset.addValue(1.0, "Catégorie 3", "Colonne 3");
    }

    // Méthode publique pour obtenir l'ensemble de données du graphique en camembert
    public DefaultPieDataset getPieDataset() {
        return pieDataset;
    }

    // Méthode publique pour obtenir l'ensemble de données du graphique en barres
    public DefaultCategoryDataset getBarDataset() {
        return barDataset;
    }
}
