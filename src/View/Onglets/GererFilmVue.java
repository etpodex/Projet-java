package View.Onglets;

import Model.Film;
import View.Onglets.GererFilmVueComposant.FormulaireAjoutFilmVue;
import View.Onglets.GererFilmVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GererFilmVue extends JPanel {

    private Film[] films = new Film[]{
            new Film("idfilm1", "titre1", "acteur1", "synopsis1", "1h30", 9.0f, "image1.jpg", 10),
            new Film("idfilm2", "titre2", "acteur2", "synopsis2", "2h10", 8.5f, "image2.jpg", 15),
            new Film("idfilm3", "titre3", "acteur3", "synopsis3", "2h45", 7.5f, "image3.jpg", 15),
    };

    private JPanel panel_grille;
    private JButton boutonAfficher;
    private boolean formulaireAffiche = false;

    public GererFilmVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(50, 100, 50));
        setLayout(new BorderLayout()); // Utilisation d'un BorderLayout

        // Création des sous-panneaux
        panel_grille = new JPanel();
        JPanel panel_bouton = new JPanel();

        // Définition des couleurs de fond pour les sous-panneaux (juste pour illustrer)
        panel_grille.setBackground(Color.RED);
        panel_bouton.setBackground(Color.BLUE);

        // Calcul des hauteurs pour chaque sous-panneau
        int height85 = (int) (frame_height * 0.86);
        int height15 = (int) (frame_height * 0.08);

        // Définition des dimensions pour chaque sous-panneau
        Dimension dimension85 = new Dimension(barre_navigation_panel_width, height85);
        Dimension dimension15 = new Dimension(barre_navigation_panel_width, height15);

        panel_grille.setPreferredSize(dimension85);
        panel_bouton.setPreferredSize(dimension15);

        // Ajout des sous-panneaux au JPanel principal
        add(panel_grille, BorderLayout.NORTH);
        add(panel_bouton, BorderLayout.SOUTH);

        // Création de la grille des films et ajout dans le panneau de la grille dès le départ
        Grille grilleFilms = new Grille();
        panel_grille.add(grilleFilms);

        // Création du bouton "Afficher"
        boutonAfficher = new JButton("Afficher");
        panel_bouton.add(boutonAfficher);

        // Ajout d'un écouteur d'événements pour le bouton "Afficher"
        boutonAfficher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!formulaireAffiche) {
                    boutonAfficher.setText("Valider");
                    formulaireAffiche = true;
                    // Dans la classe GererFilmVue
                    panel_grille.removeAll();
                    panel_grille.add(new FormulaireAjoutFilmVue(GererFilmVue.this)); // Passer une référence à GererFilmVue
                    panel_grille.revalidate();
                    panel_grille.repaint();

                } else {
                    boutonAfficher.setText("Ajouter");
                    formulaireAffiche = false;
                    // Afficher à nouveau la grille des films en utilisant la classe Grille
                    panel_grille.removeAll();
                    panel_grille.add(grilleFilms); // Ajout de la grille des films déjà créée
                    panel_grille.revalidate();
                    panel_grille.repaint();
                }
            }
        });
    }

}

