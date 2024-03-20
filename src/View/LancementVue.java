package View;

import View.LancementComposant.*;
import javax.swing.*;

public class LancementVue {

    public static void remplirFrame(JFrame frame, int frame_width, int frame_height) {
        // Calcul des dimensions pour chaque composant
        int logo_panel_height = (int) (frame_height * 0.1);
        int connexion_inscription_panel_height = (int) (frame_height * 0.8); // 85% de la hauteur de la fenêtre
        int skip_panel_height = (int) (frame_height * 0.1);

        // Création des panels avec leurs tailles calculées
        Logo logo_panel = new Logo(frame_width, logo_panel_height);
        ConnexionInscription connexion_inscription_panel = new ConnexionInscription(frame_width, connexion_inscription_panel_height);
        Skip skip_panel = new Skip(frame_width, skip_panel_height);

        // Ajout des panels à la fenêtre avec BoxLayout pour les disposer verticalement
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(logo_panel);
        frame.add(connexion_inscription_panel);
        frame.add(skip_panel);

        // Ajustement de la taille de la fenêtre pour s'adapter au contenu
        frame.pack();
    }
}
