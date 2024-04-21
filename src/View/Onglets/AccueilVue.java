package View.Onglets;

import View.Onglets.AccueilVueComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AccueilVue extends JPanel {

    // Constructeur prenant la largeur de la barre de navigation et la hauteur du frame comme paramètres
    public AccueilVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(238, 238, 238));  // Définir la couleur de fond
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));  // Définir la taille préférée du panneau

        setBorder(new EmptyBorder(20, 20, 20, 20));  // Définir une bordure vide pour l'espacement
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour organiser les composants

        // Crée les composants Offre et Calendrier
        OffreVue offreVue = new OffreVue(barre_navigation_panel_width, frame_height);  // Créer le composant Offre
        Calendrier calendrier = new Calendrier(barre_navigation_panel_width, frame_height);  // Créer le composant Calendrier

        // Ajoute les composants Offre et Calendrier au panneau principal avec des positions spécifiques
        add(offreVue, BorderLayout.NORTH);  // Ajouter Offre au nord du panneau
        add(calendrier, BorderLayout.SOUTH);  // Ajouter Calendrier au sud du panneau
    }
}
