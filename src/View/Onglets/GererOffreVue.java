package View.Onglets;

import javax.swing.*;
import java.awt.*;

public class GererOffreVue extends JPanel {

    public GererOffreVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(100, 50, 50));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
