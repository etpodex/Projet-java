package View;

import Controller.Evenements.AffichageOnglet.AffAccueilEvenement;
import Controller.Evenements.FileEvenements;
import Model.*;
import View.Onglets.*;
import View.Onglets.ReservationVueComposant.PaiementEnCoursVue;
import View.Onglets.ReservationVueComposant.PaiementVue;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

/**
 * Vue principale de l'application Cinamax.
 */
public class PrincipaleVue extends JPanel {

    // ATTRIBUTS //

    // Instance des panels qui composent la vue principale
    private BarreNavigation barre_navigation; // La barre de navigation à gauche
    private JPanel panneau_contenu; // Le panneau de contenu à droite

    // Instances des vues composant le panneau de contenu
    private MesBilletsVue mes_billets_vue; // La vue des billets
    private LesFilmsVue les_films_vue; // La vue des films
    private AccueilVue accueil_vue; // La vue d'accueil
    private MonCompteVue mon_compte_vue; // La vue de mon compte
    private ConnexionVue connexion_vue; // La vue de connexion
    private ReservationVue reservation_vue; // La vue de réservation
    private PaiementEnCoursVue paiement_en_cours_vue; // La vue de paiement en cours
    private PaiementVue paiement_vue; // La vue de paiement
    private GererOffreVue gerer_offre; // La vue de gestion des offres
    private GererFilmVue gerer_film; // La vue de gestion des films
    private GererSeanceVue gerer_seance; // La vue de gestion des séances
    private ReservationNerfVue reservation_nerf; // La vue de réservation alternative
    private int statut_utilisateur; // Le statut de l'utilisateur connecté

    // Constructeur
    public PrincipaleVue(MasterVue master_vue, int frame_width, int frame_height) {

        int panel_navigation_width = (int) (frame_width * 0.2);
        int panneau_contenu_width = (int) (frame_width * 0.8);

        // Initialisations des attributs
        this.panneau_contenu = new JPanel();

        this.barre_navigation = new BarreNavigation();

        this.mes_billets_vue = new MesBilletsVue(panneau_contenu_width, frame_height);
        this.les_films_vue = new LesFilmsVue(panneau_contenu_width, frame_height);
        this.accueil_vue = new AccueilVue(panneau_contenu_width, frame_height);
        this.mon_compte_vue = new MonCompteVue();
        this.connexion_vue = new ConnexionVue(panel_navigation_width, frame_height);
        this.gerer_offre = new GererOffreVue(panneau_contenu_width, frame_height);
        this.gerer_film = new GererFilmVue(panneau_contenu_width, frame_height);
        this.gerer_seance = new GererSeanceVue(panneau_contenu_width, frame_height);
        this.reservation_nerf = new ReservationNerfVue(panneau_contenu_width, frame_height);

        this.reservation_vue = new ReservationVue(panneau_contenu_width, frame_height);
        this.paiement_en_cours_vue = new PaiementEnCoursVue();
        this.paiement_vue = new PaiementVue(panneau_contenu_width, frame_height);


        Dimension barreNavDim = new Dimension(panel_navigation_width, frame_height);
        this.barre_navigation.setPreferredSize(barreNavDim);
        Dimension panneauContenuDim = new Dimension(panneau_contenu_width, frame_height);
        this.panneau_contenu.setPreferredSize(panneauContenuDim);

        setLayout(new BorderLayout());
        add(barre_navigation, BorderLayout.WEST);
        add(panneau_contenu, BorderLayout.CENTER);
        panneau_contenu.setLayout(new BorderLayout());

        FileEvenements.getInstance().publier(new AffAccueilEvenement());

        // Revalide la mise en page + Redessine le panneau
        refresh();
    }

    /**
     * Méthode pour modifier le statut de l'utilisateur dans la vue principale.
     * @param statut Le nouveau statut de l'utilisateur.
     */
    public void modif_statut_utilisateur(int statut) {
        this.statut_utilisateur = statut;
        barre_navigation.set_current_view(statut);
    }

