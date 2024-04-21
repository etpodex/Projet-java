package Model;

/**
 * Cette classe représente un utilisateur du système.
 */
public class Utilisateur {
    private String uuid;        // Identifiant unique de l'utilisateur
    private String email;       // Adresse email de l'utilisateur
    private String nom;         // Nom de l'utilisateur
    private String prenom;      // Prénom de l'utilisateur
    private int age;            // Âge de l'utilisateur
    private int nvAvantage;     // Niveau d'avantage de l'utilisateur
    private String password;    // Mot de passe de l'utilisateur (attention à sécuriser cette information)

    /**
     * Constructeur par défaut.
     */
    public Utilisateur() {
    }

    /**
     * Constructeur avec tous les paramètres.
     * @param uuid Identifiant unique de l'utilisateur.
     * @param email Adresse email de l'utilisateur.
     * @param nom Nom de l'utilisateur.
     * @param prenom Prénom de l'utilisateur.
     * @param age Âge de l'utilisateur.
     * @param nvAvantage Niveau d'avantage de l'utilisateur.
     * @param password Mot de passe de l'utilisateur.
     */
    public Utilisateur(String uuid, String email, String nom, String prenom, int age, int nvAvantage, String password) {
        this.uuid = uuid;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nvAvantage = nvAvantage;
        this.password = password; // Attention à sécuriser cette information.
    }

    // Getters et Setters

    /**
     * Obtenir l'identifiant unique de l'utilisateur.
     * @return L'identifiant unique de l'utilisateur.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Définir l'identifiant unique de l'utilisateur.
     * @param uuid L'identifiant unique de l'utilisateur.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Obtenir l'adresse email de l'utilisateur.
     * @return L'adresse email de l'utilisateur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Définir l'adresse email de l'utilisateur.
     * @param email L'adresse email de l'utilisateur.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtenir le nom de l'utilisateur.
     * @return Le nom de l'utilisateur.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définir le nom de l'utilisateur.
     * @param nom Le nom de l'utilisateur.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir le prénom de l'utilisateur.
     * @return Le prénom de l'utilisateur.
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Définir le prénom de l'utilisateur.
     * @param prenom Le prénom de l'utilisateur.
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     * Obtenir l'âge de l'utilisateur.
     * @return L'âge de l'utilisateur.
     */
    public int getAge() {
        return age;
    }

    /**
     * Définir l'âge de l'utilisateur.
     * @param age L'âge de l'utilisateur.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Obtenir le niveau d'avantage de l'utilisateur.
     * @return Le niveau d'avantage de l'utilisateur.
     */
    public int getNvAvantage() {
        return nvAvantage;
    }

    /**
     * Définir le niveau d'avantage de l'utilisateur.
     * @param nvAvantage Le niveau d'avantage de l'utilisateur.
     */
    public void setNvAvantage(int nvAvantage) {
        this.nvAvantage = nvAvantage;
    }

    /**
     * Obtenir le mot de passe de l'utilisateur.
     * @return Le mot de passe de l'utilisateur.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Définir le mot de passe de l'utilisateur.
     * @param password Le mot de passe de l'utilisateur.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Retourne une représentation textuelle des informations de l'utilisateur.
     * @return Une chaîne de caractères représentant l'utilisateur.
     */
    @Override
    public String toString() {
        return "UUID: " + uuid + "\nEmail: " + email + "\nNom: " + nom + "\nPrenom: " + prenom + "\nAge: " + age + "\nNiveau d'avantage: " + nvAvantage;
    }
}
