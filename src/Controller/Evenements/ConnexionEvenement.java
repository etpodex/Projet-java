package Controller.Evenements;

/**
 * Cette classe représente un événement de connexion d'un utilisateur.
 */
public class ConnexionEvenement {

    private String email;
    private String motDePasse;

    /**
     * Constructeur de la classe ConnexionEvenement.
     * @param email L'adresse email de l'utilisateur pour la connexion.
     * @param motDePasse Le mot de passe de l'utilisateur pour la connexion.
     */
    public ConnexionEvenement(String email, String motDePasse) {
        this.email = email;
        this.motDePasse = motDePasse;
    }

    /**
     * Méthode permettant d'obtenir l'adresse email associée à l'événement de connexion.
     * @return L'adresse email de l'utilisateur.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Méthode permettant d'obtenir le mot de passe associé à l'événement de connexion.
     * @return Le mot de passe de l'utilisateur.
     */
    public String getMotDePasse() {
        return motDePasse;
    }
}
