package View.Onglets.LesFilmsComposant;
import Model.Film;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Films extends JPanel {

    private Film film; // Garder une référence au film actuel
    private double[] poids_panels = {0.2, 0.8};

    // Constructeur
    public Films(int barre_navigation_panel_width, int hauteur, Film film) {
        this.film = film; // Initialiser le film actuel

        setBackground(new Color(0, 255, 127));
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur));
        setBorder(new EmptyBorder(5, 5, 5, 5));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        creerEtAjouterPanels(gbc, hauteur);
    }

    // Méthode
    private void creerEtAjouterPanels(GridBagConstraints gbc, int hauteur) {
        JPanel panel_film = new JPanel();
        panel_film.setBorder(new EmptyBorder(25, 5, 5, 5));
        panel_film.setBackground(new Color(255, 200, 0));

        gbc.gridx = 0;
        gbc.weightx = poids_panels[0]; // Utilisation du poids pour le premier panel
        gbc.weighty = 1.0;

        // Affichage de l'image dans le premier panel
        ImageIcon imageIcon = new ImageIcon(film.getUrlImage());
        JLabel imageLabel = new JLabel(imageIcon);
        panel_film.add(imageLabel);

        add(panel_film, gbc);

        // Affichage des détails dans le deuxième panel
        JPanel detailsPanel = new JPanel(new GridLayout(4, 1));
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel titreLabel = new JLabel("Titre: " + film.getNom());
        JLabel acteurLabel = new JLabel("Acteur : " + film.getActeur());
        JLabel synopsisLabel = new JLabel("Synopsis: " + film.getSynopsis());
        JLabel noteLabel = new JLabel("Note: " + film.getNote());
        //JLabel prixLabel = new JLabel("Prix: " + film.getPrixFilm());

        detailsPanel.add(titreLabel);
        detailsPanel.add(synopsisLabel);
        detailsPanel.add(noteLabel);
        //detailsPanel.add(prixLabel);

        gbc.gridx = 1;
        gbc.weightx = poids_panels[1]; // Utilisation du poids pour le deuxième panel
        add(detailsPanel, gbc);
    }
}
