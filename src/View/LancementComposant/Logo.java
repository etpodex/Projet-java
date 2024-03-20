package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Logo extends JPanel {
    /**CONSTRUCTEUR**/
    public Logo(int frame_width, int frame_height) {
        JLabel label = new JLabel("Logo Panel");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement dans le JLabel
        label.setVerticalAlignment(SwingConstants.CENTER); // Centrer le texte verticalement dans le JLabel

        //20% de la page pour le logo
        int panel_height = (int) (frame_height*0.2);
        label.setPreferredSize(new Dimension(frame_width,panel_height));
        add(label);
        // Ajoutez ici le logo ou d'autres composants pour l'affichage du logo
    }
}
