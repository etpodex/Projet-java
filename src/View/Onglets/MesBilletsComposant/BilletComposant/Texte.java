package View.Onglets.MesBilletsComposant.BilletComposant;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

/**
 * Panneau pour afficher les détails textuels d'un billet.
 */
public class Texte extends JPanel {

    // Attributs
    private JLabel title_billet;
    private JLabel date_billet;
    private JLabel horaire_billet;
    private JLabel salle_billet;
    private JLabel acheter_billet;
    private JLabel adulte_billet;
    private JLabel enfant_billet;
    private JLabel senior_billet;

    /**
     * Constructeur de la classe Texte.
     */
    public Texte() {
        setBackground(new Color(255, 255, 255)); // Définition de la couleur de fond du panneau
        setBorder(new EmptyBorder(0, 5, 5, 5)); // Définition des marges autour du panneau
        setLayout(new GridLayout(0, 1)); // Utilisation d'un GridLayout avec une seule colonne et un nombre de lignes dynamique

        // Initialisation des labels
        title_billet = new JLabel();
        date_billet = new JLabel();
        horaire_billet = new JLabel();
        salle_billet = new JLabel();
        acheter_billet = new JLabel();
        adulte_billet = new JLabel();
        enfant_billet = new JLabel();
        senior_billet = new JLabel();

        // Ajout des labels au panneau
        add(title_billet);
        add(createDateHorairePanel());
        add(createSallePanel());
        add(createBilletsPanel());
    }

    // Méthodes privées :

    /**
     * Crée un panneau pour les labels de date et d'horaire.
     *
     * @return un JPanel contenant les labels de date et d'horaire
     */
    private JPanel createDateHorairePanel() {
        JPanel panel = new JPanel(new GridLayout(1, 2));
        panel.add(date_billet);
        panel.add(horaire_billet);
        return panel;
    }

    /**
     * Crée un panneau pour le label de salle.
     *
     * @return un JPanel contenant le label de salle
     */
    private JPanel createSallePanel() {
        JPanel panel = new JPanel(new GridLayout(1, 1));
        panel.add(salle_billet);
        return panel;
    }

    /**
     * Crée un panneau pour les labels de nombre de billets.
     *
     * @return un JPanel contenant les labels de nombre de billets
     */
    private JPanel createBilletsPanel() {
        JPanel panel = new JPanel(new GridLayout(1, 4));
        panel.add(acheter_billet);
        panel.add(adulte_billet);
        panel.add(enfant_billet);
        panel.add(senior_billet);
        return panel;
    }

    // Méthodes publiques pour définir le texte des labels :

    /**
     * Définit le titre du film.
     *
     * @param titre le titre du film à afficher
     */
    public void setTitreFilm(String titre) {
        title_billet.setText("Titre: " + titre);
    }

    /**
     * Définit la date du film.
     *
     * @param date la date du film à afficher
     */
    public void setDataFilm(String date) {
        date_billet.setText("Date: " + date);
    }

    /**
     * Définit l'horaire du film.
     *
     * @param horaire l'horaire du film à afficher
     */
    public void setDataHoraire(String horaire) {
        horaire_billet.setText("Horaire: " + horaire);
    }

    /**
     * Définit la salle du film.
     *
     * @param salle la salle du film à afficher
     */
    public void setDataSalle(String salle) {
        salle_billet.setText("Salle: " + salle);
    }

    /**
     * Définit le nombre de billets à acheter.
     *
     * @param nbre le nombre de billets à acheter à afficher
     */
    public void setNbreBilletAcheter(int nbre) {
        acheter_billet.setText("Nbre billet : " + nbre);
    }

    /**
     * Définit le nombre de billets adultes.
     *
     * @param nbre le nombre de billets adultes à afficher
     */
    public void setNbreBilletAdulte(int nbre) {
        adulte_billet.setText("Adulte: " + nbre);
    }

    /**
     * Définit le nombre de billets enfants.
     *
     * @param nbre le nombre de billets enfants à afficher
     */
    public void setNbreBilletEnfant(int nbre) {
        enfant_billet.setText("Enfant: " + nbre);
    }

    /**
     * Définit le nombre de billets seniors.
     *
     * @param nbre le nombre de billets seniors à afficher
     */
    public void setNbreBilletSenior(int nbre) {
        senior_billet.setText("Senior: " + nbre);
    }
}
