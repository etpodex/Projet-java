package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffGererOffreEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;

public class GererOffre extends JButton {

    // Constructeur
    public GererOffre() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Gérer Offre"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher la gestion des offres est publié
            FileEvenements.getInstance().publier(new AffGererOffreEvenement());
        });
    }
}
