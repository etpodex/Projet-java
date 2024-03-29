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
        if (objet instanceof AffAccueilEvenement) {
            principale_vue.afficherAccueil();
        } else if (objet instanceof AffGererFilmEvenement) {
            principale_vue.afficherLesFilms();
        } else if (objet instanceof AffGererOffreEvenement) {
            principale_vue.afficherLesFilms();
        } else if (objet instanceof AffGererSeanceEvenement) {
            principale_vue.afficherLesFilms();
        } else if (objet instanceof AffLesFilmsEvenement) {
            principale_vue.afficherLesFilms();
        } else if (objet instanceof AffMesBilletsEvenement) {
            principale_vue.afficherMesBillets();
        } else if (objet instanceof AffMonCompteEvenement) {
            principale_vue.afficherMonCompte();
        }
    }

}