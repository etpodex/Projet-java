package Controller;

import Model.Offre;
import database.*;

import Controller.Evenements.*;
import Controller.Evenements.AffichageOnglet.*;
import Model.Film;
import View.MasterVue;

import java.util.List;

import Model.Utilisateur;
import Model.Sceance;
import jdk.jshell.execution.Util;

import java.util.Scanner;

public class AppControleur {
    private MasterVue master_vue;

    private UtilisateurDAO utilisateur_dao;
    private FilmDAO film_dao;
    private BilletDAO billet_dao;
    private SceanceDAO seance_dao;

    private OffreDAO offre_dao; // estelle

    private Utilisateur utilisateur_connecte = null;

    private ChartController chartController; // estelle pour point bonus projet

    public AppControleur() {
        this.master_vue = new MasterVue();

        utilisateur_dao = new UtilisateurDAO();
        film_dao = new FilmDAO();
        billet_dao = new BilletDAO();
        seance_dao = new SceanceDAO();
        offre_dao = new OffreDAO(); // estelle

        chartController = new ChartController(); // estelle pour point bonus projet

        FileEvenements.getInstance().abonner(this::evenementControleur);
        this.master_vue.afficherVueLancement();
    }

    private void evenementControleur(Object objet) {
        System.out.println(objet.getClass());
        if (objet instanceof SkipEvenement) {
            master_vue.afficherPrincipaleVue();
        } else if (objet instanceof AffConnexionEvenement) {
            master_vue.afficherConnexion();
        } else if (objet instanceof AffInscriptionEvenement) {
            master_vue.afficherInscription();
        } else if (objet instanceof ConnexionEvenement) {
            if (connexion(((ConnexionEvenement) objet).getEmail(), ((ConnexionEvenement) objet).getMotDePasse()) == 0) {
                master_vue.afficherPrincipaleVue();
                master_vue.modif_statut_utilisateur(utilisateur_connecte.getNvAvantage());
            }
        } else if (objet instanceof InscriptionEvenement) {
            if (inscription(((InscriptionEvenement) objet).getUtilisateur()) == 0) {
                if (connexion(((InscriptionEvenement) objet).getUtilisateur().getEmail(), ((InscriptionEvenement) objet).getUtilisateur().getPassword()) == 0) {
                    master_vue.afficherPrincipaleVue();
                    master_vue.modif_statut_utilisateur(utilisateur_connecte.getNvAvantage());
                }
            }

        } else if (objet instanceof DeconnexionEvenement) {
            master_vue.afficherConnexion();
            master_vue.modif_statut_utilisateur(0);
        } else if (objet instanceof RetourCIEvenement) {
            master_vue.afficherVueLancement();
        } /**else if (objet instanceof AffLesFilms) {
            master_vue.afficherPVLesFilms();
        }**/ else if (objet instanceof EffacerFilmEvenement){
            System.out.println("bouton sup cliqué");
        }

        // Implemented AffPVEvenement events
        else if (objet instanceof AffLesFilmsEvenement) {
            ((AffLesFilmsEvenement) objet).setFilms(film_dao.rechercher("nom", ""));
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffMonCompteEvenement) {
            ((AffMonCompteEvenement) objet).setUtilisateur(utilisateur_connecte);
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffMesBilletsEvenement) {
            ((AffMesBilletsEvenement) objet).setBillets(billet_dao.rechercher(utilisateur_connecte.getUuid()));
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffReservationEvenement){
            Film film = ((AffReservationEvenement)objet).getFilm();
            ((AffReservationEvenement)objet).setReservation(seance_dao.rechercher(film.getUuid()));
            //System.out.println(offre_dao.rechercher("")[0].toString());
            ((AffReservationEvenement)objet).setOffre(offre_dao.rechercher("AZERTY"));
            //System.out.println( "quelque chose : " + ((AffReservationEvenement)objet).getOffres()[0].toString());
            master_vue.afficherOnglet(objet);
        }

        // The rest of the events (just to be displayed for now)
        else if (objet instanceof AffPVEvenement) {
            master_vue.afficherOnglet(objet);
        }
    }


    public static void main(String[] args) {
        new AppControleur();
    }

    public int inscription(Utilisateur nouv_utilisateur) {

        if (nouv_utilisateur != null) {

            // Définition du niveau d'avantage basé sur l'âge
            int age = nouv_utilisateur.getAge();
            if (age <= 18) {
                nouv_utilisateur.setNvAvantage(1);
            } else if (age <= 70 && age > 18) {
                nouv_utilisateur.setNvAvantage(3);
            } else {
                nouv_utilisateur.setNvAvantage(4);
            }

            int response = utilisateur_dao.ajouter(nouv_utilisateur);
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

    public int connexion(String email, String mot_de_passe) {
        if (email != null && mot_de_passe != null) {
            this.utilisateur_connecte = utilisateur_dao.connecter(email, mot_de_passe);

            if (this.utilisateur_connecte != null) {
                System.out.println("Connexion réussie:");
                System.out.println(this.utilisateur_connecte.toString());
                return 0;
            } else {
                System.out.println("Erreur lors de la connexion.");
                return 1;
            }
        }
        return 2;
    }
    
}