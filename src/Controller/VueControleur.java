package Controller;

/**BIBLIOTHEQUE**/
import View.*;
import View.LancementComposant.ConnexionInscription;
import View.LancementComposant.Skip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueControleur {

    /**ATTRIBUTS**/
    //attribut frame principale
    private JFrame frame;
    private LancementVue vue_Lancement;
    private Skip skip_composant;
    private ConnexionInscription connexion_inscription_composant;


    /**CONSTRUCTEUR**/
    public VueControleur() {
        initialiserFrame();
        afficherVueLancement();
        initialiserComposants();
        configurerActions();
    }

    /**METHODE**/
    private void initialiserFrame() {
        // Obtention de la taille de l'écran
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcul de la largeur et de la hauteur de l'écran
        int modif_screen_width = screen_size.width *2/3;
        int modif_screen_height = screen_size.height *2/3;

        // Création de la JFrame
        frame = new JFrame();
        frame.setTitle("Cinamax");
        frame.setSize(modif_screen_width, modif_screen_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
    }

    private void afficherVueLancement(){
        LancementVue.remplirPanel(frame, frame.getWidth(), frame.getHeight());
        // Autres configurations de la JFrame
        frame.setVisible(true);
    }

    private void initialiserComposants() {
        // Récupérer les composants Skip, Connexion et Inscription depuis LancementVue
        skip_composant = LancementVue.getSkipComponsant();
        connexion_inscription_composant = LancementVue.getConnexionInscriptionComposant();
    }

    private void configurerActions() {
        // Ajouter un ActionListener pour le bouton "Skip"
        skip_composant.getSkipBouton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Skip\" a été cliqué!");
                // Ajouter ici le code pour effectuer l'action souhaitée pour Skip
            }
        });

        // Ajouter un ActionListener pour le bouton "Connexion"
        connexion_inscription_composant.getConnexionBouton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Connexion\" a été cliqué!");
                // Ajouter ici le code pour effectuer l'action souhaitée pour Connexion
            }
        });

        // Ajouter un ActionListener pour le bouton "Inscription"
        connexion_inscription_composant.getInscriptionBouton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Inscription\" a été cliqué!");
                // Ajouter ici le code pour effectuer l'action souhaitée pour Inscription
            }
        });
    }

}