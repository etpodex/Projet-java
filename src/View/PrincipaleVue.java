package View;

import View.Onglets.*;
import View.Onglets.LesFilmsComposant.Films;

import javax.swing.*;
import java.awt.*;

public class PrincipaleVue extends JPanel {

    // ATTRIBUTS //

    private MasterVue masterVue; // Instance de la vue principale

    // Instance des panels qui composent la vue principale
    private BarreNavigation barreNavigation; // La barre de navigation à gauche
    private JPanel panneauContenu; // Le panneau de contenu à droite

    // Instances des vues composant le panneau de contenu
    private MesBilletsVue mesBilletsVue; // La vue du calendrier
    private LesFilmsVue lesFilmsVue; // La vue des films
    private AccueilVue accueilVue; // La vue d'accueil
    private MonCompteVue monCompteVue; // La vue de mon compte
    private ConnexionVue connexionVue; // La vue de connexion

    // Constructeur
    public PrincipaleVue(MasterVue masterVue, int frameWidth, int frameHeight) {

        int panelNavigationWidth = (int) (frameWidth * 0.2);
        int panneauContenuWidth = (int) (frameWidth * 0.8);

        // Initialisations des attributs
        this.masterVue = masterVue;
        this.panneauContenu = new JPanel();

        this.barreNavigation = new BarreNavigation(this);

        this.mesBilletsVue = new MesBilletsVue(panneauContenuWidth, frameHeight);
        this.lesFilmsVue = new LesFilmsVue(panneauContenuWidth, frameHeight, masterVue); // Passer la référence à MasterVue
        this.accueilVue = new AccueilVue(panneauContenuWidth, frameHeight);
        this.monCompteVue = new MonCompteVue(panelNavigationWidth, frameHeight);
        this.connexionVue = new ConnexionVue(panelNavigationWidth, frameHeight);

        Dimension barreNavDim = new Dimension(panelNavigationWidth, frameHeight);
        this.barreNavigation.setPreferredSize(barreNavDim);
        Dimension panneauContenuDim = new Dimension(panneauContenuWidth, frameHeight);
        this.panneauContenu.setPreferredSize(panneauContenuDim);

        setLayout(new BorderLayout());
        add(barreNavigation, BorderLayout.WEST);
        add(panneauContenu, BorderLayout.CENTER);

        // Revalide la mise en page + Redessine le panneau
        revalidate();
        repaint();
    }

    public void clicsBarreNavigation(String boutonBarre) {
        // Supprime tout contenu précédent
        panneauContenu.removeAll();

        BorderLayout layout = new BorderLayout();
        layout.setVgap(0);

        panneauContenu.setLayout(layout);
        if (boutonBarre.equals("LesFilms")) {
            masterVue.clicsPrincipaleVue("LesFilms");
            panneauContenu.add(lesFilmsVue, BorderLayout.CENTER);
        } else if (boutonBarre.equals("MesBillets")) {
            masterVue.clicsPrincipaleVue("MesBillets");
            panneauContenu.add(mesBilletsVue, BorderLayout.CENTER);
        } else if (boutonBarre.equals("Accueil")) {
            masterVue.clicsPrincipaleVue("Accueil");
            panneauContenu.add(accueilVue, BorderLayout.CENTER);
        } else if (boutonBarre.equals("MonCompte")) {
            masterVue.clicsPrincipaleVue("MonCompte");
            panneauContenu.add(monCompteVue, BorderLayout.CENTER);
        } else if (boutonBarre.equals("Connexion")) {
            masterVue.clicsPrincipaleVue("Connexion");
            panneauContenu.add(connexionVue, BorderLayout.CENTER);
        }

        // Revalide la mise en page + Redessine le panneau
        panneauContenu.revalidate();
        panneauContenu.repaint();
    }

    public MasterVue getMasterVue() {
        return this.masterVue;
    }
}
