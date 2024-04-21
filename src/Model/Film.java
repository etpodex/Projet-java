package Model;

/**
 * Cette classe représente un film.
 */
public class Film {
    private String uuid;        // Identifiant unique du film
    private String nom;         // Nom du film
    private String acteur;      // Acteur principal du film
    private String synopsis;    // Synopsis du film
    private String temps;       // Durée du film
    private float note;         // Note attribuée au film
    private String urlImage;    // URL de l'image associée au film
    private int prixFilm;       // Prix du film

    // Constructeurs

    /**
     * Constructeur par défaut.
     */
    public Film() {
    }

    /**
     * Constructeur avec tous les paramètres.
     * @param uuid Identifiant unique du film.
     * @param nom Nom du film.
     * @param acteur Acteur principal du film.
     * @param synopsis Synopsis du film.
     * @param temps Durée du film.
     * @param note Note attribuée au film.
     * @param urlImage URL de l'image associée au film.
     * @param prixFilm Prix du film.
     */
    public Film(String uuid, String nom, String acteur, String synopsis, String temps, float note, String urlImage, int prixFilm) {
        this.uuid = uuid;
        this.nom = nom;
        this.acteur = acteur;
        this.synopsis = synopsis;
        this.temps = temps;
        this.note = note;
        this.urlImage = urlImage;
        this.prixFilm = prixFilm;
    }

    // Getters et Setters

    /**
     * Obtenir l'identifiant unique du film.
     * @return L'identifiant unique du film.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Définir l'identifiant unique du film.
     * @param uuid L'identifiant unique du film.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    /**
     * Obtenir le nom du film.
     * @return Le nom du film.
     */
    public String getNom() {
        return nom;
    }

    /**
     * Définir le nom du film.
     * @param nom Le nom du film.
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtenir l'acteur principal du film.
     * @return L'acteur principal du film.
     */
    public String getActeur() {
        return acteur;
    }

    /**
     * Définir l'acteur principal du film.
     * @param acteur L'acteur principal du film.
     */
    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    /**
     * Obtenir le synopsis du film.
     * @return Le synopsis du film.
     */
    public String getSynopsis() {
        return synopsis;
    }

    /**
     * Définir le synopsis du film.
     * @param synopsis Le synopsis du film.
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Obtenir la durée du film.
     * @return La durée du film.
     */
    public String getTemps() {
        return temps;
    }

    /**
     * Définir la durée du film.
     * @param temps La durée du film.
     */
    public void setTemps(String temps) {
        this.temps = temps;
    }

    /**
     * Obtenir la note attribuée au film.
     * @return La note attribuée au film.
     */
    public float getNote() {
        return note;
    }

    /**
     * Définir la note attribuée au film.
     * @param note La note attribuée au film.
     */
    public void setNote(float note) {
        this.note = note;
    }

    /**
     * Obtenir l'URL de l'image associée au film.
     * @return L'URL de l'image associée au film.
     */
    public String getUrlImage() {
        return urlImage;
    }

    /**
     * Définir l'URL de l'image associée au film.
     * @param urlImage L'URL de l'image associée au film.
     */
    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    /**
     * Obtenir le prix du film.
     * @return Le prix du film.
     */
    public int getPrixFilm() {
        return prixFilm;
    }

    /**
     * Définir le prix du film.
     * @param prixFilm Le prix du film.
     */
    public void setPrixFilm(int prixFilm) {
        this.prixFilm = prixFilm;
    }

    /**
     * Définir l'identifiant du film.
     * @param uuidFilm L'identifiant du film.
     */
    public void setIdFilm(String uuidFilm) {
        this.uuid = uuidFilm;
    }

    // Méthode toString pour afficher les informations du film

    /**
     * Représentation textuelle du film.
     * @return Une chaîne de caractères représentant le film.
     */
    @Override
    public String toString() {
        return "Film{" +
                "uuid='" + uuid + '\'' +
                ", nom='" + nom + '\'' +
                ", acteur='" + acteur + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", temps='" + temps + '\'' +
                ", note=" + note +
                ", urlImage='" + urlImage + '\'' +
                ", prixFilm=" + prixFilm +
                '}';
    }
}
