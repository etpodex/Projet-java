package View.Onglets;

import Model.Film;
import View.MasterVue;
import View.Onglets.LesFilmsComposant.Films;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    // Attributs
    private Film[] films;
    private int nombre_de_film;

    private JPanel film_panel_liste;
    private JScrollPane scrollPane;
    private JPanel wrapperPanel;

    private int barre_navigation_panel_width;

    // Constructeur
    public LesFilmsVue(int barre_navigation_panel_width, int frame_height) {

        setBackground(new Color(125, 125, 255)); // Définir la couleur de fond
        setBorder(new EmptyBorder(20, 80, 20, 80)); // Définir les marges intérieures
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height)); // Définir la taille préférée

        BorderLayout layout = new BorderLayout();
        setLayout(layout); // Utiliser un BorderLayout pour organiser les composants

        this.film_panel_liste = new JPanel();
        this.film_panel_liste.setLayout(new BoxLayout(this.film_panel_liste, BoxLayout.Y_AXIS)); // Utiliser un BoxLayout vertical pour organiser les films

        this.barre_navigation_panel_width = barre_navigation_panel_width;

        this.scrollPane = new JScrollPane();
        scrollPane.setViewportView(film_panel_liste);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Cacher la barre de défilement verticale
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // Cacher la barre de défilement horizontale

        wrapperPanel = new JPanel(new BorderLayout());
        wrapperPanel.add(scrollPane, BorderLayout.CENTER);

        add(wrapperPanel, BorderLayout.CENTER); // Ajouter le JScrollPane au centre du panneau
    }

    // Méthode pour mettre à jour les films affichés
    public void updateFilms(Film[] films) {
        this.films = films;
        this.nombre_de_film = films.length;

        film_panel_liste.removeAll(); // Supprimer tous les films précédemment affichés

        for (int i = 0; i < nombre_de_film; i++) {
            Films film_panel = new Films(barre_navigation_panel_width * 2 / 3, 200, films[i]); // Créer un nouveau panneau pour chaque film
            film_panel_liste.add(film_panel); // Ajouter le panneau du film à la liste
        }

        film_panel_liste.revalidate(); // Rafraîchir l'affichage des films
        film_panel_liste.repaint(); // Redessiner le panneau des films
    }
}
