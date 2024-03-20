package View;

import View.LancementComposant.*;
import javax.swing.*;

public class LancementVue {

    public static void remplirPanel(JFrame frame, int frame_width, int frame_height) {
        JPanel grand_panneau = new JPanel();

        // Calcul des dimensions pour chaque composant
        int logo_panel_height = (int) (frame_height * 0.1);
        int connexion_inscription_panel_height = (int) (frame_height * 0.8); // 85% de la hauteur de la fenêtre
        int skip_panel_height = (int) (frame_height * 0.1);

        // Création des panels avec leurs tailles calculées
        Logo logo_panel = new Logo(frame_width, logo_panel_height);
        ConnexionInscription connexion_inscription_panel = new ConnexionInscription(frame_width, connexion_inscription_panel_height);
        Skip skip_panel = new Skip(frame_width, skip_panel_height);

        // Ajout des panels au grand panneau avec BoxLayout pour les disposer verticalement
        grand_panneau.setLayout(new BoxLayout(grand_panneau, BoxLayout.Y_AXIS));
        grand_panneau.add(logo_panel);
        grand_panneau.add(connexion_inscription_panel);
        grand_panneau.add(skip_panel);

        // Ajout du grand panneau au JFrame
        frame.getContentPane().add(grand_panneau);
    }
}
