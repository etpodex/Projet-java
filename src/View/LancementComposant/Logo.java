package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Logo extends JPanel {

    public Logo(int frameWidth, int frameHeight) {
        JLabel label = new JLabel("CINAMAX");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement dans le JLabel
        label.setVerticalAlignment(SwingConstants.CENTER); // Centrer le texte verticalement dans le JLabel

        int panelHeight = (int) (frameHeight * 0.1); // Ajustement pour que le panel de Logo prenne 10% de l'écran
        label.setPreferredSize(new Dimension(frameWidth, panelHeight));
        add(label);
    }
}
