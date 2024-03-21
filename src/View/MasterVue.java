package View;

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
        this.principale_vue = new PrincipaleVue(this);
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
        lancement_vue.remplirPanel(frame, frame.getWidth(), frame.getHeight());
        // Autres configurations de la JFrame
        frame.setVisible(true);
    }

    public void clicsLancement(String bouton) {
        if (bouton.equals("Skip")) {

            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            afficherPrincipaleVue();

        } else if (bouton.equals("Connexion")) {

            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            //CI Vue
            ci_vue.creationCIPanel(frame, frame.getWidth(), frame.getHeight(), 1);
        } else if (bouton.equals("Inscription")) {
            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            //CI Vue
            ci_vue.creationCIPanel(frame, frame.getWidth(), frame.getHeight(), 2);
        }
    }

    public void clicsCIView(String bouton) {
        if (bouton.equals("Retour")) {
            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            afficherVueLancement();
        }
        else if (bouton.equals("Valider")) {

            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            afficherVueLancement();
        }
    }

    public void afficherPrincipaleVue(){

        principale_vue.remplirPanelBarrePrincipal(frame, frame.getWidth(), frame.getHeight());

        frame.getContentPane().add(principale_vue);
        frame.setVisible(true);
    }

    public void clicsPrincipaleVue(String bouton) {
        if (bouton.equals("LesFilms")) {
            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            afficherPrincipaleVue();
        }
        else if (bouton.equals("Calendrier")) {

            //réinitialiser la frame
            frame.getContentPane().removeAll(); // Retire tous les composants du contenu principal de la JFrame
            frame.getContentPane().revalidate(); // Recalculer la disposition des composants
            frame.getContentPane().repaint(); // Redessiner la JFrame

            afficherPrincipaleVue();
        }
    }
}
