package View.Onglets;

import Model.Utilisateur;
import View.Onglets.MonCompteComposant.*;

import javax.swing.*;
import java.awt.*;

public class MonCompteVue extends JPanel {

    private Utilisateur utilisateur;

    private InformationUtilisateurs information_utilisateurs_scroll_panel;
    private Footer footer_panel;

    public MonCompteVue() {
        setBackground(new Color(194, 156, 255)); // Définir la couleur de fond du panneau
        setLayout(new BorderLayout()); // Utiliser un BorderLayout pour organiser les composants

        // Création du panel d'informations utilisateurs
        this.information_utilisateurs_scroll_panel = new InformationUtilisateurs(utilisateur);

        // Ajout du JScrollPane d'informations utilisateurs au centre de MonCompteVue par défaut
        add(information_utilisateurs_scroll_panel, BorderLayout.CENTER);

        // Création du footer
        this.footer_panel = new Footer();

        // Ajout du footer en bas de MonCompteVue
        add(footer_panel, BorderLayout.SOUTH);

        // Ajout des listeners du footer pour changer la vue
        footer_panel.addModifierListener(e -> {
            information_utilisateurs_scroll_panel.switchVue(); // Activer le mode édition
        });
        footer_panel.addValiderListener(e -> {
            information_utilisateurs_scroll_panel.switchVue(); // Désactiver le mode édition
        });
    }

    // Méthode pour mettre à jour les informations utilisateur
    public void updateMonCompte(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
        information_utilisateurs_scroll_panel.updateValues(utilisateur);
    }
}

// Classe interne pour le panneau d'informations sur l'utilisateur
class InformationUtilisateurs extends JScrollPane {

    private JPanel panel;

    private JTextField prenomField;
    private JTextField nomField;
    private JTextField ageField;
    private JTextField nvAvantageField;
    private JTextField emailField;
    private JPasswordField passwordField;

    private boolean isEditable = false; // Indicateur pour le mode édition

    // Constructeur
    public InformationUtilisateurs(Utilisateur utilisateur) {

        panel = new JPanel(); // Création d'un JPanel pour contenir les composants

        panel.setBackground(new Color(255, 204, 204)); // Définition de la couleur de fond
        panel.setLayout(new GridBagLayout()); // Utilisation d'un gestionnaire de disposition GridBagLayout

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

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
        updateValues(utilisateur);

        // Positionnement des composants sur la grille
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(prenomLabel, gbc);

        gbc.gridx = 1;
        panel.add(prenomField, gbc);

        gbc.gridx = 2;
        panel.add(nomLabel, gbc);

        gbc.gridx = 3;
        panel.add(nomField, gbc);

        gbc.gridx = 4;
        panel.add(ageLabel, gbc);

        gbc.gridx = 5;
        panel.add(ageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        panel.add(nvAvantageLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 1;
        panel.add(nvAvantageField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        panel.add(emailLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 4;
        panel.add(emailField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 2;
        gbc.gridwidth = 4;
        panel.add(passwordField, gbc);

        setViewportView(panel);
    }

    // Méthode pour mettre à jour les valeurs des champs de texte avec les informations utilisateur
    public void updateValues(Utilisateur utilisateur) {
        if (utilisateur != null) {
            prenomField.setText(utilisateur.getPrenom());
            nomField.setText(utilisateur.getNom());
            ageField.setText(String.valueOf(utilisateur.getAge()));
            nvAvantageField.setText(String.valueOf(utilisateur.getNvAvantage()));
            emailField.setText(utilisateur.getEmail());
            passwordField.setText(utilisateur.getPassword());
        } else {
            prenomField.setText("Inconnu");
            nomField.setText("Inconnu");
            ageField.setText("Inconnu");
            nvAvantageField.setText("Inconnu");
            emailField.setText("Vous n'êtes pas connecté");
            passwordField.setText("Inconnu");
        }
    }

    // Méthode pour activer/désactiver le mode édition
    public void switchVue() {
        if (isEditable) {
            // Désactiver le mode édition
            prenomField.setEditable(false);
            nomField.setEditable(false);
            ageField.setEditable(false);
            nvAvantageField.setEditable(false);
            emailField.setEditable(false);
            passwordField.setEditable(false);
            passwordField.setEchoChar('*'); // Masquer le mot de passe
        } else {
            // Activer le mode édition
            prenomField.setEditable(true);
            nomField.setEditable(true);
            ageField.setEditable(true);
            nvAvantageField.setEditable(true);
            emailField.setEditable(true);
            passwordField.setEditable(true);
            passwordField.setEchoChar('\0'); // Afficher le mot de passe
        }
        isEditable = !isEditable; // Inverser le mode édition
    }
}
