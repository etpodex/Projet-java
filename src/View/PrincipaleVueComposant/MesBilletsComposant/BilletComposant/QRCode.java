package View.PrincipaleVueComposant.MesBilletsComposant.BilletComposant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class QRCode extends JPanel {

    //Attributs
    private JLabel qrcode_billet;

    public QRCode(int barre_navigation_panel_width, int hauteur){
        setBackground(new Color(150,100,100));
        int longueur_qrcode = barre_navigation_panel_width*3/6;
        setPreferredSize(new Dimension(longueur_qrcode, hauteur));

        setBorder(new EmptyBorder(5, 5, 5, 5));

        setLayout(new GridLayout(0, 1));

        qrcode_billet = new JLabel();

        add(qrcode_billet);
    }

    public void setQRCode(String qrCodePath) {
        qrcode_billet.setIcon(new ImageIcon(qrCodePath)); // Définit l'icône du JLabel avec l'image QRCode
    }

}
