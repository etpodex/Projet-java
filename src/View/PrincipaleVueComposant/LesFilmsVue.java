package View.PrincipaleVueComposant;

import javax.swing.*;
import java.awt.*;

public class LesFilmsVue extends JPanel {
    public LesFilmsVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(0, 210, 120));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
