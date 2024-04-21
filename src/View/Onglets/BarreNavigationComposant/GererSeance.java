package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffGererSeanceEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;

/**
 * Le bouton GererSeance est utilisé pour afficher l'interface de gestion des séances dans la barre de navigation.
 */
public class GererSeance extends JButton {

    /**
     * Constructeur de la classe GererSeance.
     */
    public GererSeance() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Gerer Seance"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher la gestion des séances est publié
            FileEvenements.getInstance().publier(new AffGererSeanceEvenement());
        });
    }
}
