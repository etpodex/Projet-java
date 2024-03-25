package View.Onglets;

import javax.swing.*;
import java.awt.*;

public class MonCompteVue extends JPanel {

    public MonCompteVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(50, 15, 100));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + redessine le panneau
        revalidate();
        repaint();
    }

}