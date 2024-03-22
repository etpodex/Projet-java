package View;

import View.PrincipaleVueComposant.AccueilVue;
import View.PrincipaleVueComposant.BarreNavigation;
import View.PrincipaleVueComposant.CalendrierVue;
import View.PrincipaleVueComposant.LesFilmsVue;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel{

    private JPanel panneau_principal;
    private JPanel barre_navigation;
    private MasterVue master_vue;
    private CalendrierVue calendrier_vue;
    private LesFilmsVue les_films_vue;
    private AccueilVue accueil_vue;
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

        calendrier_vue = new CalendrierVue((int) (panneau_principal_width), frame_height);
        les_films_vue = new LesFilmsVue((int) (panneau_principal_width), frame_height);
        accueil_vue = new AccueilVue((int) panneau_principal_width, frame_height);

        panneau_principal.setPreferredSize(new Dimension((int) (panneau_principal_width), frame_height));

        setLayout(new BorderLayout());
        add(barre_navigation, BorderLayout.WEST);
        add(panneau_principal, BorderLayout.EAST);
    }

    public void clicsBarreNavigation(String bouton_barre) {
        // Supprime tout contenu précédent
        panneau_principal.removeAll();

        BorderLayout layout = new BorderLayout();
        layout.setVgap(0);

        panneau_principal.setLayout(layout);
        if (bouton_barre.equals("LesFilms")) {
            master_vue.clicsPrincipaleVue("LesFilms");
            panneau_principal.add(les_films_vue, BorderLayout.CENTER);
        } else if (bouton_barre.equals("Calendrier")) {
            master_vue.clicsPrincipaleVue("Calendrier");
            panneau_principal.add(calendrier_vue, BorderLayout.CENTER);
        } else if (bouton_barre.equals("Accueil")){
            master_vue.clicsPrincipaleVue("Accueil");
            panneau_principal.add(accueil_vue, BorderLayout.CENTER);
        }


        // Revalide la mise en page
        panneau_principal.revalidate();
        // Redessine le panneau
        panneau_principal.repaint();

    }
}
