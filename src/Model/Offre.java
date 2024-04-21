package Model;

/**
 * Cette classe représente une offre promotionnelle.
 */
public class Offre {
    private String nom_promo;   // Nom de la promotion
    private int reduction;      // Réduction offerte par la promotion
    private String code_promo;  // Code associé à la promotion

    /**
     * Constructeur par défaut. Initialise tous les attributs à des valeurs nulles ou par défaut.
     */
    public Offre() {
        this.nom_promo = null;
        this.reduction = 0;
        this.code_promo = null;
    }

    /**
     * Constructeur avec tous les paramètres.
     * @param nom_promo Le nom de la promotion.
     * @param reduction La réduction offerte par la promotion.
     * @param code_promo Le code associé à la promotion.
     */
    public Offre(String nom_promo, int reduction, String code_promo) {
        this.nom_promo = nom_promo;
        this.reduction = reduction;
        this.code_promo = code_promo;
    }

    /**
     * Obtenir le nom de la promotion.
     * @return Le nom de la promotion.
     */
    public String getNom_promo() {
        return nom_promo;
    }

    /**
     * Définir le nom de la promotion.
     * @param nom_promo Le nom de la promotion.
     */
    public void setNom_promo(String nom_promo) {
        this.nom_promo = nom_promo;
    }

    /**
     * Obtenir la réduction offerte par la promotion.
     * @return La réduction offerte par la promotion.
     */
    public int getReduction() {
        return reduction;
    }

    /**
     * Définir la réduction offerte par la promotion.
     * @param reduction La réduction offerte par la promotion.
     */
    public void setReduction(int reduction) {
        this.reduction = reduction;
    }

    /**
     * Obtenir le code associé à la promotion.
     * @return Le code associé à la promotion.
     */
    public String getCode_promo() {
        return code_promo;
    }

    /**
     * Définir le code associé à la promotion.
     * @param code_promo Le code associé à la promotion.
     */
    public void setCode_promo(String code_promo) {
        this.code_promo = code_promo;
    }
}
