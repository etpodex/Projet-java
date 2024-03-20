package Controller;

import View.*;
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
        int modifScreenWidth = screenSize.width *2/ 3;
        int modifScreenHeight = screenSize.height *2/ 3;

        // Création de la JFrame en utilisant la moitié de la taille de l'écran
        frame = new JFrame();
        frame.setTitle("Cinamax");
        frame.setSize(modifScreenWidth, modifScreenHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran

        //appel des pannels
        LancementVue.remplirFrame(frame, modifScreenWidth, modifScreenHeight);

        frame.setVisible(true);
    }

    // Méthode pour récupérer la largeur de la JFrame
    public int getFrameWidth() {
        return frame.getWidth();
    }

    // Méthode pour récupérer la hauteur de la JFrame
    public int getFrameHeight() {
        return frame.getHeight();
    }
}