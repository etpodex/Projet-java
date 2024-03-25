package View.Onglets;

import Model.Film;
import View.Onglets.LesFilmsComposant.Films;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    private int nombre_de_film = 3;

    private String[][] films = {
            {"coucou francis", "5/5", "Franc Dupont, Argile tamere", "2h45", "azertyuiopqsdfghjklmgeifgfkdhvcowvcovovvvusdvjvbs", "image1.jpg"},
            {"l'eau mouille", "5/5", "Franc Dupont, Argile tamere", "2h45", "azertyuiopqsdfghjklmgeifgfkdhvcowvcovovvvusdvjvbs","image2.jpg"},
            {"hop hop hop", "5/5", "Franc Dupont, Argile tamere", "2h45", "azertyuiopqsdfghjklmgeifgfkdhvcowvcovovvvusdvjvbs","image3.jpg"}
    };

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height){

        int hauteur = frame_height / 3 - 30;
        setBackground(new Color(125, 125, 255));
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur));


        //BorderLayout layout = new BorderLayout();

        setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding autour de Billet

        setLayout(new GridLayout(nombre_de_film, 1, 0, 10));

        for (int i = 0; i < nombre_de_film; i++){
            JPanel film_panel_liste = new JPanel();
            film_panel_liste.setLayout(new BoxLayout(film_panel_liste, BoxLayout.Y_AXIS));

            Films remplissage = new Films(barre_navigation_panel_width, hauteur);
            remplissage.setTitreFilm(films[i][0]);
            remplissage.setEtoile(films[i][1]);
            remplissage.setAuteur(films[i][2]);
            remplissage.setHeure(films[i][3]);
            remplissage.setSynopsis(films[i][4]);
            remplissage.setAfficheFilm(films[i][5]);

            film_panel_liste.add(remplissage);

            add(film_panel_liste, BorderLayout.NORTH);
        }

        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * nombre_de_film));

    }
}