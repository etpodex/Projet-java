package View.Onglets.LesFilmsComposant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Films extends JPanel {

    private int nombre_de_panel_film = 2;
    private double[] poids_panels = {0.25, 0.75};

    private JLabel titre_film;
    private JLabel etoile_film;
    private JLabel auteur_film;
    private JLabel heure_film;
    private JLabel synopsis_film;
    private JLabel affiche_film;


    // Constructeur
    public Films(int barre_navigation_panel_width, int hauteur) {

        setBackground(new Color(0, 255, 127));
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur));
        setBorder(new EmptyBorder(5, 5, 5, 5));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;


        titre_film = new JLabel();
        etoile_film = new JLabel();
        auteur_film = new JLabel();
        heure_film = new JLabel();
        synopsis_film = new JLabel();

        affiche_film = new JLabel();



        for (int i = 0; i < nombre_de_panel_film; i++) {
            JPanel panel_film = new JPanel();
            panel_film.setBorder(new EmptyBorder(5, 5, 5, 5));
            panel_film.setBackground(new Color(255 * i / (i + 1), 100 * i / (i + 1), 0));

            gbc.gridx = i;
            gbc.weightx = poids_panels[i];
            gbc.weighty = hauteur;

            if (i == 0) {
                panel_film.add(affiche_film);

            } else {
                panel_film.setLayout(new GridLayout(0, 1, 0, 0)); // Utiliser FlowLayout avec alignement à gauche

                panel_film.add(titre_film);
                panel_film.add(createInfoFilmPanel());
                panel_film.add(synopsis_film);
            }

            add(panel_film, gbc);

        }
    }

    //Methode

    private JPanel createInfoFilmPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(etoile_film);
        panel.add(auteur_film);
        panel.add(heure_film);
        return panel;
    }

    public void setTitreFilm(String titre) {
        titre_film.setText("Titre: " + titre);
    }

    public void setEtoile (String etoile) {
        etoile_film.setText(etoile);
    }

    public void setAuteur(String auteur) {
        auteur_film.setText(auteur);
    }

    public void setHeure(String heure) {
        heure_film.setText("  -  " + heure);
    }

    public void setSynopsis(String synopsis) {
        synopsis_film.setText("Synopsis: " + synopsis);
    }

    public void setAfficheFilm(String affiches_film) {
        affiche_film.setIcon(new ImageIcon(affiches_film)); // Définit l'icône du JLabel avec l'image QRCode
    }
}