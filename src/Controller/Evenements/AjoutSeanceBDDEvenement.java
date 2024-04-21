package Controller.Evenements;

import Model.Sceance;

/**
 * Cet événement représente l'ajout d'une séance dans la base de données.
 */
public class AjoutSeanceBDDEvenement {

    private Sceance seance;  // Séance à ajouter dans la base de données

    /**
     * Définit la séance à ajouter dans la base de données.
     *
     * @param seance La séance à ajouter
     */
    public void setSeance(Sceance seance) {
        this.seance = seance;
    }

    /**
     * Obtient la séance à ajouter dans la base de données.
     *
     * @return La séance à ajouter
     */
    public Sceance getSeance() {
        return seance;
    }
}
