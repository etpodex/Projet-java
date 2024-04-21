package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffPaiementEvenement;
import Controller.Evenements.FileEvenements;
import Model.Sceance;

import javax.swing.*;
import java.awt.*;

public class ReservationNerfVue extends JPanel {

    private JComboBox<String> sceanceComboBox;
    private JSpinner billetAdulteSpinner;
    private JLabel prixTotalLabel;
    private JLabel placesRestantesLabel; // Champ pour afficher le nombre de places restantes

    // Prix des billets
    private static final double PRIX_BILLET = 10.0;

    // Constructeur
    public ReservationNerfVue(int panneau_contenu_width, int frame_height) {

        setBackground(new Color(238, 238, 238)); // Définir la couleur de fond du panneau
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

        // Création des spinners pour le nombre de billets adultes
        billetAdulteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        // Création de la JLabel pour afficher le prix total
        prixTotalLabel = new JLabel("Prix total : 0.00 €");
        GridBagConstraints gbcPrixTotalLabel = new GridBagConstraints();
        gbcPrixTotalLabel.gridx = 0;
        gbcPrixTotalLabel.gridy = 4;
        gbcPrixTotalLabel.gridwidth = 3;
        gbcPrixTotalLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcPrixTotalLabel.insets = new Insets(5, 5, 5, 5);
        add(prixTotalLabel, gbcPrixTotalLabel);

        // Création de la JLabel pour afficher le nombre de places restantes
        placesRestantesLabel = new JLabel("Places restantes : ");
        GridBagConstraints gbcPlacesRestantesLabel = new GridBagConstraints();
        gbcPlacesRestantesLabel.gridx = 0;
        gbcPlacesRestantesLabel.gridy = 2;
        gbcPlacesRestantesLabel.gridwidth = 3;
        gbcPlacesRestantesLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcPlacesRestantesLabel.insets = new Insets(5, 5, 5, 5);
        add(placesRestantesLabel, gbcPlacesRestantesLabel);

        // Ajout d'un écouteur d'événements à la JComboBox
        sceanceComboBox.addActionListener(e -> updatePlacesRestantes());

        // Ajout d'un écouteur d'événements pour le spinner afin de mettre à jour le prix total
        billetAdulteSpinner.addChangeListener(e -> calculerPrixTotal());

        // Ajout du spinner dans un panneau
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new GridLayout(1, 2));
        spinnerPanel.add(new JLabel("Billet Adulte:"));
        spinnerPanel.add(billetAdulteSpinner);

        // Ajout du panneau de spinners
        GridBagConstraints gbcSpinner = new GridBagConstraints();
        gbcSpinner.gridx = 0;
        gbcSpinner.gridy = 1;
        gbcSpinner.gridwidth = 3;
        gbcSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbcSpinner.insets = new Insets(5, 5, 5, 5);
        add(spinnerPanel, gbcSpinner);

        // Ajout du bouton "Payer"
        JButton payerButton = new JButton("Payer");
        payerButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffPaiementEvenement());
            reinitialiserChamps();
        });

        GridBagConstraints gbcPayerButton = new GridBagConstraints();
        gbcPayerButton.gridx = 0;
        gbcPayerButton.gridy = 3;
        gbcPayerButton.gridwidth = 3;
        gbcPayerButton.fill = GridBagConstraints.HORIZONTAL;
        gbcPayerButton.insets = new Insets(5, 5, 5, 5);
        add(payerButton, gbcPayerButton);

        revalidate();
        repaint();
    }

    private void calculerPrixTotal() {
        int nbBilletsAdulte = (int) billetAdulteSpinner.getValue();
        double prixTotal = nbBilletsAdulte * PRIX_BILLET;
        prixTotalLabel.setText(String.format("Prix total : %.2f €", prixTotal));
    }

    private void updatePlacesRestantes() {
        int selectedIndex = sceanceComboBox.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < seances.length) {
            Sceance selectedSceance = seances[selectedIndex];
            int placesRestantes = selectedSceance.getNbPlaceRestante();
            placesRestantesLabel.setText("Places restantes : " + placesRestantes);
        }
    }

    private void reinitialiserChamps() {
        sceanceComboBox.setSelectedIndex(0);
        billetAdulteSpinner.setValue(0);
        prixTotalLabel.setText("Prix total : 0.00 €");
        placesRestantesLabel.setText("Places restantes : ");
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
