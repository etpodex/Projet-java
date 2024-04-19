package View.Onglets.GererSeanceVueComposant;

import Model.Sceance;

import javax.swing.*;
import java.awt.*;

public class FormulaireAjoutSeanceVue extends JPanel {
    private JTextField idFilmField, idSalleField, horaireField, dateField;

    public FormulaireAjoutSeanceVue() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        idFilmField = addFormField("ID du film:", gbc);
        idSalleField = addFormField("ID de la salle:", gbc);
        horaireField = addFormField("Horaire:", gbc);
        dateField = addFormField("Date:", gbc);
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
        return !idFilmField.getText().trim().isEmpty() &&
                !idSalleField.getText().trim().isEmpty() &&
                !horaireField.getText().trim().isEmpty() &&
                !dateField.getText().trim().isEmpty();
    }

    public Sceance createSeanceFromFields() {
        try {
            int idFilm = Integer.parseInt(idFilmField.getText());
            int idSalle = Integer.parseInt(idSalleField.getText());
            String horaire = horaireField.getText();
            String date = dateField.getText();
            return new Sceance(0, idFilm, horaire, idSalle, date, 0);
        } catch (NumberFormatException e) {
            // Gérer l'erreur de conversion
            e.printStackTrace();
            return null;
        }
    }
}
