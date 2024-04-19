package View.Onglets.GererFilmVueComposant;

import Model.Film;
import View.Onglets.GererFilmVue;

import javax.swing.*;
import java.awt.*;

public class FormulaireAjoutFilmVue extends JPanel {
    private GererFilmVue parent; // Référence vers la vue parente
    private JTextField titreField, acteurField, tempsField, noteField, synopsisField, afficheField;

    // Constructeur
    public FormulaireAjoutFilmVue(GererFilmVue parent) {
        this.parent = parent; // Initialisation de la référence vers la vue parente
        setLayout(new GridBagLayout()); // Configuration du layout en grille
        GridBagConstraints gbc = new GridBagConstraints(); // Création d'un objet GridBagConstraints pour contrôler la disposition des composants
        gbc.anchor = GridBagConstraints.WEST; // Alignement à gauche des composants
        gbc.insets = new Insets(5, 5, 5, 5); // Marge entre les composants

        // Ajout des champs de texte avec leur label correspondant
        titreField = addFormField("Titre:", gbc);
        acteurField = addFormField("Acteur:", gbc);
        tempsField = addFormField("Temps:", gbc);
        noteField = addFormField("Note:", gbc);
        synopsisField = addFormField("Synopsis:", gbc);
        afficheField = addFormField("URL de l'affiche:", gbc);
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
        return !titreField.getText().trim().isEmpty() &&
                !acteurField.getText().trim().isEmpty() &&
                !tempsField.getText().trim().isEmpty() &&
                !noteField.getText().trim().isEmpty() &&
                !synopsisField.getText().trim().isEmpty() &&
                !afficheField.getText().trim().isEmpty();
    }

    // Méthode pour créer un objet Film à partir des champs de texte
    public Film createFilmFromFields() {
        return new Film(
                "", // Laisser l'ID vide pour le moment
                titreField.getText(), // Titre du film
                acteurField.getText(), // Acteur principal
                synopsisField.getText(), // Synopsis
                tempsField.getText(), // Durée
                Float.parseFloat(noteField.getText()), // Note
                afficheField.getText(), // URL de l'affiche
                0 // Le stock initial peut être défini ici (0 par défaut)
        );
    }
}
