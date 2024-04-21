package View.Onglets.AccueilVueComposant;

import Model.Offre;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * La classe OffreVue représente un panneau pour afficher des offres avec des codes promo et des réductions.
 */
public class OffreVue extends JPanel {

    private Offre[] offres = new Offre[]{
            new Offre("Offre1", 10, "CODE1"),
            new Offre("Offre2", 20, "CODE2"),
            new Offre("Offre3", 15, "CODE3")
    };
    private int nombre_de_panel_offre = offres.length; // Nombre de panneaux correspondant au nombre d'offres
    private double[] poids_panels; // Poids des panneaux pour le layout

    /**
     * Constructeur de la classe OffreVue.
     *
     * @param barre_navigation_panel_width La largeur de la barre de navigation.
     * @param frame_height                 La hauteur du frame.
     */
    public OffreVue(int barre_navigation_panel_width, int frame_height) {
        // Initialiser les poids des panneaux en fonction du nombre d'offres
        poids_panels = new double[nombre_de_panel_offre];
        for (int i = 0; i < nombre_de_panel_offre; i++) {
            poids_panels[i] = 1.0 / nombre_de_panel_offre;
        }

        // Calcul de la hauteur des panneaux
        int hauteur = frame_height * 1 / 3 - 30;

        // Configuration de l'apparence du JPanel Offre
        setBackground(new Color(238, 238, 238)); // Couleur de fond
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur)); // Taille préférée
        setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure

        // Configuration du layout en grille
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Remplissage horizontal et vertical

        // Appel de la méthode pour créer et ajouter les panneaux
        creerEtAjouterPanels(gbc, hauteur);
    }

    /**
     * Méthode privée pour créer et ajouter les panneaux d'offres.
     *
     * @param gbc      Les contraintes de la grille.
     * @param hauteur  La hauteur des panneaux.
     */
    private void creerEtAjouterPanels(GridBagConstraints gbc, int hauteur) {
        for (int i = 0; i < nombre_de_panel_offre; i++) {
            JPanel panel_offre = new JPanel(); // Création d'un nouveau JPanel
            panel_offre.setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour centrer le texte

            // Configuration de l'apparence du JPanel
            panel_offre.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure
            panel_offre.setBackground(new Color(255, 255 - 20 * i, 255 - 40 * i)); // Couleur de fond

            // Création du JLabel pour l'offre
            String texteOffre = String.format("<html><center>Avec le code %s <br>obtenez %d%% de réduction !</center></html>", offres[i].getCode_promo(), offres[i].getReduction());
            JLabel labelOffre = new JLabel(texteOffre, SwingConstants.CENTER);
            panel_offre.add(labelOffre, BorderLayout.CENTER); // Ajout du label au centre du panel

            // Configuration des contraintes du layout
            gbc.gridx = i; // Position en X dans la grille
            gbc.weightx = poids_panels[i]; // Poids horizontal
            gbc.weighty = 1; // Poids vertical pour utiliser toute la hauteur disponible

            // Ajout du JPanel au conteneur Offre
            add(panel_offre, gbc);
        }
    }
}
