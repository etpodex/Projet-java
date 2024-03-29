package Model;

public class Film {
    private String uuid;
    private String nom;
    private String synopsis;
    private float note;
    private String urlImage;
    private int prixFilm;
    private String acteur;


    // Constructeur par défaut
    public Film() {
    }

    // Constructeur avec tous les paramètres
    public Film(String uuid, String nom, String synopsis, float note, String urlImage, int prixFilm,String acteur) {
        this.uuid = uuid;
        this.nom = nom;
        this.synopsis = synopsis;
        this.note = note;
        this.urlImage = urlImage;
        this.prixFilm = prixFilm;
        this.acteur = acteur;
    }

    // Getters et Setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        this.note = note;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public int getPrixFilm() {
        return prixFilm;
    }

    public void setPrixFilm(int prixFilm) {
        this.prixFilm = prixFilm;
    }
    public String getacteur() {
        return acteur;
    }

    public void setacteur(String prixFilm) {
        this.acteur = acteur;
    }

}
