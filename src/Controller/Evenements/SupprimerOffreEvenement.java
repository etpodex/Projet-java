package Controller.Evenements;

/**
 * Événement de suppression d'une offre.
 */
public class SupprimerOffreEvenement {
    private String code_offre;

    /**
     * Constructeur par défaut de l'événement de suppression d'une offre.
     */
    public SupprimerOffreEvenement() {
    }

    /**
     * Obtient le code de l'offre à supprimer.
     *
     * @return Le code de l'offre à supprimer.
     */
    public String getCode() {
        return code_offre;
    }

    /**
     * Définit le code de l'offre à supprimer.
     *
     * @param code_offre Le code de l'offre à supprimer.
     */
    public void setCode(String code_offre) {
        this.code_offre = code_offre;
    }
}
