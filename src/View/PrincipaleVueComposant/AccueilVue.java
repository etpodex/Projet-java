package View.PrincipaleVueComposant;

import javax.swing.*;
import java.awt.*;

public class AccueilVue extends JPanel {

    public AccueilVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(125, 125, 255));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page
        revalidate();
        // Redessine le panneau
        repaint();
    }

}