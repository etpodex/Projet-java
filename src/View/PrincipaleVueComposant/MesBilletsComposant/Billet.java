package View.PrincipaleVueComposant.MesBilletsComposant;

import javax.swing.*;
import java.awt.*;

public class Billet extends JPanel {

    // Attributs
    private JLabel title_billet;
    private JLabel date_billet;
    private JLabel horaire_billet;
    private JLabel salle_billet;
    private JLabel siege_billet;
    private JLabel acheter_billet;
    private JLabel adulte_billet;
    private JLabel enfant_billet;
    private JLabel senior_billet;


    // Constructeur
    public Billet(int barre_navigation_panel_width, int frame_height) {
        int hauteur = frame_height * 1 / 3 - 30;
        setBackground(new Color(0, 255, 127));
        setPreferredSize(new Dimension(barre_navigation_panel_width, hauteur));

        title_billet = new JLabel();
        date_billet = new JLabel();
        horaire_billet = new JLabel();
        salle_billet = new JLabel();
        siege_billet = new JLabel();
        acheter_billet = new JLabel();
        adulte_billet = new JLabel();
        enfant_billet = new JLabel();
        senior_billet = new JLabel();

        // Add components to this panel
        add(title_billet);
        add(date_billet);
        add(horaire_billet);
        add(salle_billet);
        add(siege_billet);
        add(acheter_billet);
        add(adulte_billet);
        add(enfant_billet);
        add(senior_billet);

        // Revalidate the layout and repaint the panel
        revalidate();
        repaint();
    }

    // Methodes pr envoyer a MesBilletsVue
    public void setTitreFilm(String titre) {
        title_billet.setText("Film: " + titre);
    }

    public void setDataFilm(String date) {
        date_billet.setText("Date: " + date);
    }

    public void setDataHoraire(String horaire) {
        horaire_billet.setText("Horaire: " + horaire);
    }

    public void setDataSalle(int salle) {
        salle_billet.setText("Salle: " + salle);
    }

    public void setDataSiege(String siege) {
        siege_billet.setText("Siège: " + siege);
    }

    public void setNbreBilletAcheter(int nbre) {
        acheter_billet.setText("Nombre de billets achetés: " + nbre);
    }

    public void setNbreBilletAdulte(int nbre) {
        adulte_billet.setText("Nombre de billets adulte: " + nbre);
    }

    public void setNbreBilletEnfant(int nbre) {
        enfant_billet.setText("Nombre de billets enfant: " + nbre);
    }

    public void setNbreBilletSenior(int nbre) {
        senior_billet.setText("Nombre de billets senior: " + nbre);
    }
}
