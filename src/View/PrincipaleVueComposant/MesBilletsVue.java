package View.PrincipaleVueComposant;

import View.PrincipaleVueComposant.MesBilletsComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class MesBilletsVue extends JPanel {

    public MesBilletsVue(int panneau_contenu_width, int frame_height) {
        setBackground(new Color(40, 25, 125));
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(20, 20, 20, 20));
        panneau_contenu_width = panneau_contenu_width*14/15;
        // Création des composants
        AffichageBillet billet = new AffichageBillet(panneau_contenu_width, frame_height);

        // Création d'un panel interne pour le contenu défilable
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(billet, BorderLayout.NORTH);

        // Création d'un JScrollPane qui contient le contentPanel
        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(null);

        // Ajout d'un MouseWheelListener pour gérer le défilement vertical
        contentPanel.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                JViewport viewport = scrollPane.getViewport();
                Point viewPosition = viewport.getViewPosition();
                int speed = scrollPane.getVerticalScrollBar().getUnitIncrement();
                viewPosition.y += e.getWheelRotation() * speed;
                int max = contentPanel.getPreferredSize().height - viewport.getHeight();
                int min = 0;
                if (viewPosition.y < min) viewPosition.y = min;
                if (viewPosition.y > max) viewPosition.y = max;
                viewport.setViewPosition(viewPosition);
            }
        });

        // Ajout du JScrollPane au panneau
        add(scrollPane, BorderLayout.CENTER);
    }
}
