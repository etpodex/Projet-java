package Controller.Evenements.AffichageOnglet;

import Model.Utilisateur;

/**
 * La classe AffMonCompteEvenement sert à afficher la page de gestion de son compte en transmettant les variables necessaires.
 */
public class AffMonCompteEvenement extends AffPVEvenement {

    Utilisateur utilisateur;

    public AffMonCompteEvenement() {
    }

    /**
     * Méthode pour obtenir l'utilisateur à afficher.
     * @return L'utilisateur à afficher.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    /**
     * Méthode pour définir l'utilisateur à afficher.
     * @param utilisateur L'utilisateur à afficher.
     */
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }
}
