package Controller;

import database.BilletDAO;

import Controller.Evenements.*;
import Controller.Evenements.AffichageOnglet.*;
import Model.Film;
import View.MasterVue;
import database.UtilisateurDAO;
import java.util.List;

import Model.Utilisateur;
import java.util.Scanner;

public class AppControleur {
    private MasterVue master_vue;
    private UtilisateurDAO utilisateur_dao;

    public AppControleur() {
        this.master_vue = new MasterVue();
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
        }

        else if (objet instanceof AffPVEvenement) {
            master_vue.afficherOnglet(objet);
        }
    }


    public static void main(String[] args) {
        new AppControleur();
    }


    public int inscription() {
        String[] inscriptionData = master_vue.getInscriptionData();
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
        String[] connexionData = master_vue.getConnexionData();
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
    
}