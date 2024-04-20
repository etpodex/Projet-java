package View.Onglets.MesBilletsComposant;

import Model.Billet;
import View.Onglets.MesBilletsComposant.BilletComposant.QRCode;
import View.Onglets.MesBilletsComposant.BilletComposant.Texte;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AffichageBillet extends JPanel {

    // Attributs
    private int barre_navigation_panel_width; // Largeur de la barre de navigation
    private int hauteur; // Hauteur des panneaux de billets

    public AffichageBillet(int barre_navigation_panel_width, int frame_height) {
        this.barre_navigation_panel_width = barre_navigation_panel_width;
        this.hauteur = frame_height / 3 - 30;
        setBackground(new Color(238, 238, 238));
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    // Méthode pour nettoyer les billets existants
    private void clearBillets() {
        removeAll(); // Supprimer tous les composants du panel
        revalidate();
        repaint();
    }

    // Méthode pour mettre à jour les billets
    public void updateBillets(Billet[] billets) {
        clearBillets(); // Effacer les billets précédents avant d'ajouter les nouveaux
        for (Billet billet : billets) {
            JPanel billetPanel = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.fill = GridBagConstraints.BOTH;
            gbc.weighty = 1.0;

            QRCode qrcode = new QRCode();
            qrcode.setQRCode(billet.getUrlImageFilm());
            gbc.anchor = GridBagConstraints.LINE_START;
            gbc.weightx = 0.1;
            gbc.gridheight = GridBagConstraints.REMAINDER;
            billetPanel.add(qrcode, gbc);

            Texte texte = new Texte();
            texte.setTitreFilm(billet.getTitreFilm());
            texte.setDataFilm(billet.getDateSeance());
            texte.setDataHoraire(billet.getHeureSeance());
            texte.setDataSalle(billet.getSalleBillet());
            texte.setDataSiege(billet.getSiegeBillet());
            texte.setNbreBilletAcheter(billet.getNombreBilletAdulte() + billet.getNombreBilletEnfant() + billet.getNombreBilletSenior());
            texte.setNbreBilletAdulte(billet.getNombreBilletAdulte());
            texte.setNbreBilletEnfant(billet.getNombreBilletEnfant());
            texte.setNbreBilletSenior(billet.getNombreBilletSenior());
            gbc.anchor = GridBagConstraints.LINE_END;
            gbc.weightx = 0.9;
            billetPanel.add(texte, gbc);

            add(billetPanel);
        }
        setLayout(new GridLayout(billets.length, 1, 0, 10)); // 1 colonne, espacement vertical de 10 pixels
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur * billets.length));
    }
}
