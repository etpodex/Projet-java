package Model;

/**
 * Cette classe représente une séance de cinéma.
 */
public class Sceance {
    private String idSceance;        // Identifiant de la séance
    private String idFilm;           // Identifiant du film projeté lors de la séance
    private String horaire;          // Horaire de la séance
    private int idSalle;             // Identifiant de la salle où se déroule la séance
    private String date;             // Date de la séance
    private int nbPlaceRestante;     // Nombre de places restantes pour la séance

    /**
     * Constructeur de la classe Sceance.
     * @param idSceance Identifiant de la séance.
     * @param idFilm Identifiant du film projeté lors de la séance.
     * @param horaire Horaire de la séance.
     * @param idSalle Identifiant de la salle où se déroule la séance.
     * @param date Date de la séance.
     * @param nbPlaceRestante Nombre de places restantes pour la séance.
     */
    public Sceance(String idSceance, String idFilm, String horaire, int idSalle, String date, int nbPlaceRestante) {
        this.idSceance = idSceance;
        this.idFilm = idFilm;
        this.horaire = horaire;
        this.idSalle = idSalle;
        this.date = date;
        this.nbPlaceRestante = nbPlaceRestante;
    }

    // Getters et Setters

    /**
     * Obtenir l'identifiant de la séance.
     * @return L'identifiant de la séance.
     */
    public String getIdSceance() {
        return idSceance;
    }

    /**
     * Définir l'identifiant de la séance.
     * @param idSceance L'identifiant de la séance.
     */
    public void setIdSceance(String idSceance) {
        this.idSceance = idSceance;
    }

    /**
     * Obtenir l'identifiant du film projeté lors de la séance.
     * @return L'identifiant du film projeté lors de la séance.
     */
    public String getIdFilm() {
        return idFilm;
    }

    /**
     * Définir l'identifiant du film projeté lors de la séance.
     * @param idFilm L'identifiant du film projeté lors de la séance.
     */
    public void setIdFilm(String idFilm) {
        this.idFilm = idFilm;
    }

    /**
     * Obtenir l'horaire de la séance.
     * @return L'horaire de la séance.
     */
    public String getHoraire() {
        return horaire;
    }

    /**
     * Définir l'horaire de la séance.
     * @param horaire L'horaire de la séance.
     */
    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    /**
     * Obtenir l'identifiant de la salle où se déroule la séance.
     * @return L'identifiant de la salle où se déroule la séance.
     */
    public int getIdSalle() {
        return idSalle;
    }

    /**
     * Définir l'identifiant de la salle où se déroule la séance.
     * @param idSalle L'identifiant de la salle où se déroule la séance.
     */
    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    /**
     * Obtenir la date de la séance.
     * @return La date de la séance.
     */
    public String getDate() {
        return date;
    }

    /**
     * Définir la date de la séance.
     * @param date La date de la séance.
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * Obtenir le nombre de places restantes pour la séance.
     * @return Le nombre de places restantes pour la séance.
     */
    public int getNbPlaceRestante() {
        return nbPlaceRestante;
    }

    /**
     * Définir le nombre de places restantes pour la séance.
     * @param nbPlaceRestante Le nombre de places restantes pour la séance.
     */
    public void setNbPlaceRestante(int nbPlaceRestante) {
        this.nbPlaceRestante = nbPlaceRestante;
    }
}
