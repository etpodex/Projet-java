package View.Onglets.ReservationVueComposant;

import Controller.Evenements.AffichageOnglet.AffPaiementEnCoursEvenement;
import Controller.Evenements.FileEvenements;
import View.MasterVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PaiementVue extends JPanel {

    private JTextField nom_sur_carte_field; // Champ de saisie du nom sur la carte
    private JTextField numero_carte_field; // Champ de saisie du numéro de carte
    private JTextField date_expiration_field; // Champ de saisie de la date d'expiration
    private JTextField cvv_field; // Champ de saisie du CVV
    private JTextField code_promo_field; // Champ de saisie du code promo

    public PaiementVue(int panneau_contenu_width, int frame_height) {

        setBackground(new Color(238,238,238));
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(panneau_contenu_width, frame_height));

        // En-tête de la page de paiement
        JLabel titreLabel = new JLabel("Paiement par carte de crédit");
        titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titreLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Zone de saisie des détails de la carte de crédit
        JPanel detail_carte_panel = new JPanel(new GridBagLayout());
        detail_carte_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nom_sur_carte_label = new JLabel("Nom sur la carte:");
        nom_sur_carte_field = new JTextField(10);
        JLabel numero_carte_label = new JLabel("Numéro de carte:");
        numero_carte_field = new JTextField(15);
        JLabel date_expiration_label = new JLabel("Date d'expiration:");
        date_expiration_field = new JTextField(5);
        JLabel cvv_label = new JLabel("CVV:");
        cvv_field = new JTextField(3);
        JLabel code_promo_label = new JLabel("Code promo:");
        code_promo_field = new JTextField(5);

        // Configuration des contraintes de disposition
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        detail_carte_panel.add(nom_sur_carte_label, gbc);
        gbc.gridy = 1;
        detail_carte_panel.add(numero_carte_label, gbc);

        gbc.gridy = 2;
        detail_carte_panel.add(date_expiration_label, gbc);

        gbc.gridy = 3;
        detail_carte_panel.add(cvv_label, gbc);
        gbc.gridy = 4;
        detail_carte_panel.add(code_promo_label, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        detail_carte_panel.add(nom_sur_carte_field, gbc);

        gbc.gridy = 1;
        detail_carte_panel.add(numero_carte_field, gbc);

        gbc.gridy = 2;
        detail_carte_panel.add(date_expiration_field, gbc);

        gbc.gridy = 3;
        detail_carte_panel.add(cvv_field, gbc);
        gbc.gridy = 4;
        detail_carte_panel.add(code_promo_field, gbc);

        // Ajout du faux numéro de carte en gris clair
        numero_carte_field.setForeground(Color.LIGHT_GRAY);
        numero_carte_field.setText("0000 0000 0000 0000");
        numero_carte_field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (numero_carte_field.getText().equals("0000 0000 0000 0000")) {
                    numero_carte_field.setText("");
                    numero_carte_field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (numero_carte_field.getText().isEmpty()) {
                    numero_carte_field.setText("0000 0000 0000 0000");
                    numero_carte_field.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        // Ajout du faux numéro de carte en gris clair
        date_expiration_field.setForeground(Color.LIGHT_GRAY);
        date_expiration_field.setText("MM/AA");
        date_expiration_field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (date_expiration_field.getText().equals("MM/AA")) {
                    date_expiration_field.setText("");
                    date_expiration_field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (date_expiration_field.getText().isEmpty()) {
                    date_expiration_field.setText("MM/AA");
                    date_expiration_field.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        // Blinder le champ de la date d'expiration pour accepter uniquement des chiffres et insérer automatiquement le "/" après 2 chiffres
        date_expiration_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                JTextField textField = (JTextField) e.getSource();
                if (!((c >= '0' && c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
                if (textField.getText().length() == 2 && c != KeyEvent.VK_BACK_SPACE && c != KeyEvent.VK_DELETE) {
                    textField.setText(textField.getText() + "/");
                }
                if (textField.getText().length() >= 5) {
                    e.consume();
                }
            }
        });

        // Ajout du faux CVV en gris clair
        cvv_field.setForeground(Color.LIGHT_GRAY);
        cvv_field.setText("000");
        cvv_field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (cvv_field.getText().equals("000")) {
                    cvv_field.setText("");
                    cvv_field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (cvv_field.getText().isEmpty()) {
                    cvv_field.setText("000");
                    cvv_field.setForeground(Color.LIGHT_GRAY);
                }
            }
        });

        // Blinder le champ CVV pour accepter uniquement 3 chiffres
        cvv_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }
                // Vérifier si la longueur du champ est supérieure à 3
                if (cvv_field.getText().length() >= 3) {
                    e.consume(); // Ignorer la saisie supplémentaire
                }
            }
        });

        // Limiter le champ du numéro de carte à accepter uniquement des chiffres et un maximum de 19 caractères
        numero_carte_field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) {
                    e.consume();
                }

                // Ajouter un espace tous les 4 chiffres dans le numéro de carte
                String text = numero_carte_field.getText();
                if ((text.length() + 1) % 5 == 0 && text.length() < 19) {
                    numero_carte_field.setText(text + " ");
                }

                // Limiter le champ à 19 caractères (16 chiffres et 3 espaces)
                if (text.length() >= 19) {
                    e.consume();
                }
            }
        });

        // Boutons de paiement et de retour
        JButton bouton_paiement = new JButton("Payer");
        bouton_paiement.setFont(new Font("Arial", Font.BOLD, 16));

        JButton bouton_retour = new JButton("Retour");
        bouton_retour.setFont(new Font("Arial", Font.BOLD, 16));

        // Action lorsque le bouton de paiement est cliqué
        bouton_paiement.addActionListener(e -> {
            if (areAllFieldsFilled()) {
                FileEvenements.getInstance().publier(new AffPaiementEnCoursEvenement());
                // Réinitialiser les champs après un paiement réussi
                reinitialiserChamps();
            }
        });

        // Action lorsque le bouton de retour est cliqué
        bouton_retour.addActionListener(e -> {
            // Ajoutez ici l'action à effectuer lorsque le bouton de retour est cliqué
        });

        // Ajout des composants à la page de paiement
        add(titreLabel, BorderLayout.NORTH);
        add(detail_carte_panel, BorderLayout.CENTER);

        JPanel boutonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        boutonsPanel.add(bouton_retour);
        boutonsPanel.add(bouton_paiement);
        add(boutonsPanel, BorderLayout.SOUTH);

        revalidate(); // Revalider le panneau pour mettre à jour l'affichage
        repaint(); // Redessiner le panneau
    }

    // Vérifie si tous les champs sont remplis et valides
    // Vérifie si tous les champs sont remplis et valides
    private boolean areAllFieldsFilled() {
        StringBuilder errors = new StringBuilder();
        boolean isValid = true;

        // Vérification des champs non vides
        if (nom_sur_carte_field.getText().isEmpty() ||
                numero_carte_field.getText().isEmpty() ||
                date_expiration_field.getText().isEmpty() ||
                cvv_field.getText().isEmpty() ||
                code_promo_field.getText().isEmpty()) {
            errors.append("Tous les champs doivent être remplis.\n");
            isValid = false;
        }

        // Vérification du numéro de carte
        String numeroCarte = numero_carte_field.getText().replaceAll("\\s+", ""); // Supprime les espaces
        if (numeroCarte.length() != 16 || !numeroCarte.matches("\\d{16}")) {
            errors.append("Numéro de carte invalide.\n");
            isValid = false;
        }

        // Vérification de la date d'expiration
        String dateExpiration = date_expiration_field.getText();
        if (!dateExpiration.matches("\\d{2}/\\d{2}")) {
            errors.append("Date d'expiration invalide.\n");
            isValid = false;
        } else {
            // Extraire le mois et l'année
            String[] parts = dateExpiration.split("/");
            int month = Integer.parseInt(parts[0]);
            int year = Integer.parseInt(parts[1]);

            // Vérifier si le mois est entre 1 et 12 et l'année est dans le futur
            if (month < 1 || month > 12 || year < 22 || (year == 22 && month < 4)) {
                errors.append("Date d'expiration invalide.\n");
                isValid = false;
            }
        }

        // Vérification du CVV
        String cvv = cvv_field.getText();
        if (cvv.length() != 3 || !cvv.matches("\\d{3}")) {
            errors.append("CVV invalide.\n");
            isValid = false;
        }

        // Si des erreurs sont détectées, affichez toutes les erreurs accumulées
        if (!isValid) {
            JOptionPane.showMessageDialog(this, errors.toString(), "Erreur", JOptionPane.ERROR_MESSAGE);
        }

        return isValid;
    }

    // Vérifie si la date d'expiration est valide
    private boolean isValidExpirationDate(String date) {
        String[] parts = date.split("/");
        int month = Integer.parseInt(parts[0]);
        int year = Integer.parseInt(parts[1]);

        // Renvoie true si la date est dans le futur
        return year > 24 || (year == 24 && month >= 4);
    }

    // Réinitialise tous les champs à leur état initial
    public void reinitialiserChamps() {
        nom_sur_carte_field.setText("");
        numero_carte_field.setText("");
        date_expiration_field.setText("");
        cvv_field.setText("");
        code_promo_field.setText(""); // Réinitialise également le champ du code promo

        // Remettre les couleurs par défaut et les textes de faux numéro de carte, CVV et code promo
        numero_carte_field.setForeground(Color.LIGHT_GRAY);
        numero_carte_field.setText("0000 0000 0000 0000");
        date_expiration_field.setForeground(Color.LIGHT_GRAY);
        date_expiration_field.setText("MM/AA");
        cvv_field.setForeground(Color.LIGHT_GRAY);
        cvv_field.setText("000");
        code_promo_field.setForeground(Color.BLACK); // Assurez-vous que le texte du champ du code promo est noir
    }
}
