package View.Onglets.AccueilVueComposant;

import javax.swing.*;
import java.awt.*;

public class Calendrier extends JPanel {
    public Calendrier(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(100, 149, 237));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height*2/3 - 70));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}