    // Méthodes pour afficher les différentes vues dans le panneau de contenu

    /**
     * Affiche la vue des films avec la liste des films fournie.
     * @param films La liste des films à afficher.
     */
    public void afficherLesFilms(Film[] films) {
        panneau_contenu.removeAll();
        les_films_vue.updateFilms(films);
        panneau_contenu.add(les_films_vue, BorderLayout.CENTER);
        refresh();
    }

    /**
     * Affiche la vue d'accueil avec les données des datasets fournis.
     * @param datasets Les datasets contenant les données pour les graphiques.
     */
    public void afficherAccueil(Object[] datasets) {
        panneau_contenu.removeAll();
        accueil_vue.setCharts((DefaultPieDataset) datasets[0], (DefaultCategoryDataset) datasets[1]);
        panneau_contenu.add(accueil_vue);
        refresh();
    }

    /**
     * Affiche la vue de gestion des films avec la liste des films fournie.
     * @param films La liste des films à afficher.
     */
    public void afficherGererFilm(Film[] films) {
        panneau_contenu.removeAll();
        gerer_film.setFilms(films);
        panneau_contenu.add(gerer_film);
        refresh();
    }

    /**
     * Affiche la vue de gestion des offres avec la liste des offres fournie.
     * @param offres La liste des offres à afficher.
     */
    public void afficherGererOffre(Offre[] offres) {
        panneau_contenu.removeAll();
        gerer_offre.setGererOffres(offres);
        panneau_contenu.add(gerer_offre);
        refresh();
    }

    /**
     * Affiche la vue de gestion des séances avec la liste des séances fournie.
     * @param sceances La liste des séances à afficher.
     */
    public void afficherGererSeance(Sceance[] sceances) {
        panneau_contenu.removeAll();
        gerer_seance.setGererSeances(sceances);
        panneau_contenu.add(gerer_seance);
        refresh();
    }

    /**
     * Affiche la vue des billets avec la liste des billets fournie.
     * @param billets La liste des billets à afficher.
     */
    public void afficherMesBillets(Billet[] billets) {
        panneau_contenu.removeAll();
        mes_billets_vue.updateBillets(billets);
        panneau_contenu.add(mes_billets_vue);
        refresh();
    }

    /**
     * Affiche la vue de mon compte avec les données de l'utilisateur fournies.
     * @param utilisateur Les données de l'utilisateur à afficher.
     */
    public void afficherMonCompte(Utilisateur utilisateur) {
        panneau_contenu.removeAll();
        mon_compte_vue.updateMonCompte(utilisateur);
        panneau_contenu.add(mon_compte_vue);
        refresh();
    }

    /**
     * Affiche la vue de réservation avec les données des séances et des offres fournies.
     * @param seances La liste des séances disponibles.
     * @param offres La liste des offres disponibles.
     */
    public void afficherReservation(Sceance[] seances, Offre[] offres) {
        panneau_contenu.removeAll();
        if (statut_utilisateur == 1 || statut_utilisateur == 3 || statut_utilisateur == 4) {
            reservation_vue.update_info_seance(seances);
            reservation_vue.update_info_offre(offres, 1);
            panneau_contenu.add(reservation_vue);
            refresh();
        } else {
            reservation_nerf.update_info_seance(seances);
            panneau_contenu.add(reservation_nerf);
            refresh();
        }
    }

    /**
     * Affiche la vue de paiement en cours.
     */
    public void afficherPaiementEnCours() {
        panneau_contenu.removeAll();
        panneau_contenu.add(paiement_en_cours_vue);
        paiement_en_cours_vue.startPaiementTimer();
        refresh();
    }

    /**
     * Affiche la vue de paiement.
     */
    public void afficherPaiement() {
        panneau_contenu.removeAll();
        panneau_contenu.add(paiement_vue);
        refresh();
    }

    // Méthode privée pour rafraîchir l'affichage de la vue principale

    /**
     * Rafraîchit l'affichage de la vue principale.
     */
    private void refresh() {
        revalidate();
        repaint();
    }
}
