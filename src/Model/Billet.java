package Model;

/**
 * Cette classe représente un billet pour une séance de cinéma.
 */
public class Billet {

    // Attributs

    /**
     * Titre du film pour lequel le billet est réservé.
     */
    private String titreFilm;

    /**
     * Date de la séance du film.
     */
    private String dateSeance;

    /**
     * Heure de la séance du film.
     */
    private String heureSeance;

    /**
     * Salle où se déroule la séance.
     */
    private String salleBillet;

    /**
     * Siège réservé pour cette séance.
     */
    private String siegeBillet;

    /**
     * Nombre de billets adultes réservés.
     */
    private int nombreBilletAdulte;

    /**
     * Nombre de billets enfants réservés.
     */
    private int nombreBilletEnfant;

    /**
     * Nombre de billets seniors réservés.
     */
    private int nombreBilletSenior;

    /**
     * Adresse e-mail du client ayant réservé le billet.
     */
    private String mailClient;

    /**
     * URL de l'image associée au film.
     */
    private String urlImageFilm;

    /**
     * Identifiant unique de la séance.
     */
    private String idSeance;

    // Constructeurs

    /**
     * Constructeur par défaut.
     */
    public Billet() {
    }

    /**
     * Constructeur avec tous les paramètres.
     * @param titreFilm Titre du film.
     * @param dateSeance Date de la séance.
     * @param heureSeance Heure de la séance.
     * @param salleBillet Salle de la séance.
     * @param siegeBillet Siège réservé.
     * @param nombreBilletAdulte Nombre de billets adultes.
     * @param nombreBilletEnfant Nombre de billets enfants.
     * @param nombreBilletSenior Nombre de billets seniors.
     * @param mailClient Adresse e-mail du client.
     * @param urlImageFilm URL de l'image associée au film.
     * @param idSeance Identifiant unique de la séance.
     */
    public Billet(String titreFilm, String dateSeance, String heureSeance, String salleBillet, String siegeBillet,
                  int nombreBilletAdulte, int nombreBilletEnfant, int nombreBilletSenior,
                  String mailClient, String urlImageFilm, String idSeance) {
        this.titreFilm = titreFilm;
        this.dateSeance = dateSeance;
        this.heureSeance = heureSeance;
        this.salleBillet = salleBillet;
        this.siegeBillet = siegeBillet;
        this.nombreBilletAdulte = nombreBilletAdulte;
        this.nombreBilletEnfant = nombreBilletEnfant;
        this.nombreBilletSenior = nombreBilletSenior;
        this.mailClient = mailClient;
        this.urlImageFilm = urlImageFilm;
        this.idSeance = idSeance;
    }

    // Getters

    /**
     * Obtenir le titre du film.
     * @return Le titre du film.
     */
    public String getTitreFilm() {
        return titreFilm;
    }

    /**
     * Obtenir la date de la séance.
     * @return La date de la séance.
     */
    public String getDateSeance() {
        return dateSeance;
    }

    /**
     * Obtenir l'heure de la séance.
     * @return L'heure de la séance.
     */
    public String getHeureSeance() {
        return heureSeance;
    }

    /**
     * Obtenir la salle de la séance.
     * @return La salle de la séance.
     */
    public String getSalleBillet() {
        return salleBillet;
    }

    /**
     * Obtenir le siège réservé.
     * @return Le siège réservé.
     */
    public String getSiegeBillet() {
        return siegeBillet;
    }

    /**
     * Obtenir le nombre de billets adultes.
     * @return Le nombre de billets adultes.
     */
    public int getNombreBilletAdulte() {
        return nombreBilletAdulte;
    }

    /**
     * Obtenir le nombre de billets enfants.
     * @return Le nombre de billets enfants.
     */
    public int getNombreBilletEnfant() {
        return nombreBilletEnfant;
    }

    /**
     * Obtenir le nombre de billets seniors.
     * @return Le nombre de billets seniors.
     */
    public int getNombreBilletSenior() {
        return nombreBilletSenior;
    }

