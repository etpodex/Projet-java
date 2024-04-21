package View.Onglets;
import Controller.Evenements.AjoutSeanceBDDEvenement;
import Controller.Evenements.FileEvenements;
import Model.Sceance;
import View.Onglets.GererSeanceVueComposant.FormulaireAjoutSeanceVue;
import View.Onglets.GererSeanceVueComposant.Grille;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Vue pour gérer les séances, affichant une grille de séances et un formulaire pour ajouter de nouvelles séances.
 */
public class GererSeanceVue extends JPanel {

    // Attributs

    /** Liste des séances actuellement gérées. */
    private Sceance[] seances;

    /** Panneau pour afficher la grille des séances. */
    private JPanel panelGrille;

    /** Bouton pour afficher le formulaire ou ajouter une séance. */
    private JButton boutonAfficher;

    /** Grille d'affichage des séances. */
    private Grille grilleSeances;

    /** Formulaire pour ajouter une nouvelle séance. */
    private FormulaireAjoutSeanceVue formulaireAjoutSeanceVue;

    /** Indique si le formulaire est actuellement affiché. */
    private boolean formulaireAffiche = false;

    /**
     * Constructeur de la vue pour gérer les séances.
     *
     * @param barreNavigationPanelWidth Largeur de la barre de navigation.
     * @param frameHeight              Hauteur de la fenêtre principale.
     */
    public GererSeanceVue(int barreNavigationPanelWidth, int frameHeight) {
        setBackground(new Color(238, 238, 238)); // Définir la couleur de fond
        setPreferredSize(new Dimension(barreNavigationPanelWidth, frameHeight)); // Définir la taille préférée

        // Initialisation des composants
        panelGrille = new JPanel(new BorderLayout()); // Initialisation du panneau pour la grille
        JScrollPane scrollPane = new JScrollPane(panelGrille); // Ajout d'une barre de défilement
        boutonAfficher = new JButton("Ajouter"); // Initialisation du bouton "Ajouter"
        grilleSeances = new Grille(seances); // Initialisation de la grille avec les séances
        formulaireAjoutSeanceVue = new FormulaireAjoutSeanceVue(); // Initialisation du formulaire pour ajouter une séance

        // Mise en page du panneau principal
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER); // Ajout de la grille avec barre de défilement
        add(boutonAfficher, BorderLayout.SOUTH); // Ajout du bouton "Ajouter" en bas de la fenêtre

        // Affichage initial des séances dans la grille
        panelGrille.add(grilleSeances);

        // Action du bouton "Ajouter" pour afficher/masquer le formulaire ou ajouter une séance
        boutonAfficher.addActionListener(e -> {
            if (!formulaireAffiche) {
                afficherFormulaire(); // Si le formulaire n'est pas affiché, l'afficher
            } else {
                ajouterSeance(); // Sinon, ajouter la séance
            }
        });
    }

    /**
     * Définit les séances à afficher dans la grille.
     *
     * @param seances Tableau d'objets Sceance à afficher.
     */
    public void setGererSeances(Sceance[] seances) {
        this.seances = seances;
        grilleSeances.setSeances(seances);
    }

    /**
     * Affiche le formulaire d'ajout de séance.
     */
    private void afficherFormulaire() {
        boutonAfficher.setText("Valider"); // Changer le texte du bouton en "Valider"
        formulaireAffiche = true; // Mettre le formulaire en mode affiché
        panelGrille.removeAll(); // Supprimer tous les composants du panneau grille
        panelGrille.add(formulaireAjoutSeanceVue); // Ajouter le formulaire au panneau grille
        panelGrille.revalidate(); // Rafraîchir l'affichage
        panelGrille.repaint(); // Redessiner le panneau
    }

    /**
     * Ajoute une séance à la liste des séances.
     */
    private void ajouterSeance() {
        Sceance nouvelleSeance = formulaireAjoutSeanceVue.createSeanceFromFields(); // Créer une nouvelle séance à partir des champs du formulaire
        if (nouvelleSeance != null) { // Vérifier si tous les champs sont remplis correctement
            List<Sceance> seanceList = new ArrayList<>(Arrays.asList(seances)); // Convertir le tableau de séances en liste
            seanceList.add(nouvelleSeance); // Ajouter la nouvelle séance à la liste
            seances = seanceList.toArray(new Sceance[0]); // Convertir la liste en tableau de séances
            grilleSeances.ajouterSeance(nouvelleSeance.getIdFilm(), nouvelleSeance.getIdSalle(), nouvelleSeance.getHoraire(), nouvelleSeance.getDate()); // Ajouter la séance à la grille
            boutonAfficher.setText("Ajouter"); // Revenir au texte initial du bouton
            formulaireAffiche = false; // Mettre le formulaire en mode masqué
            panelGrille.removeAll(); // Supprimer tous les composants du panneau grille
            panelGrille.add(grilleSeances); // Ajouter la grille au panneau
            panelGrille.revalidate(); // Rafraîchir l'affichage
            panelGrille.repaint(); // Redessiner le panneau

            AjoutSeanceBDDEvenement evenement = new AjoutSeanceBDDEvenement(); // Créer un événement pour ajouter une séance
            evenement.setSeance(nouvelleSeance); // Ajouter la nouvelle séance à l'événement
            FileEvenements.getInstance().publier(evenement); // Publier un événement pour afficher les séances
        } else {
            JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE); // Afficher un message d'erreur si tous les champs ne sont pas remplis
        }
    }
}
