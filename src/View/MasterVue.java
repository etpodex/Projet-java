package View;

import Controller.AppControleur;

import javax.swing.*;
import java.awt.*;

public class MasterVue {

    private JFrame frame;
    private LancementVue lancement_vue;
    private CIVue ci_vue;
    private PrincipaleVue principale_vue;
    private AppControleur app_controleur;

    public MasterVue(AppControleur app_controleur) {
        initialiserFrame();
        this.lancement_vue = new LancementVue(this);
        this.ci_vue = new CIVue(this);
        this.principale_vue = new PrincipaleVue(this, frame.getWidth(), frame.getHeight());
        this.app_controleur = app_controleur;
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

    //LancementVue
    public void afficherVueLancement() {

        frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
        frame.getContentPane().revalidate(); // Recalculer la disposition des composants
        frame.getContentPane().repaint(); // Redessiner la JFrame

        lancement_vue.remplirPanel(frame, frame.getWidth(), frame.getHeight());
        // Autres configurations de la JFrame
        frame.setVisible(true);
    }

    public void afficherConnexion() {
        frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
        frame.getContentPane().revalidate(); // Recalculer la disposition des composants
        frame.getContentPane().repaint(); // Redessiner la JFrame

        ci_vue.creationCIPanel(frame, frame.getWidth(), frame.getHeight(), 1);
    }

    public void afficherInscription() {
        frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
        frame.getContentPane().revalidate(); // Recalculer la disposition des composants
        frame.getContentPane().repaint(); // Redessiner la JFrame

        ci_vue.creationCIPanel(frame, frame.getWidth(), frame.getHeight(), 2);
    }


    public void clicsCIView(String bouton) {
        if (bouton.equals("ValiderInscription")) {
            app_controleur.inscription();
            afficherPrincipaleVue();
        }
        else if (bouton.equals("ValiderConnexion")) {

            int connect_result = app_controleur.connexion();
            if (connect_result == 0) {
                afficherPrincipaleVue();
            }
        }
    }

    public void afficherPrincipaleVue(){

        frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
        frame.getContentPane().revalidate(); // Recalculer la disposition des composants
        frame.getContentPane().repaint(); // Redessiner la JFrame

        frame.getContentPane().add(principale_vue);
        frame.setVisible(true);
    }

    public void afficherPVLesFilms() {
        principale_vue.afficherLesFilms();
    }

    public void clicsPrincipaleVue(String bouton) {

        if (bouton.equals("Connexion")) {
            afficherVueLancement();
        }
        else {
            afficherPrincipaleVue();
        }

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
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

    public void resetLancementVue() {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();

        this.lancement_vue = new LancementVue(this);
        afficherVueLancement();
    }
    // Dans la classe MasterVue
    public void afficherAccueilVue() {
        clicsPrincipaleVue("Accueil");
    }
}