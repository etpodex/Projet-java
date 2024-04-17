package View.Onglets;

import Model.Film;
import View.Onglets.GererFilmVueComposant.Grille;
import View.Onglets.GererFilmVueComposant.FormulaireAjoutFilmVue;
import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GererFilmVue extends JPanel {
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

    public GererFilmVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(50, 100, 50));
        setLayout(new BorderLayout());
        panel_grille = new JPanel(new BorderLayout());
        JPanel panel_bouton = new JPanel();
        panel_grille.setBackground(Color.RED);
        panel_bouton.setBackground(Color.BLUE);
        Dimension dimension85 = new Dimension(barre_navigation_panel_width, (int) (frame_height * 0.86));
        Dimension dimension15 = new Dimension(barre_navigation_panel_width, (int) (frame_height * 0.08));
        panel_grille.setPreferredSize(dimension85);
        panel_bouton.setPreferredSize(dimension15);
        add(panel_grille, BorderLayout.NORTH);
        add(panel_bouton, BorderLayout.SOUTH);

        grilleFilms = new Grille(films);
        formulaireAjoutFilmVue = new FormulaireAjoutFilmVue(this);
        panel_grille.add(grilleFilms);

        boutonAfficher = new JButton("Afficher");
        boutonAfficher.addActionListener(e -> toggleForm());
        panel_bouton.add(boutonAfficher);
    }

    private void toggleForm() {
        if (!formulaireAffiche) {
            boutonAfficher.setText("Valider");
            formulaireAffiche = true;
            panel_grille.removeAll();
            panel_grille.add(formulaireAjoutFilmVue);
        } else {
            if (formulaireAjoutFilmVue.areAllFieldsFilled()) {
                Film newFilm = formulaireAjoutFilmVue.createFilmFromFields();
                addFilm(newFilm);
            }
            boutonAfficher.setText("Afficher");
            formulaireAffiche = false;
            panel_grille.removeAll();
            panel_grille.add(grilleFilms);
        }
        panel_grille.revalidate();
        panel_grille.repaint();
    }

    public void addFilm(Film film) {
        Film[] newFilms = Arrays.copyOf(films, films.length + 1);
        newFilms[newFilms.length - 1] = film;
        films = newFilms;
        grilleFilms.ajouterFilm(film.getNom(), film.getActeur(), film.getTemps(), film.getNote(), film.getSynopsis(), new ImageIcon(film.getUrlImage()));
    }
}
