package View.Onglets;

import Model.Film;
import View.MasterVue;
import View.Onglets.LesFilmsComposant.Films;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    Film[] films;
    private int nombre_de_film;

    private JPanel film_panel_liste;
    private JScrollPane scrollPane;
    private JPanel wrapperPanel;

    private int barre_navigation_panel_width;

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height) {

        setBackground(new Color(125, 125, 255));
        setBorder(new EmptyBorder(20, 80, 20, 80));
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));

        BorderLayout layout = new BorderLayout();
        setLayout(layout);

        this.film_panel_liste = new JPanel();
        this.film_panel_liste.setLayout(new BoxLayout(this.film_panel_liste, BoxLayout.Y_AXIS));

        this.barre_navigation_panel_width = barre_navigation_panel_width;

        this.scrollPane = new JScrollPane();
        scrollPane.setViewportView(film_panel_liste);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Cacher la barre de défilement verticale
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Cacher la barre de défilement horizontale

        wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(scrollPane, BorderLayout.CENTER);

        add(wrapperPanel, BorderLayout.CENTER);
    }

    public void updateFilms(Film[] films) {
        this.films = films;
        this.nombre_de_film = films.length;

        film_panel_liste.removeAll();

        for (int i = 0; i < nombre_de_film; i++) {
            Films film_panel = new Films(barre_navigation_panel_width * 2 / 3, 200, films[i]); // Passer la référence à MasterVue
            film_panel_liste.add(film_panel);
        }

        film_panel_liste.revalidate();
        film_panel_liste.repaint();
    }
}
