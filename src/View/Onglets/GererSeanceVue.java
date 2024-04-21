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

    // Attributs
    private Sceance[] seances = new Sceance[]{
            new Sceance(1, "1", "09:00", 1, "2024-04-01", 100),
            new Sceance(2, "1", "12:00", 2, "2024-04-01", 120),
            new Sceance(3, "1", "15:00", 3, "2024-04-01", 80),
            new Sceance(4, "1", "10:00", 1, "2024-04-02", 90),
            new Sceance(5, "1", "13:00", 2, "2024-04-02", 110),
            new Sceance(6, "1", "16:00", 3, "2024-04-02", 70),
            new Sceance(7, "1", "11:00", 1, "2024-04-03", 80),
            new Sceance(8, "1", "14:00", 2, "2024-04-03", 100)
    };

    private JPanel panelGrille;
    private JButton boutonAfficher;
    private Grille grilleSeances;
    private FormulaireAjoutSeanceVue formulaireAjoutSeanceVue;
    private boolean formulaireAffiche = false;

    // Constructeur
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

    // Méthode pour afficher le formulaire d'ajout de séance
    private void afficherFormulaire() {
        boutonAfficher.setText("Valider"); // Changer le texte du bouton en "Valider"
        formulaireAffiche = true; // Mettre le formulaire en mode affiché
        panelGrille.removeAll(); // Supprimer tous les composants du panneau grille
        panelGrille.add(formulaireAjoutSeanceVue); // Ajouter le formulaire au panneau grille
        panelGrille.revalidate(); // Rafraîchir l'affichage
        panelGrille.repaint(); // Redessiner le panneau
    }

    // Méthode pour ajouter une séance
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
        } else {
            JOptionPane.showMessageDialog(this, "Erreur : Veuillez remplir tous les champs correctement.", "Erreur", JOptionPane.ERROR_MESSAGE); // Afficher un message d'erreur si tous les champs ne sont pas remplis
        }
    }
}
