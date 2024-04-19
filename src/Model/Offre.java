package Model;

public class Offre {
    private String nom_promo;
    private String reduction;
    private String code_promo;

    public Offre(String nom_promo, String reduction, String code_promo) {
        this.nom_promo = nom_promo;
        this.reduction = reduction;
        this.code_promo = code_promo;
    }

    public String getNom_promo() {
        return nom_promo;
    }

    public void setNom_promo(String nom_promo) {
        this.nom_promo = nom_promo;
    }

    public String getReduction() {
        return reduction;
    }

    public void setReduction(String reduction) {
        this.reduction = reduction;
    }

    public String getCode_promo() {
        return code_promo;
    }

    public void setCode_promo(String code_promo) {
        this.code_promo = code_promo;
    }
}
