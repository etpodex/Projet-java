package View.Onglets.ReservationVueComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaiementVue extends JPanel {

    public PaiementVue() {
        setBackground(Color.WHITE); // Fond blanc
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        // En-tête de la page de paiement
        JLabel titleLabel = new JLabel("Paiement par carte de crédit");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Zone de saisie des détails de la carte de crédit
        JPanel cardDetailsPanel = new JPanel(new GridBagLayout()); // Utilisation de GridBagLayout
        cardDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Marge intérieure

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nomSurCarteLabel = new JLabel("Nom sur la carte:");
        JTextField nomSurCarteField = new JTextField(10);
        JLabel cardNumberLabel = new JLabel("Numéro de carte:");
        JTextField cardNumberField = new JTextField(15);
        JLabel expiryDateLabel = new JLabel("Date d'expiration:");
        JTextField expiryDateField = new JTextField(5);
        JLabel cvvLabel = new JLabel("CVV:");
        JTextField cvvField = new JTextField(3);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        cardDetailsPanel.add(nomSurCarteLabel, gbc);

        gbc.gridy = 1;
        cardDetailsPanel.add(cardNumberLabel, gbc);

        gbc.gridy = 2;
        cardDetailsPanel.add(expiryDateLabel, gbc);

        gbc.gridy = 3;
        cardDetailsPanel.add(cvvLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        cardDetailsPanel.add(nomSurCarteField, gbc);

        gbc.gridy = 1;
        cardDetailsPanel.add(cardNumberField, gbc);

        gbc.gridy = 2;
        cardDetailsPanel.add(expiryDateField, gbc);

        gbc.gridy = 3;
        cardDetailsPanel.add(cvvField, gbc);

        // Bouton de paiement
        JButton payButton = new JButton("Payer");
        payButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Action lorsque le bouton de paiement est cliqué
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Basculer vers la page de paiement en cours
                removeAll(); // Supprimer tous les composants de la page actuelle
                add(new PaiementEnCoursVue(), BorderLayout.CENTER); // Ajouter la page de paiement en cours
                revalidate(); // Mettre à jour l'affichage
                repaint(); // Redessiner la page
            }
        });

        // Ajout des composants à la page de paiement
        add(titleLabel, BorderLayout.NORTH);
        add(cardDetailsPanel, BorderLayout.CENTER);
        add(payButton, BorderLayout.SOUTH);
    }
}
