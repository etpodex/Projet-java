package View.PrincipaleVueComposant;

import javax.swing.*;
import java.awt.*;

public class MesBilletsVue extends JPanel {

    public MesBilletsVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(255, 0, 0));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }

}
