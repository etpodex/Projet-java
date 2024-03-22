package View.CIComposant;

import View.CIVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel{
    private JButton bouton_valider;
    private JButton bouton_retour;

    public Footer(int frame_width, int frame_height, CIVue ci_vue){
        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        setLayout(new GridBagLayout());

        bouton_valider = new JButton("Valider");
        bouton_valider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Valider\" a été cliqué!");
                ci_vue.clicValider();
            }
        });

        bouton_retour = new JButton("Retour");
        bouton_retour.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Retour\" a été cliqué!");
                ci_vue.clicRetour();
            }
        });
        ///action listener

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


    // Méthode pour obtenir les boutons
    public JButton getValiderBouton() {
        return bouton_valider;
    }
    public JButton getRetourBouton() {
        return bouton_retour;
    }
}


