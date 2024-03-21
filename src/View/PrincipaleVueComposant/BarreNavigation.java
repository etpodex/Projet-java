package View.PrincipaleVueComposant;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    JPanel barre_navigation;

    public BarreNavigation(int barre_navigation_panel_width, int frame_height){
        barre_navigation = new JPanel();
        setBackground(new Color(186, 230, 187));
        barre_navigation.setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

    }

}
