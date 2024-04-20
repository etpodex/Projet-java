package View.Onglets;

import View.PrincipaleVue;
import View.Onglets.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    // Déclaration des composants de la barre de navigation
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

    // Constructeur de la barre de navigation
    public BarreNavigation() {

        this.panel_boutons = new JPanel();

        // Initialisation des différents composants de la barre de navigation
        this.les_films = new LesFilms();
        this.mes_billets = new MesBillets();
        this.accueil = new Accueil();
        this.mon_compte = new MonCompte();
        this.connexion = new Connexion();
        this.gerer_offre = new GererOffre();
        this.gerer_film = new GererFilm();
        this.gerer_seance = new GererSeance();
        this.deconnexion = new Deconnexion();

        setBackground(new Color(238, 238, 238));  // Définition de la couleur de fond

        set_current_view(0);  // Définition de la vue par défaut

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);  // Utilisation d'un layout vertical
        setLayout(layout);

        // Ajout du panel invité par défaut
        add(this.panel_boutons);
    }

    /**
     * Change la vue actuelle
     * @param vue_nb 0 pour invité, 1 pour client, 2 pour employé
     */
    public void set_current_view(int vue_nb) {
        panel_boutons.removeAll();  // Suppression de tous les composants du panel

        // Sélection de la vue en fonction du numéro passé en paramètre
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

        // Rafraîchissement de l'affichage des composants
        panel_boutons.revalidate();
        panel_boutons.repaint();

        revalidate();
        repaint();
    }
}
