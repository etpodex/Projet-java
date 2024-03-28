package View.Onglets;

import javax.swing.*;
import java.awt.*;

public class GererSeanceVue extends JPanel {
    public GererSeanceVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(50, 50, 100));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
