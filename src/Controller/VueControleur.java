package Controller;

/**BIBLIOTHEQUE**/
import View.*;
import View.LancementComposant.ConnexionInscription;
import View.LancementComposant.Skip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VueControleur {

    /**ATTRIBUTS**/

    private MasterVue master_vue;


    /**CONSTRUCTEUR**/
    public VueControleur() {
        master_vue = new MasterVue();
        master_vue.afficherVueLancement();

    }

    /**METHODE**/

}