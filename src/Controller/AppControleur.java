package Controller;

import database.BilletDAO;
import database.UtilisateurDAO;
import Model.Film;
import java.util.List;

import Model.Utilisateur;
import java.util.Scanner;

public class AppControleur {
    private VueControleur vue_controleur;
    private UtilisateurDAO utilisateur_dao;

    //private final List<BilletInfo> billets;

    public AppControleur() {
        //vue_controleur = new VueControleur(this);
        utilisateur_dao = new UtilisateurDAO();
        Film[] films = new Film[]{
                new Film("idfilm1", "titre1", "synopsis1", 9.0f, "image1.jpg", 10,"acteur 1"),
                new Film("idfilm2", "titre2", "synopsis2", 8.5f, "image2.jpg", 15,"acteur 2"),
                // ... d'autres instances de Film
        };
        Scanner scanner = new Scanner(System.in);
        BilletDAO Billet = new BilletDAO();
        //GestionFilm Film = new GestionFilm();


        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Rechercher Billet");
            System.out.println("2. Ajouter billet");
            System.out.println("3. Quitter");
            System.out.println("4. rechercher un films");
            System.out.println("3. ajouter un film");
            System.out.println("3. modifier un film");
            System.out.print("Entrez votre choix: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne de fin après le nombre

            switch (choice) {
                case 1:
                    Model.Billet[] billets = Billet.rechercher("34ff0fef-8cd4-4b92-b9e7-c322f9f4e472");
                    break;
                case 2:
                    System.out.print("Billet ajouté: ");
                    Billet.ajouter("34ff0fef-8cd4-4b92-b9e7-c322f9f4e472","1","[value-6]",String.valueOf(2),String.valueOf(1),String.valueOf(1),String.valueOf(1),"A2");
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    System.out.print("Entrez votre email: ");
                    String maildelete = scanner.nextLine();
                    break;
                case 5:
                    System.out.print("Entrez votre email: ");
                    String mail = scanner.nextLine();

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
            choice = 0;
        }
        scanner.close();
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