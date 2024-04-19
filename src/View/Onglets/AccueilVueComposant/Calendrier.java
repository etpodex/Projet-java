package View.Onglets.AccueilVueComposant;

import javax.swing.*;
import java.awt.*;

public class Calendrier extends JPanel {

    private ChartView chartView;  // Référence à la vue du graphique

    // Constructeur prenant la largeur de la barre de navigation et la hauteur du frame comme paramètres
    public Calendrier(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(100, 149, 237));  // Définir la couleur de fond
        // Définir la taille préférée du panneau en fonction des paramètres
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height * 2 / 3 - 70));

        chartView = new ChartView();  // Instancier la vue du graphique
        add(chartView); // Ajouter ChartView directement au panneau

        // Assurez-vous que ChartView soit visible et correctement dimensionné
        chartView.setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height * 2 / 3 - 70));
        chartView.setVisible(true);
    }
}
