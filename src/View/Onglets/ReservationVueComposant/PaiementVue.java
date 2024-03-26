package View.Onglets.ReservationVueComposant;

import javax.swing.*;
import java.awt.*;

public class PaiementVue extends JPanel {

    public PaiementVue() {
        setBackground(Color.WHITE); // Fond blanc
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        // En-tête de la page de paiement
        JLabel titleLabel = new JLabel("Paiement par carte de crédit");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Zone de saisie des détails de la carte de crédit
        JPanel cardDetailsPanel = new JPanel();
        cardDetailsPanel.setLayout(new GridLayout(4, 2));
        cardDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Marge intérieure
        JLabel cardNumberLabel = new JLabel("Numéro de carte:");
        JTextField cardNumberField = new JTextField();
        JLabel expiryDateLabel = new JLabel("Date d'expiration:");
        JTextField expiryDateField = new JTextField();
        JLabel cvvLabel = new JLabel("CVV:");
        JTextField cvvField = new JTextField();
        cardDetailsPanel.add(cardNumberLabel);
        cardDetailsPanel.add(cardNumberField);
        cardDetailsPanel.add(expiryDateLabel);
        cardDetailsPanel.add(expiryDateField);
        cardDetailsPanel.add(cvvLabel);
        cardDetailsPanel.add(cvvField);

        // Bouton de paiement
        JButton payButton = new JButton("Payer");
        payButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Ajout des composants à la page de paiement
        add(titleLabel, BorderLayout.NORTH);
        add(cardDetailsPanel, BorderLayout.CENTER);
        add(payButton, BorderLayout.SOUTH);
    }
}
