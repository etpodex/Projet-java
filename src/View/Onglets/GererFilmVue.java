package View.Onglets;


import javax.swing.*;
import java.awt.*;

import static javax.swing.text.StyleConstants.setBackground;

public class GererFilmVue extends JPanel {
    public GererFilmVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(50, 100, 50));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
