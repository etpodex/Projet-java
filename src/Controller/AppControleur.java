package Controller;

import View.MasterVue;
import database.GestionClient;
import database.GestionFilm;

import java.util.List;

public class AppControleur {
    private VueControleur vue_controleur;
    private GestionClient gestion_client;
    private GestionFilm gestion_film;

    public AppControleur() {
        vue_controleur = new VueControleur();
        gestion_client = new GestionClient();
        gestion_film = new GestionFilm();

        gestion_client.ajouter("email_client", "mot_de_passe_client", "prenom_client", "nom_client", "21", "2");
    }

    public static void main(String[] args) {
        new AppControleur();
    }
}
