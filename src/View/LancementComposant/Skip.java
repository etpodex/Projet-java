package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Skip extends JPanel {

    public Skip(int frameWidth, int frameHeight) {
        setLayout(new GridBagLayout());

        // Création du bouton "Skip"
        JButton boutonSkip = new JButton("Skip");

        // GridBagConstraints pour positionner le bouton à droite
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Marge
        gbc.anchor = GridBagConstraints.EAST; // Ancrage à l'est pour placer le composant à droite
        gbc.weightx = 1.0; // Poids pour occuper l'espace disponible dans la colonne

        add(boutonSkip, gbc); // Ajout du bouton avec les contraintes
    }
}
