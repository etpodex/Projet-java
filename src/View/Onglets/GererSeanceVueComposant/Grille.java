package View.Onglets.GererSeanceVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;
import Model.Sceance;

public class Grille extends JPanel {

    private JTable table;

    public Grille(Sceance[] seances) {
        setLayout(new BorderLayout());

        String[] colonnesNoms = {"Nom du film", "Salle", "Heure", "Date", "Supprimer"};
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4; // Seule la colonne "Supprimer" est modifiable
            }
        };

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);

        // Définir les rendus et éditeurs pour la colonne "Supprimer"
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Sceance seance : seances) {
            ajouterSeance(seance.getIdFilm(), seance.getIdSalle(), seance.getHoraire(), seance.getDate());
        }
    }

    public void ajouterSeance(int idFilm, int salle, String horaire, String date) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{idFilm, salle, horaire, date, "Supprimer"});
    }

    private class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                                                       boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    private class ButtonEditor extends DefaultCellEditor {
        private JButton button;
        private String label;
        private boolean isPushed;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);
            button.addActionListener(e -> fireEditingStopped());
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
