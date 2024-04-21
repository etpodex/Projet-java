package Controller;

import Model.*;
import database.*;

import Controller.Evenements.*;
import Controller.Evenements.AffichageOnglet.*;
import View.MasterVue;

import java.util.List;

import jdk.jshell.execution.Util;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.util.Scanner;



/**
 * Le contrôleur principal de l'application qui gère les événements et les interactions entre les vues et les modèles.
 */
public class AppControleur {
    private MasterVue master_vue;

    private UtilisateurDAO utilisateur_dao;
    private FilmDAO film_dao;
    private BilletDAO billet_dao;
    private SceanceDAO seance_dao;

    private OffreDAO offre_dao; // estelle

    private Utilisateur utilisateur_connecte = null;

    private ChartController chartController; // estelle pour point bonus projet


    /**
     * Constructeur par défaut de l'AppControleur.
     * Initialise les vues et les DAO nécessaires, puis affiche la vue de lancement.
     */
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

    /**
     * Méthode de gestion des événements de l'application.
     *
     * @param objet L'objet représentant l'événement à traiter.
     */
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
        } else if (objet instanceof ModifierUtilisateurEvenement) {
            utilisateur_dao.modifier(((ModifierUtilisateurEvenement) objet).getUtilisateur());
        } else if (objet instanceof DeconnexionEvenement) {
            master_vue.afficherConnexion();
            master_vue.modif_statut_utilisateur(0);
        } else if (objet instanceof RetourCIEvenement) {
            master_vue.afficherVueLancement();
        } else if (objet instanceof EffacerFilmEvenement){
            film_dao.retirer(((EffacerFilmEvenement) objet).getIdFilm());
        } else if (objet instanceof AjoutFilmBDDEvenement) {
            film_dao.ajouter(((AjoutFilmBDDEvenement) objet).getFilm());
        } else if (objet instanceof AjoutSeanceBDDEvenement) {
            seance_dao.ajouter(((AjoutSeanceBDDEvenement) objet).getSeance());
        } else if (objet instanceof SuppressionSeanceBDDEvenement) {
            seance_dao.supprimer(((SuppressionSeanceBDDEvenement) objet).getUuid());
        } else if (objet instanceof SupprimerOffreEvenement) {
            offre_dao.retirer(((SupprimerOffreEvenement) objet).getCode());
        } else if (objet instanceof AjouterOffreEvenement) {
            offre_dao.ajouter(((AjouterOffreEvenement) objet).getOffre());
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
        } else if (objet instanceof AffAccueilEvenement) {

            DefaultPieDataset pieDataset = new DefaultPieDataset();
            Film[] pie_data = film_dao.rechercher("note","");
            for (Film film : pie_data) {
                pieDataset.setValue(film.getNom(), film.getNote());
            }
            ((AffAccueilEvenement) objet).setPieDataset(pieDataset);

            DefaultCategoryDataset barDataset = new DefaultCategoryDataset();
            Film[] bar_data = film_dao.rechercher("note","");
            for (Film film : bar_data) {
                barDataset.addValue(film.getNote(), film.getNom(), "Column");
            }
            ((AffAccueilEvenement) objet).setBarDataset(barDataset);

            master_vue.afficherOnglet(objet);

        } else if (objet instanceof AffReservationEvenement){
            Film film = ((AffReservationEvenement)objet).getFilm();
            ((AffReservationEvenement)objet).setReservation(seance_dao.rechercher(film.getUuid()));
            //System.out.println(offre_dao.rechercher("")[0].toString());
            ((AffReservationEvenement)objet).setOffre(offre_dao.rechercher(""));
            //System.out.println( "quelque chose : " + ((AffReservationEvenement)objet).getOffres()[0].toString());
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffGererFilmEvenement) {
            ((AffGererFilmEvenement) objet).setFilms(film_dao.rechercher("nom", ""));
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffGererSeanceEvenement) {
            ((AffGererSeanceEvenement) objet).setSceances(seance_dao.rechercher(""));
            System.out.println(seance_dao.rechercher("").length);
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffGererOffreEvenement) {
            ((AffGererOffreEvenement) objet).setOffres(offre_dao.rechercher(""));
            master_vue.afficherOnglet(objet);
        } else if (objet instanceof AffPaiementEvenement) {
            Billet billet = ((AffPaiementEvenement) objet).getBillet();
            if (utilisateur_connecte != null) {
                billet.setMailClient(utilisateur_connecte.getUuid());
                billet_dao.ajouter(billet);
                ((AffPaiementEvenement) objet).setBillet(billet);
                master_vue.afficherOnglet(objet);
            }
        }

        // The rest of the events (just to be displayed for now)
        else if (objet instanceof AffPVEvenement) {
            master_vue.afficherOnglet(objet);
        }
    }

    /**
     * Point d'entrée principal de l'application.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cette application).
     */
    public static void main(String[] args) {
        new AppControleur();
    }


    /**
     * Méthode permettant d'inscrire un nouvel utilisateur dans le système.
     *
     * @param nouv_utilisateur L'utilisateur à inscrire.
     * @return 0 en cas de succès, 1 en cas d'échec, 2 si l'utilisateur est nul.
     */
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

    /**
     * Méthode permettant de connecter un utilisateur au système.
     *
     * @param email         L'adresse e-mail de l'utilisateur.
     * @param mot_de_passe  Le mot de passe de l'utilisateur.
     * @return 0 en cas de succès, 1 en cas d'échec, 2 si l'email ou le mot de passe est nul.
     */
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