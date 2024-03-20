package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Skip extends JPanel {
    /**CONSTRUCTEUR**/
    public Skip(int frame_width, int frame_height) {
        JLabel label = new JLabel("Skip Panel");
        //60% de la page pour les boutons
        int panel_height = (int) (frame_height*0.2);
        setPreferredSize(new Dimension(frame_width,panel_height)); // Définir une taille préférée pour le JLabel
        add(label);
        // Ajoutez ici d'autres composants pour le bouton de skip
    }
}
