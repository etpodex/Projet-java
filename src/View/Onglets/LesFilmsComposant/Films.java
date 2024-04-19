package View.Onglets.LesFilmsComposant;

import Controller.Evenements.AffichageOnglet.AffReservationEvenement;
import Controller.Evenements.FileEvenements;
import Model.Film;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Films extends JPanel {

    private Film film; // Référence au film actuel
    private double[] poids_panels = {0.2, 0.8}; // Poids des deux panels

    // Constructeur
    public Films(int barre_navigation_panel_width, int hauteur, Film film) {
        this.film = film; // Initialisation du film actuel

        setBackground(new Color(0, 255, 127)); // Couleur de fond
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur)); // Taille préférée
        setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure

        setLayout(new GridBagLayout()); // Layout en grille
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        creerEtAjouterPanels(gbc); // Méthode pour créer et ajouter les panels
    }

    // Méthode pour créer et ajouter les panels
    private void creerEtAjouterPanels(GridBagConstraints gbc) {
        // Premier panel pour l'image
        JPanel panel_image = new JPanel();
        panel_image.setBorder(new EmptyBorder(25, 5, 5, 5)); // Bordure
        panel_image.setBackground(new Color(255, 200, 0)); // Couleur de fond

        gbc.gridx = 0;
        gbc.weightx = poids_panels[0]; // Poids du premier panel
        gbc.weighty = 1.0;

        // Affichage de l'image dans le premier panel
        ImageIcon imageIcon = new ImageIcon(film.getUrlImage());
        JLabel imageLabel = new JLabel(imageIcon);
        panel_image.add(imageLabel);

        add(panel_image, gbc);

        // Deuxième panel pour les détails du film et le bouton Réserver
        JPanel detailsPanel = new JPanel(new GridLayout(5, 1)); // 5 lignes (Titre, Synopsis, Note, Bouton Réserver)
        detailsPanel.setBackground(Color.WHITE); // Couleur de fond
        detailsPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure

        // Labels pour les détails du film
        JLabel titreLabel = new JLabel("Titre: " + film.getNom());
        JLabel acteurLabel = new JLabel("Acteur : " + film.getActeur());
        JLabel synopsisLabel = new JLabel("Synopsis: " + film.getSynopsis());
        JLabel noteLabel = new JLabel("Note: " + film.getNote());

        // Bouton Réserver
        JButton reserverButton = new JButton("Réserver");
        reserverButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffReservationEvenement()); // Publier un événement de réservation
        });

        // Ajout des composants au deuxième panel
        detailsPanel.add(titreLabel);
        detailsPanel.add(synopsisLabel);
        detailsPanel.add(noteLabel);
        detailsPanel.add(reserverButton); // Ajout du bouton Réserver

        gbc.gridx = 1;
        gbc.weightx = poids_panels[1]; // Poids du deuxième panel
        add(detailsPanel, gbc);
    }
}
