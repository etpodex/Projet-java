package View;


import Controller.Evenements.AffichageOnglet.AffAccueilEvenement;
import Controller.Evenements.FileEvenements;
import Model.Billet;
import Model.Film;
import Model.Sceance;
import Model.Utilisateur;
import View.Onglets.*;
import View.Onglets.ReservationVueComposant.PaiementEnCoursVue;
import View.Onglets.ReservationVueComposant.PaiementVue;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel {

    // ATTRIBUTS //

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
    private ReservationNerfVue reservation_nerf;
    private int statut_utilisateur;

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

    public void modif_statut_utilisateur(int statut) {
        this.statut_utilisateur = statut;
        barre_navigation.set_current_view(statut);
    }

    public void update_info_seance(Sceance[] seance){
        reservation_nerf.update_info_seance(seance);
        reservation_vue.update_info_seance(seance);
    }

    public void afficherLesFilms(Film[] films) {
        panneau_contenu.removeAll();
        les_films_vue.updateFilms(films);
        panneau_contenu.add(les_films_vue, BorderLayout.CENTER);
        refresh();
    }

    public void afficherAccueil(Object[] datasets) {
        panneau_contenu.removeAll();
        accueil_vue.setPieChart((DefaultPieDataset) datasets[0]);
        accueil_vue.setBarChart((DefaultCategoryDataset) datasets[1]);
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
    public void afficherMesBillets(Billet[] billets) {
        panneau_contenu.removeAll();
        mes_billets_vue.updateBillets(billets);
        panneau_contenu.add(mes_billets_vue);
        refresh();
    }

    public void afficherMonCompte(Utilisateur utilisateur) {
        panneau_contenu.removeAll();
        mon_compte_vue.updateMonCompte(utilisateur);
        panneau_contenu.add(mon_compte_vue);
        refresh();
    }

    public void afficherReservation(Sceance[] seances) {
        panneau_contenu.removeAll();
        if (statut_utilisateur == 1 || statut_utilisateur == 3 || statut_utilisateur == 4) {
            System.out.println(seances[0].toString());
            reservation_vue.update_info_seance(seances);
            panneau_contenu.add(reservation_vue);
            refresh();
        } else {
            reservation_nerf.update_info_seance(seances);
            panneau_contenu.add(reservation_nerf);
            refresh();
        }
    }

    public void afficherPaiementEnCours() {
        panneau_contenu.removeAll();
        panneau_contenu.add(paiement_en_cours_vue);
        paiement_en_cours_vue.startPaiementTimer();
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


