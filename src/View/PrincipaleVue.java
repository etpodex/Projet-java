package View;

import Controller.Evenements.FileEvenements;
import View.Onglets.*;
import View.Onglets.ReservationVueComposant.PaiementEnCoursVue;
import View.Onglets.ReservationVueComposant.PaiementVue;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel {

    // ATTRIBUTS //

    private MasterVue master_vue; // Instance de la vue principale

    // Instance des panels qui composent la vue principale
    private BarreNavigation barre_navigation; // La barre de navigation à gauche
    private JPanel panneau_contenu; // Le panneau de contenu à droite

    // Instances des vues composant le panneau de contenu
    private MesBilletsVue mes_billets_vue; // La vue du calendrier
    private LesFilmsVue les_films_vue; // La vue des films
    private AccueilVue accueil_vue; // La vue d'accueil
    private MonCompteVue mon_compte_vue; // La vue de mon compte
    private ConnexionVue connexion_vue; // La vue de connexion
    private ReservationVue reservation_vue; // La vue de réservation
    private PaiementEnCoursVue paiement_en_cours_vue; // La vue de paiement en cours
    private PaiementVue paiement_vue; // La vue de paiement

    private GererOffreVue gerer_offre;
    private GererFilmVue gerer_film;
    private GererSeanceVue gerer_seance;

    // Constructeur
    public PrincipaleVue(MasterVue master_vue, int frame_width, int frame_height) {

        int panel_navigation_width = (int) (frame_width * 0.2);
        int panneau_contenu_width = (int) (frame_width * 0.8);

        // Initialisations des attributs
        this.master_vue = master_vue;
        this.panneau_contenu = new JPanel();

        this.barre_navigation = new BarreNavigation();

        this.mes_billets_vue = new MesBilletsVue(panneau_contenu_width, frame_height);
        this.les_films_vue = new LesFilmsVue(panneau_contenu_width, frame_height, master_vue);
        this.accueil_vue = new AccueilVue(panneau_contenu_width, frame_height);
        this.mon_compte_vue = new MonCompteVue(panel_navigation_width, frame_height);
        this.connexion_vue = new ConnexionVue(panel_navigation_width, frame_height);
        this.gerer_offre = new GererOffreVue(panneau_contenu_width, frame_height);
        this.gerer_film = new GererFilmVue(panneau_contenu_width, frame_height);
        this.gerer_seance = new GererSeanceVue(panneau_contenu_width, frame_height);

        this.reservation_vue = new ReservationVue(panneau_contenu_width, frame_height);
        this.paiement_en_cours_vue = new PaiementEnCoursVue(master_vue);
        this.paiement_vue = new PaiementVue(panneau_contenu_width, frame_height);


        Dimension barreNavDim = new Dimension(panel_navigation_width, frame_height);
        this.barre_navigation.setPreferredSize(barreNavDim);
        Dimension panneauContenuDim = new Dimension(panneau_contenu_width, frame_height);
        this.panneau_contenu.setPreferredSize(panneauContenuDim);

        setLayout(new BorderLayout());
        add(barre_navigation, BorderLayout.WEST);
        add(panneau_contenu, BorderLayout.CENTER);

        // Revalide la mise en page + Redessine le panneau
        refresh();
    }

    public void afficherLesFilms() {
        panneau_contenu.removeAll();
        panneau_contenu.add(les_films_vue);
        refresh();
    }

    public void afficherAccueil() {
        panneau_contenu.removeAll();
        panneau_contenu.add(accueil_vue);
        refresh();
    }

    public void afficherGererFilm() {
        panneau_contenu.removeAll();
        panneau_contenu.add(gerer_film);
        refresh();
    }

    public void afficherGererOffre() {
        panneau_contenu.removeAll();
        panneau_contenu.add(gerer_offre);
        refresh();
    }

    public void afficherGererSeance() {
        panneau_contenu.removeAll();
        panneau_contenu.add(gerer_seance);
        refresh();
    }
    public void afficherMesBillets() {
        panneau_contenu.removeAll();
        panneau_contenu.add(mes_billets_vue);
        refresh();
    }

    public void afficherMonCompte() {
        panneau_contenu.removeAll();
        panneau_contenu.add(mon_compte_vue);
        refresh();
    }

    public void afficherReservation() {
        panneau_contenu.removeAll();
        panneau_contenu.add(reservation_vue);
        refresh();
    }

    public void afficherPaiementEnCours() {
        panneau_contenu.removeAll();
        panneau_contenu.add(paiement_en_cours_vue);
        refresh();
    }

    public void afficherPaiement() {
        panneau_contenu.removeAll();
        panneau_contenu.add(paiement_vue);
        refresh();
    }

    private void refresh() {
        revalidate();
        repaint();
    }

}


