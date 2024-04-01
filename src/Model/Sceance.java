package Model;

import java.util.Date;

public class Sceance {
    private int idSceance;
    private int idFilm;
    private String horaire;
    private int idSalle;
    private String date;
    private int nbPlaceRestante;

    // Getters
    public int getIdSceance() {
        return idSceance;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public String getHoraire() {
        return horaire;
    }

    public int getIdSalle() {
        return idSalle;
    }

    public String getDate() {
        return date;
    }

    public int getNbPlaceRestante() {
        return nbPlaceRestante;
    }

    // Setters
    public void setIdSceance(int idSceance) {
        this.idSceance = idSceance;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public void setHoraire(String horaire) {
        this.horaire = horaire;
    }

    public void setIdSalle(int idSalle) {
        this.idSalle = idSalle;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setNbPlaceRestante(int nbPlaceRestante) {
        this.nbPlaceRestante = nbPlaceRestante;
    }
}
