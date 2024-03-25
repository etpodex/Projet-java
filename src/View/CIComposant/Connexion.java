package View.CIComposant;

import javax.swing.*;
import java.awt.*;

public class Connexion extends JPanel {

    private JTextField emailField;
    private JPasswordField passwordField;

    public Connexion(int frame_width, int frame_height) {
        setLayout(new BorderLayout());

        // Création du panneau pour le formulaire de connexion
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0); // Espacement entre les champs

        // Panel pour la paire d'étiquette-champ de saisie de l'e-mail
        JLabel emailLabel = new JLabel("Mail :");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(emailLabel, gbc);
        gbc.gridy++;
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Panel pour la paire d'étiquette-champ de saisie du mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe :");
        gbc.gridy++;
        formPanel.add(passwordLabel, gbc);
        gbc.gridy++;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Ajoute le panneau du formulaire au centre du panneau principal
        add(formPanel, BorderLayout.CENTER);
    }

    // Méthode pour récupérer les données de connexion
    public String[] getConnexionData() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        return new String[]{email, password};
    }
}
