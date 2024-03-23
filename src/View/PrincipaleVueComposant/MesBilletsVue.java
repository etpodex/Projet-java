package View.PrincipaleVueComposant;

import View.PrincipaleVueComposant.MesBilletsComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MesBilletsVue extends JPanel {

    public MesBilletsVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(40, 25, 125));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        setBorder(new EmptyBorder(20,20,20,20));
        setLayout(new BorderLayout());

        // Création des composants
        Billet billet = new Billet(barre_navigation_panel_width, frame_height);

        // Ajout des composants
        add(billet, BorderLayout.NORTH);

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }

}