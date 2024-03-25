package View.PrincipaleVueComposant;

import View.PrincipaleVueComposant.AccueilVueComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AccueilVue extends JPanel {

    public AccueilVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(125, 125, 255));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour organiser les composants

        // Crée les composants Offre et Calendrier
        Offre offre = new Offre(barre_navigation_panel_width, frame_height);
        Calendrier calendrier = new Calendrier(barre_navigation_panel_width, frame_height);

        // Ajoute les composants Offre et Calendrier au panneau principal
        add(offre, BorderLayout.NORTH);
        add(calendrier, BorderLayout.SOUTH);
    }
}