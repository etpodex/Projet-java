package View.Onglets;

import Model.Sceance;
import View.Onglets.GererSeanceVueComposant.FormulaireAjoutSeanceVue;
import View.Onglets.GererSeanceVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GererSeanceVue extends JPanel {

    private Sceance[] seances = new Sceance[]{
            new Sceance(1, 1, "09:00", 1, "2024-04-01", 100),
            new Sceance(2, 2, "12:00", 2, "2024-04-01", 120),
            new Sceance(3, 3, "15:00", 3, "2024-04-01", 80),
            new Sceance(4, 1, "10:00", 1, "2024-04-02", 90),
            new Sceance(5, 2, "13:00", 2, "2024-04-02", 110),
            new Sceance(6, 3, "16:00", 3, "2024-04-02", 70),
            new Sceance(7, 1, "11:00", 1, "2024-04-03", 80),
            new Sceance(8, 2, "14:00", 2, "2024-04-03", 100)
    };

    private JPanel panelGrille;
    private JButton boutonAfficher;
    private Grille grilleSeances;
    private FormulaireAjoutSeanceVue formulaireAjoutSeanceVue;
    private boolean formulaireAffiche = false;

    public GererSeanceVue(int barreNavigationPanelWidth, int frameHeight) {
        setBackground(new Color(100, 50, 50));
        setPreferredSize(new Dimension(barreNavigationPanelWidth, frameHeight));

        // Initialisation des composants
        panelGrille = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(panelGrille);
        boutonAfficher = new JButton("Ajouter");
        grilleSeances = new Grille(seances); // Initialisation de la grille avec les séances
        formulaireAjoutSeanceVue = new FormulaireAjoutSeanceVue();

        // Mise en page du panneau principal
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(boutonAfficher, BorderLayout.SOUTH);

        // Affichage initial des séances dans la grille
        panelGrille.add(grilleSeances);

        // Action du bouton pour afficher/masquer le formulaire ou ajouter une séance
        boutonAfficher.addActionListener(e -> {
            if (!formulaireAffiche) {
                afficherFormulaire();
            } else {
                ajouterSeance();
            }
        });
    }

    private void afficherFormulaire() {
        boutonAfficher.setText("Valider");
        formulaireAffiche = true;
        panelGrille.removeAll();
        panelGrille.add(formulaireAjoutSeanceVue);
        panelGrille.revalidate();
        panelGrille.repaint();
    }

    private void ajouterSeance() {
        Sceance nouvelleSeance = formulaireAjoutSeanceVue.createSeanceFromFields();
        if (nouvelleSeance != null) {
            List<Sceance> seanceList = new ArrayList<>(Arrays.asList(seances));
            seanceList.add(nouvelleSeance);
            seances = seanceList.toArray(new Sceance[0]);
            grilleSeances.ajouterSeance(nouvelleSeance.getIdFilm(), nouvelleSeance.getIdSalle(), nouvelleSeance.getHoraire(), nouvelleSeance.getDate());
            boutonAfficher.setText("Ajouter");
            formulaireAffiche = false;
            panelGrille.removeAll();
            panelGrille.add(grilleSeances);
            panelGrille.revalidate();
            panelGrille.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
