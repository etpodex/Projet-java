package View.Onglets.MesBilletsComposant;

import Model.Billet;
import View.Onglets.MesBilletsComposant.BilletComposant.QRCode;
import View.Onglets.MesBilletsComposant.BilletComposant.Texte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AffichageBillet extends JPanel {

    // Attribut
    Billet[] billets = new Billet[]{
            new Billet("Titre du film 1", "12/03/2023", "14:00", "Salle 1","7H",
                    2, 3, 1, "client@example1.com", "image1.jpg"),
            new Billet("Titre du film 2", "12/04/2023", "15:00", "Salle 2","7G",
                    2, 3, 1, "client@example2.com", "image2.jpg"),
            new Billet("Titre du film 3", "12/05/2023", "16:00", "Salle 3","7F",
                    2, 3, 1, "client@example3.com", "image3.jpg"),
            new Billet("Titre du film 4", "12/06/2023", "17:00", "Salle 4","7E",
                    2, 3, 1, "client@example4.com", "image4.jpg")
    };

    // texte
    private int nombre_de_panel_billet = billets.length;

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
            QRCode qrcode = new QRCode(); // Utilise 20% de la largeur du billetPanel
            qrcode.setQRCode(billets[i].getUrlImageFilm()); // Mise à jour du QRCode
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.weightx = 0.1; // QRCode occupe 20% de la largeur disponible
            gbc.gridheight = GridBagConstraints.REMAINDER; // Fait en sorte que le QRCode prenne toute la hauteur du panneau
            billetPanel.add(qrcode, gbc); // Ajout de QRCode à gauche

            // Pour le Texte
            Texte texte = new Texte(); // Utilise 80% de la largeur du billetPanel
            texte.setTitreFilm(billets[i].getTitreFilm());
            texte.setDataFilm(billets[i].getDateSeance());
            texte.setDataHoraire(billets[i].getHeureSeance());
            texte.setDataSalle(billets[i].getSalleBillet());
            texte.setDataSiege(billets[i].getSiegeBillet());
            texte.setNbreBilletAcheter(billets[i].getNombreBilletAdulte() + billets[i].getNombreBilletEnfant() + billets[i].getNombreBilletSenior()); // Total des billets
            texte.setNbreBilletAdulte(billets[i].getNombreBilletAdulte());
            texte.setNbreBilletEnfant(billets[i].getNombreBilletEnfant());
            texte.setNbreBilletSenior(billets[i].getNombreBilletSenior());
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.weightx = 0.9; // Texte occupe 80% de la largeur disponible
            billetPanel.add(texte, gbc); // Ajout de Texte à droite

            add(billetPanel); // Ajouter le panneau de billet à la grille
        }

        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * nombre_de_panel_billet));
    }
}
