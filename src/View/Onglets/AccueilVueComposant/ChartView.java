package View.Onglets.AccueilVueComposant;

import Model.ChartModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import javax.swing.*;
import java.awt.*;

/**
 * La classe ChartView représente la vue des graphiques en camembert et en barres.
 */
public class ChartView extends JPanel {
    private ChartPanel pieChartPanel;  // Panneau pour le graphique en camembert
    private ChartPanel barChartPanel;  // Panneau pour le graphique en barres

    /**
     * Constructeur de la classe ChartView.
     */
    public ChartView() {
        setLayout(new GridLayout(1, 2));  // Définit la disposition pour les graphiques
        setMinimumSize(new Dimension(400, 300)); // Assure qu'il ne devienne pas trop petit

        // Initialiser les graphiques avec les ensembles de données du modèle
        ChartModel model = new ChartModel();
        setCharts(model.getPieDataset(), model.getBarDataset());

        add(pieChartPanel);  // Ajouter le graphique en camembert au panneau
        add(barChartPanel);  // Ajouter le graphique en barres au panneau
    }

    /**
     * Définit un graphique en camembert dans le panneau.
     *
     * @param pieDataset Le jeu de données du graphique en camembert.
     * @param barDataset Le jeu de données du graphique en barres.
     */
    public void setCharts(DefaultPieDataset pieDataset, DefaultCategoryDataset barDataset) {

        JFreeChart piechart = ChartFactory.createPieChart("Tendance Film", pieDataset, true, true, false);
        pieChartPanel = new ChartPanel(piechart);
        pieChartPanel.setChart(piechart);
        pieChartPanel.revalidate();
        pieChartPanel.repaint();

        JFreeChart barchart = ChartFactory.createBarChart("Tendance Film", "Film", "Score", barDataset);
        barChartPanel = new ChartPanel(barchart);
        barChartPanel.setChart(barchart);
        barChartPanel.revalidate();
        barChartPanel.repaint();

        removeAll();
        add(pieChartPanel);
        add(barChartPanel);
        revalidate();  // Revalider pour refléter les changements de mise en page
        repaint();  // Redessiner le composant
    }
}
