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
    //recevoir les datas d'inscriptions
    public String[] getMasterVueData() {
        return master_vue.getInscriptionData();
    }

    //print pour vérif les data
    public void printMasterVueInscriptionData() {
        String[] inscriptionData = master_vue.getInscriptionData();
        if (inscriptionData != null) {
            System.out.println("Données d'inscription de MasterVue : ");
            for (String data : inscriptionData) {
                System.out.println(data);
            }
        } else {
            System.out.println("MasterVue n'est pas initialisé ou les données d'inscription sont vides.");
        }
    }

}