package View.Onglets.GererFilmVueComposant;

import Model.Film;
import View.Onglets.GererFilmVue;

import javax.swing.*;
import java.awt.*;

/**
 * Panel contenant le formulaire pour l'ajout d'un film.
 */
public class FormulaireAjoutFilmVue extends JPanel {
    private GererFilmVue parent; // Référence vers la vue parente
    private JTextField titreField, acteurField, tempsField, noteField, synopsisField, afficheField;

    /**
     * Constructeur pour le formulaire d'ajout de film.
     *
     * @param parent La vue parente à laquelle ce formulaire appartient.
     */
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

    /**
     * Méthode privée pour ajouter un champ de texte avec son label correspondant.
     *
     * @param labelText Le texte du label.
     * @param gbc       Les contraintes de disposition GridBagConstraints.
     * @return Le champ de texte JTextField créé.
     */
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

    /**
     * Méthode pour vérifier si tous les champs sont remplis.
     *
     * @return true si tous les champs sont remplis, false sinon.
     */
    public boolean areAllFieldsFilled() {
        return !titreField.getText().trim().isEmpty() &&
                !acteurField.getText().trim().isEmpty() &&
                !tempsField.getText().trim().isEmpty() &&
                !noteField.getText().trim().isEmpty() &&
                !synopsisField.getText().trim().isEmpty() &&
                !afficheField.getText().trim().isEmpty();
    }

    /**
     * Méthode pour créer un objet Film à partir des champs de texte.
     *
     * @return L'objet Film créé à partir des champs de texte, ou null en cas d'erreur.
     */
    public Film createFilmFromFields() {
        // Vérifier si la note est valide
        float note;
        try {
            note = Float.parseFloat(noteField.getText());
            if (note < 0 || note > 10) {
                // Afficher un message d'erreur si la note est invalide
                JOptionPane.showMessageDialog(this, "La note doit être comprise entre 0 et 10.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
                return null; // Retourner null pour indiquer une erreur
            }
        } catch (NumberFormatException e) {
            // Afficher un message d'erreur si la saisie n'est pas un nombre
            JOptionPane.showMessageDialog(this, "Veuillez saisir une valeur numérique pour la note.", "Erreur de saisie", JOptionPane.ERROR_MESSAGE);
            return null; // Retourner null pour indiquer une erreur
        }

        // Si la note est valide, créer et retourner l'objet Film
        return new Film(
                // Créer un UUID
                java.util.UUID.randomUUID().toString(),
                titreField.getText(), // Titre du film
                acteurField.getText(), // Acteur principal
                synopsisField.getText(), // Synopsis
                tempsField.getText(), // Durée
                note, // Note
                afficheField.getText(), // URL de l'affiche
                0 // Le stock initial peut être défini ici (0 par défaut)
        );
    }
}
