package View.PrincipaleVueComposant.AccueilVueComposant.OffreComposant;

import javax.swing.*;
import java.awt.*;

public class FormeRectangle extends JPanel {
    public FormeRectangle (int barre_navigation_panel_width, int hauteur){
        setBackground(new Color(255,0,100));
        setPreferredSize(new Dimension(barre_navigation_panel_width*5/9 , hauteur));

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }
}
