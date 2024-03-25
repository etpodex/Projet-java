package View.PrincipaleVueComposant;

import View.PrincipaleVueComposant.AccueilVueComposant.*;
import View.PrincipaleVueComposant.LesFilmsComposant.Film;
import View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant.QRCode;
import View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant.Texte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    private int nombre_de_film = 100;

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height) {
        int hauteur = frame_height / 3 - 30;
        setBackground(new Color(125, 125, 255));
        setBorder(new EmptyBorder(20,80,20,80));
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JPanel film_panel_liste = new JPanel();
        film_panel_liste.setLayout(new BoxLayout(film_panel_liste, BoxLayout.Y_AXIS));

        for (int i = 0; i < nombre_de_film; i++) {
            Film film_panel = new Film(barre_navigation_panel_width*2/3, 300);
            film_panel_liste.add(film_panel);
        }

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(film_panel_liste);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Cacher la barre de défilement verticale
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Cacher la barre de défilement horizontale

        JPanel wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(scrollPane, BorderLayout.CENTER);

        add(wrapperPanel, BorderLayout.CENTER);
    }
}
