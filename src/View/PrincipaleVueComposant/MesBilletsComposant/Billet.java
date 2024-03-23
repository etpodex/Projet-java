package View.PrincipaleVueComposant.MesBilletsComposant;

import View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant.QRCode;
import View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant.Texte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Billet extends JPanel {

    // Attribut

    // texte
    private int nombre_de_panel_billet = 2;
    private String[] titre_film_billet = {"coucou francis", "l'eau mouille"};
    private String[] data_film_billet = {"12/03/24", "30/10/25"};
    private String[] data_horaire_billet = {"15h00", "17h00"};
    private int data_salle_billet[] = {2, 3};
    private String[] data_siege_billet = {"5A", "7B"};
    private int nbre_de_billet_acheter[] = {2, 3};
    private int nbre_de_billet_adulte[] = {1, 1};
    private int nbre_de_billet_enfant[] = {1, 1};
    private int nbre_de_billet_senior[] = {0, 1};

    private String qrcode_billet[] = {"image1.jpg", "image2.jpg"};


    public Billet(int barre_navigation_panel_width, int frame_height) {

        int hauteur = frame_height / 3 - 30;
        setBackground(new Color(0, 255, 127));
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding autour de Billet

        setLayout(new GridLayout(nombre_de_panel_billet, 1, 0, 10)); // Utilisation de GridLayout avec 1 colonne et espacement vertical

        for (int i = 0; i < nombre_de_panel_billet; i++) {
            JPanel billetPanel = new JPanel(new BorderLayout()); // Utilisation de BorderLayout pour organiser les composants

            Texte texte = new Texte(barre_navigation_panel_width / 2, hauteur);
            texte.setTitreFilm(titre_film_billet[i]);
            texte.setDataFilm(data_film_billet[i]);
            texte.setDataHoraire(data_horaire_billet[i]);
            texte.setDataSalle(data_salle_billet[i]);
            texte.setDataSiege(data_siege_billet[i]);
            texte.setNbreBilletAcheter(nbre_de_billet_acheter[i]);
            texte.setNbreBilletAdulte(nbre_de_billet_adulte[i]);
            texte.setNbreBilletEnfant(nbre_de_billet_enfant[i]);
            texte.setNbreBilletSenior(nbre_de_billet_senior[i]);
            billetPanel.add(texte, BorderLayout.EAST); // Ajout de Texte à droite

            QRCode qrcode = new QRCode(barre_navigation_panel_width / 2, hauteur);
            qrcode.setQRCode(qrcode_billet[i]); // Mise à jour du QRCode
            billetPanel.add(qrcode, BorderLayout.WEST); // Ajout de QRCode à gauche

            add(billetPanel); // Ajouter le panneau de billet à la grille
        }

        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * nombre_de_panel_billet));
    }
}


