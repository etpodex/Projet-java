package View.Onglets.AccueilVueComposant;

import Model.ChartModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.*;
import java.awt.*;

public class ChartView extends JPanel {
    private ChartPanel pieChartPanel;  // Panneau pour le graphique en camembert
    private ChartPanel barChartPanel;  // Panneau pour le graphique en barres

    public ChartView() {
        setLayout(new GridLayout(1, 2));  // Définit la disposition pour les graphiques
        setMinimumSize(new Dimension(400, 300)); // Assure qu'il ne devienne pas trop petit

        // Initialiser les graphiques avec les ensembles de données du modèle
        ChartModel model = new ChartModel();
        setPieChart(model.getPieDataset());  // Afficher le graphique en camembert
        setBarChart(model.getBarDataset());  // Afficher le graphique en barres
    }

    public void setPieChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart("Graphique en Camembert", dataset, true, true, false);
        pieChartPanel = new ChartPanel(chart);
        add(pieChartPanel);  // Ajouter le graphique en camembert au panneau
        revalidate();  // Revalider pour refléter les changements de mise en page
        repaint();  // Redessiner le composant
    }

    public void setBarChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart("Graphique en Barres", "Catégorie", "Score", dataset);
        barChartPanel = new ChartPanel(chart);
        add(barChartPanel);  // Ajouter le graphique en barres au panneau
        revalidate();  // Revalider pour refléter les changements de mise en page
        repaint();  // Redessiner le composant
    }
}
