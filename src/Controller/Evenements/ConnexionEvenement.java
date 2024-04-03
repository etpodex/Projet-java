package Controller.Evenements;

public class ConnexionEvenement {

    private String email;
    private String motDePasse;

    public ConnexionEvenement(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    public String getEmail() {
        return email;
    }

    public String getMotDePasse() {
        return motDePasse;
    }
}