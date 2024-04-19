package View.Onglets.GererSeanceVueComposant;

import javax.swing.*;
import java.awt.*;
import Model.Sceance;

public class FormulaireAjoutSeanceVue extends JPanel {
    private JTextField nomFilmField;
    private JComboBox<String> salleComboBox;
    private JTextField heureField;
    private JTextField dateField;

    public FormulaireAjoutSeanceVue() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel nomFilmLabel = new JLabel("Nom du film:");
        nomFilmField = new JTextField(20);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nomFilmLabel, gbc);
        gbc.gridx = 1;
        add(nomFilmField, gbc);

        JLabel salleLabel = new JLabel("Salle:");
        salleComboBox = new JComboBox<>();
        salleComboBox.addItem("1");
        salleComboBox.addItem("2");
        salleComboBox.addItem("3");
        gbc.gridx = 0;
        gbc.gridy++;
        add(salleLabel, gbc);
        gbc.gridx = 1;
        add(salleComboBox, gbc);

        JLabel heureLabel = new JLabel("Heure:");
        heureField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy++;
        add(heureLabel, gbc);
        gbc.gridx = 1;
        add(heureField, gbc);

        JLabel dateLabel = new JLabel("Date (JJ/MM/AAAA):");
        dateField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy++;
        add(dateLabel, gbc);
        gbc.gridx = 1;
        add(dateField, gbc);
    }

    public boolean areAllFieldsFilled() {
        return !nomFilmField.getText().trim().isEmpty() &&
                !heureField.getText().trim().isEmpty() &&
                !dateField.getText().trim().isEmpty();
    }

    public Sceance createSeanceFromFields() {
        try {
            String nomFilm = nomFilmField.getText();
            int salle = Integer.parseInt((String) salleComboBox.getSelectedItem());
            String heure = heureField.getText();
            String date = dateField.getText();

            return new Sceance(0, 0, heure, salle, date, 0);
        } catch (NumberFormatException e) {
            // Gérer l'erreur de conversion
            e.printStackTrace();
            return null;
        }
    }
}
