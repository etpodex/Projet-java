package View.Onglets.GererOffreVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;

import Model.Offre;

public class Grille extends JPanel {

    private JTable table;

    public Grille(Offre[] offres) {
        setLayout(new BorderLayout());

        String[] colonnesNoms = {"Nom Promo", "% Promo", "Code Promo", "Supprimer"};
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3; // Seule la colonne "Supprimer" est modifiable
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

        for (Offre offre : offres) {
            ajouterOffre(offre.getNom_promo(), offre.getReduction(), offre.getCode_promo());
        }
    }

    public void ajouterOffre(String nomPromo, int reduction, String codePromo) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{nomPromo, reduction, codePromo, "Supprimer"});
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
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
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
