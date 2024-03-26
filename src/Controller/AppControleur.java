package Controller;

import Model.Film;
import View.Onglets.LesFilmsComposant.Films;
import database.UtilisateurDAO;

import java.util.List;

public class AppControleur {
    private VueControleur vue_controleur;
    private UtilisateurDAO utilisateur_dao;

    //private final List<BilletInfo> billets;

    public AppControleur() {
        vue_controleur = new VueControleur(this);
        utilisateur_dao = new UtilisateurDAO();
        Film[] films = new Film[]{
                new Film("idfilm1", "titre1", "acteur1", "synopsis1", 9.0f, "image1.jpg", 10),
                new Film("idfilm2", "titre2", "acteur2","synopsis2", 8.5f, "image2.jpg", 15),
        };

    }

    public static void main(String[] args) {
        new AppControleur();

    }

    public void inscription() {
        String[] inscriptionData = vue_controleur.getInscriptionData();
        if (inscriptionData != null) {
            int response = utilisateur_dao.ajouter(inscriptionData);
            if (response == 0) {
                System.out.println("Inscription réussie.");
            } else {
                System.out.println("Erreur lors de l'inscription.");
            }
        }
    }
}