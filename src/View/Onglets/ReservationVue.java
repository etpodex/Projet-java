package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffPaiementEvenement;
import Controller.Evenements.FileEvenements;
import View.MasterVue;
import View.Onglets.ReservationVueComposant.PaiementVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationVue extends JPanel {


    public ReservationVue(int panneau_contenu_width, int frame_height) {

        setBackground(Color.WHITE);
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(panneau_contenu_width, frame_height));

        // Création du bouton "Payer"
        JButton payerButton = new JButton("Payer");
        payerButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffPaiementEvenement());
        });

        // Ajout du bouton "Payer" au centre de la page
        add(payerButton, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
}
