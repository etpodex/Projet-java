package View.Onglets;

import Model.Film;
import View.Onglets.LesFilmsComposant.Films;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    private int nombre_de_film = 3;

    private String[] titre_film = {"coucou francis", "l'eau mouille", "hop hop hop"};
    private String[] affiche_film = {"image1.jpg", "image2.jpg", "image3.jpg"};

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height){

        int hauteur = frame_height / 3 - 30;
        setBackground(new Color(125, 125, 255));
        setPreferredSize(new Dimension(barre_navigation_panel_width,hauteur));


        //BorderLayout layout = new BorderLayout();

        setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding autour de Billet

        setLayout(new GridLayout(nombre_de_film, 1, 0, 10));

        for (int i=0; i < nombre_de_film; i++){
            JPanel film_panel_liste = new JPanel();
            film_panel_liste.setLayout(new BoxLayout(film_panel_liste, BoxLayout.Y_AXIS));

            Films remplissage = new Films(barre_navigation_panel_width, hauteur);
            remplissage.setTitreFilm(titre_film[i]);
            remplissage.setAfficheFilm(affiche_film[i]);
            film_panel_liste.add(remplissage);

            add(film_panel_liste, BorderLayout.NORTH);
        }

        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * nombre_de_film));

    }
}
