package View.CIComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Footer extends JPanel{
    private JButton bouton_valider;
    private JButton bouton_retour;

    public Footer(int frame_width, int frame_height){
        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        setLayout(new GridBagLayout());

        bouton_valider = new JButton("Valider");
        bouton_retour = new JButton("Retour");

        //GridBagLayout :
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0; // Poids pour occuper l'espace disponible dans la colonne

        add(bouton_valider, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        add(bouton_retour, gbc);
    }

    /**
    // Méthode pour obtenir les boutons
    public JButton getSkipBouton() {
        return bouton_valider;
    }
    public JButton getSkipBouton() {
        return bouton_valider;
    }**/
}


