package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffMonCompteEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class MonCompte extends JButton {

    // Constructeur
    public MonCompte() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Mon Compte"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher le compte de l'utilisateur est publié
            FileEvenements.getInstance().publier(new AffMonCompteEvenement());
        });
    }
}
