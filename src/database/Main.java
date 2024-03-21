package database;

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
        GestionClient client = new GestionClient();

        // Pour récupérer les infos d'un client
        //4dbHelper.getClientInfo(1); // Remplacez 1 par l'ID du client souhaité

        // Pour ajouter un nouveau client
        //dbHelper.addClient(1, "coco@example.com", "motdepasse", 20, 0, "Doee", "eJohn");
        //dbHelper.deleteClient(1);
        //GestionnairedeCompte manager = new GestionnairedeCompte();

        // Essayez de vous connecter avec un email et mot de passe

        boolean running = true;

        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Se connecter");
            System.out.println("2. S'inscrire");
            System.out.println("3. Quitter");
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

                    response = client.ajouter(emailRegister, passwordRegister, firstName, lastName, age, status);

                    response.forEach(System.out::println);
                    break;
                case 3:
                    running = false;
                    break;
                case 4:
                    System.out.print("Entrez votre email: ");
                    String maildelete = scanner.nextLine();
                    client.retirer(maildelete);
                default:
                    System.out.println("Choix invalide. Veuillez réessayer.");
            }
        }
        scanner.close();
    }
}
