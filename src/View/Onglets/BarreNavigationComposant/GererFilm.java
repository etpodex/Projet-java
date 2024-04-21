package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffGererFilmEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;

/**
 * Le bouton GererFilm est utilisé pour afficher l'interface de gestion des films dans la barre de navigation.
 */
public class GererFilm extends JButton {

    /**
     * Constructeur de la classe GererFilm.
     */
    public GererFilm() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Gérer Film"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher la gestion des films est publié
            FileEvenements.getInstance().publier(new AffGererFilmEvenement());
        });
    }
}
