package View.PrincipaleVueComposant;

import View.PrincipaleVueComposant.BarreNavigationComposant.Calendrier;
import View.PrincipaleVueComposant.BarreNavigationComposant.LesFilms;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private LesFilms les_films;
    private Calendrier calendrier;

    public BarreNavigation(int barre_navigation_panel_width, int frame_height){

        les_films = new LesFilms();
        calendrier = new Calendrier();

        setBackground(new Color(186, 230, 187));
        setPreferredSize(new Dimension(barre_navigation_panel_width,frame_height));
        les_films.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));
        calendrier.setPreferredSize(new Dimension(barre_navigation_panel_width, 50));
        add(les_films);
        add(calendrier);
    }

}
