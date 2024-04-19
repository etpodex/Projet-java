package View.Onglets.GererSeanceVueComposant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.*;
import Model.Sceance;

public class Grille extends JPanel {

    private JTable table;

    public Grille(Sceance[] seances) {
        setLayout(new BorderLayout());

        String[] colonnesNoms = {"Nom du film", "Salle", "Heure", "Date"};
        DefaultTableModel tableModel = new DefaultTableModel(null, colonnesNoms);

        table = new JTable(tableModel);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setRowHeight(30);
        table.getTableHeader().setReorderingAllowed(false);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        for (Sceance seance : seances) {
            ajouterSeance(seance.getIdFilm(), seance.getIdSalle(), seance.getHoraire(), seance.getDate());
        }
    }

    public void ajouterSeance(int idFilm, int salle, String horaire, String date) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.addRow(new Object[]{idFilm, salle, horaire, date});
    }
}
