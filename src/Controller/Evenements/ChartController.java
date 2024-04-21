package Controller.Evenements;

import Model.ChartModel;
import View.Onglets.AccueilVueComposant.ChartView;

public class ChartController {
    private ChartModel model;  // Modèle pour les données du graphique
    private ChartView view;  // Vue pour afficher le graphique

    public ChartController() {
        model = new ChartModel();  // Initialiser le modèle
        view = new ChartView();  // Initialiser la vue
        initializeCharts();  // Appeler la méthode pour initialiser les graphiques
    }

    // Méthode privée pour initialiser les graphiques dans la vue
    private void initializeCharts() {
        // Configurer les graphiques dans la vue avec les données du modèle
        view.setCharts(model.getPieDataset(), model.getBarDataset());
    }
}
