package View.CIComposant;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class Inscription extends JPanel {

    private static final int FIELD_WIDTH = 20;

    private JTextField nomField;
    private JTextField prenomField;
    private JFormattedTextField ageField;
    private JTextField mailField;
    private JPasswordField passwordField;

    private JComboBox<Integer> ageComboBox;

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

        nomField = new JTextField(FIELD_WIDTH);
        prenomField = new JTextField(FIELD_WIDTH);
        mailField = new JTextField(FIELD_WIDTH);
        passwordField = new JPasswordField(FIELD_WIDTH); // Champs de mot de passe

        // Création d'un champ de texte pour l'âge avec un filtre pour n'accepter que les chiffres
        try {
            MaskFormatter ageFormatter = new MaskFormatter("##"); // Format pour deux chiffres
            ageField = new JFormattedTextField(ageFormatter);
            ageField.setColumns(3); // Taille du champ
        } catch (ParseException e) {
            e.printStackTrace();
        }

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
            if (i == 2) {
                add(ageField, gbc); // Ajout du champ de texte pour l'âge
            } else {
                add(getFieldComponent(i), gbc);
            }
        }
    }

    // Méthode pour obtenir le champ de texte correspondant à l'index
    private JTextField getFieldComponent(int index) {
        switch (index) {
            case 0: return nomField;
            case 1: return prenomField;
            case 3: return mailField;
            case 4: return passwordField;
            default: return null;
        }
    }

    // Méthode pour récupérer les données d'inscription
    public String[] getInscriptionData() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        String age = ageField.getText(); // Récupération de l'âge depuis le champ de texte
        String mail = mailField.getText();
        String password = new String(passwordField.getPassword());

        return new String[]{mail, password, nom, prenom, age, "1"};

        //pour change convertir le string d'age en int plus tard
        /**
         * // Récupération de l'âge depuis le champ de texte
         * String ageStr = ageField.getText();
         *
         * // Conversion de la chaîne de caractères en un entier
         * int age = Integer.parseInt(ageStr);
         */
    }
}
