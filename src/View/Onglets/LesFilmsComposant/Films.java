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

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS)); // Layout en boîte horizontale

        creerEtAjouterPanels(barre_navigation_panel_width); // Méthode pour créer et ajouter les panels
    }

    // Méthode pour créer et ajouter les panels
    private void creerEtAjouterPanels(int barre_navigation_panel_width) {
        // Premier panel pour l'image
        JPanel panel_image = new JPanel();
        panel_image.setBorder(new EmptyBorder(25, 5, 5, 5)); // Bordure
        panel_image.setBackground(new Color(255, 200, 0)); // Couleur de fond

        // Largeur fixe pour le panel_image (20% de la largeur totale)
        int panelImageWidth = (int) (barre_navigation_panel_width * poids_panels[0]);
        panel_image.setPreferredSize(new Dimension(panelImageWidth, getHeight())); // Hauteur automatique

        // Affichage de l'image dans le premier panel
        ImageIcon imageIcon = new ImageIcon(film.getUrlImage());
        JLabel imageLabel = new JLabel(imageIcon);
        panel_image.add(imageLabel);

        add(panel_image);

        // Deuxième panel pour les détails du film et le bouton Réserver
        JPanel detailsPanel = new JPanel(new GridLayout(6, 1)); // 6 lignes (Titre, Acteur, Synopsis, Note, Bouton Réserver)
        detailsPanel.setBackground(Color.WHITE); // Couleur de fond
        detailsPanel.setBorder(new EmptyBorder(5, 5, 5, 5)); // Bordure

        // Labels pour les détails du film
        JLabel titreLabel = new JLabel("Titre: " + film.getNom());
        JLabel acteurLabel = new JLabel("Acteur : " + film.getActeur());
        JLabel noteLabel = new JLabel("Note: " + film.getNote());
        JLabel synopsisLabel = new JLabel("Synopsis:");

        // Calculer la largeur maximum avant retour à la ligne pour le synopsis
        int maxSynopsisWidth = (int) (barre_navigation_panel_width * poids_panels[1]);

        // Création du synopsis avec retour à la ligne automatique
        JTextArea synopsisTextArea = new JTextArea(film.getSynopsis());
        synopsisTextArea.setLineWrap(true);
        synopsisTextArea.setWrapStyleWord(true);
        synopsisTextArea.setEditable(false);

        // JScrollPane pour permettre le défilement du synopsis si nécessaire
        JScrollPane synopsisScrollPane = new JScrollPane(synopsisTextArea);
        synopsisScrollPane.setBorder(BorderFactory.createLineBorder(Color.WHITE)); // Bordure blanche
        synopsisScrollPane.setPreferredSize(new Dimension(maxSynopsisWidth, 100)); // Hauteur ajustable

        // Bouton Réserver
        JButton reserverButton = new JButton("Réserver");
        reserverButton.addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffReservationEvenement()); // Publier un événement de réservation
        });

        // Ajout des composants au deuxième panel
        detailsPanel.add(titreLabel);
        detailsPanel.add(acteurLabel);
        detailsPanel.add(synopsisLabel);
        detailsPanel.add(synopsisScrollPane);
        detailsPanel.add(noteLabel);
        detailsPanel.add(reserverButton); // Ajout du bouton Réserver

        add(detailsPanel);
    }
}
