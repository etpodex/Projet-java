package View.Onglets;

import View.Onglets.MesBilletsComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MesBilletsVue extends JPanel {

    public MesBilletsVue(int panneau_contenu_width, int frame_height) {
        setBackground(new Color(40, 25, 125));
        setBorder(new EmptyBorder(20, 20, 0, 20));

        // Ajustement de la largeur du panneau de contenu
        panneau_contenu_width = panneau_contenu_width * 14 / 15;

        // Création des composants
        AffichageBillet billet = new AffichageBillet(panneau_contenu_width, frame_height);

        // Création d'un panel interne pour le contenu défilable
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        // Ajout du composant billet au panel interne
        contentPanel.add(billet);

        // Création d'un JScrollPane qui contient le contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Cacher la barre de défilement verticale
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        // Ajout du JScrollPane au panneau
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }
}
