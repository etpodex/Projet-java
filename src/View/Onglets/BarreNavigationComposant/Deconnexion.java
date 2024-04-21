package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.DeconnexionEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;

/**
 * Le bouton Deconnexion est utilisé pour déclencher l'événement de déconnexion dans la barre de navigation.
 */
public class Deconnexion extends JButton {

    /**
     * Constructeur de la classe Deconnexion.
     */
    public Deconnexion() {
        // Configuration de l'apparence du bouton
        setBackground(Color.WHITE); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Se Déconnecter"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour effectuer la déconnexion est publié
            FileEvenements.getInstance().publier(new DeconnexionEvenement());
        });
    }
}