    /**
     * Obtenir l'adresse e-mail du client.
     * @return L'adresse e-mail du client.
     */
    public String getMailClient() {
        return mailClient;
    }

    /**
     * Obtenir l'URL de l'image associée au film.
     * @return L'URL de l'image associée au film.
     */
    public String getUrlImageFilm() {
        return urlImageFilm;
    }

    /**
     * Obtenir l'identifiant unique de la séance.
     * @return L'identifiant unique de la séance.
     */
    public String getIdSeance() {
        return idSeance;
    }

    // Setters

    /**
     * Définir le titre du film.
     * @param titreFilm Le titre du film.
     */
    public void setTitreFilm(String titreFilm) {
        this.titreFilm = titreFilm;
    }

    /**
     * Définir la date de la séance.
     * @param dateSeance La date de la séance.
     */
    public void setDateSeance(String dateSeance) {
        this.dateSeance = dateSeance;
    }

    /**
     * Définir l'heure de la séance.
     * @param heureSeance L'heure de la séance.
     */
    public void setHeureSeance(String heureSeance) {
        this.heureSeance = heureSeance;
    }

    /**
     * Définir la salle de la séance.
     * @param salleBillet La salle de la séance.
     */
    public void setSalleBillet(String salleBillet) {
        this.salleBillet = salleBillet;
    }

    /**
     * Définir le nombre de billets adultes.
     * @param nombreBilletAdulte Le nombre de billets adultes.
     */
    public void setNombreBilletAdulte(int nombreBilletAdulte) {
        this.nombreBilletAdulte = nombreBilletAdulte;
    }

    /**
     * Définir le nombre de billets enfants.
     * @param nombreBilletEnfant Le nombre de billets enfants.
     */
    public void setNombreBilletEnfant(int nombreBilletEnfant) {
        this.nombreBilletEnfant = nombreBilletEnfant;
    }

    /**
     * Définir le nombre de billets seniors.
     * @param nombreBilletSenior Le nombre de billets seniors.
     */
    public void setNombreBilletSenior(int nombreBilletSenior) {
        this.nombreBilletSenior = nombreBilletSenior;
    }

    /**
     * Définir l'adresse e-mail du client.
     * @param mailClient L'adresse e-mail du client.
     */
    public void setMailClient(String mailClient) {
        this.mailClient = mailClient;
    }

    /**
     * Définir le siège réservé.
     * @param siegeBillet Le siège réservé.
     */
    public void setSiegeBillet(String siegeBillet) {
        this.siegeBillet = siegeBillet;
    }

    /**
     * Définir l'URL de l'image associée au film.
     * @param urlImageFilm L'URL de l'image associée au film.
     */
    public void setUrlImageFilm(String urlImageFilm) {
        this.urlImageFilm = urlImageFilm;
    }

    /**
     * Définir l'identifiant unique de la séance.
     * @param idSeance L'identifiant unique de la séance.
     */
    public void setIdSeance(String idSeance) {
        this.idSeance = idSeance;
    }

    // Méthode toString

    /**
     * Représentation textuelle du billet.
     * @return Une chaîne de caractères représentant le billet.
     */
    @Override
    public String toString() {
        return "Billet{" +
                "titreFilm='" + titreFilm + '\'' +
                ", dateSeance=" + dateSeance +
                ", heureSeance='" + heureSeance + '\'' +
                ", salleBillet='" + salleBillet + '\'' +
                ", siegeBillet='" + siegeBillet + '\'' +
                ", nombreBilletAdulte=" + nombreBilletAdulte +
                ", nombreBilletEnfant=" + nombreBilletEnfant +
                ", nombreBilletSenior=" + nombreBilletSenior +
                ", mailClient='" + mailClient + '\'' +
                ", urlImageFilm='" + urlImageFilm + '\'' +
                '}';
    }
}
