package View.PrincipaleVueComposant;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    public BarreNavigation(int barre_navigation_panel_width, int frame_height){

        setBackground(new Color(186, 230, 187));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

    }

}
