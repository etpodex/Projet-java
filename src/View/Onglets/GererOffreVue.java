package View.Onglets;

import Model.Offre;
import View.Onglets.GererOffreVueComposant.FormulaireAjoutOffreVue;
import View.Onglets.GererOffreVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class GererOffreVue extends JPanel {

    // Déclaration des attributs
    private Offre[] offres = new Offre[]{
            new Offre("Offre1", 10, "CODE1"),
            new Offre("Offre2", 20, "CODE2"),
            new Offre("Offre3", 15, "CODE3")
    };

    private JPanel panelGrille;
    private JButton boutonAfficher;
    private Grille grilleOffres;
    private FormulaireAjoutOffreVue formulaireAjoutOffreVue;
    private boolean formulaireAffiche = false;

    // Constructeur
    public GererOffreVue(int barreNavigationPanelWidth, int frameHeight) {
        setBackground(new Color(100, 50, 50)); // Définition de la couleur de fond
        setPreferredSize(new Dimension(barreNavigationPanelWidth, frameHeight)); // Définition de la taille préférée

        // Création des composants
        panelGrille = new JPanel(new BorderLayout()); // Panneau pour la grille
        JScrollPane scrollPane = new JScrollPane(panelGrille); // Ajout d'une barre de défilement
        boutonAfficher = new JButton("Ajouter"); // Bouton pour afficher le formulaire ou ajouter une offre
        grilleOffres = new Grille(offres); // Initialisation de la grille avec les offres
        formulaireAjoutOffreVue = new FormulaireAjoutOffreVue(); // Formulaire pour ajouter une offre

        // Mise en page du panneau principal
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER); // Ajout de la grille avec barre de défilement
        add(boutonAfficher, BorderLayout.SOUTH); // Ajout du bouton au bas de la fenêtre

        // Affichage initial des offres dans la grille
        panelGrille.add(grilleOffres);

        // Action du bouton pour afficher/masquer le formulaire ou ajouter une offre
        boutonAfficher.addActionListener(e -> {
            if (!formulaireAffiche) {
                afficherFormulaire();
            } else {
                ajouterOffre();
            }
        });
    }

    // Méthode pour afficher le formulaire
    private void afficherFormulaire() {
        boutonAfficher.setText("Valider");
        formulaireAffiche = true;
        panelGrille.removeAll();
        panelGrille.add(formulaireAjoutOffreVue);
        panelGrille.revalidate();
        panelGrille.repaint();
    }

    // Méthode pour ajouter une offre
    private void ajouterOffre() {
        Offre nouvelleOffre = formulaireAjoutOffreVue.createOffreFromFields(); // Création d'une nouvelle offre à partir des champs du formulaire
        if (nouvelleOffre != null) { // Vérification si les champs sont remplis correctement
            Offre[] nouvellesOffres = Arrays.copyOf(offres, offres.length + 1); // Création d'une nouvelle liste d'offres avec une taille augmentée
            nouvellesOffres[nouvellesOffres.length - 1] = nouvelleOffre; // Ajout de la nouvelle offre à la fin de la liste
            offres = nouvellesOffres; // Mise à jour de la liste des offres
            grilleOffres.ajouterOffre(nouvelleOffre.getNom_promo(), nouvelleOffre.getReduction(), nouvelleOffre.getCode_promo()); // Ajout de l'offre à la grille
            boutonAfficher.setText("Ajouter");
            formulaireAffiche = false;
            panelGrille.removeAll();
            panelGrille.add(grilleOffres);
            panelGrille.revalidate();
            panelGrille.repaint();

            // Affichage des offres ajoutées (pour le débogage)
            for (int i = 0; i < offres.length; i++) {
                Offre offre = offres[i];
                System.out.println("\tnew Offre(\"" + offre.getNom_promo() + "\", " + offre.getReduction() + ", \"" + offre.getCode_promo() + "\")" + (i < offres.length - 1 ? "," : ""));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE); // Affichage d'un message d'erreur si tous les champs ne sont pas remplis
        }
    }
}
