package View;

import View.PrincipaleVueComposant.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue {

    private JPanel grand_panneau_principal;
    private JPanel barre_navigation;

    public PrincipaleVue(MasterVue master_vue){
        grand_panneau_principal = new JPanel();
    }

    public void remplirPanelBarrePrincipal(JFrame frame, int frame_width, int frame_height){
        int barre_navigation_panel_width = (int) (frame_width * 0.2);
        barre_navigation = new BarreNavigation(barre_navigation_panel_width, frame_height);

        grand_panneau_principal.setLayout(new BorderLayout());
        grand_panneau_principal.add(barre_navigation, BorderLayout.WEST);
    }

    public JPanel getPanneauPrincipale(){
        return grand_panneau_principal;
    }
}
