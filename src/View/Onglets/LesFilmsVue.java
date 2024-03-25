package View.Onglets;

import View.PrincipaleVueComposant.AccueilVueComposant.*;
import View.PrincipaleVueComposant.LesFilmsComposant.Film;
import View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant.QRCode;
import View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant.Texte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class LesFilmsVue extends JPanel {

    private int nombre_de_film = 3;

    public LesFilmsVue(int barre_navigation_panel_width, int frame_height){
        int hauteur = frame_height / 3 - 30;
        setBackground(new Color(125, 125, 255));
        setPreferredSize(new Dimension(barre_navigation_panel_width,hauteur));

        BorderLayout layout = new BorderLayout();

        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(layout);

        JPanel film_panel_liste = new JPanel();
        film_panel_liste.setLayout(new BoxLayout(film_panel_liste, BoxLayout.Y_AXIS));

        for (int i = 0; i < nombre_de_film; i++) {
            Film film_panel = new Film(barre_navigation_panel_width, 150); // Utilisation de BorderLayout pour organiser les composants

            film_panel_liste.add(film_panel); // Ajouter le panneau de billet à la grille
        }

        add(film_panel_liste, BorderLayout.NORTH);

        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * nombre_de_film));
    }
}