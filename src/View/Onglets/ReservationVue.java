package View.Onglets;

import View.MasterVue;
import View.Onglets.ReservationVueComposant.PaiementVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationVue extends JPanel {

    private MasterVue masterVue;

    public ReservationVue(MasterVue masterVue) {
        this.masterVue = masterVue;

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        // Création du bouton "Payer"
        JButton payerButton = new JButton("Payer");
        payerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code pour ouvrir la page de paiement
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(ReservationVue.this);
                frame.getContentPane().removeAll(); // Supprime le contenu actuel de la fenêtre
                frame.getContentPane().add(new PaiementVue(masterVue)); // Ajoute la page de paiement à la fenêtre avec la référence à MasterVue
                frame.revalidate(); // Rafraîchit la fenêtre pour afficher la nouvelle page
                frame.repaint();
            }
        });

        // Ajout du bouton "Payer" au centre de la page
        add(payerButton, BorderLayout.CENTER);
    }
}
