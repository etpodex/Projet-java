package Controller;

import Controller.BilletInfoPourAppControleur.BilletInfo;
import View.PrincipaleVueComposant.MesBilletsComposant.AffichageBillet;

import View.MasterVue;
import database.GestionClient;
import database.GestionFilm;

import java.util.ArrayList;
import java.util.List;

public class AppControleur {
    private VueControleur vue_controleur;
    private GestionClient gestion_client;
    private GestionFilm gestion_film;

    //private final List<BilletInfo> billets;

    public AppControleur() {
        vue_controleur = new VueControleur();
        gestion_client = new GestionClient();
        gestion_film = new GestionFilm();

        gestion_client.ajouter("email_client", "mot_de_passe_client", "prenom_client", "nom_client", "21", "2");

        // billets
        /**
        billets = new ArrayList<>();
        billets.add(new BilletInfo("coucou francis", "12/03/24", "15h00", 2, "5A", 2, 1, 1, 0, "image1.jpg"));
        billets.add(new BilletInfo("l'eau mouille", "30/10/25", "17h00", 3, "7B", 3, 1, 1, 1, "image2.jpg"));**/
    }

    public static void main(String[] args) {
        new AppControleur();
        //new AppControleur().demarrer();
    }
/**
    public void demarrer() {
        AffichageBillet affichageBillet = new AffichageBillet(800, 600, this);
        // Ajoutez affichageBillet à votre interface utilisateur
    }

    // methode billet
    public List<BilletInfo> getInfosBillets() {
        return billets;
    }**/
}