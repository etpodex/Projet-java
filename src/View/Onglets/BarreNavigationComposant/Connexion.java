package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffConnexionEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class Connexion extends JButton {

    // Constructeur
    public Connexion() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Connexion"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher l'interface de connexion est publié
            FileEvenements.getInstance().publier(new AffConnexionEvenement());
        });
    }
}
