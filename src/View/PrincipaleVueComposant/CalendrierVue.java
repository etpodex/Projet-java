package View.PrincipaleVueComposant;

import View.PrincipaleVue;

import javax.swing.*;
import java.awt.*;

public class CalendrierVue extends JPanel {

    public CalendrierVue(int barre_navigation_panel_width, int frame_height){
        setBackground(new Color(255, 0, 0));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));
    }

}
