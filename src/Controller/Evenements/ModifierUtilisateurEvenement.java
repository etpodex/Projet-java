package Controller.Evenements;

import Model.Utilisateur;

/**
 * Événement signalant la modification des informations d'un utilisateur.
 */
public class ModifierUtilisateurEvenement {

    private Utilisateur utilisateur;

    /**
     * Constructeur de l'événement de modification d'utilisateur.
     *
     * @param utilisateur L'utilisateur dont les informations ont été modifiées.
     */
    public ModifierUtilisateurEvenement(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    /**
     * Obtient l'utilisateur dont les informations ont été modifiées.
     *
     * @return L'utilisateur modifié.
     */
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
}
