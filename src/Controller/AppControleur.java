package Controller;

import Controller.Evenements.*;
import Controller.Evenements.Affichage.AffConnexionEvenement;
import Controller.Evenements.Affichage.AffInscriptionEvenement;
import Controller.Evenements.Affichage.AffLesFilms;
import Model.Film;
import Model.Utilisateur;
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
        } else if (objet instanceof AffConnexionEvenement) {
            master_vue.afficherConnexion();
        } else if (objet instanceof AffInscriptionEvenement) {
            master_vue.afficherInscription();
        } else if (objet instanceof ConnexionEvenement) {
            if (connexion() == 0) {
                master_vue.afficherPrincipaleVue();
            }
        } else if (objet instanceof InscriptionEvenement) {
            if (inscription() == 0) {
                master_vue.afficherPrincipaleVue();
            }
        } else if (objet instanceof RetourCIEvenement) {
            master_vue.afficherVueLancement();
        } else if (objet instanceof AffLesFilms) {
            master_vue.afficherPVLesFilms();
        }
    }


    public static void main(String[] args) {
        new AppControleur();
    }


    public int inscription() {
        String[] inscriptionData = getInscriptionData();
        if (inscriptionData != null) {
            int response = utilisateur_dao.ajouter(inscriptionData);
            if (response == 0) {
                System.out.println("Inscription réussie.");
                return 0;
            } else {
                System.out.println("Erreur lors de l'inscription.");
                return 1;
            }
        }
        return 2;
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