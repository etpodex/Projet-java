package View.Onglets.GererFilmVueComposant;

import Model.Film;
import View.Onglets.GererFilmVue;
import javax.swing.*;
import java.awt.*;

public class FormulaireAjoutFilmVue extends JPanel {
    private GererFilmVue parent;
    private JTextField titreField, acteurField, tempsField, noteField, synopsisField, afficheField;

    public FormulaireAjoutFilmVue(GererFilmVue parent) {
        this.parent = parent;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        titreField = addFormField("Titre:", gbc);
        acteurField = addFormField("Acteur:", gbc);
        tempsField = addFormField("Temps:", gbc);
        noteField = addFormField("Note:", gbc);
        synopsisField = addFormField("Synopsis:", gbc);
        afficheField = addFormField("URL de l'affiche:", gbc);
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
        return !titreField.getText().trim().isEmpty() &&
                !acteurField.getText().trim().isEmpty() &&
                !tempsField.getText().trim().isEmpty() &&
                !noteField.getText().trim().isEmpty() &&
                !synopsisField.getText().trim().isEmpty() &&
                !afficheField.getText().trim().isEmpty();
    }

    public Film createFilmFromFields() {
        return new Film(
                "", // Laisser l'ID vide pour le moment
                titreField.getText(),
                acteurField.getText(),
                synopsisField.getText(),
                tempsField.getText(),
                Float.parseFloat(noteField.getText()),
                afficheField.getText(),
                0 // Le stock initial peut être défini ici
        );
    }
}
