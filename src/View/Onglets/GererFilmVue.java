package View.Onglets;

import Controller.Evenements.AffichageOnglet.AffGererFilmEvenement;
import Controller.Evenements.AjoutFilmBDDEvenement;
import Controller.Evenements.FileEvenements;
import Model.Film;
import View.Onglets.GererFilmVueComposant.Grille;
import View.Onglets.GererFilmVueComposant.FormulaireAjoutFilmVue;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GererFilmVue extends JPanel {
    // Déclaration des attributs
    private Film[] films;
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
                AjoutFilmBDDEvenement evenement = new AjoutFilmBDDEvenement();
                evenement.setFilm(newFilm);
                FileEvenements.getInstance().publier(evenement);
                FileEvenements.getInstance().publier(new AffGererFilmEvenement());
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
    public void setFilms(Film[] films) {
        this.films = films;
        grilleFilms.setFilms(films);
    }
}
