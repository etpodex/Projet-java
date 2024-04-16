package View.Onglets;

import Controller.Evenements.EffacerFilmEvenement;
import Controller.Evenements.FileEvenements;
import Model.Film;

import javax.swing.*;
import java.awt.*;

public class GererFilmVue extends JPanel {

    private Film[] films = new Film[]{
            new Film("idfilm1", "titre1", "acteur1", "synopsis1", "1h30", 9.0f, "image1.jpg", 10),
            new Film("idfilm2", "titre2", "acteur2", "synopsis2", "2h10", 8.5f, "image2.jpg", 15),
            new Film("idfilm3", "titre3", "acteur3", "synopsis3", "2h45", 7.5f, "image3.jpg", 15),
    };

    public GererFilmVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(50, 100, 50));
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));

        // Création d'un panneau pour contenir la grille
        JPanel grillePanel = new JPanel();
        grillePanel.setLayout(new GridLayout(films.length + 1, 1)); // Une colonne pour chaque ligne
        grillePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        String[] columnNames = {"Titre", "Acteur", "Temps", "Note", "Synopsis", "Affiche", "Supprimer"};

        // Ajouter les en-têtes de colonne
        JPanel headerPanel = new JPanel(new GridLayout(1, 7));
        headerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (String columnName : columnNames) {
            JLabel label = new JLabel(columnName);
            label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            label.setHorizontalAlignment(SwingConstants.CENTER);
            headerPanel.add(label);
        }
        grillePanel.add(headerPanel);

        // Ajouter chaque film à la grille
        for (int i = 0; i < films.length; i++) {
            Film film = films[i];
            JPanel filmPanel = new JPanel(new GridLayout(1, 7));
            filmPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            JLabel titreLabel = new JLabel(film.getNom());
            titreLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            titreLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filmPanel.add(titreLabel);

            JLabel acteurLabel = new JLabel(film.getActeur());
            acteurLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            acteurLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filmPanel.add(acteurLabel);

            JLabel tempsLabel = new JLabel(film.getTemps());
            tempsLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            tempsLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filmPanel.add(tempsLabel);

            JLabel noteLabel = new JLabel(String.valueOf(film.getNote()));
            noteLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            noteLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filmPanel.add(noteLabel);

            JLabel synopsisLabel = new JLabel(film.getSynopsis());
            synopsisLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            synopsisLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filmPanel.add(synopsisLabel);

            JLabel afficheLabel = new JLabel(film.getUrlImage());
            afficheLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            afficheLabel.setHorizontalAlignment(SwingConstants.CENTER);
            filmPanel.add(afficheLabel);

            JButton supprimer = new JButton("X");
            supprimer.setForeground(Color.RED);
            supprimer.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
            supprimer.setContentAreaFilled(false);
            supprimer.setFocusPainted(false);
            supprimer.setOpaque(false);
            supprimer.setBorder(BorderFactory.createLineBorder(Color.BLACK));

            // Ajouter un action listener pour supprimer le film
            int finalI = i; // Utilisé dans l'action listener
            supprimer.addActionListener(e -> {
                // Supprimer le film de la liste films
                films = removeFilmAtIndex(films, finalI);
                // Retirer le panneau du film de la grille
                grillePanel.remove(finalI + 1); // +1 pour compenser l'en-tête
                // Rafraîchir l'affichage
                revalidate();
                repaint();
                // Publier un événement pour informer les abonnés
                FileEvenements.getInstance().publier(new EffacerFilmEvenement());
            });

            filmPanel.add(supprimer);

            grillePanel.add(filmPanel);
        }

        add(grillePanel);

        revalidate();
        repaint();
    }

    // Méthode pour supprimer un film à un index donné dans un tableau de films
    private Film[] removeFilmAtIndex(Film[] films, int index) {
        Film[] newFilms = new Film[films.length - 1];
        System.arraycopy(films, 0, newFilms, 0, index);
        System.arraycopy(films, index + 1, newFilms, index, films.length - index - 1);
        return newFilms;
    }
}