package Controller.Evenements.AffichageOnglet;

import Model.Offre;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class AffAccueilEvenement extends AffPVEvenement {

    DefaultPieDataset pieDataset;
    DefaultCategoryDataset barDataset;
    Offre[] offres;

    public AffAccueilEvenement() {}

    public void setOffres(Offre[] offres) {
        this.offres = offres;
    }

    public Offre[] getOffres() {
        return offres;
    }

    public void setPieDataset(DefaultPieDataset pieDataset) {
        this.pieDataset = pieDataset;
    }

    public void setBarDataset(DefaultCategoryDataset barDataset) {
        this.barDataset = barDataset;
    }

    public Object[] getDatasets() {
        return new Object[]{pieDataset, barDataset};
    }
}
