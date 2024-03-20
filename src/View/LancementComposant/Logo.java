package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Logo extends JPanel {
    /**CONSTRUCTEUR**/
    public Logo(int frame_width, int frame_height) {
        JLabel label = new JLabel("CINAMAX");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement dans le JLabel
        label.setVerticalAlignment(SwingConstants.CENTER); // Centrer le texte verticalement dans le JLabel

        int panel_height = (int) (frame_height); // Ajustement pour que le panel de Logo prenne 10% de l'écran
        label.setPreferredSize(new Dimension(frame_width,panel_height));
        add(label);
    }
}
