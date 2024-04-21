package View.Onglets.GererSeanceVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import Model.Sceance;

public class Grille extends JPanel {

    private JTable table;

    // Constructeur
    public Grille(Sceance[] seances) {
        setLayout(new BorderLayout()); // Configuration du layout en BorderLayout

        // Définition des noms de colonnes
        String[] colonnesNoms = {"Nom du film", "Salle", "Heure", "Date", "Supprimer"};
        // Création du modèle de table avec les colonnes définies
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Seule la colonne "Supprimer" est modifiable
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

        // Ajout des séances à la table
        for (Sceance seance : seances) {
            ajouterSeance(seance.getIdFilm(), seance.getIdSalle(), seance.getHoraire(), seance.getDate());
        }
    }

    // Méthode pour ajouter une séance à la table
    public void ajouterSeance(String idFilm, int salle, String horaire, String date) {
        DefaultTableModel model = (DefaultTableModel) table.getModel(); // Récupération du modèle de la table
        // Ajout d'une nouvelle ligne avec les données de la séance
        model.addRow(new Object[]{idFilm, salle, horaire, date, "Supprimer"});
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

    public void setSeances(Sceance[] seances) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Sceance seance : seances) {
            ajouterSeance(seance.getIdFilm(), seance.getIdSalle(), seance.getHoraire(), seance.getDate());
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
                // Code à exécuter lorsque le bouton est cliqué (supprimer la séance)
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
