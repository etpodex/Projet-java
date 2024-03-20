package View.LancementComposant;

import javax.swing.*;
import java.awt.*;

public class Skip extends JPanel {

    public Skip(int frame_width, int frame_height) {
        setLayout(new GridBagLayout());

        //Bouton Inscription
        JButton bouton_skip = new JButton ("Skip");

        //GridBagLayout :
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0; // Poids pour occuper l'espace disponible dans la colonne

        add(bouton_skip, gbc);
    }
}
