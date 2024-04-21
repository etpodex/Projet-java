package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffPaiementEvenement;
import Controller.Evenements.FileEvenements;
import Model.Billet;
import Model.Film;
import Model.Offre;
import Model.Sceance;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Cette classe représente la vue pour la réservation de billets pour un film.
 * Elle affiche une interface graphique permettant de choisir une séance, le nombre de billets
 * de différents types, d'appliquer un code promo et affiche le prix total ainsi que le nombre
 * de places restantes pour la séance sélectionnée.
 */
public class ReservationVue extends JPanel {

    private JComboBox<String> sceanceComboBox;
    private JSpinner billetEnfantSpinner;
    private JSpinner billetSeniorSpinner;
    private JSpinner billetAdulteSpinner;
    private JSpinner billetMembreSpinner;
    private JTextField codePromoField; // Champ de saisie du code promo
    private JLabel prixTotalLabel;
    private JLabel placesRestantesLabel; // Champ pour afficher le nombre de places restantes

    private Sceance[] info_seance;
    private Offre[] info_offre;
    private Film film;

    // Prix des billets
    private static final double PRIX_BILLET = 10.0;
    private static final double REDUCTION_ENFANT = 0.20;
    private static final double REDUCTION_SENIOR = 0.15;
    private static final double REDUCTION_MEMBRE = 0.30;

    // Liste des offres avec leurs codes promo et réductions
    private Offre[] offres;

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
                update_info_seance(info_seance);
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
        validerButton.addActionListener(e -> update_info_offre(info_offre, 0));

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
            // Récupérer la séance sélectionnée
            int selectedIndex = sceanceComboBox.getSelectedIndex();

            Random rand = new Random();
            // Créer une liste de billets avec les quantités correspondantes
            Billet billet = new Billet(
                    info_seance[selectedIndex].getIdFilm(),
                    info_seance[selectedIndex].getDate(),
                    info_seance[selectedIndex].getHoraire(),
                    String.valueOf(info_seance[selectedIndex].getIdSalle()),
                    String.valueOf(rand.nextInt(50)),
                    // Récupérer le nombre de billets de chaque type
                    (int) billetAdulteSpinner.getValue(),
                    (int) billetEnfantSpinner.getValue(),
                    (int) billetSeniorSpinner.getValue(),
                    null,
                    null,
                    info_seance[selectedIndex].getIdSceance()
            );

            AffPaiementEvenement evenement = new AffPaiementEvenement();
            evenement.setBillet(billet);
            // Publier un événement de paiement en utilisant le gestionnaire d'événements FileEvenements
            FileEvenements.getInstance().publier(evenement);
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

    /**
     * Met à jour les informations sur les séances disponibles.
     * @param seance Un tableau de séances disponibles.
     */
    public void update_info_seance(Sceance[] seance){
        this.info_seance = seance;
        sceanceComboBox.removeAllItems();
        // Ajouter les dates et heures des séances disponibles à la JComboBox pour un film spécifique
        for (Sceance sceance : info_seance) {
            sceanceComboBox.addItem(sceance.getDate() + "" + sceance.getHoraire());
            int placesRestantes = sceance.getNbPlaceRestante();
            // Mettre à jour le texte du champ "place restante"
            placesRestantesLabel.setText("capacite de la salle : " + placesRestantes);
        }
    }


    /**
     * Met à jour les informations sur les offres disponibles.
     * @param offres Un tableau d'offres disponibles.
     * @param first_load Indique s'il s'agit du premier chargement des offres.
     */
    public void update_info_offre(Offre[] offres, int first_load){
        this.info_offre = offres;
        String codePromo = codePromoField.getText();
        boolean codePromoValide = false;
        double tauxReduction = 0.0;

        System.out.println(info_offre.toString());

        // Vérifier si le code promo est valide et obtenir le taux de réduction correspondant
        for (Offre offre : info_offre) {
            if (offre.getCode_promo().equals(codePromo)) {
                codePromoValide = true;
                tauxReduction = offre.getReduction();
                break;
            }
        }

        // Si le code promo est valide, recalculer le prix total en appliquant la réduction
        if(first_load == 1) {
            calculerPrixTotal();
        } else if (codePromoValide) {
            calculerPrixTotal(); // Appel à la méthode pour recalculer le prix total
            JOptionPane.showMessageDialog(this, "Code promo appliqué avec succès. Taux de réduction : " + tauxReduction + "%", "Information", JOptionPane.INFORMATION_MESSAGE);
        } else {
            // Sinon, afficher un message d'erreur
            JOptionPane.showMessageDialog(this, "Code promo invalide", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Calcule le prix total en fonction du nombre de billets de chaque type sélectionnés.
     */
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
        for (Offre offre : info_offre) {
            if (offre.getCode_promo().equals(codePromo)) {
                prixTotal -= (prixTotal * offre.getReduction() / 100);
                break;
            }
        }

        // Affichage du prix total
        prixTotalLabel.setText(String.format("Prix total : %.2f €", prixTotal));
    }

    /**
     * Réinitialise tous les champs de la vue de réservation.
     */
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
}
