package View;

import View.PrincipaleVueComposant.BarreNavigation;
import View.PrincipaleVueComposant.BarreNavigationComposant.Calendrier;
import View.PrincipaleVueComposant.BarreNavigationComposant.LesFilms;
import View.PrincipaleVueComposant.CalendrierVue;
import View.PrincipaleVueComposant.LesFilmsVue;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel{

    private JPanel panneau_principal;
    private JPanel barre_navigation;
    private MasterVue master_vue;
    private CalendrierVue calendrier;
    private LesFilmsVue les_films_vue;
    private JFrame frame;

    public PrincipaleVue(MasterVue master_vue){
        this.master_vue = master_vue;
        panneau_principal = new JPanel();
    }

    public void remplirPanelBarrePrincipal(JFrame frame, int frame_width, int frame_height){
        this.frame = frame;

        int barre_navigation_panel_width = (int) (frame_width * 0.2);
        int panneau_principal_width = (int) (frame_width*0.8);

        barre_navigation = new BarreNavigation(barre_navigation_panel_width, frame_height, this);
        calendrier = new CalendrierVue((int) (panneau_principal_width), frame_height);
        //System.out.println("taille calendrier : " + (frame_width - barre_navigation_panel_width));
        les_films_vue = new LesFilmsVue((int) (panneau_principal_width), frame_height);
        //System.out.println("taille les films : " + (frame_width - barre_navigation_panel_width));
        panneau_principal.setPreferredSize(new Dimension((int) (panneau_principal_width), frame_height));
        //System.out.println("taille panneau principal : " + (frame_width - barre_navigation_panel_width));
        setLayout(new BorderLayout());
        add(barre_navigation, BorderLayout.WEST);
        add(panneau_principal, BorderLayout.EAST);
    }

    public void clicsBarreNavigation(String bouton_barre){
        // Supprime tout contenu précédent
        panneau_principal.removeAll();

        if (bouton_barre.equals("LesFilms")){
            master_vue.clicsPrincipaleVue("LesFilms");
            panneau_principal.add(les_films_vue, BorderLayout.CENTER);
        } else if (bouton_barre.equals("Calendrier")){
            master_vue.clicsPrincipaleVue("Calendrier");
            panneau_principal.add(calendrier, BorderLayout.CENTER);
        }

        // Revalide la mise en page
        panneau_principal.revalidate();
        // Redessine le panneau
        panneau_principal.repaint();
    }


}
