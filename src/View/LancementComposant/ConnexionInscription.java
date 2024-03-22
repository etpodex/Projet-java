package View.LancementComposant;

/**BIBLIOTHEQUE**/
import View.LancementVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnexionInscription extends JPanel {
    /**ATTRIBUT**/
    private JButton bouton_connexion;
    private JButton bouton_inscription;

    /**CONSTRUCTEUR**/
    public ConnexionInscription(int frame_width, int frame_height, LancementVue lancement_vue) {
        //Utilisation GridBagLayout pour positionner les composants
        setLayout(new GridBagLayout());

        //Bouton connexion
        bouton_connexion = new JButton("Connexion");
        bouton_connexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Connexion\" a été cliqué!");
                lancement_vue.clicConnexion();
            }
        });

        //Bouton Inscription
        bouton_inscription = new JButton ("Inscription");
        bouton_inscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Inscription\" a été cliqué!");
                lancement_vue.clicInscription();
            }
        });

        //GridBagLayout :
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);

        add(bouton_connexion, gbc);

        gbc.gridy = 1;
        add(bouton_inscription, gbc);

        setPreferredSize(new Dimension(frame_width,frame_height));
    }

    /**METHODE**/

    // POUR BOUTON CONNEXION

    //-->pour le moment cette methode est inutile
    public void addConnexionBoutonListener(ActionListener listener){
        bouton_connexion.addActionListener(listener);
    }

    // Méthode pour obtenir le bouton "Skip"
    public JButton getConnexionBouton() {
        return bouton_connexion;
    }

    // POUR BOUTON INSCRIPTION

    // Méthode pour obtenir le bouton "Skip"
    public JButton getInscriptionBouton() {
        return bouton_inscription;
    }
}
