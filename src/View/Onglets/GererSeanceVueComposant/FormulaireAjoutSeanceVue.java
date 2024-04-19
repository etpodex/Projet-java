package View.Onglets.GererSeanceVueComposant;

import Model.Sceance;

import javax.swing.*;
import java.awt.*;

public class FormulaireAjoutSeanceVue extends JPanel {
    private JTextField idFilmField, idSalleField, horaireField, dateField;

    // Constructeur
    public FormulaireAjoutSeanceVue() {
        setLayout(new GridBagLayout()); // Configuration du layout en grille
        GridBagConstraints gbc = new GridBagConstraints(); // Création d'un objet GridBagConstraints pour contrôler la disposition des composants
        gbc.anchor = GridBagConstraints.WEST; // Alignement à gauche des composants
        gbc.insets = new Insets(5, 5, 5, 5); // Marge entre les composants

        // Ajout des champs de texte avec leur label correspondant
        idFilmField = addFormField("ID du film:", gbc);
        idSalleField = addFormField("ID de la salle:", gbc);
        horaireField = addFormField("Horaire:", gbc);
        dateField = addFormField("Date:", gbc);
    }

    // Méthode privée pour ajouter un champ de texte avec son label correspondant
    private JTextField addFormField(String labelText, GridBagConstraints gbc) {
        JLabel label = new JLabel(labelText); // Création d'un JLabel avec le texte du label
        JTextField textField = new JTextField(20); // Création d'un champ de texte JTextField
        gbc.gridx = 0; // Position en X dans la grille
        gbc.gridy++; // Passage à la ligne suivante
        gbc.gridwidth = 1; // Nombre de colonnes occupées par le composant
        gbc.anchor = GridBagConstraints.WEST; // Alignement à gauche du label
        add(label, gbc); // Ajout du label à la vue

        gbc.gridx = 1; // Position en X dans la grille
        gbc.anchor = GridBagConstraints.EAST; // Alignement à droite du champ de texte
        add(textField, gbc); // Ajout du champ de texte à la vue
        return textField; // Retourne le champ de texte créé
    }

    // Méthode pour vérifier si tous les champs sont remplis
    public boolean areAllFieldsFilled() {
        return !idFilmField.getText().trim().isEmpty() &&
                !idSalleField.getText().trim().isEmpty() &&
                !horaireField.getText().trim().isEmpty() &&
                !dateField.getText().trim().isEmpty();
    }

    // Méthode pour créer un objet Sceance à partir des champs de texte
    public Sceance createSeanceFromFields() {
        try {
            int idFilm = Integer.parseInt(idFilmField.getText()); // Conversion du texte en entier pour l'ID du film
            int idSalle = Integer.parseInt(idSalleField.getText()); // Conversion du texte en entier pour l'ID de la salle
            String horaire = horaireField.getText(); // Récupération de l'horaire
            String date = dateField.getText(); // Récupération de la date
            return new Sceance(0, idFilm, horaire, idSalle, date, 0); // Création et retour de l'objet Sceance avec l'ID initialisé à 0
        } catch (NumberFormatException e) { // Gestion de l'erreur si la conversion échoue
            e.printStackTrace(); // Affichage de la trace de l'erreur
            return null; // Retourne null en cas d'erreur
        }
    }
}
