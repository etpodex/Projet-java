package Controller;

import Controller.Evenements.FileEvenements;
import Controller.Evenements.SkipEvenement;
import Model.Film;
import View.MasterVue;
import database.UtilisateurDAO;

import java.util.List;

public class AppControleur {
    private MasterVue master_vue;
    private UtilisateurDAO utilisateur_dao;

    //private final List<BilletInfo> billets;

    public AppControleur() {
        this.master_vue = new MasterVue(this);
        utilisateur_dao = new UtilisateurDAO();

        FileEvenements.getInstance().abonner(this::evenementControleur);


        Film[] films = new Film[]{
                new Film("idfilm1", "titre1", "acteur1", "synopsis1", 9.0f, "image1.jpg", 10),
                new Film("idfilm2", "titre2", "acteur2","synopsis2", 8.5f, "image2.jpg", 15),
        };

        this.master_vue.afficherVueLancement();
    }

    private void evenementControleur(Object objet) {
        if (objet instanceof SkipEvenement) {
            master_vue.afficherPrincipaleVue();
        }
    }


    public static void main(String[] args) {
        new AppControleur();
    }


    public void inscription() {
        String[] inscriptionData = getInscriptionData();
        if (inscriptionData != null) {
            int response = utilisateur_dao.ajouter(inscriptionData);
            if (response == 0) {
                System.out.println("Inscription réussie.");
            } else {
                System.out.println("Erreur lors de l'inscription.");
            }
        }
    }

    public int connexion() {
        String[] connexionData = getConnexionData();
        if (connexionData != null) {
            List<String> user = utilisateur_dao.connecter(connexionData[0], connexionData[1]);

            if (user != null) {
                System.out.println("Connexion réussie.");
                return 0;
            } else {
                System.out.println("Erreur lors de la connexion.");
                return 1;
            }
        }
        return 2;
    }


    /**METHODE**/
    //recevoir les datas d'inscriptions

    public String[] getInscriptionData() {
        return master_vue.getInscriptionData();
    }

    public String[] getConnexionData() {
        return master_vue.getConnexionData();
    }
}