package Controller;

import javax.swing.*;
import java.awt.*;

public class VueControleur {
    private JFrame frame;

    public VueControleur() {
        initialiserFrame();
    }

    private void initialiserFrame() {
        // Obtention de la taille de l'écran
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcul de la moitié de la largeur et de la hauteur de l'écran
        int halfScreenWidth = screenSize.width *2/ 3;
        int halfScreenHeight = screenSize.height *2/ 3;

        // Création de la JFrame en utilisant la moitié de la taille de l'écran
        frame = new JFrame();
        frame.setTitle("Cinamax");
        frame.setSize(halfScreenWidth, halfScreenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        frame.setVisible(true);
    }
}