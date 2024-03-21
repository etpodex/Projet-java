package View.LancementComposant;

import View.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Skip extends JPanel {

    /**ATTRIBUTS**/
    private JButton bouton_skip;

    /**CONSTRUCTEUR**/
    public Skip(LancementVue lancement_vue) {

        setLayout(new GridBagLayout());

        //Bouton skip
        bouton_skip = new JButton ("Skip");
        bouton_skip.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Skip\" a été cliqué!");
                lancement_vue.clicSkip();
            }
        });

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
