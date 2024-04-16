package View.Onglets.GererFilmVueComposant;

import Model.Film;
import View.Onglets.GererFilmVue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormulaireAjoutFilmVue extends JPanel {

    private GererFilmVue parent;

    public FormulaireAjoutFilmVue(GererFilmVue parent) {
        this.parent = parent;

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titreLabel = new JLabel("Titre:");
        JTextField titreField = new JTextField(20);
        addFormField(this, gbc, titreLabel, titreField);

        JLabel acteurLabel = new JLabel("Acteur:");
        JTextField acteurField = new JTextField(20);
        addFormField(this, gbc, acteurLabel, acteurField);

        JLabel tempsLabel = new JLabel("Temps:");
        JTextField tempsField = new JTextField(20);
        addFormField(this, gbc, tempsLabel, tempsField);

        JLabel noteLabel = new JLabel("Note:");
        JTextField noteField = new JTextField(20);
        addFormField(this, gbc, noteLabel, noteField);

        JLabel synopsisLabel = new JLabel("Synopsis:");
        JTextField synopsisField = new JTextField(20);
        addFormField(this, gbc, synopsisLabel, synopsisField);

        JLabel afficheLabel = new JLabel("URL de l'affiche:");
        JTextField afficheField = new JTextField(20);
        addFormField(this, gbc, afficheLabel, afficheField);

        JButton validerButton = new JButton("Valider");
        validerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Créer un nouveau film avec les données du formulaire
                Film newFilm = new Film(
                        "", // Laisser l'ID vide pour le moment
                        titreField.getText(),
                        acteurField.getText(),
                        synopsisField.getText(),
                        tempsField.getText(),
                        Float.parseFloat(noteField.getText()),
                        afficheField.getText(),
                        0 // Le stock initial peut être défini ici
                );
                // Ajouter le nouveau film à la liste des films dans le parent
                //parent.addFilm(newFilm);

                // Retourner à la vue précédente (liste des films)
                JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(FormulaireAjoutFilmVue.this);
                frame.getContentPane().removeAll();
                frame.getContentPane().add(parent);
                frame.revalidate();
                frame.repaint();
            }
        });
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
    }

    private void addFormField(JPanel panel, GridBagConstraints gbc, JLabel label, JTextField textField) {
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(label, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(textField, gbc);
    }
}
