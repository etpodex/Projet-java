package View.Onglets;

import View.PrincipaleVue;
import View.Onglets.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private Compte compte;
    private LesFilms les_films;
    private MesBillets mes_billets;
    private Accueil accueil;
    private MonCompte mon_compte;
    private Connexion connexion;
    private GererOffre gerer_offre;
    private GererFilm gerer_film;
    private GererSeance gerer_seance;
    public BarreNavigation() {
        this.compte = new Compte();
        this.les_films = new LesFilms();
        this.mes_billets = new MesBillets();
        this.accueil = new Accueil();
        this.mon_compte = new MonCompte();
        this.connexion = new Connexion();
        this.gerer_offre = new GererOffre();
        this.gerer_film = new GererFilm();
        this.gerer_seance = new GererSeance();

        setBackground(new Color(186, 230, 187));

        JPanel panel_boutons = new JPanel();
        panel_boutons.setLayout(new GridLayout(8,1));
        panel_boutons.add(les_films);
        panel_boutons.add(mes_billets);
        panel_boutons.add(accueil);
        panel_boutons.add(mon_compte);
        panel_boutons.add(connexion);
        panel_boutons.add(gerer_offre);
        panel_boutons.add(gerer_film);
        panel_boutons.add(gerer_seance);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        //add(compte);
        add(panel_boutons);

        compte.setPreferredSize(new Dimension(200, 20));
    }
}