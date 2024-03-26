package View.Onglets.MesBilletsComposant;

import View.Onglets.MesBilletsComposant.BilletComposant.QRCode;
import View.Onglets.MesBilletsComposant.BilletComposant.Texte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AffichageBillet extends JPanel {

    // Attribut

    // texte
    private int nombre_de_panel_billet = 4;
    private String[] titre_film_billet = {"coucou francis", "l'eau mouille", "hop hop hop", "azerty"};
    private String[] data_film_billet = {"12/03/24", "30/10/25", "15/05/2018", "30/02/2023"};
    private String[] data_horaire_billet = {"15h00", "17h00", "11h00", "20h00"};
    private int data_salle_billet[] = {2, 3, 2, 1};
    private String[] data_siege_billet = {"5A", "7B", "9F - 5Y - 9I", "10M"};
    private int nbre_de_billet_acheter[] = {2, 3, 3, 1};
    private int nbre_de_billet_adulte[] = {1, 1, 3, 0};
    private int nbre_de_billet_enfant[] = {1, 1, 0, 0};
    private int nbre_de_billet_senior[] = {0, 1, 0, 1};

    private String qrcode_billet[] = {"image1.jpg", "image2.jpg", "image3.jpg", "image4.jpg"};


    public AffichageBillet(int barre_navigation_panel_width, int frame_height) {

        int hauteur = frame_height / 3 - 30;
        setBackground(new Color(0, 255, 127));
        setBorder(new EmptyBorder(10, 10, 10, 10)); // Padding autour de Billet

        setLayout(new GridLayout(nombre_de_panel_billet, 1, 0, 10)); // Utilisation de GridLayout avec 1 colonne et espacement vertical

        for (int i = 0; i < nombre_de_panel_billet; i++) {
            JPanel billetPanel = new JPanel(new GridBagLayout()); // Utilisation de GridBagLayout pour organiser les composants

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1.0;

            // Pour le QRCode
            QRCode qrcode = new QRCode(barre_navigation_panel_width / 5, hauteur); // Utilise 20% de la largeur du billetPanel
            qrcode.setQRCode(qrcode_billet[i]); // Mise à jour du QRCode
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.weightx = 0.2; // QRCode occupe 20% de la largeur disponible
            gbc.gridheight = GridBagConstraints.REMAINDER; // Fait en sorte que le QRCode prenne toute la hauteur du panneau
            billetPanel.add(qrcode, gbc); // Ajout de QRCode à gauche

            // Pour le Texte
            Texte texte = new Texte((int)(barre_navigation_panel_width * 0.8), hauteur); // Utilise 80% de la largeur du billetPanel
            texte.setTitreFilm(titre_film_billet[i]);
            texte.setDataFilm(data_film_billet[i]);
            texte.setDataHoraire(data_horaire_billet[i]);
            texte.setDataSalle(data_salle_billet[i]);
            texte.setDataSiege(data_siege_billet[i]);
            texte.setNbreBilletAcheter(nbre_de_billet_acheter[i]);
            texte.setNbreBilletAdulte(nbre_de_billet_adulte[i]);
            texte.setNbreBilletEnfant(nbre_de_billet_enfant[i]);
            texte.setNbreBilletSenior(nbre_de_billet_senior[i]);
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.weightx = 0.8; // Texte occupe 80% de la largeur disponible
            billetPanel.add(texte, gbc); // Ajout de Texte à droite

            add(billetPanel); // Ajouter le panneau de billet à la grille
        }

        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * nombre_de_panel_billet));
    }
}
