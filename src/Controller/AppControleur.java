package Controller;

import database.UtilisateurDAO;

import java.util.List;

public class AppControleur {
    private VueControleur vue_controleur;
    private UtilisateurDAO utilisateur_dao;

    //private final List<BilletInfo> billets;

    public AppControleur() {
        vue_controleur = new VueControleur(this);
        utilisateur_dao = new UtilisateurDAO();
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