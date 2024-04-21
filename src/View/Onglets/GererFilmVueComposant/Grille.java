package View.Onglets.GererFilmVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.*;

import Controller.Evenements.EffacerFilmEvenement;
import Controller.Evenements.FileEvenements;
import Model.Film;

public class Grille extends JPanel {

    private JTable table;

    private Film[] films;

    // Constructeur
    public Grille(Film[] films) {

        this.films = films;
        setLayout(new BorderLayout());

        String[] colonnesNoms = {"Titre", "Acteur", "Temps", "Note", "Synopsis", "Affiche", "Supprimer"};
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6; // Seule la colonne "Supprimer" est modifiable
            }
        };

        table = new JTable(tableModel); // Création de la table avec le modèle
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // Sélection unique
        table.setRowHeight(30); // Hauteur des lignes
        table.getTableHeader().setReorderingAllowed(false); // Interdiction de réorganiser les colonnes

        // Définition des rendus et des éditeurs pour la colonne "Supprimer"
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox()));

        JScrollPane scrollPane = new JScrollPane(table); // Ajout de la table dans un JScrollPane
        add(scrollPane, BorderLayout.CENTER); // Ajout du JScrollPane au centre de ce panneau

    }

    public void setFilms(Film[] films) {
        this.films = films;
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for (Film film : films) {
            ajouterFilm(film.getNom(), film.getActeur(), film.getTemps(), film.getNote(), film.getSynopsis(), new ImageIcon(film.getUrlImage()));
        }
    }

    // Méthode pour ajouter un film à la table
    public void ajouterFilm(String titre, String acteur, String temps, double note, String synopsis, Icon affiche) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{titre, acteur, temps, note, synopsis, affiche, "Supprimer"});
    }

    // Classe interne pour le rendu des boutons dans la colonne "Supprimer"
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

    // Classe interne pour l'édition des cellules dans la colonne "Supprimer"
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
                // Récupérer l'uuid du film à supprimer à partir du numéro de ligne
                int film_index = table.getSelectedRow();
                String uuid = films[film_index].getUuid();

                FileEvenements.getInstance().publier(new EffacerFilmEvenement(uuid));
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
