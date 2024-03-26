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
        JPanel detail_carte_panel = new JPanel(new GridBagLayout());
        detail_carte_panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nom_sur_carte_label = new JLabel("Nom sur la carte:");
        JTextField nom_sur_carte_field = new JTextField(10);
        JLabel card_number_label = new JLabel("Numéro de carte:");
        JTextField card_number_field = new JTextField(15);
        JLabel date_expiration_label = new JLabel("Date d'expiration:");
        JTextField date_expiration_field = new JTextField(5);
        JLabel cvv_label = new JLabel("CVV:");
        JTextField cvv_field = new JTextField(3);
        JLabel code_promo_label = new JLabel("Code promo:");
        JTextField code_promo_field = new JTextField(5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        detail_carte_panel.add(nom_sur_carte_label, gbc);
        gbc.gridy = 1;
        detail_carte_panel.add(card_number_label, gbc);

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
        detail_carte_panel.add(card_number_field, gbc);

        gbc.gridy = 2;
        detail_carte_panel.add(date_expiration_field, gbc);

        gbc.gridy = 3;
        detail_carte_panel.add(cvv_field, gbc);
        gbc.gridy = 4;
        detail_carte_panel.add(code_promo_field, gbc);

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
        add(detail_carte_panel, BorderLayout.CENTER);
        add(payButton, BorderLayout.SOUTH);
    }
}
