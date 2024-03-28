package View.Onglets;

import Controller.VueControleur;
import View.PrincipaleVue;
import View.Onglets.BarreNavigationComposant.*;

import javax.swing.*;
import java.awt.*;

public class BarreNavigation extends JPanel {

    private Compte compte;
    private LesFilms les_films;
    private MesBillets mes_billets;
    private Accueil accueil;
    private MonCompte mon_compte;
    private Connexion connexion;
    private GererOffre gerer_offre;
    private GererFilm gerer_film;
    private GererSeance gerer_seance;
    private PrincipaleVue principale_vue;

    public BarreNavigation(PrincipaleVue principale_vue){
        this.principale_vue = principale_vue;
        this.compte = new Compte();
        this.les_films = new LesFilms(this);
        this.mes_billets = new MesBillets(this);
        this.accueil = new Accueil(this);
        this.mon_compte = new MonCompte(this);
        this.connexion = new Connexion(this);
        this.gerer_offre = new GererOffre(this);
        this.gerer_film = new GererFilm(this);
        this.gerer_seance = new GererSeance(this);

        setBackground(new Color(186, 230, 187));

        JPanel panel_boutons = new JPanel();
        panel_boutons.setLayout(new GridLayout(8,1));
        panel_boutons.add(les_films);
        panel_boutons.add(mes_billets);
        panel_boutons.add(accueil);
        panel_boutons.add(mon_compte);
        panel_boutons.add(connexion);
        panel_boutons.add(gerer_offre);
        panel_boutons.add(gerer_film);
        panel_boutons.add(gerer_seance);

        BoxLayout layout = new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(layout);

        //add(compte);
        add(panel_boutons);

        compte.setPreferredSize(new Dimension(200, 20));
    }

    public void clicMesBillets(){
        principale_vue.clicsBarreNavigation("MesBillets");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicLesFilms(){
        principale_vue.clicsBarreNavigation("LesFilms");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicAccueil(){
        principale_vue.clicsBarreNavigation("Accueil");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicMonCompte(){
        principale_vue.clicsBarreNavigation("MonCompte");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }

    public void clicConnexion(){
        principale_vue.getMasterVue().resetLancementVue();

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }
    public void clicGererOffre(){
        principale_vue.clicsBarreNavigation("GererOffre");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }
    public void clicGererFilm(){
        principale_vue.clicsBarreNavigation("GererFilm");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }
    public void clicGererSeance(){
        principale_vue.clicsBarreNavigation("GererSeance");

        // Revalide la mise en page + redessine le panneau
        principale_vue.revalidate();
        principale_vue.repaint();
    }
}