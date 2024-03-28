package Controller;

/**BIBLIOTHEQUE**/
import View.*;

public class VueControleur {

    /**ATTRIBUTS**/

    private AppControleur app_controleur;
    private MasterVue master_vue;


    /**CONSTRUCTEUR**/
    public VueControleur(AppControleur app_controleur) {
        this.master_vue = new MasterVue(this);
        this.master_vue.afficherVueLancement();
        this.app_controleur = app_controleur;
    }



    /**METHODE**/
    //recevoir les datas d'inscriptions
    public void inscription() {
        app_controleur.inscription();
    }

    public int connexion() {
        return app_controleur.connexion();
    }

    public String[] getInscriptionData() {
        return master_vue.getInscriptionData();
    }

    public String[] getConnexionData() {
        return master_vue.getConnexionData();
    }
}