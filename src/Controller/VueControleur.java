package Controller;

/**BIBLIOTHEQUE**/
import View.*;
import View.LancementComposant.Skip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueControleur {

    /**ATTRIBUTS**/
    //attribut frame principale
    private JFrame frame;
    private LancementVue vue_Lancement;
    private Skip skip_composant;


    /**CONSTRUCTEUR**/
    public VueControleur() {
        initialiserFrame();
        afficherVueLancement();
        this.skip_composant = LancementVue.getSkipComponent(); // Obtenez le composant Skip ici
        skipConfigurerActions();
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
    }

    private void afficherVueLancement(){
        LancementVue.remplirPanel(frame, frame.getWidth(), frame.getHeight());
        // Autres configurations de la JFrame
        frame.setVisible(true);
    }

    private void skipConfigurerActions() {
        // Ajouter un ActionListener pour le bouton "Skip" dans la classe Skip
        skip_composant.getSkipBouton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Code à exécuter lors du clic sur le bouton "Skip"
                System.out.println("Le bouton \"Skip\" a été cliqué!");
                // Ajoutez ici le code pour effectuer l'action souhaitée
            }
        });
    }

}