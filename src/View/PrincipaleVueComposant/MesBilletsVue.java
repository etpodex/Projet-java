package View.PrincipaleVueComposant;

import View.PrincipaleVueComposant.MesBilletsComposant.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MesBilletsVue extends JPanel {

    private int nombre_de_panel_billet = 2;
    private String[] titre_film_billet = {"coucou francis", "l'eau mouille"};
    private String[] data_film_billet = {"12/03/24", "30/10/25"};
    private String[] data_horaire_billet = {"15h00", "17h00"};
    private int data_salle_billet[] = {2,3};
    private String[] data_siege_billet = {"5A","7B"};
    private int nbre_de_billet_acheter[] = {2,3};
    private int nbre_de_billet_adulte[] = {1,1};
    private int nbre_de_billet_enfant[] = {1,1};
    private int nbre_de_billet_senior[] = {0,1};

    public MesBilletsVue(int barre_navigation_panel_width, int frame_height) {
        setBackground(new Color(40, 25, 125));
        setPreferredSize(new Dimension(barre_navigation_panel_width, frame_height));
        setBorder(new EmptyBorder(20, 20, 20, 20));
        setLayout(new GridLayout(nombre_de_panel_billet, 1));

        // Creation Panel Billet
        for (int i = 0; i < nombre_de_panel_billet; i++) {

            Billet billet = new Billet(barre_navigation_panel_width, frame_height);
            billet.setTitreFilm(titre_film_billet[i]);
            billet.setDataFilm(data_film_billet[i]);
            billet.setDataHoraire(data_horaire_billet[i]);
            billet.setDataSalle(data_salle_billet[i]);
            billet.setDataSiege(data_siege_billet[i]);
            billet.setNbreBilletAcheter(nbre_de_billet_acheter[i]);
            billet.setNbreBilletAdulte(nbre_de_billet_adulte[i]);
            billet.setNbreBilletEnfant(nbre_de_billet_enfant[i]);
            billet.setNbreBilletSenior(nbre_de_billet_senior[i]);
            billet.setBackground(new Color(150*i/(i+1),150*i/(i+1), 0));
            add(billet);
        }

        // Revalidate and repaint the panel
        revalidate();
        repaint();
    }
}
