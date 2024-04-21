package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffMesBilletsEvenement;
import Controller.Evenements.FileEvenements;

import javax.swing.*;
import java.awt.*;

/**
 * Le bouton MesBillets est utilisé pour afficher les billets de l'utilisateur dans la barre de navigation.
 */
public class MesBillets extends JButton {

    /**
     * Constructeur de la classe MesBillets.
     */
    public MesBillets() {
        // Configuration de l'apparence du bouton
        setBackground(new Color(255,255,255)); // Couleur de fond
        setForeground(Color.GRAY); // Couleur du texte
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2)); // Bordure
        setFocusPainted(false); // Désactiver la mise en évidence du focus
        setText("Mes Billets"); // Texte du bouton

        // Ajout d'un écouteur d'événement pour gérer les clics sur le bouton
        addActionListener(e -> {
            // Lorsque le bouton est cliqué, un événement pour afficher les billets de l'utilisateur est publié
            FileEvenements.getInstance().publier(new AffMesBilletsEvenement());
        });
    }
}
