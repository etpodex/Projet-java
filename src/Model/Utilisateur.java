package Model;

import java.util.Date;

public class Utilisateur {
    private String nom;
    private String prenom;
    private String email;
    private Date dateNaissance;
    private int nvMembre;

    private boolean estEmploye;

    public Utilisateur(String nom, String prenom, String email, Date dateNaissance, int nvMembre, boolean estEmploye) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.nvMembre = nvMembre;
        this.estEmploye = estEmploye;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public int getNvMembre() {
        return nvMembre;
    }

    public boolean getEstEmploye() {
        return estEmploye;
    }
}
