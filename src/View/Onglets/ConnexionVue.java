package View.Onglets;

import javax.swing.*;
import java.awt.*;

/**
 * La classe ConnexionVue représente la vue de la page de connexion dans l'interface utilisateur.
 */
public class ConnexionVue extends JPanel {

    /**
     * Constructeur de la vue de la page de connexion.
     *
     * @param barre_navigation_panel_width La largeur de la barre de navigation.
     * @param frame_height                La hauteur du frame.
     */
    public ConnexionVue(int barre_navigation_panel_width, int frame_height){

        setBackground(new Color(238, 238, 238));  // Définit la couleur de fond
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));  // Définit la taille préférée

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
