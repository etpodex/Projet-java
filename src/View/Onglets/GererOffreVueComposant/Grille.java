package View.Onglets.GererOffreVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

import Model.Offre;

public class Grille extends JPanel {

    private JTable table;

    // Constructeur
    public Grille(Offre[] offres) {
        setLayout(new BorderLayout()); // Configuration du layout en BorderLayout

        // Définition des noms de colonnes
        String[] colonnesNoms = {"Nom Promo", "% Promo", "Code Promo", "Supprimer"};
        // Création du modèle de table avec les colonnes définies
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Seule la colonne "Supprimer" est modifiable
            }
        };

        table = new JTable(tableModel); // Création de la table avec le modèle défini
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Sélection unique
        table.setRowHeight(30); // Hauteur des lignes
        table.getTableHeader().setReorderingAllowed(false); // Interdiction de réorganiser les colonnes

        // Définition des rendus et éditeurs pour la colonne "Supprimer"
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table); // Création d'un JScrollPane contenant la table
        add(scrollPane, BorderLayout.CENTER); // Ajout du JScrollPane au centre de ce panneau

        // Ajout des offres à la table
        for (Offre offre : offres) {
            ajouterOffre(offre.getNom_promo(), offre.getReduction(), offre.getCode_promo());
        }
    }

    // Méthode pour ajouter une offre à la table
    public void ajouterOffre(String nomPromo, int reduction, String codePromo) {
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // Récupération du modèle de la table
        // Ajout d'une nouvelle ligne avec les données de l'offre
        model.addRow(new Object[]{nomPromo, reduction, codePromo, "Supprimer"});
    }

    // Classe interne pour le rendu des boutons dans la colonne "Supprimer"
    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString()); // Définition du texte du bouton
            return this;
        }
    }

    // Classe interne pour l'édition des cellules dans la colonne "Supprimer"
    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton(); // Création du bouton
            button.setOpaque(true); // Définition de l'opacité
            button.addActionListener(e -> fireEditingStopped()); // Ajout d'un écouteur d'événement
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                                                     boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                // Code à exécuter lorsque le bouton est cliqué (supprimer l'offre)
                ((DefaultTableModel) table.getModel()).removeRow(table.getEditingRow());
            }
            isPushed = false;
            return label;
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }
}
