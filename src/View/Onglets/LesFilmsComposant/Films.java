package View.Onglets.LesFilmsComposant;

import Controller.Evenements.AffichageOnglet.AffReservationEvenement;
import Controller.Evenements.FileEvenements;
import Model.Film;
import View.MasterVue;
import View.Onglets.ReservationVue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Films extends JPanel {

    private Film film; // Garder une référence au film actuel
    private double[] poids_panels = {0.2, 0.8};

    // Constructeur
    public Films(int barre_navigation_panel_width, int hauteur, Film film, MasterVue masterVue) {
        this.film = film; // Initialiser le film actuel

        setBackground(new Color(0, 255, 127));
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur));
        setBorder(new EmptyBorder(5, 5, 5, 5));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        creerEtAjouterPanels(gbc, hauteur, masterVue);
    }

    // Méthode
    private void creerEtAjouterPanels(GridBagConstraints gbc, int hauteur, MasterVue masterVue) {
        JPanel panel_image = new JPanel();
        panel_image.setBorder(new EmptyBorder(25, 5, 5, 5));
        panel_image.setBackground(new Color(255, 200, 0));

        gbc.gridx = 0;
        gbc.weightx = poids_panels[0]; // Utilisation du poids pour le premier panel
        gbc.weighty = 1.0;

        // Affichage de l'image dans le premier panel
        ImageIcon imageIcon = new ImageIcon(film.getUrlImage());
        JLabel imageLabel = new JLabel(imageIcon);
        panel_image.add(imageLabel);

        add(panel_image, gbc);

        // Affichage des détails dans le deuxième panel
        JPanel detailsPanel = new JPanel(new GridLayout(5, 1)); // Ajout d'une rangée pour le bouton Réserver
        detailsPanel.setBackground(Color.WHITE);
        detailsPanel.setBorder(new EmptyBorder(5, 5, 5, 5));

        JLabel titreLabel = new JLabel("Titre: " + film.getNom());
        JLabel acteurLabel = new JLabel("Acteur : " + film.getActeur());
        JLabel synopsisLabel = new JLabel("Synopsis: " + film.getSynopsis());
        JLabel noteLabel = new JLabel("Note: " + film.getNote());

        JButton reserverButton = new JButton("Réserver"); // Bouton Réserver
        reserverButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffReservationEvenement());
        });

        detailsPanel.add(titreLabel);
        detailsPanel.add(synopsisLabel);
        detailsPanel.add(noteLabel);
        detailsPanel.add(reserverButton); // Ajout du bouton Réserver

        gbc.gridx = 1;
        gbc.weightx = poids_panels[1]; // Utilisation du poids pour le deuxième panel
        add(detailsPanel, gbc);
    }
}
