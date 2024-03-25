package View.Onglets.LesFilmsComposant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Film extends JPanel {

    private int nombre_de_panel_film = 2;
    private double[] poids_panels = {0.25, 0.75};

    // Constructeur
    public Film(int barre_navigation_panel_width, int hauteur) {

        setBackground(new Color(0, 255, 127));
        setPreferredSize(new Dimension(barre_navigation_panel_width,hauteur));
        setBorder(new EmptyBorder(5,5,5,5));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        creerEtAjouterPanels(gbc, hauteur);

    }

    //Methode
    private void creerEtAjouterPanels(GridBagConstraints gbc, int hauteur){
        for (int i=0; i<nombre_de_panel_film; i++){
            JPanel panel_film = new JPanel();

            panel_film.setBorder(new EmptyBorder(5, 5, 5, 5));
            panel_film.setBackground(new Color(255*i/(i+1),100*i/(i+1),0));

            gbc.gridx = i;
            gbc.weightx = poids_panels[i];
            gbc.weighty = hauteur;

            add(panel_film, gbc);
        }
    }
}