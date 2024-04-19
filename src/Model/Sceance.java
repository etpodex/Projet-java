package Model;

import java.util.Date;

public class Sceance {
    private int idSceance;
    private int idFilm;
    private String horaire;
    private int idSalle;
    private String date;
    private int nbPlaceRestante;

    // Constructeur
    public Sceance(int idSceance, int idFilm, String horaire, int idSalle, String date, int nbPlaceRestante) {
        this.idSceance = idSceance;
        this.idFilm = idFilm;
        this.horaire = horaire;
        this.idSalle = idSalle;
        this.date = date;
        this.nbPlaceRestante = nbPlaceRestante;
    }

    // Getters et Setters
    public int getIdSceance() {
        return idSceance;
    }

    public void setIdSceance(int idSceance) {
        this.idSceance = idSceance;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getHoraire() {
        return horaire;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNbPlaceRestante() {
        return nbPlaceRestante;
    }

    public void setNbPlaceRestante(int nbPlaceRestante) {
        this.nbPlaceRestante = nbPlaceRestante;
    }
}
