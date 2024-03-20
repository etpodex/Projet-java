package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class ConnexionInscription extends JPanel {

    public ConnexionInscription(int frameWidth, int frameHeight) {
        // Utilisation GridBagLayout pour positionner les composants
        setLayout(new GridBagLayout());

        // Bouton connexion
        JButton boutonConnexion = new JButton("Connexion");

        // Bouton Inscription
        JButton boutonInscription = new JButton("Inscription");

        // GridBagConstraints pour positionner les composants
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5); // Marge entre les composants

        add(boutonConnexion, gbc);

        gbc.gridy = 1;
        add(boutonInscription, gbc);

        setPreferredSize(new Dimension(frameWidth, frameHeight));
    }
}
