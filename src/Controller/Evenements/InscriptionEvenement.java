package Controller.Evenements;

import Model.Utilisateur;
import jdk.jshell.execution.Util;

public class InscriptionEvenement {

    private Utilisateur utilisateur;

    public InscriptionEvenement(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}
