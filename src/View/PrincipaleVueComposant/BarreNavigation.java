package View.PrincipaleVueComposant;

import View.PrincipaleVue;
import View.PrincipaleVueComposant.BarreNavigationComposant.Calendrier;
import View.PrincipaleVueComposant.BarreNavigationComposant.LesFilms;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private LesFilms les_films;
    private Calendrier calendrier;
    private PrincipaleVue principale_vue;

    public BarreNavigation(int barre_navigation_panel_width, int frame_height, PrincipaleVue principale_vue){

        les_films = new LesFilms(this);
        calendrier = new Calendrier(this);
        this.principale_vue = principale_vue;

        System.out.println("barre navigation : " + barre_navigation_panel_width);
        setBackground(new Color(186, 230, 187));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));
        les_films.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));
        calendrier.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));

        add(les_films);
        add(calendrier);
    }

    public void clicCalendrier(){
        principale_vue.clicsBarreNavigation("Calendrier");
    }

    public void clicLesFilms(){
        principale_vue.clicsBarreNavigation("LesFilms");
    }
}
