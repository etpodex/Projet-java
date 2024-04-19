package View.Onglets.MesBilletsComposant.BilletComposant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QRCode extends JPanel {

    // Attributs
    private JLabel qrcode_billet;

    public QRCode(){
        setBackground(new Color(150,100,100)); // Définition de la couleur de fond du panneau
        setBorder(new EmptyBorder(5, 35, 5, 5)); // Définition des marges autour du panneau
        setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout avec une seule colonne et un nombre de lignes dynamique

        // Initialisation du label pour afficher le QRCode
        qrcode_billet = new JLabel();

        add(qrcode_billet); // Ajout du label au panneau
    }

    // Méthode publique pour définir le QRCode à afficher
    public void setQRCode(String qrCodePath) {
        qrcode_billet.setIcon(new ImageIcon(qrCodePath)); // Définit l'icône du JLabel avec l'image QRCode
    }
}
