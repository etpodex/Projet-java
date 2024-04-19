package View.Onglets.GererOffreVueComposant;

import Model.Offre;

import javax.swing.*;
import java.awt.*;

public class FormulaireAjoutOffreVue extends JPanel {
    private JTextField nomPromoField, reductionField, codePromoField;

    public FormulaireAjoutOffreVue() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        nomPromoField = addFormField("Nom de la Promo:", gbc);
        reductionField = addFormField("Réduction (%):", gbc);
        codePromoField = addFormField("Code Promo:", gbc);
    }

    private JTextField addFormField(String labelText, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText);
        JTextField textField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        add(textField, gbc);
        return textField;
    }

    public boolean areAllFieldsFilled() {
        return !nomPromoField.getText().trim().isEmpty() &&
                !reductionField.getText().trim().isEmpty() &&
                !codePromoField.getText().trim().isEmpty();
    }

    public Offre createOffreFromFields() {
        try {
            int reduction = Integer.parseInt(reductionField.getText());
            return new Offre(
                    nomPromoField.getText(),
                    String.valueOf(reduction),
                    codePromoField.getText()
            );
        } catch (NumberFormatException e) {
            // Gérer l'erreur de conversion
            e.printStackTrace();
            return null;
        }
    }
}
