package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Skip extends JPanel {
    public Skip(int frameWidth, int frameHeight) {
        JLabel label = new JLabel("Skip Panel");
        label.setPreferredSize(new Dimension(frameWidth, frameHeight / 3)); // Définir une taille préférée pour le JLabel
        add(label);
        // Ajoutez ici d'autres composants pour le bouton de skip
    }
}
