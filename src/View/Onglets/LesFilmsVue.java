package View.Onglets;

import Model.Film;
import View.MasterVue;
import View.Onglets.LesFilmsComposant.Films;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    Film[] films = new Film[]{
            new Film("idfilm1", "titre1", "acteur1", "synopsis1", 9.0f, "image1.jpg", 10),
            new Film("idfilm2", "titre2", "acteur2", "synopsis2", 8.5f, "image2.jpg", 15),
            new Film("idfilm2", "titre2", "acteur2", "synopsis3", 7.5f, "image3.jpg", 15),
    };
    private int nombre_de_film = films.length;

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height, MasterVue master_vue) {

        setBackground(new Color(125, 125, 255));
        setBorder(new EmptyBorder(20, 80, 20, 80));
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        JPanel film_panel_liste = new JPanel();
        film_panel_liste.setLayout(new BoxLayout(film_panel_liste, BoxLayout.Y_AXIS));

        for (int i = 0; i < nombre_de_film; i++) {
            Films film_panel = new Films(barre_navigation_panel_width * 2 / 3, 200, films[i], master_vue); // Passer la référence à MasterVue
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
