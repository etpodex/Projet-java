package database;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper dbHelper = new DatabaseHelper();

        // Pour récupérer les infos d'un client
        dbHelper.getClientInfo(1); // Remplacez 1 par l'ID du client souhaité

        // Pour ajouter un nouveau client
        dbHelper.addClient(1, "coco@lklk.com", "motdepasse", 20, 0, "Doee", "eJohn");
        dbHelper.deleteClient(1);

    }
}
