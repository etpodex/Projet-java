package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffPaiementEvenement;
import Controller.Evenements.FileEvenements;
import Model.Offre;
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
    private JTextField codePromoField; // Champ de saisie du code promo
    private JLabel prixTotalLabel;
    private JLabel placesRestantesLabel; // Champ pour afficher le nombre de places restantes

    // Prix des billets
    private static final double PRIX_BILLET = 10.0;
    private static final double REDUCTION_ENFANT = 0.20;
    private static final double REDUCTION_SENIOR = 0.15;
    private static final double REDUCTION_MEMBRE = 0.30;

    // Liste des offres avec leurs codes promo et réductions
    private Offre[] offres = new Offre[]{
            new Offre("Offre1", 10, "CODE1"),
            new Offre("Offre2", 20, "CODE2"),
            new Offre("Offre3", 15, "CODE3")
    };

    // Constructeur
    public ReservationVue(int panneau_contenu_width, int frame_height) {

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

        // Création des spinners pour le nombre de billets de différents types
        billetEnfantSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        billetSeniorSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        billetAdulteSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        billetMembreSpinner = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));

        // Ajout du champ de saisie du code promo
        JLabel codePromoLabel = new JLabel("Code promo:");
        codePromoField = new JTextField(10);

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
        gbcPlacesRestantesLabel.gridy = -3; // Juste en dessous de "Choisissez votre séance"
        gbcPlacesRestantesLabel.gridwidth = 3;
        gbcPlacesRestantesLabel.fill = GridBagConstraints.HORIZONTAL;
        gbcPlacesRestantesLabel.insets = new Insets(5, 5, 5, 5);
        add(placesRestantesLabel, gbcPlacesRestantesLabel);

        // Ajout d'un écouteur d'événements à la JComboBox pour détecter les changements de sélection de séance
        sceanceComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mettre à jour le champ "place restante" avec le nombre de places restantes pour la séance sélectionnée
                updatePlacesRestantes();
            }
        });

        // Ajout d'un écouteur d'événements pour chaque spinner afin de mettre à jour le prix total
        billetEnfantSpinner.addChangeListener(e -> calculerPrixTotal());
        billetSeniorSpinner.addChangeListener(e -> calculerPrixTotal());
        billetAdulteSpinner.addChangeListener(e -> calculerPrixTotal());
        billetMembreSpinner.addChangeListener(e -> calculerPrixTotal());

        // Création d'un panneau pour les spinners
        JPanel spinnerPanel = new JPanel();
        spinnerPanel.setLayout(new GridLayout(5, 2));
        spinnerPanel.add(new JLabel("Billet Enfant:"));
        spinnerPanel.add(billetEnfantSpinner);
        spinnerPanel.add(new JLabel("Billet Senior:"));
        spinnerPanel.add(billetSeniorSpinner);
        spinnerPanel.add(new JLabel("Billet Adulte:"));
        spinnerPanel.add(billetAdulteSpinner);
        spinnerPanel.add(new JLabel("Billet Membre:"));
        spinnerPanel.add(billetMembreSpinner);
        spinnerPanel.add(codePromoLabel);
        spinnerPanel.add(codePromoField);

        // Ajout des spinners
        GridBagConstraints gbcSpinner = new GridBagConstraints();
        gbcSpinner.gridx = 0;
        gbcSpinner.gridy = 1; // Juste en dessous de "Choisissez votre séance"
        gbcSpinner.gridwidth = 3;
        gbcSpinner.fill = GridBagConstraints.HORIZONTAL;
        gbcSpinner.insets = new Insets(5, 5, 5, 5);
        add(spinnerPanel, gbcSpinner);

        // Création du bouton "Valider"
        JButton validerButton = new JButton("Valider code promo");
        // Ajout d'un écouteur d'événements pour le bouton "Valider"
        validerButton.addActionListener(e -> validerCodePromo());

        // Ajout du bouton "Valider"
        GridBagConstraints gbcValiderButton = new GridBagConstraints();
        gbcValiderButton.gridx = 0;
        gbcValiderButton.gridy = 2;
        gbcValiderButton.gridwidth = 3;
        gbcValiderButton.fill = GridBagConstraints.HORIZONTAL;
        gbcValiderButton.insets = new Insets(5, 5, 5, 5);
        add(validerButton, gbcValiderButton);

        // Création du bouton "Payer"
        JButton payerButton = new JButton("Payer");
        // Ajout d'un écouteur d'événements pour le bouton "Payer"
        payerButton.addActionListener(e -> {
            // Publier un événement de paiement en utilisant le gestionnaire d'événements FileEvenements
            FileEvenements.getInstance().publier(new AffPaiementEvenement());
            // Réinitialiser les champs après un paiement réussi
            reinitialiserChamps();
        });

        // Ajout du bouton "Payer"
        GridBagConstraints gbcPayerButton = new GridBagConstraints();
        gbcPayerButton.gridx = 0;
        gbcPayerButton.gridy = 3;
        gbcPayerButton.gridwidth = 3;
        gbcPayerButton.fill = GridBagConstraints.HORIZONTAL;
        gbcPayerButton.insets = new Insets(5, 5, 5, 5);
        add(payerButton, gbcPayerButton);

        revalidate(); // Valider la disposition des composants
        repaint(); // Redessiner le panneau
    }

    // Méthode pour valider et appliquer le code promo
    private void validerCodePromo() {
        String codePromo = codePromoField.getText();
        boolean codePromoValide = false;
        double tauxReduction = 0.0;

        // Vérifier si le code promo est valide et obtenir le taux de réduction correspondant
        for (Offre offre : offres) {
            if (offre.getCode_promo().equals(codePromo)) {
                codePromoValide = true;
                tauxReduction = offre.getReduction();
                break;
            }
        }

        // Si le code promo est valide, recalculer le prix total en appliquant la réduction
        if (codePromoValide) {
            calculerPrixTotal();
            JOptionPane.showMessageDialog(this, "Code promo appliqué avec succès. Taux de réduction : " + tauxReduction + "%", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Sinon, afficher un message d'erreur
            JOptionPane.showMessageDialog(this, "Code promo invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Méthode pour calculer le prix total en fonction du nombre de billets de chaque type
    private void calculerPrixTotal() {
        int nbBilletsEnfant = (int) billetEnfantSpinner.getValue();
        int nbBilletsSenior = (int) billetSeniorSpinner.getValue();
        int nbBilletsAdulte = (int) billetAdulteSpinner.getValue();
        int nbBilletsMembre = (int) billetMembreSpinner.getValue();

        // Calcul du prix total avec les réductions appropriées
        double prixTotal = (nbBilletsEnfant * PRIX_BILLET * (1 - REDUCTION_ENFANT)) +
                (nbBilletsSenior * PRIX_BILLET * (1 - REDUCTION_SENIOR)) +
                (nbBilletsAdulte * PRIX_BILLET) +
                (nbBilletsMembre * PRIX_BILLET * (1 - REDUCTION_MEMBRE));

        // Appliquer la réduction du code promo s'il est valide
        String codePromo = codePromoField.getText();
        for (Offre offre : offres) {
            if (offre.getCode_promo().equals(codePromo)) {
                prixTotal -= (prixTotal * offre.getReduction() / 100);
                break;
            }
        }

        // Affichage du prix total
        prixTotalLabel.setText(String.format("Prix total : %.2f €", prixTotal));
    }

    // Méthode pour mettre à jour le champ "place restante" avec le nombre de places restantes pour la séance sélectionnée
    private void updatePlacesRestantes() {
        // Récupérer l'index de la séance sélectionnée dans la JComboBox
        int selectedIndex = sceanceComboBox.getSelectedIndex();
        // Vérifier si l'index est valide
        if (selectedIndex >= 0 && selectedIndex < seances.length) {
            // Récupérer la séance sélectionnée
            Sceance selectedSceance = seances[selectedIndex];
            // Récupérer le nombre de places restantes pour la séance sélectionnée
            int placesRestantes = selectedSceance.getNbPlaceRestante();
            // Mettre à jour le texte du champ "place restante"
            placesRestantesLabel.setText("Places restantes : " + placesRestantes);
        }
    }

    // Méthode pour réinitialiser tous les champs de la vue de réservation
    private void reinitialiserChamps() {
        // Réinitialiser la sélection de la séance
        sceanceComboBox.setSelectedIndex(0);
        // Réinitialiser les valeurs des spinners à zéro
        billetEnfantSpinner.setValue(0);
        billetSeniorSpinner.setValue(0);
        billetAdulteSpinner.setValue(0);
        billetMembreSpinner.setValue(0);
        // Réinitialiser le champ de saisie du code promo
        codePromoField.setText("");
        // Réinitialiser le prix total à zéro
        prixTotalLabel.setText("Prix total : 0.00 €");
        // Réinitialiser le champ "place restante"
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
