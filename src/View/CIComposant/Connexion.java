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
        this.emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Panel pour la paire d'étiquette-champ de saisie du mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe :");
        gbc.gridy++;
        formPanel.add(passwordLabel, gbc);
        gbc.gridy++;
        this.passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Ajoute le panneau du formulaire au centre du panneau principal
        add(formPanel, BorderLayout.CENTER);
    }

    public String[] getConnexionData() {
        // Récupère les données de connexion
        String[] data = new String[2];
        data[0] = emailField.getText();
        data[1] = new String(passwordField.getPassword());
        return data;
    }
}
