package View.Onglets;

import Model.Offre;
import View.Onglets.GererOffreVueComposant.FormulaireAjoutOffreVue;
import View.Onglets.GererOffreVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GererOffreVue extends JPanel {

    private List<Offre> offres;
    private JPanel panelGrille;
    private JButton boutonAfficher;
    private Grille grilleOffres;
    private FormulaireAjoutOffreVue formulaireAjoutOffreVue;
    private boolean formulaireAffiche = false;

    public GererOffreVue(int barreNavigationPanelWidth, int frameHeight) {
        setBackground(new Color(100, 50, 50));
        setPreferredSize(new Dimension(barreNavigationPanelWidth, frameHeight));

        // Création des composants
        panelGrille = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(panelGrille);
        boutonAfficher = new JButton("Ajouter");
        grilleOffres = new Grille(new Offre[0]); // Initialisation de la grille
        formulaireAjoutOffreVue = new FormulaireAjoutOffreVue();

        // Mise en page du panneau principal
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(boutonAfficher, BorderLayout.SOUTH);

        // Initialisation de la liste des offres avec quelques offres
        offres = new ArrayList<>();
        initialiserOffres();

        // Action du bouton pour afficher/masquer le formulaire ou ajouter une offre
        boutonAfficher.addActionListener(e -> {
            if (!formulaireAffiche) {
                afficherFormulaire();
            } else {
                ajouterOffre();
            }
        });
    }

    private void afficherFormulaire() {
        boutonAfficher.setText("Valider");
        formulaireAffiche = true;
        panelGrille.removeAll();
        panelGrille.add(formulaireAjoutOffreVue);
        panelGrille.revalidate();
        panelGrille.repaint();
    }

    private void ajouterOffre() {
        Offre nouvelleOffre = formulaireAjoutOffreVue.createOffreFromFields();
        if (nouvelleOffre != null) {
            offres.add(nouvelleOffre);
            grilleOffres.ajouterOffre(nouvelleOffre.getNom_promo(), nouvelleOffre.getReduction(), nouvelleOffre.getCode_promo());
            boutonAfficher.setText("Ajouter");
            formulaireAffiche = false;
            panelGrille.removeAll();
            panelGrille.add(grilleOffres);
            panelGrille.revalidate();
            panelGrille.repaint();
        } else {
            JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void initialiserOffres() {
        // Initialisez quelques offres ici
        offres.add(new Offre("Offre1", "10%", "CODE1"));
        offres.add(new Offre("Offre2", "20%", "CODE2"));
        offres.add(new Offre("Offre3", "15%", "CODE3"));

        // Ajoutez-les également à la grille
        for (Offre offre : offres) {
            grilleOffres.ajouterOffre(offre.getNom_promo(), offre.getReduction(), offre.getCode_promo());
        }
    }
}
