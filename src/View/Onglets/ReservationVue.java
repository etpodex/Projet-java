package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffPaiementEvenement;
import Controller.Evenements.FileEvenements;
import Model.Sceance;
import View.MasterVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReservationVue extends JPanel {

    private JComboBox<String> sceanceComboBox;
    private JSpinner billetEnfantSpinner;
    private JSpinner billetSeniorSpinner;
    private JSpinner billetAdulteSpinner;
    private JSpinner billetMembreSpinner;

    // Constructeur
    public ReservationVue(int panneau_contenu_width, int frame_height) {

        setBackground(Color.WHITE); // Définir la couleur de fond du panneau
        setLayout(new GridBagLayout()); // Utiliser un GridBagLayout pour organiser les composants

        // Création de la JLabel pour indiquer de choisir la séance
        JLabel labelChoixSceance = new JLabel("Choisissez votre séance:");
        GridBagConstraints gbcLabel = new GridBagConstraints();
        gbcLabel.gridx = 0;
        gbcLabel.gridy = 0;
        gbcLabel.insets = new Insets(5, 5, 5, 5);
        add(labelChoixSceance, gbcLabel);

        // Création de la JComboBox pour sélectionner la séance
        sceanceComboBox = new JComboBox<>();
        GridBagConstraints gbcComboBox = new GridBagConstraints();
        gbcComboBox.gridx = 1;
        gbcComboBox.gridy = 0;
        gbcComboBox.gridwidth = 2;
        gbcComboBox.fill = GridBagConstraints.HORIZONTAL;
        gbcComboBox.insets = new Insets(5, 5, 5, 5);
        add(sceanceComboBox, gbcComboBox);

        // Ajouter les dates et heures des séances disponibles à la JComboBox pour un film spécifique (ID = 1 par exemple)
        int filmId = 1; // ID du film spécifique
        for (Sceance sceance : seances) {
            if (sceance.getIdFilm() == filmId) {
                sceanceComboBox.addItem(sceance.getDate() + " " + sceance.getHoraire());
            }
        }

        // Création des spinners pour le nombre de billets de différents types
        billetEnfantSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        billetSeniorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        billetAdulteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        billetMembreSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        // Création du bouton "Payer"
        JButton payerButton = new JButton("Payer");
        // Ajout d'un écouteur d'événements pour le bouton "Payer"
        payerButton.addActionListener(e -> {
            // Publier un événement de paiement en utilisant le gestionnaire d'événements FileEvenements
            FileEvenements.getInstance().publier(new AffPaiementEvenement());
        });

        // Création d'un panneau pour les spinners
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new GridLayout(4, 2));
        spinnerPanel.add(new JLabel("Billet Enfant:"));
        spinnerPanel.add(billetEnfantSpinner);
        spinnerPanel.add(new JLabel("Billet Senior:"));
        spinnerPanel.add(billetSeniorSpinner);
        spinnerPanel.add(new JLabel("Billet Adulte:"));
        spinnerPanel.add(billetAdulteSpinner);
        spinnerPanel.add(new JLabel("Billet Membre:"));
        spinnerPanel.add(billetMembreSpinner);

        // Ajout des spinners et du bouton "Payer"
        GridBagConstraints gbcSpinner = new GridBagConstraints();
        gbcSpinner.gridx = 0;
        gbcSpinner.gridy = 1;
        gbcSpinner.gridwidth = 3;
        gbcSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbcSpinner.insets = new Insets(5, 5, 5, 5);
        add(spinnerPanel, gbcSpinner);

        // Ajout du bouton "Payer"
        GridBagConstraints gbcPayerButton = new GridBagConstraints();
        gbcPayerButton.gridx = 0;
        gbcPayerButton.gridy = 2;
        gbcPayerButton.gridwidth = 3;
        gbcPayerButton.fill = GridBagConstraints.HORIZONTAL;
        gbcPayerButton.insets = new Insets(5, 5, 5, 5);
        add(payerButton, gbcPayerButton);

        revalidate(); // Valider la disposition des composants
        repaint(); // Redessiner le panneau
    }

    // Déclaration des séances
    private Sceance[] seances = new Sceance[]{
            new Sceance(1, 1, "09:00", 1, "2024-04-01", 100),
            new Sceance(2, 2, "12:00", 2, "2024-04-01", 120),
            new Sceance(3, 3, "15:00", 3, "2024-04-01", 80),
            new Sceance(4, 1, "10:00", 1, "2024-04-02", 90),
            new Sceance(5, 2, "13:00", 2, "2024-04-02", 110),
            new Sceance(6, 3, "16:00", 3, "2024-04-02", 70),
            new Sceance(7, 1, "11:00", 1, "2024-04-03", 80),
            new Sceance(8, 2, "14:00", 2, "2024-04-03", 100)
    };
}
