package View.Onglets.MonCompteComposant;

import javax.swing.*;
import java.awt.*;
import Model.Utilisateur;

/**
 * Panneau pour afficher les informations de l'utilisateur.
 */
public class InformationUtilisateurs extends JPanel {

    // Attributs
    private JTextField prenomField;
    private JTextField nomField;
    private JTextField ageField;
    private JTextField nvAvantageField;
    private JTextField emailField;
    private JTextField passwordField;
    private Utilisateur utilisateur;

    /**
     * Constructeur de la classe InformationUtilisateurs.
     * @param utilisateur l'utilisateur pour lequel afficher les informations.
     */
    public InformationUtilisateurs(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;

        setBackground(new Color(255, 204, 204)); // Définition de la couleur de fond
        setLayout(new GridBagLayout()); // Utilisation d'un gestionnaire de disposition GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5); // Marge autour des composants

        // Création des étiquettes pour les champs de texte
        JLabel prenomLabel = new JLabel("Prénom: ");
        JLabel nomLabel = new JLabel("Nom: ");
        JLabel ageLabel = new JLabel("Age: ");
        JLabel nvAvantageLabel = new JLabel("Niveau d'avantage: ");
        JLabel emailLabel = new JLabel("Email: ");
        JLabel passwordLabel = new JLabel("Mot de passe: ");

        // Création des champs de texte avec une taille réduite
        prenomField = new JTextField(10);
        nomField = new JTextField(10);
        ageField = new JTextField(3); // Taille réduite pour l'âge
        nvAvantageField = new JTextField(5);
        emailField = new JTextField(15);
        passwordField = new JPasswordField(10);

        // Affichage des informations de l'utilisateur dans les champs de texte correspondants
        prenomField.setText(utilisateur.getPrenom());
        nomField.setText(utilisateur.getNom());
        ageField.setText(Integer.toString(utilisateur.getAge()));
        nvAvantageField.setText(Integer.toString(utilisateur.getNvAvantage()));
        emailField.setText(utilisateur.getEmail());
        passwordField.setText(utilisateur.getPassword());

        // Positionnement des composants sur la grille
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(prenomLabel, gbc);

        gbc.gridx = 1;
        add(prenomField, gbc);

        gbc.gridx = 2;
        add(nomLabel, gbc);

        gbc.gridx = 3;
        add(nomField, gbc);

        gbc.gridx = 4;
        add(ageLabel, gbc);

        gbc.gridx = 5;
        add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(nvAvantageLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        add(nvAvantageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        add(emailLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 4;
        add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(passwordLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 4;
        add(passwordField, gbc);

        // Désactivation de l'édition des champs de texte
        prenomField.setEditable(false);
        nomField.setEditable(false);
        ageField.setEditable(false);
        nvAvantageField.setEditable(false);
        emailField.setEditable(false);
        passwordField.setEditable(false);
    }
}
