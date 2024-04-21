package View.Onglets;

import Controller.Evenements.AjouterOffreEvenement;
import Controller.Evenements.FileEvenements;
import Model.Offre;
import View.Onglets.GererOffreVueComposant.FormulaireAjoutOffreVue;
import View.Onglets.GererOffreVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Vue pour gérer les offres, affichant une grille d'offres et un formulaire pour ajouter de nouvelles offres.
 */
public class GererOffreVue extends JPanel {

    // Déclaration des attributs

    /** Liste des offres actuellement gérées. */
    private Offre[] offres;

    /** Panneau pour afficher la grille des offres. */
    private JPanel panelGrille;

    /** Bouton pour afficher le formulaire ou ajouter une offre. */
    private JButton boutonAfficher;

    /** Grille d'affichage des offres. */
    private Grille grilleOffres;

    /** Formulaire pour ajouter une nouvelle offre. */
    private FormulaireAjoutOffreVue formulaireAjoutOffreVue;

    /** Indique si le formulaire est actuellement affiché. */
    private boolean formulaireAffiche = false;

    /**
     * Constructeur de la vue pour gérer les offres.
     *
     * @param barreNavigationPanelWidth Largeur de la barre de navigation.
     * @param frameHeight              Hauteur de la fenêtre principale.
     */
    public GererOffreVue(int barreNavigationPanelWidth, int frameHeight) {
        setBackground(new Color(238, 238, 238)); // Définition de la couleur de fond
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

    /**
     * Affiche le formulaire d'ajout d'offre.
     */
    private void afficherFormulaire() {
        boutonAfficher.setText("Valider");
        formulaireAffiche = true;
        panelGrille.removeAll();
        panelGrille.add(formulaireAjoutOffreVue);
        panelGrille.revalidate();
        panelGrille.repaint();
    }

    /**
     * Ajoute une nouvelle offre à la liste des offres.
     */
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

            AjouterOffreEvenement evenement = new AjouterOffreEvenement();
            evenement.setOffre(nouvelleOffre);
            FileEvenements.getInstance().publier(evenement); // Publication de l'événement pour mettre à jour les offres

            // Affichage des offres ajoutées (pour le débogage)
            for (int i = 0; i < offres.length; i++) {
                Offre offre = offres[i];
                System.out.println("\tnew Offre(\"" + offre.getNom_promo() + "\", " + offre.getReduction() + ", \"" + offre.getCode_promo() + "\")" + (i < offres.length - 1 ? "," : ""));
            }
        } else {
            JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE); // Affichage d'un message d'erreur si tous les champs ne sont pas remplis
        }
    }

    /**
     * Définit les offres à afficher dans la grille.
     *
     * @param offres Tableau d'objets Offre à afficher.
     */
    public void setGererOffres(Offre[] offres) {
        this.offres = offres;
        grilleOffres.setOffres(offres);
    }
}
