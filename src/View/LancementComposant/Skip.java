package View.LancementComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Skip extends JPanel {

    /**ATTRIBUTS**/
    private JButton bouton_skip;

    /**CONSTRUCTEUR**/
    public Skip(int frame_width, int frame_height) {
        setLayout(new GridBagLayout());

        //Bouton Inscription
        bouton_skip = new JButton ("Skip");

        //GridBagLayout :
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0; // Poids pour occuper l'espace disponible dans la colonne

        add(bouton_skip, gbc);
    }

    /**METHODE**/

    //-->pour le moment cette methode est inutile
    public void addSkipBoutonListener(ActionListener listener){
        bouton_skip.addActionListener(listener);
    }

    // Méthode pour obtenir le bouton "Skip"
    public JButton getSkipBouton() {
        return bouton_skip;
    }

}
