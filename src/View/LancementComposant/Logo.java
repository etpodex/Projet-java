package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Logo extends JPanel {
    public Logo(int frameWidth, int frameHeight) {
        JLabel label = new JLabel("Logo Panel");
        label.setPreferredSize(new Dimension(frameWidth, frameHeight / 3)); // Définir une taille préférée pour le JLabel
        add(label);
        // Ajoutez ici le logo ou d'autres composants pour l'affichage du logo
    }
}
