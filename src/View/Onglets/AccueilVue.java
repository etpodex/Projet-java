package View.Onglets;

import View.Onglets.AccueilVueComposant.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * La classe AccueilVue représente la vue principale pour l'onglet Accueil.
 * Elle contient une vue d'offre en haut et une vue de calendrier en bas.
 */
public class AccueilVue extends JPanel {

    private Calendrier calendrier;  // Référence à la vue du calendrier

    /**
     * Constructeur prenant la largeur de la barre de navigation et la hauteur du frame comme paramètres.
     *
     * @param barre_navigation_panel_width La largeur de la barre de navigation.
     * @param frame_height                  La hauteur du frame.
     */
    public AccueilVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(238, 238, 238));  // Définir la couleur de fond
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));  // Définir la taille préférée du panneau

        setBorder(new EmptyBorder(20, 20, 20, 20));  // Définir une bordure vide pour l'espacement
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour organiser les composants

        // Crée les composants Offre et Calendrier
        OffreVue offreVue = new OffreVue(barre_navigation_panel_width, frame_height);  // Créer le composant Offre
        this.calendrier = new Calendrier(barre_navigation_panel_width, frame_height);  // Créer le composant Calendrier

        // Ajoute les composants Offre et Calendrier au panneau principal avec des positions spécifiques
        add(offreVue, BorderLayout.NORTH);  // Ajouter Offre au nord du panneau
        add(calendrier, BorderLayout.SOUTH);  // Ajouter Calendrier au sud du panneau
    }

    /**
     * Met à jour le graphique circulaire dans la vue du calendrier avec le jeu de données spécifié.
     *
     * @param dataset Le jeu de données pour le graphique circulaire.
     */
    public void setPieChart(DefaultPieDataset dataset) {
        this.calendrier.setPieChart(dataset);  // Appeler la méthode setPieChart de Calendrier
    }

    /**
     * Met à jour le graphique à barres dans la vue du calendrier avec le jeu de données spécifié.
     *
     * @param dataset Le jeu de données pour le graphique à barres.
     */
    public void setBarChart(DefaultCategoryDataset dataset) {
        this.calendrier.setBarChart(dataset);  // Appeler la méthode setBarChart de Calendrier
    }

}
