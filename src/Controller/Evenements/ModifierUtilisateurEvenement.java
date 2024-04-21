package Controller.Evenements;

import Model.Utilisateur;

public class ModifierUtilisateurEvenement {

    private Utilisateur utilisateur;
    public ModifierUtilisateurEvenement(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}
