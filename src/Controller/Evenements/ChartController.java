package Controller.Evenements;

import Model.ChartModel;
import View.Onglets.AccueilVueComposant.ChartView;

/**
 * Cette classe est responsable de la gestion des graphiques dans l'application.
 */
public class ChartController {
    private ChartModel model;  // Modèle pour les données du graphique
    private ChartView view;  // Vue pour afficher le graphique

    /**
     * Constructeur de la classe ChartController.
     * Initialise le modèle et la vue, puis initialise les graphiques.
     */
    public ChartController() {
        model = new ChartModel();  // Initialiser le modèle
        view = new ChartView();  // Initialiser la vue
        initializeCharts();  // Appeler la méthode pour initialiser les graphiques
    }

    /**
     * Méthode privée pour initialiser les graphiques dans la vue avec les données du modèle.
     */
    private void initializeCharts() {
        // Configurer les graphiques dans la vue avec les données du modèle
        view.setCharts(model.getPieDataset(), model.getBarDataset());
    }
}
