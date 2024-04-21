package View.Onglets;

import Model.Film;
import View.Onglets.GererFilmVueComposant.Grille;
import View.Onglets.GererFilmVueComposant.FormulaireAjoutFilmVue;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GererFilmVue extends JPanel {
    // Déclaration des attributs
    private Film[] films = new Film[]{
            new Film("idfilm1", "titre1", "acteur1", "synopsis1", "1h30", 9.0f, "image1.jpg", 10),
            new Film("idfilm2", "titre2", "acteur2", "synopsis2", "2h10", 8.5f, "image2.jpg", 15),
            new Film("idfilm3", "titre3", "acteur3", "synopsis3", "2h45", 7.5f, "image3.jpg", 15),
    };
    private JPanel panel_grille;
    private JButton boutonAfficher;
    private Grille grilleFilms;
    private FormulaireAjoutFilmVue formulaireAjoutFilmVue;
    private boolean formulaireAffiche = false;

    // Constructeur
    public GererFilmVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(238, 238, 238));  // Définir la couleur de fond
        setLayout(new BorderLayout());  // Utilisation d'un BorderLayout pour organiser les composants
        panel_grille = new JPanel(new BorderLayout());  // Initialisation du panneau pour la grille
        JPanel panel_bouton = new JPanel();  // Initialisation du panneau pour le bouton
        panel_grille.setBackground(new Color(238,238,238));  // Définir la couleur de fond du panneau grille
        panel_bouton.setBackground(new Color(238,238,238));  // Définir la couleur de fond du panneau bouton

        // Définition des dimensions pour les panneaux grille et bouton
        Dimension dimension85 = new Dimension(barre_navigation_panel_width, (int) (frame_height * 0.86));
        Dimension dimension15 = new Dimension(barre_navigation_panel_width, (int) (frame_height * 0.08));
        panel_grille.setPreferredSize(dimension85);
        panel_bouton.setPreferredSize(dimension15);

        // Ajout des panneaux grille et bouton au panneau principal
        add(panel_grille, BorderLayout.NORTH);
        add(panel_bouton, BorderLayout.SOUTH);

        // Initialisation de la grille de films
        grilleFilms = new Grille(films);
        // Initialisation du formulaire pour ajouter un film
        formulaireAjoutFilmVue = new FormulaireAjoutFilmVue(this);
        panel_grille.add(grilleFilms);  // Ajout de la grille à son panneau parent

        // Création et ajout du bouton "Afficher"
        boutonAfficher = new JButton("Afficher");
        boutonAfficher.addActionListener(e -> toggleForm());
        panel_bouton.add(boutonAfficher);
    }

    // Méthode pour basculer entre l'affichage de la grille et du formulaire
    private void toggleForm() {
        if (!formulaireAffiche) {
            boutonAfficher.setText("Valider");
            formulaireAffiche = true;
            panel_grille.removeAll();
            panel_grille.add(formulaireAjoutFilmVue);  // Afficher le formulaire d'ajout de film
        } else {
            if (formulaireAjoutFilmVue.areAllFieldsFilled()) {
                // Créer un nouveau film à partir des champs du formulaire
                Film newFilm = formulaireAjoutFilmVue.createFilmFromFields();
                addFilm(newFilm);  // Ajouter le nouveau film à la liste et à la grille
            } else {
                // Afficher un message d'erreur si tous les champs ne sont pas remplis correctement
                JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
            boutonAfficher.setText("Afficher");
            formulaireAffiche = false;
            panel_grille.removeAll();
            panel_grille.add(grilleFilms);  // Afficher à nouveau la grille de films
        }
        panel_grille.revalidate();
        panel_grille.repaint();
    }

    // Méthode pour ajouter un film à la liste et à la grille
    public void addFilm(Film film) {
        Film[] newFilms = Arrays.copyOf(films, films.length + 1);  // Créer une nouvelle liste avec une taille augmentée
        newFilms[newFilms.length - 1] = film;  // Ajouter le nouveau film à la fin de la liste
        films = newFilms;  // Mettre à jour la référence de la liste des films
        grilleFilms.ajouterFilm(film.getNom(), film.getActeur(), film.getTemps(), film.getNote(), film.getSynopsis(), new ImageIcon(film.getUrlImage()));  // Ajouter le film à la grille
    }
}
