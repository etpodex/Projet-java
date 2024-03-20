package View;

/**BIBLIOTHEQUE**/
import View.LancementComposant.*;
import javax.swing.*;
import java.awt.*;

public class LancementVue {

    /**METHODE**/
    public static void remplirFrame(JFrame frame, int frameWidth, int frameHeight) {
        // Ajouter les composants nécessaires
        frame.setLayout(new GridLayout(3, 1)); // Layout pour afficher les composants verticalement

        // Panel pour la connexion/inscription
        ConnexionInscription connexionInscriptionPanel = new ConnexionInscription(frameWidth, frameHeight);
        frame.add(connexionInscriptionPanel);

        // Panel pour le logo
        Logo logoPanel = new Logo(frameWidth, frameHeight);
        frame.add(logoPanel);

        // Panel pour le bouton skip
        Skip skipPanel = new Skip(frameWidth, frameHeight);
        frame.add(skipPanel);

        // Ajuster la taille de la fenêtre pour s'adapter au contenu
        frame.pack();
    }
}
