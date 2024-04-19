package View.Onglets;

import View.PrincipaleVue;
import View.Onglets.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    LesFilms les_films;
    MesBillets mes_billets;
    Accueil accueil;
    MonCompte mon_compte;
    Connexion connexion;
    GererOffre gerer_offre;
    GererFilm gerer_film;
    GererSeance gerer_seance;
    Deconnexion deconnexion;

    JPanel panel_boutons;

    public BarreNavigation() {

        this.panel_boutons = new JPanel();

        this.les_films = new LesFilms();
        this.mes_billets = new MesBillets();
        this.accueil = new Accueil();
        this.mon_compte = new MonCompte();
        this.connexion = new Connexion();
        this.gerer_offre = new GererOffre();
        this.gerer_film = new GererFilm();
        this.gerer_seance = new GererSeance();
        this.deconnexion = new Deconnexion();

        setBackground(new Color(186, 230, 187));

        set_current_view(0);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        // Ajout du panel invité par défaut
        add(this.panel_boutons);
    }

    /**
     * Change la vue actuelle
     * @param vue_nb 0 pour invite 1 pour client 2 pour employe
     */
    public void set_current_view(int vue_nb) {
        panel_boutons.removeAll();
        if (vue_nb == 0) {
            panel_boutons.setLayout(new GridLayout(3,1));
            panel_boutons.add(les_films);
            panel_boutons.add(accueil);
            panel_boutons.add(connexion);
        } else if (vue_nb == 1) {
            panel_boutons.setLayout(new GridLayout(5,1));
            panel_boutons.add(les_films);
            panel_boutons.add(mes_billets);
            panel_boutons.add(accueil);
            panel_boutons.add(mon_compte);
            panel_boutons.add(deconnexion);
        } else if (vue_nb == 2) {
            panel_boutons.setLayout(new GridLayout(7,1));
            panel_boutons.add(les_films);
            panel_boutons.add(accueil);
            panel_boutons.add(mon_compte);
            panel_boutons.add(gerer_offre);
            panel_boutons.add(gerer_film);
            panel_boutons.add(gerer_seance);
            panel_boutons.add(deconnexion);
        }

        panel_boutons.revalidate();
        panel_boutons.repaint();

        revalidate();
        repaint();
    }
}