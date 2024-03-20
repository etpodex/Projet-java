package View.LancementComposant;

/**BIBLIOTHEQUE**/
import javax.swing.*;
import java.awt.*;

public class ConnexionInscription extends JPanel {

    /**CONSTRUCTEUR**/
    public ConnexionInscription(int frameWidth, int frameHeight) {
        JLabel label = new JLabel("Connexion/Inscription Panel");
        label.setPreferredSize(new Dimension(frameWidth, frameHeight / 3)); // Définir une taille préférée pour le JLabel
        add(label);
        // Ajoutez ici d'autres composants pour la connexion/inscription
    }
}
