package View;

import Controller.AppControleur;
import Controller.Evenements.AffichageOnglet.*;

import javax.swing.*;
import java.awt.*;

public class MasterVue {

    private JFrame frame;
    private LancementVue lancement_vue;
    private CIVue ci_vue;
    private PrincipaleVue principale_vue;

    public MasterVue() {
        initialiserFrame();
        this.lancement_vue = new LancementVue(this);
        this.ci_vue = new CIVue(this);
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

    public void afficherAccueilVue() {
        resetFrame();
        principale_vue.afficherAccueil();
    }

    // Méthode pour récupérer les données d'inscription à partir de CIVue
    public String[] getInscriptionData() {
        if (ci_vue != null) {
            return ci_vue.getInscriptionData();
        } else {
            return null; // Retourne null si CIVue n'est pas initialisé
        }
    }

    public String[] getConnexionData() {
        if (ci_vue != null) {
            return ci_vue.getConnexionData();
        } else {
            return null; // Retourne null si CIVue n'est pas initialisé
        }
    }

    public void afficherOnglet(Object objet) {
        System.out.println(objet.getClass());
        switch (objet) {
            case AffAccueilEvenement affAccueilEvenement -> principale_vue.afficherAccueil();
            case AffGererFilmEvenement affGererFilmEvenement -> principale_vue.afficherGererFilm();
            case AffGererOffreEvenement affGererOffreEvenement -> principale_vue.afficherGererOffre();
            case AffGererSeanceEvenement affGererSeanceEvenement -> principale_vue.afficherGererSeance();
            case AffLesFilmsEvenement affLesFilmsEvenement -> principale_vue.afficherLesFilms();
            case AffMesBilletsEvenement affMesBilletsEvenement -> principale_vue.afficherMesBillets();
            case AffMonCompteEvenement affMonCompteEvenement -> principale_vue.afficherMonCompte();
            case AffReservationEvenement affReservationEvenement -> principale_vue.afficherReservation();
            case AffPaiementEvenement affPaiementEvenement -> principale_vue.afficherPaiement();
            case AffPaiementEnCoursEvenement affPaiementEnCoursEvenement -> principale_vue.afficherPaiementEnCours();
            default -> {
                System.out.println("Erreur: Onglet non reconnu.");
            }
        }
    }

}