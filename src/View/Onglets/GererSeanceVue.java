package View.Onglets;

import Model.Sceance;
import View.Onglets.GererSeanceVueComposant.FormulaireAjoutSeanceVue;
import View.Onglets.GererSeanceVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GererSeanceVue extends JPanel {

    private List<Sceance> sceances;
    private JPanel panelGrille;
    private JButton boutonAfficher;
    private Grille grilleSeances;
    private FormulaireAjoutSeanceVue formulaireAjoutSeanceVue;
    private boolean formulaireAffiche = false;

    public GererSeanceVue(int barreNavigationPanelWidth, int frameHeight) {
        setBackground(new Color(100, 50, 50));
        setPreferredSize(new Dimension(barreNavigationPanelWidth, frameHeight));

        // Initialisation des séances
        sceances = new ArrayList<>();
        // Ajoutez ici vos séances initiales si nécessaire

        // Création des composants
        panelGrille = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(panelGrille);
        boutonAfficher = new JButton("Ajouter");
        grilleSeances = new Grille(sceances.toArray(new Sceance[0])); // Initialisation de la grille avec les séances
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
            sceances.add(nouvelleSeance);
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
