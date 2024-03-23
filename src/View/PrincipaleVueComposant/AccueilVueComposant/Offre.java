package View.PrincipaleVueComposant.AccueilVueComposant;

import View.PrincipaleVueComposant.AccueilVueComposant.OffreComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Offre extends JPanel {

    private int nombre_de_panel_offre = 2;
    private double[] poids_panels = {0.25, 0.25};

    // Constructeur
    public Offre(int barre_navigation_panel_width, int frame_height) {

        int hauteur = frame_height*1/3 - 30;

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
        for (int i=0; i<nombre_de_panel_offre; i++){
            JPanel panel_offre = new JPanel();

            panel_offre.setBorder(new EmptyBorder(5, 5, 5, 5));
            panel_offre.setBackground(new Color(255*i/(i+1),100*i/(i+1),0));

            gbc.gridx = i;
            gbc.weightx = poids_panels[i];
            gbc.weighty = hauteur;

            add(panel_offre, gbc);
        }
    }
}