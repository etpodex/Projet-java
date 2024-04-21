package Controller.Evenements;

import Model.Utilisateur;

/**
 * Événement signalant une tentative d'inscription d'un nouvel utilisateur.
 */
public class InscriptionEvenement {

    private Utilisateur utilisateur;

    /**
     * Constructeur de l'événement d'inscription.
     *
     * @param utilisateur L'utilisateur à inscrire.
     */
    public InscriptionEvenement(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Obtient l'utilisateur à inscrire.
     *
     * @return L'utilisateur à inscrire.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}
