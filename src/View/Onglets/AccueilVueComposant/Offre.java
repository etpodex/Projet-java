package View.Onglets.AccueilVueComposant;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Offre extends JPanel {

    private int nombre_de_panel_offre = 4; // Nombre de panneaux dans l'offre
    private double[] poids_panels = {0.25, 0.25, 0.25, 0.25}; // Poids des panneaux pour le layout

    // Constructeur
    public Offre(int barre_navigation_panel_width, int frame_height) {

        // Calcul de la hauteur des panneaux
        int hauteur = frame_height * 1 / 3 - 30;

        // Configuration de l'apparence du JPanel Offre
        setBackground(new Color(0, 255, 127)); // Couleur de fond
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur)); // Taille préférée
        setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure

        // Configuration du layout en grille
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH; // Remplissage horizontal et vertical

        // Appel de la méthode pour créer et ajouter les panneaux
        creerEtAjouterPanels(gbc, hauteur);

    }

    // Méthode pour créer et ajouter les panneaux
    private void creerEtAjouterPanels(GridBagConstraints gbc, int hauteur) {
        for (int i = 0; i < nombre_de_panel_offre; i++) {
            JPanel panel_offre = new JPanel(); // Création d'un nouveau JPanel

            // Configuration de l'apparence du JPanel
            panel_offre.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure
            panel_offre.setBackground(new Color(255 * i / (i + 1), 100 * i / (i + 1), 0)); // Couleur de fond

            // Configuration des contraintes du layout
            gbc.gridx = i; // Position en X dans la grille
            gbc.weightx = poids_panels[i]; // Poids horizontal
            gbc.weighty = hauteur; // Poids vertical

            // Ajout du JPanel au conteneur Offre
            add(panel_offre, gbc);
        }
    }
}
