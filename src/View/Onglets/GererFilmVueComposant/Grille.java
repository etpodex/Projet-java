package View.Onglets.GererFilmVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import Model.Film;

public class Grille extends JPanel {

    private JTable table;

    public Grille(Film[] films) {
        setLayout(new BorderLayout());

        String[] colonnesNoms = {"Titre", "Acteur", "Temps", "Note", "Synopsis", "Affiche", "Supprimer"};
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Only the "Supprimer" column is editable
            }
        };

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);

        // Set the renderers and editors for the "Supprimer" column
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Film film : films) {
            ajouterFilm(film.getNom(), film.getActeur(), film.getTemps(), film.getNote(), film.getSynopsis(), new ImageIcon(film.getUrlImage()));
        }
    }

    public void ajouterFilm(String titre, String acteur, String temps, double note, String synopsis, Icon affiche) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{titre, acteur, temps, note, synopsis, affiche, "Supprimer"});
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
                // Code to perform action when the button is clicked
                ((DefaultTableModel)table.getModel()).removeRow(table.getEditingRow());
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
