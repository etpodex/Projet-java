package Controller.Evenements;

/**
 * Événement de suppression d'une séance dans la base de données.
 */
public class SuppressionSeanceBDDEvenement {

    private String uuid;

    /**
     * Constructeur par défaut de l'événement de suppression d'une séance.
     */
    public SuppressionSeanceBDDEvenement() {
    }

    /**
     * Obtient l'UUID de la séance à supprimer.
     *
     * @return L'UUID de la séance à supprimer.
     */
    public String getUuid() {
        return uuid;
    }

    /**
     * Définit l'UUID de la séance à supprimer.
     *
     * @param uuid L'UUID de la séance à supprimer.
     */
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
