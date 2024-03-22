package View.CIComposant;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel{
    public Header(int frame_width, int frame_height){
        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        JLabel label = new JLabel("CINAMAX");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement dans le JLabel
        label.setVerticalAlignment(SwingConstants.CENTER); // Centrer le texte verticalement dans le JLabel

        int panel_height = (int) (frame_height); // Ajustement pour que le panel de Logo prenne 10% de l'écran
        label.setPreferredSize(new Dimension(frame_width,panel_height));
        add(label);
    }
}

