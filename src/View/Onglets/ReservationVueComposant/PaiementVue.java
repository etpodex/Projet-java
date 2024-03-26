package View.Onglets.ReservationVueComposant;

import View.MasterVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaiementVue extends JPanel {

    private MasterVue masterVue;

    public PaiementVue(MasterVue masterVue) {
        this.masterVue = masterVue;

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // En-tête de la page de paiement
        JLabel titleLabel = new JLabel("Paiement par carte de crédit");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));

        // Zone de saisie des détails de la carte de crédit
        JPanel cardDetailsPanel = new JPanel(new GridBagLayout());
        cardDetailsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

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

        // Ajoutez d'autres composants ici ...

        // Bouton de paiement
        JButton payButton = new JButton("Payer");
        payButton.setFont(new Font("Arial", Font.BOLD, 16));

        // Action lorsque le bouton de paiement est cliqué
        payButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Basculer vers la page de paiement en cours
                removeAll();
                add(new PaiementEnCoursVue(masterVue), BorderLayout.CENTER);
                revalidate();
                repaint();
            }
        });

        // Ajout des composants à la page de paiement
        add(titleLabel, BorderLayout.NORTH);
        add(cardDetailsPanel, BorderLayout.CENTER);
        add(payButton, BorderLayout.SOUTH);
    }
}
