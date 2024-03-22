package View.PrincipaleVueComposant;

import View.PrincipaleVue;
import View.PrincipaleVueComposant.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private Compte compte;
    private LesFilms les_films;
    private Calendrier calendrier;
    private Accueil accueil;
    private PrincipaleVue principale_vue;

    public BarreNavigation(PrincipaleVue principale_vue){
        this.principale_vue = principale_vue;
        this.compte = new Compte();
        this.les_films = new LesFilms(this);
        this.calendrier = new Calendrier(this);
        this.accueil = new Accueil(this);

        setBackground(new Color(186, 230, 187));

        JPanel panel_boutons = new JPanel();
        panel_boutons.setLayout(new GridLayout(7,1));
        panel_boutons.add(les_films);
        panel_boutons.add(calendrier);
        panel_boutons.add(accueil);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        add(compte);
        add(panel_boutons);

        compte.setPreferredSize(new Dimension(200, 20));
    }

    public void clicCalendrier(){
        principale_vue.clicsBarreNavigation("Calendrier");
    }

    public void clicLesFilms(){
        principale_vue.clicsBarreNavigation("LesFilms");
    }

    public void clicAccueil(){
        principale_vue.clicsBarreNavigation("Accueil");
    }
}
