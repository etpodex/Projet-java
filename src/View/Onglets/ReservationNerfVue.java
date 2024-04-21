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

        // Création des composants graphiques et leur ajout au panneau
        // ...

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
