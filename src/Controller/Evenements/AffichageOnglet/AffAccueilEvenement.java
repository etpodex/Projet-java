package Controller.Evenements.AffichageOnglet;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

public class AffAccueilEvenement extends AffPVEvenement {

    DefaultPieDataset pieDataset;
    DefaultCategoryDataset barDataset;

    public AffAccueilEvenement() {}

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
