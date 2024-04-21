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

    // Constructeur
    public ReservationVue(int panneau_contenu_width, int frame_height) {

        setBackground(new Color(238, 238, 238)); // Définir la couleur de fond du panneau
        setLayout(new GridBagLayout()); // Utiliser un GridBagLayout pour organiser les composants

        // Création des composants graphiques et leur ajout au panneau
        // ...

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
