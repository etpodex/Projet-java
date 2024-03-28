package View.Onglets;

import javax.swing.*;
import java.awt.*;

public class ConnexionVue extends JPanel {
    public ConnexionVue(int barre_navigation_panel_width, int frame_height){

        setBackground(new Color(75, 200, 200));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
