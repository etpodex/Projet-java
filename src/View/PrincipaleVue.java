package View;

import View.PrincipaleVueComposant.AccueilVue;
import View.PrincipaleVueComposant.BarreNavigation;
import View.PrincipaleVueComposant.CalendrierVue;
import View.PrincipaleVueComposant.LesFilmsVue;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel{


    // ATTRIBUTS //

    private MasterVue master_vue;               // Instance de la vue principale

    // Instance des panels qui composent la vue principale
    private BarreNavigation barre_navigation;   // La barre de navigation à gauche
    private JPanel panneau_contenu;             // Le panneau de contenu à droite

    // Instances des vues composant le panneau de contenu
    private CalendrierVue calendrier_vue;       // La vue du calendrier
    private LesFilmsVue les_films_vue;          // La vue des films
    private AccueilVue accueil_vue;             // La vue d'accueil


    // Constructeur
    public PrincipaleVue(MasterVue master_vue, int frame_width, int frame_height){

        int panel_navigation_width = (int) (frame_width * 0.2);
        int panneau_contenu_width = (int) (frame_width*0.8);

        // Initialisations des attributs
        this.master_vue = master_vue;
        this.panneau_contenu = new JPanel();

        this.barre_navigation = new BarreNavigation(this);

        this.calendrier_vue = new CalendrierVue(panneau_contenu_width, frame_height);
        this.les_films_vue = new LesFilmsVue(panneau_contenu_width, frame_height);
        this.accueil_vue = new AccueilVue(panel_navigation_width, frame_height);

        Dimension barre_nav_dim = new Dimension(panel_navigation_width, frame_height);
        this.barre_navigation.setPreferredSize(barre_nav_dim);
        Dimension panneau_contenu_dim = new Dimension(panneau_contenu_width, frame_height);
        this.panneau_contenu.setPreferredSize(panneau_contenu_dim);

        setLayout(new BorderLayout());
        add(barre_navigation, BorderLayout.WEST);
        add(panneau_contenu, BorderLayout.EAST);

        // Revalide la mise en page
        revalidate();
        // Redessine le panneau
        repaint();
    }

    public void clicsBarreNavigation(String bouton_barre) {
        // Supprime tout contenu précédent
        panneau_contenu.removeAll();

        BorderLayout layout = new BorderLayout();
        layout.setVgap(0);

        panneau_contenu.setLayout(layout);
        if (bouton_barre.equals("LesFilms")) {
            master_vue.clicsPrincipaleVue("LesFilms");
            panneau_contenu.add(les_films_vue, BorderLayout.CENTER);
        } else if (bouton_barre.equals("Calendrier")) {
            master_vue.clicsPrincipaleVue("Calendrier");
            panneau_contenu.add(calendrier_vue, BorderLayout.CENTER);
        } else if (bouton_barre.equals("Accueil")){
            master_vue.clicsPrincipaleVue("Accueil");
            panneau_contenu.add(accueil_vue, BorderLayout.CENTER);
        }


        // Revalide la mise en page
        panneau_contenu.revalidate();
        // Redessine le panneau
        panneau_contenu.repaint();

    }
}
