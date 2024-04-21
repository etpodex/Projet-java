package View.Onglets.MonCompteComposant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel {
    // Attributs
    private JButton boutonModifier;
    private JButton boutonValider;

    public Footer() {
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout pour organiser les composants
        setBackground(new Color(238,238,238)); // Définition de la couleur de fond du panneau

        // Initialisation du bouton "Modifier"
        boutonModifier = new JButton("Modifier");
        // Ajout d'un écouteur d'événements pour le bouton "Modifier"
        boutonModifier.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action lors du clic sur le bouton "Modifier"
                // Remplacer le bouton "Modifier" par le bouton "Valider"
                remove(boutonModifier);
                add(boutonValider, BorderLayout.EAST);
                revalidate(); // Actualisation de l'interface utilisateur
                repaint(); // Redessin de l'interface utilisateur
            }
        });

        // Initialisation du bouton "Valider"
        boutonValider = new JButton("Valider");
        // Ajout d'un écouteur d'événements pour le bouton "Valider"
        boutonValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Action lors du clic sur le bouton "Valider"
                // Remplacer le bouton "Valider" par le bouton "Modifier"
                remove(boutonValider);
                add(boutonModifier, BorderLayout.EAST);
                revalidate(); // Actualisation de l'interface utilisateur
                repaint(); // Redessin de l'interface utilisateur
            }
        });

        // Par défaut, afficher le bouton "Modifier" à droite
        add(boutonModifier, BorderLayout.EAST);
    }

    // Méthode pour ajouter un écouteur d'événements au bouton "Modifier"
    public void addModifierListener(ActionListener listener) {
        boutonModifier.addActionListener(listener);
    }

    // Méthode pour ajouter un écouteur d'événements au bouton "Valider"
    public void addValiderListener(ActionListener listener) {
        boutonValider.addActionListener(listener);
    }
}
