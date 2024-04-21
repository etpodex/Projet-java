package View.Onglets;

import View.Onglets.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

/**
 * La classe BarreNavigation représente la barre de navigation affichée dans l'interface utilisateur.
 * Elle permet à l'utilisateur de naviguer entre différentes vues de l'application.
 */
public class BarreNavigation extends JPanel {

    // Déclaration des composants de la barre de navigation
    private LesFilms les_films;
    private MesBillets mes_billets;
    private Accueil accueil;
    private MonCompte mon_compte;
    private Connexion connexion;
    private GererOffre gerer_offre;
    private GererFilm gerer_film;
    private GererSeance gerer_seance;
    private Deconnexion deconnexion;

    private JPanel panel_boutons;

    /**
     * Constructeur de la barre de navigation.
     * Initialise les différents composants de la barre de navigation et définit la vue par défaut.
     */
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
     * Change la vue actuelle de la barre de navigation en fonction du numéro de vue spécifié.
     *
     * @param vue_nb Le numéro de la vue à afficher.
     *               0 pour invité, 1 pour client enfant, 2 pour employé, 3 pour client adulte, 4 pour client senior.
     */
    public void set_current_view(int vue_nb) {
        panel_boutons.removeAll();  // Suppression de tous les composants du panel

        // Sélection de la vue en fonction du numéro passé en paramètre
        if (vue_nb == 0) {
            panel_boutons.setLayout(new GridLayout(3,1));
            panel_boutons.add(accueil);
            panel_boutons.add(les_films);
            panel_boutons.add(connexion);
        } else if (vue_nb == 1 || vue_nb == 3 || vue_nb == 4) {
            panel_boutons.setLayout(new GridLayout(5,1));
            panel_boutons.add(accueil);
            panel_boutons.add(les_films);
            panel_boutons.add(mes_billets);
            panel_boutons.add(mon_compte);
            panel_boutons.add(deconnexion);
        } else if (vue_nb == 2) {
            panel_boutons.setLayout(new GridLayout(7,1));
            panel_boutons.add(accueil);
            panel_boutons.add(les_films);
            panel_boutons.add(gerer_offre);
            panel_boutons.add(gerer_film);
            panel_boutons.add(gerer_seance);
            panel_boutons.add(mon_compte);
            panel_boutons.add(deconnexion);
        }

        // Rafraîchissement de l'affichage des composants
        panel_boutons.revalidate();
        panel_boutons.repaint();

        revalidate();
        repaint();
    }
}
