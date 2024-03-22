package View.PrincipaleVueComposant;

import View.PrincipaleVue;
import View.PrincipaleVueComposant.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private Compte compte;
    private LesFilms les_films;
    private MesBillets mes_billets;
    private Accueil accueil;
    private MonCompte mon_compte;
    private PrincipaleVue principale_vue;

    public BarreNavigation(PrincipaleVue principale_vue){
        this.principale_vue = principale_vue;
        this.compte = new Compte();
        this.les_films = new LesFilms(this);
        this.mes_billets = new MesBillets(this);
        this.accueil = new Accueil(this);
        this.mon_compte = new MonCompte(this);

        setBackground(new Color(186, 230, 187));

        JPanel panel_boutons = new JPanel();
        panel_boutons.setLayout(new GridLayout(7,1));
        panel_boutons.add(les_films);
        panel_boutons.add(mes_billets);
        panel_boutons.add(accueil);
        panel_boutons.add(mon_compte);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        add(compte);
        add(panel_boutons);

        compte.setPreferredSize(new Dimension(200, 20));
    }

    public void clicMesBillets(){
        principale_vue.clicsBarreNavigation("MesBillets");

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
