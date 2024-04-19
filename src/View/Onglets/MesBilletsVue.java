package View.Onglets;

import Model.Billet;
import View.Onglets.MesBilletsComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MesBilletsVue extends JScrollPane {

    // Constructeur
    public MesBilletsVue(int panneau_contenu_width, int frame_height) {
        setBackground(new Color(40, 25, 125)); // Définir la couleur de fond du JScrollPane
        setBorder(new EmptyBorder(20, 20, 0, 20)); // Définir les marges intérieures

        // Ajustement de la largeur du panneau de contenu
        panneau_contenu_width = panneau_contenu_width * 14 / 15;

        // Création des composants
        AffichageBillet billet = new AffichageBillet(panneau_contenu_width, frame_height); // Créer un nouvel affichage de billet

        // Création d'un panel interne pour le contenu défilable
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS)); // Utiliser un BoxLayout vertical pour organiser les composants

        // Ajout du composant billet au panel interne
        contentPanel.add(billet);

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
        // Mettre à jour les billets (cette méthode peut être complétée pour mettre à jour l'affichage des billets en fonction des nouvelles données)
    }
}
