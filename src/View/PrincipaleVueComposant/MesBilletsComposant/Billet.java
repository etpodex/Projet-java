package View.PrincipaleVueComposant.MesBilletsComposant;

import javax.swing.*;
import java.awt.*;

public class Billet extends JPanel {
    public Billet(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(0, 255, 127));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height*1/3 - 30));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
