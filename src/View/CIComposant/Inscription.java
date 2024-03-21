package View.CIComposant;

import javax.swing.*;
import java.awt.*;

public class Inscription extends JPanel {

    public Inscription(int panel_width, int panel_height) {
        setPreferredSize(new Dimension(panel_width, panel_height));
        setBackground(Color.WHITE); // Couleur de fond du panneau

        // Création des étiquettes et des champs de texte pour chaque champ du formulaire
        JLabel nomLabel = new JLabel("Nom:");
        JTextField nomField = new JTextField(20); // 20 caractères de large

        JLabel prenomLabel = new JLabel("Prénom:");
        JTextField prenomField = new JTextField(20);

        JLabel ageLabel = new JLabel("Âge:");
        JTextField ageField = new JTextField(3); // 3 caractères de large pour l'âge

        JLabel mailLabel = new JLabel("E-mail:");
        JTextField mailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        JPasswordField passwordField = new JPasswordField(20); // Champs de mot de passe

        // Mise en page des composants
        setLayout(new GridLayout(6, 2, 5, 5)); // 6 lignes, 2 colonnes, espacement de 5 pixels
        add(nomLabel);
        add(nomField);
        add(prenomLabel);
        add(prenomField);
        add(ageLabel);
        add(ageField);
        add(mailLabel);
        add(mailField);
        add(passwordLabel);
        add(passwordField);
    }
}

