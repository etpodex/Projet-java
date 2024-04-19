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

    // Constructeur
    public ReservationVue(int panneau_contenu_width, int frame_height) {

        setBackground(Color.WHITE); // Définir la couleur de fond du panneau
        setLayout(new BorderLayout()); // Utiliser un BorderLayout pour organiser les composants
        setPreferredSize(new Dimension(panneau_contenu_width, frame_height)); // Définir la taille préférée du panneau

        // Création du bouton "Payer"
        JButton payerButton = new JButton("Payer");
        // Ajout d'un écouteur d'événements pour le bouton "Payer"
        payerButton.addActionListener(e -> {
            // Publier un événement de paiement en utilisant le gestionnaire d'événements FileEvenements
            FileEvenements.getInstance().publier(new AffPaiementEvenement());
        });

        // Ajout du bouton "Payer" au centre de la page
        add(payerButton, BorderLayout.CENTER);

        revalidate(); // Valider la disposition des composants
        repaint(); // Redessiner le panneau
    }
}
