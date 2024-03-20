package View;

import View.LancementComposant.ConnexionInscription;
import View.LancementComposant.Logo;
import View.LancementComposant.Skip;
import javax.swing.*;
import java.awt.*;

public class LancementVue {

    public static void remplirFrame(JFrame frame, int frameWidth, int frameHeight) {
        // Calcul des dimensions pour chaque composant
        int logoPanelHeight = (int) (frameHeight * 0.1);
        int connexionInscriptionPanelHeight = (int) (frameHeight * 0.8); // 85% de la hauteur de la fenêtre
        int skipPanelHeight = (int) (frameHeight * 0.1);

        // Création des panels avec leurs tailles calculées
        Logo logoPanel = new Logo(frameWidth, logoPanelHeight);
        ConnexionInscription connexionInscriptionPanel = new ConnexionInscription(frameWidth, connexionInscriptionPanelHeight);
        Skip skipPanel = new Skip(frameWidth, skipPanelHeight);

        // Ajout des panels à la fenêtre avec BoxLayout pour les disposer verticalement
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(logoPanel);
        frame.add(connexionInscriptionPanel);
        frame.add(skipPanel);

        // Ajustement de la taille de la fenêtre pour s'adapter au contenu
        frame.pack();
    }
}
