package Model;

public class Film {
    private String uuid;
    private String nom;
    private String acteur;
    private String synopsis;
    private String temps;
    private float note;
    private String urlImage;
    private int prixFilm;


    // Constructeur par défaut
    public Film() {
    }

    // Constructeur avec tous les paramètres
    public Film(String uuid, String nom, String acteur, String synopsis, String temps, float note, String urlImage, int prixFilm) {
        this.uuid = uuid;
        this.nom = nom;
        this.acteur = acteur;
        this.synopsis = synopsis;
        this.note = note;
        this.temps = temps;
        this.urlImage = urlImage;
        this.prixFilm = prixFilm;

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

    public String getActeur() {
        return acteur;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setActeur(String acteur) {
        this.acteur = acteur;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public String getTemps(){
        return temps;
    }

    public void setTemps(String temps){
        this.temps = temps;
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

    // Méthode toString pour afficher les informations du film
    @Override
    public String toString() {
        return "Film{" +
                "uuid='" + uuid + '\'' +
                ", nom='" + nom + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", temps='" + temps + '\'' +
                ", note=" + note +
                ", urlImage='" + urlImage + '\'' +
                ", prixFilm=" + prixFilm +
                '}';
    }
}