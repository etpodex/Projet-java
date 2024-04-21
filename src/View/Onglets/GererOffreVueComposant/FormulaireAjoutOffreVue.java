package View.Onglets.GererOffreVueComposant;

import Model.Offre;

import javax.swing.*;
import java.awt.*;

/**
 * Panel contenant un formulaire pour l'ajout d'une nouvelle offre.
 */
public class FormulaireAjoutOffreVue extends JPanel {
    private JTextField nomPromoField, reductionField, codePromoField;

    /**
     * Constructeur de la vue du formulaire d'ajout d'offre.
     */
    public FormulaireAjoutOffreVue() {
        setLayout(new GridBagLayout()); // Configuration du layout en grille
        GridBagConstraints gbc = new GridBagConstraints(); // Création d'un objet GridBagConstraints pour contrôler la disposition des composants
        gbc.anchor = GridBagConstraints.WEST; // Alignement à gauche des composants
        gbc.insets = new Insets(5, 5, 5, 5); // Marge entre les composants

        // Ajout des champs de texte avec leur label correspondant
        nomPromoField = addFormField("Nom de la Promo:", gbc);
        reductionField = addFormField("Réduction:", gbc);
        codePromoField = addFormField("Code Promo:", gbc);
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
     * Méthode pour vérifier si tous les champs du formulaire sont remplis.
     *
     * @return true si tous les champs sont remplis, sinon false.
     */
    public boolean areAllFieldsFilled() {
        return !nomPromoField.getText().trim().isEmpty() &&
                !reductionField.getText().trim().isEmpty() &&
                !codePromoField.getText().trim().isEmpty();
    }

    /**
     * Méthode pour créer un objet Offre à partir des données saisies dans les champs du formulaire.
     *
     * @return L'objet Offre créé ou null en cas d'erreur.
     */
    public Offre createOffreFromFields() {
        try {
            int reduction = Integer.parseInt(reductionField.getText()); // Conversion du texte en entier pour la réduction
            return new Offre(
                    nomPromoField.getText(), // Nom de la promotion
                    reduction, // Réduction
                    codePromoField.getText() // Code promotionnel
            );
        } catch (NumberFormatException e) { // Gestion de l'erreur si la conversion échoue
            e.printStackTrace(); // Affichage de la trace de l'erreur
            return null; // Retourne null en cas d'erreur
        }
    }
}
