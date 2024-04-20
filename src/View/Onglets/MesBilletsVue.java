package View.Onglets;

import Model.Billet;
import View.Onglets.MesBilletsComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MesBilletsVue extends JScrollPane {

    private AffichageBillet affichageBillet;

    // Constructeur
    public MesBilletsVue(int panneau_contenu_width, int frame_height) {
        setBackground(new Color(238, 238, 238)); // Définir la couleur de fond du JScrollPane
        setBorder(new EmptyBorder(20, 20, 0, 20)); // Définir les marges intérieures

        // Ajustement de la largeur du panneau de contenu
        panneau_contenu_width = panneau_contenu_width * 14 / 15;

        // Création des composants
        this.affichageBillet = new AffichageBillet(panneau_contenu_width, frame_height); // Créer un nouvel affichage de affichageBillet

        // Création d'un panel interne pour le contenu défilable
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Utiliser un BoxLayout vertical pour organiser les composants

        // Ajout du composant affichageBillet au panel interne
        contentPanel.add(affichageBillet);

        // Création d'un JScrollPane qui contient le contentPanel
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Cacher la barre de défilement verticale
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Cacher la barre de défilement horizontale
        setBorder(null); // Supprimer la bordure du JScrollPane

        // Ajout du contentPanel au JScrollPane
        setViewportView(contentPanel);

        // Définir la mise en page du JScrollPane
        setLayout(new ScrollPaneLayout());
    }

    // Méthode pour mettre à jour les billets
    public void updateBillets(Billet[] billets) {
        this.affichageBillet.updateBillets(billets); // Mettre à jour les billets dans l'affichage de billets
    }
}
