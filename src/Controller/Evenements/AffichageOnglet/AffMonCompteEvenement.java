package Controller.Evenements.AffichageOnglet;

import Model.Utilisateur;

public class AffMonCompteEvenement extends AffPVEvenement {

    Utilisateur utilisateur;

    public AffMonCompteEvenement() {
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
