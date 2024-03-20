package View.LancementComposant;

/**BIBLIOTHEQUE**/
import javax.swing.*;
import java.awt.*;

public class ConnexionInscription extends JPanel {

    /**CONSTRUCTEUR**/
    public ConnexionInscription(int frame_width, int frame_height) {
        //Utilisation GridBagLayout pour positionner les composants
        setLayout(new GridBagLayout());

        //Bouton connexion
        JButton bouton_connexion = new JButton("Connexion");

        //Bouton Inscription
        JButton bouton_inscription = new JButton ("Inscription");

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
