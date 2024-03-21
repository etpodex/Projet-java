package View.CIComposant;

import javax.swing.*;
import java.awt.*;

public class Inscription extends JPanel {

    private static final int FIELD_WIDTH = 20;

    public Inscription(int panelWidth, int panelHeight) {
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setBackground(Color.WHITE); // Couleur de fond du panneau

        // Création des étiquettes et des champs de texte pour chaque champ du formulaire
        JLabel[] labels = {
                new JLabel("Nom:"),
                new JLabel("Prénom:"),
                new JLabel("Âge:"),
                new JLabel("E-mail:"),
                new JLabel("Mot de passe:")
        };

        JTextField[] textFields = {
                new JTextField(FIELD_WIDTH),
                new JTextField(FIELD_WIDTH),
                new JTextField(3), // 3 caractères de large pour l'âge
                new JTextField(FIELD_WIDTH),
                new JPasswordField(FIELD_WIDTH) // Champs de mot de passe
        };

        // Mise en page des composants avec une disposition de grille améliorée
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les composants

        // Ajout des étiquettes et des champs de texte à la grille
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; // Colonne des étiquettes
            gbc.gridy = i; // Ligne actuelle
            gbc.anchor = GridBagConstraints.LINE_END; // Alignement à droite
            add(labels[i], gbc);

            gbc.gridx = 1; // Colonne des champs de texte
            gbc.anchor = GridBagConstraints.LINE_START; // Alignement à gauche
            add(textFields[i], gbc);
        }
    }
}
