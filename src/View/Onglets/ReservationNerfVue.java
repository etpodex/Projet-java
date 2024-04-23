package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffPaiementEvenement;
import Controller.Evenements.FileEvenements;
import Model.Billet;
import Model.Sceance;

import javax.swing.*;
import java.awt.*;

/**
 * Cette classe représente la vue pour la réservation de billets pour une séance de Nerf.
 * Elle affiche une interface graphique permettant de choisir une séance, le nombre de billets adultes,
 * et affiche le prix total ainsi que le nombre de places restantes pour la séance sélectionnée.
 */
public class ReservationNerfVue extends JPanel {

    private JComboBox<String> sceanceComboBox;
    private JSpinner billetAdulteSpinner;
    private JLabel prixTotalLabel;
    private JLabel placesRestantesLabel; // Champ pour afficher le nombre de places restantes
    private Sceance[] info_seance;

    // Prix des billets
    private static final double PRIX_BILLET = 10.0;

    /**
     * Constructeur de la classe ReservationNerfVue.
     * @param panneau_contenu_width La largeur du panneau de contenu.
     * @param frame_height La hauteur de la fenêtre.
     */
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

    /**
     * Met à jour les informations sur les séances disponibles.
     * @param seance Un tableau de séances disponibles.
     */
    public void update_info_seance(Sceance[] seance){
        this.info_seance = seance;
        sceanceComboBox.removeAllItems();
        // Ajouter les dates et heures des séances disponibles à la JComboBox pour un film spécifique
        for (Sceance sceance : info_seance) {
            sceanceComboBox.addItem(sceance.getDate() + " " + sceance.getHoraire());
        }
    }

    /**
     * Calcule le prix total en fonction du nombre de billets adultes sélectionnés.
     */
    private void calculerPrixTotal() {
        int nbBilletsAdulte = (int) billetAdulteSpinner.getValue();
        double prixTotal = nbBilletsAdulte * PRIX_BILLET;
        prixTotalLabel.setText(String.format("Prix total : %.2f €", prixTotal));
    }

    /**
     * Met à jour le nombre de places restantes en fonction de la séance sélectionnée.
     */
    private void updatePlacesRestantes() {
        int selectedIndex = sceanceComboBox.getSelectedIndex();
        if (selectedIndex >= 0 && selectedIndex < info_seance.length) {
            Sceance selectedSceance = info_seance[selectedIndex];
            int placesRestantes = selectedSceance.getNbPlaceRestante();
            placesRestantesLabel.setText("Places restantes : " + placesRestantes);
        }
    }

    /**
     * Réinitialise les champs de saisie et d'affichage.
     */
    private void reinitialiserChamps() {
        sceanceComboBox.setSelectedIndex(0);
        billetAdulteSpinner.setValue(0);
        prixTotalLabel.setText("Prix total : 0.00 €");
        placesRestantesLabel.setText("Places restantes : ");
    }
}
