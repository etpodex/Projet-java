package Controller;

/**BIBLIOTHEQUE**/
import View.*;
import javax.swing.*;
import java.awt.*;

public class VueControleur {

    /**ATTRIBUTS**/
    //attribut frame principale
    private JFrame frame;

    /**CONSTRUCTEUR**/
    public VueControleur() {
        initialiserFrame();
    }

    /**METHODE**/
    private void initialiserFrame() {
        // Obtention de la taille de l'écran
        Dimension screen_size = Toolkit.getDefaultToolkit().getScreenSize();

        // Calcul de la largeur et de la hauteur de l'écran
        int modif_screen_width = screen_size.width *2/3;
        int modif_screen_height = screen_size.height *2/3;

        // Création de la JFrame
        frame = new JFrame();
        frame.setTitle("Cinamax");
        frame.setSize(modif_screen_width, modif_screen_height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran

        //appel des pannels
        LancementVue.remplirFrame(frame, modif_screen_width, modif_screen_height);

        //rendre visible la frame
        frame.setVisible(true);
    }

}