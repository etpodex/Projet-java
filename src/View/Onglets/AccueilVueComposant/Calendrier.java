package View.Onglets.AccueilVueComposant;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * La classe Calendrier représente un panneau pour afficher des graphiques.
 */
public class Calendrier extends JPanel {

    private ChartView chartView;  // Référence à la vue du graphique

    /**
     * Constructeur de la classe Calendrier.
     *
     * @param barre_navigation_panel_width La largeur de la barre de navigation.
     * @param frame_height                 La hauteur du frame.
     */
    public Calendrier(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(238, 238, 238));  // Définir la couleur de fond
        // Définir la taille préférée du panneau en fonction des paramètres
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height * 2 / 3 - 70));

        chartView = new ChartView();  // Instancier la vue du graphique
        add(chartView); // Ajouter ChartView directement au panneau

        // Assurez-vous que ChartView soit visible et correctement dimensionné
        chartView.setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height * 2 / 3 - 70));
        chartView.setVisible(true);
    }

    /**
     * Définit un graphique circulaire (pie chart) dans le panneau.
     *
     * @param dataset Le jeu de données du graphique circulaire.
     */
    public void setPieChart(PieDataset dataset) {
        chartView.setPieChart(dataset);  // Appeler la méthode setPieChart de ChartView
    }

    /**
     * Définit un graphique à barres dans le panneau.
     *
     * @param dataset Le jeu de données du graphique à barres.
     */
    public void setBarChart(CategoryDataset dataset) {
        chartView.setBarChart(dataset);  // Appeler la méthode setBarChart de ChartView
    }
}
