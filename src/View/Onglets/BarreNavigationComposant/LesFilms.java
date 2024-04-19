package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffLesFilmsEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class LesFilms extends JButton {

    // Constructeur
    public LesFilms() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Les Films"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher les films est publié
            FileEvenements.getInstance().publier(new AffLesFilmsEvenement());
        });
    }
}
