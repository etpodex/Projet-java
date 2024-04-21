package View;

import Controller.Evenements.AffichageOnglet.*;
import Model.Sceance;

import javax.swing.*;
import java.awt.*;

public class MasterVue {

    private JFrame frame;
    private LancementVue lancement_vue;
    private CIVue ci_vue;
    private PrincipaleVue principale_vue;


    public MasterVue() {
        initialiserFrame();
        this.lancement_vue = new LancementVue();
        this.ci_vue = new CIVue();
        this.principale_vue = new PrincipaleVue(this, frame.getWidth(), frame.getHeight());
    }

    private void initialiserFrame() {
        // Obtention de la taille de l'écran
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcul de la largeur et de la hauteur de l'écran
        int modif_screen_width = screen_size.width * 2 / 3;
        int modif_screen_height = screen_size.height * 2 / 3;

        // Création de la JFrame
        frame = new JFrame();
        frame.setTitle("Cinamax");
        frame.setSize(modif_screen_width, modif_screen_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        frame.setVisible(true);
    }

    private void resetFrame() {
        frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
        frame.getContentPane().revalidate(); // Recalculer la disposition des composants
        frame.getContentPane().repaint(); // Redessiner la JFrame
    }

    public void afficherVueLancement() {
        resetFrame();
        lancement_vue.remplirPanel(frame, frame.getWidth(), frame.getHeight());
        frame.setVisible(true);
    }

    public void afficherConnexion() {
        resetFrame();
        ci_vue.creationCIPanel(frame, frame.getWidth(), frame.getHeight(), 1);
    }

    public void afficherInscription() {
        resetFrame();
        ci_vue.creationCIPanel(frame, frame.getWidth(), frame.getHeight(), 2);
    }

    public void afficherPrincipaleVue(){
        resetFrame();
        frame.getContentPane().add(principale_vue);
        frame.setVisible(true);
    }

    public void afficherOnglet(Object objet) {
        switch (objet) {
            case AffAccueilEvenement affAccueilEvenement -> principale_vue.afficherAccueil(affAccueilEvenement.getDatasets());
            case AffGererFilmEvenement affGererFilmEvenement -> principale_vue.afficherGererFilm(affGererFilmEvenement.getFilms());
            case AffGererOffreEvenement affGererOffreEvenement -> principale_vue.afficherGererOffre();
            case AffGererSeanceEvenement affGererSeanceEvenement -> principale_vue.afficherGererSeance(affGererSeanceEvenement.getSceances());
            case AffLesFilmsEvenement affLesFilmsEvenement -> principale_vue.afficherLesFilms(affLesFilmsEvenement.getFilms());
            case AffMesBilletsEvenement affMesBilletsEvenement -> principale_vue.afficherMesBillets(affMesBilletsEvenement.getBillets());
            case AffMonCompteEvenement affMonCompteEvenement -> principale_vue.afficherMonCompte(affMonCompteEvenement.getUtilisateur());
            case AffReservationEvenement affReservationEvenement -> principale_vue.afficherReservation(affReservationEvenement.getSeances(), affReservationEvenement.getOffres());
            case AffPaiementEvenement affPaiementEvenement -> principale_vue.afficherPaiement();
            case AffPaiementEnCoursEvenement affPaiementEnCoursEvenement -> principale_vue.afficherPaiementEnCours();
            default -> {
                System.out.println("Erreur: Onglet non reconnu.");
            }
        }
    }

    public void modif_statut_utilisateur(int statut) {
        principale_vue.modif_statut_utilisateur(statut);
    }


}