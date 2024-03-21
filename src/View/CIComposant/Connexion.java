package View.CIComposant;

import javax.swing.*;
import java.awt.*;

public class Connexion extends JPanel {
    public Connexion(int frame_width, int frame_height) {
        setLayout(new BorderLayout());

        // Création du panneau pour le formulaire de connexion
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(2, 1, 0, 10)); // GridLayout avec 2 lignes, espacement vertical de 10 pixels entre les lignes
        formPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // Ajoute une marge autour du panneau

        // Panel pour la paire d'étiquette-champ de saisie de l'e-mail
        JPanel emailPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centrer les éléments horizontalement
        JLabel emailLabel = new JLabel("Mail :");
        JTextField emailField = new JTextField(20);
        emailPanel.add(emailLabel);
        emailPanel.add(emailField);

        // Panel pour la paire d'étiquette-champ de saisie du mot de passe
        JPanel passwordPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Centrer les éléments horizontalement
        JLabel passwordLabel = new JLabel("Mot de passe :");
        JPasswordField passwordField = new JPasswordField(20);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        // Ajout des panels au formulaire
        formPanel.add(emailPanel);
        formPanel.add(passwordPanel);

        // Ajoute le panneau du formulaire au centre du panneau principal
        add(formPanel, BorderLayout.CENTER);
    }
}