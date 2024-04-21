package View.Onglets.MesBilletsComposant.BilletComposant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Panneau pour afficher un QRCode.
 */
public class QRCode extends JPanel {

    // Attribut
    private JLabel qrcode_billet;

    /**
     * Constructeur de la classe QRCode.
     */
    public QRCode() {
        setBackground(new Color(255, 200, 0)); // Définition de la couleur de fond du panneau
        setBorder(new EmptyBorder(5, 35, 5, 5)); // Définition des marges autour du panneau
        setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout avec une seule colonne et un nombre de lignes dynamique

        // Initialisation du label pour afficher le QRCode
        qrcode_billet = new JLabel();

        add(qrcode_billet); // Ajout du label au panneau
    }

    /**
     * Méthode publique pour définir le QRCode à afficher.
     *
     * @param qrCodePath le chemin vers l'image du QRCode
     */
    public void setQRCode(String qrCodePath) {
        qrcode_billet.setIcon(new ImageIcon(qrCodePath)); // Définit l'icône du JLabel avec l'image QRCode
    }
}
