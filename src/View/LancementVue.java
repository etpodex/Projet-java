package View;

import Controller.Evenements.AffConnexionEvenement;
import Controller.Evenements.FileEvenements;
import Controller.Evenements.AffInscriptionEvenement;
import Controller.Evenements.SkipEvenement;

import javax.swing.*;
import java.awt.*;

public class LancementVue {

    private static Skip skip_panel;
    private static ConnexionInscription connexion_inscription_panel;

    public LancementVue(){
    }

    public void remplirPanel(JFrame frame, int frame_width, int frame_height) {
        JPanel grand_panneau = new JPanel();

        // Calcul des dimensions pour chaque composant
        int logo_panel_height = (int) (frame_height * 0.1);
        int connexion_inscription_panel_height = (int) (frame_height * 0.8); // 85% de la hauteur de la fenêtre

        // Création des panels avec leurs tailles calculées
        Logo logo_panel = new Logo(frame_width, logo_panel_height);
        connexion_inscription_panel = new ConnexionInscription(frame_width, connexion_inscription_panel_height);
        skip_panel = new Skip();

        // Ajout des panels au grand panneau avec BoxLayout pour les disposer verticalement
        grand_panneau.setLayout(new BoxLayout(grand_panneau, BoxLayout.Y_AXIS));
        grand_panneau.add(logo_panel);
        grand_panneau.add(connexion_inscription_panel);
        grand_panneau.add(skip_panel);

        // Ajout du grand panneau au JFrame
        frame.getContentPane().add(grand_panneau);
    }
}

class Skip extends JPanel {

    /**ATTRIBUTS**/
    private JButton bouton_skip;

    /**CONSTRUCTEUR**/
    public Skip() {
        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        setLayout(new GridBagLayout());

        //Bouton skip
        bouton_skip = new JButton ("Skip");
        bouton_skip.addActionListener(e -> {FileEvenements.getInstance().publier(new SkipEvenement());} );

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

class Logo extends JPanel {
    /**CONSTRUCTEUR**/
    public Logo(int frame_width, int frame_height) {
        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        JLabel label = new JLabel("CINAMAX");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement dans le JLabel
        label.setVerticalAlignment(SwingConstants.CENTER); // Centrer le texte verticalement dans le JLabel

        int panel_height = (int) (frame_height); // Ajustement pour que le panel de Logo prenne 10% de l'écran
        label.setPreferredSize(new Dimension(frame_width,panel_height));
        add(label);
    }
}

class ConnexionInscription extends JPanel {
    /**ATTRIBUT**/
    private JButton bouton_connexion;
    private JButton bouton_inscription;

    /**CONSTRUCTEUR**/
    public ConnexionInscription(int frame_width, int frame_height) {
        //Utilisation GridBagLayout pour positionner les composants
        setLayout(new GridBagLayout());

        //Bouton connexion
        bouton_connexion = new JButton("Connexion");
        bouton_connexion.addActionListener(e -> FileEvenements.getInstance().publier(new AffConnexionEvenement()));

        //Bouton Inscription
        bouton_inscription = new JButton ("Inscription");
        bouton_inscription.addActionListener(e -> FileEvenements.getInstance().publier(new AffInscriptionEvenement()));

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
}
