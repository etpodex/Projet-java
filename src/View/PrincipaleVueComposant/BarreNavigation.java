package View.PrincipaleVueComposant;

import View.PrincipaleVue;
import View.PrincipaleVueComposant.BarreNavigationComposant.Calendrier;
import View.PrincipaleVueComposant.BarreNavigationComposant.LesFilms;
import View.PrincipaleVueComposant.BarreNavigationComposant.Accueil;
import View.PrincipaleVueComposant.BarreNavigationComposant.MonCompte;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private LesFilms les_films;
    private Calendrier calendrier;
    private Accueil accueil;
    private MonCompte mon_compte;
    private PrincipaleVue principale_vue;

    public BarreNavigation(int barre_navigation_panel_width, int frame_height, PrincipaleVue principale_vue){

        les_films = new LesFilms(this);
        calendrier = new Calendrier(this);
        accueil = new Accueil(this);
        mon_compte = new MonCompte(this);
        this.principale_vue = principale_vue;

        setBackground(new Color(186, 230, 187));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));

        les_films.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));
        calendrier.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));
        accueil.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));
        mon_compte.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));

        add(les_films);
        add(calendrier);
        add(accueil);
        add(mon_compte);
    }

    public void clicCalendrier(){
        principale_vue.clicsBarreNavigation("Calendrier");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicLesFilms(){
        principale_vue.clicsBarreNavigation("LesFilms");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicAccueil(){
        principale_vue.clicsBarreNavigation("Accueil");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicMonCompte(){
        principale_vue.clicsBarreNavigation("MonCompte");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }
}
