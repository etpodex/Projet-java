package database;

import Model.Utilisateur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        UtilisateurDAO client = new UtilisateurDAO();
        //GestionFilm Film = new GestionFilm();


        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Se connecter");
            System.out.println("2. S'inscrire");
            System.out.println("3. Quitter");
            System.out.println("4. retirer");
            System.out.println("3. rechercher par mail");
            System.out.println("3. modifier");
            System.out.print("Entrez votre choix: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consomme la ligne de fin après le nombre

            switch (choice) {
                case 1:
                    System.out.print("Entrez votre email: ");
                    String emailLogin = scanner.nextLine();
                    System.out.print("Entrez votre mot de passe: ");
                    String passwordLogin = scanner.nextLine();
                    List<String> userInfo = client.connecter(emailLogin, passwordLogin);
                    List<String> response;

                    if (userInfo != null) {
                        System.out.println("Utilisateur connecté avec succès :");
                        //userInfo.forEach(System.out::println);
                        String ageInfo = userInfo.get(4); // Obtenez l'information d'âge
                        System.out.println(ageInfo); // Imprimez uniquement les chiffres

                        System.out.println("L'âge de l'utilisateur est : " + ageInfo.replaceAll("[^0-9]", "")); // Imprimez uniquement les chiffres

                    } else {
                        System.out.println("Email ou mot de passe incorrect.");
                    }
                    break;
                case 2:
                    System.out.print("Entrez votre email: ");
                    String emailRegister = scanner.nextLine();
                    System.out.print("Entrez votre mot de passe: ");
                    String passwordRegister = scanner.nextLine();
                    System.out.print("Entrez votre prénom: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Entrez votre nom de famille: ");
                    String lastName = scanner.nextLine();
                    System.out.print("Entrez votre âge: ");
                    int age = scanner.nextInt();
                    System.out.print("Entrez votre statut (0 ou 1): ");
                    int status = scanner.nextInt();
                    scanner.nextLine(); // Consomme la ligne de fin après le nombre

                    response = client.ajouter(emailRegister, passwordRegister, firstName, lastName, String.valueOf(age), String.valueOf(status));

                    response.forEach(System.out::println);
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    System.out.print("Entrez votre email: ");
                    String maildelete = scanner.nextLine();
                    client.retirer(maildelete);
                    break;
                case 5:
                    System.out.print("Entrez votre email: ");
                    String mail = scanner.nextLine();
                    List<Utilisateur> resultats = client.rechercher(mail, String.valueOf(1));
                    if (resultats.isEmpty()) {
                        System.out.println("Aucun utilisateur trouvé.");
                    } else {
                        for (Utilisateur utilisateur : resultats) {
                            System.out.println(utilisateur.getEmail() + ", " + utilisateur.getNom() + " " + utilisateur.getPrenom());
                            // Afficher les autres détails selon les besoins
                        }
                    }
                    break;
                case 6:
                    //System.out.print("Entrez votre email: ");
                    //String email = scanner.nextLine();
                    //response = client.modifier(email,String.valueOf(1));
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
            choice = 0;
        }
        scanner.close();
    }
}
