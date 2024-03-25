package Model;

public class Utilisateur {
    private String uuid;
    private String email;
    private String nom;
    private String prenom;
    private int age;
    private int nvAvantage;
    private String password;

    public Utilisateur() {
    }

    // Constructeur //
    public Utilisateur(String uuid, String email, String nom, String prenom, int age, int nvAvantage, String password) {
        this.uuid = uuid;
        this.email = email;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.nvAvantage = nvAvantage;
        this.password = password; // Encore une fois, soyez prudent avec les mots de passe.
    }

    // Getters et Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNvAvantage() {
        return nvAvantage;
    }

    public void setNvAvantage(int nvAvantage) {
        this.nvAvantage = nvAvantage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {//affiche info utilisateur
        return "Utilisateur{" +
                "uuid='" + uuid + '\'' +
                ", email='" + email + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", nvAvantage=" + nvAvantage +
                ", password='" + password + '\'' +
                '}';
    }
}
