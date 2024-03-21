package View;

import View.PrincipaleVueComposant.BarreNavigation;
import View.PrincipaleVueComposant.BarreNavigationComposant.Calendrier;
import View.PrincipaleVueComposant.BarreNavigationComposant.LesFilms;
import View.PrincipaleVueComposant.CalendrierVue;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel{

    private JPanel panneau_principal;
    private JPanel barre_navigation;

    private MasterVue master_vue;

    private CalendrierVue calendrier;
    private LesFilms les_films;
    private JFrame frame;

    public PrincipaleVue(MasterVue master_vue){
        this.master_vue = master_vue;
        panneau_principal = new JPanel();
    }

    public void remplirPanelBarrePrincipal(JFrame frame, int frame_width, int frame_height){
        this.frame = frame;
        int barre_navigation_panel_width = (int) (frame_width * 0.2);
        barre_navigation = new BarreNavigation(barre_navigation_panel_width, frame_height, this);
        calendrier = new CalendrierVue((int) (frame_width - barre_navigation_panel_width), frame_height);
        panneau_principal.setPreferredSize(new Dimension((int) (frame_width * 0.8), frame_height));
        setLayout(new BorderLayout());
        add(barre_navigation, BorderLayout.WEST);
        add(panneau_principal, BorderLayout.EAST);
    }

    public void clicsBarreNavigation(String bouton_barre){
        if (bouton_barre.equals("LesFilms")){
            master_vue.clicsPrincipaleVue("LesFilms");
        } else if (bouton_barre.equals("Calendrier")){
            master_vue.clicsPrincipaleVue("Calendrier");

            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            setLayout(new BorderLayout());
            add(barre_navigation, BorderLayout.WEST);
            add(calendrier, BorderLayout.EAST);

            frame.getContentPane().add(this);
        }
    }




}
