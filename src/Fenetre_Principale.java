/**import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre_Principale {

    //Attributs fenetre principale
    private JFrame fenetrePrincipale;

    //Constructeur
    public Fenetre_Principale() {
        creerEtAfficherGUI();
    }

    //Methode
    private void creerEtAfficherGUI() {

        //creation fenetre principale
        fenetrePrincipale = new JFrame("Cinema");
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenir la taille de l'écran pour avoir une fenetre au top
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Taille de la fenêtre en fonction de la taille de l'écran obtenue juste au dessus
        fenetrePrincipale.setSize(screenWidth, screenHeight);

        /**ONGLETS**/
/**

        //Accueil
        JPanel accueilPanel = new JPanel();
        accueilPanel.add(new JLabel("Voici l'Accueil"));

        //Les films
        JPanel lesFilmsPanel = new JPanel();
        accueilPanel.add(new JLabel("Voici les Films"));

        //Connexion
        JPanel connexionPanel = new JPanel();
        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);
        JLabel passwordLabel = new JLabel("Mot de passe:");
        JPasswordField passwordField = new JPasswordField(20);
        JButton inscriptionButton = new JButton("Inscription");
        JButton connexionButton = new JButton("Connexion");

        connexionPanel.add(emailLabel);
        connexionPanel.add(emailField);
        connexionPanel.add(passwordLabel);
        connexionPanel.add(passwordField);
        connexionPanel.add(inscriptionButton);
        connexionPanel.add(connexionButton);

        // Action clic bouton "Inscription"
        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //-----------> code a rajouter pour mettre la nouvelle connexion dans la data base
                afficherNouvelleFenetre();
            }
        });

        // Action clic bouton "Connexion"
        connexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                afficherNouvelleFenetre();
            }
        });

        //regroupement des onglets dans le tableau onglets
        JTabbedPane onglets = new JTabbedPane();
        onglets.addTab("Accueil", accueilPanel);
        onglets.addTab("Les Films", lesFilmsPanel);
        onglets.addTab("Connexion", connexionPanel);


        /**Fenetre Principale**/
/**
        //integration des onglets dans la fenetre principale
        fenetrePrincipale.add(onglets);
        //faire apparaitre la fenetre
        fenetrePrincipale.setVisible(true);
    }

    private void afficherNouvelleFenetre() {
        fenetrePrincipale.dispose(); // Fermer la fenêtre actuelle

        JFrame nouvelleFenetre = new JFrame("Nouvelle fenetre");
        nouvelleFenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenir la taille de l'écran pour avoir une fenetre au top
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Taille de la fenêtre en fonction de la taille de l'écran obtenue juste au dessus
        nouvelleFenetre.setSize(screenWidth, screenHeight);

        JPanel accueilPanel = new JPanel();
        accueilPanel.add(new JLabel("Voici l'Accueil"));

        JPanel lesFilmsPanel = new JPanel();
        lesFilmsPanel.add(new JLabel("Voici Les Films"));

        JPanel mesBilletsPanel = new JPanel();
        mesBilletsPanel.add(new JLabel("Voici vos billets"));

        JPanel monProfilPanel = new JPanel();
        monProfilPanel.add(new JLabel("Voici votre profil"));

        JTabbedPane onglets = new JTabbedPane();
        onglets.addTab("Accueil", accueilPanel);
        onglets.addTab("Les Films", lesFilmsPanel);
        onglets.addTab("Mes Billets", mesBilletsPanel);
        onglets.addTab("Mon Profil", monProfilPanel);

        nouvelleFenetre.add(onglets);
        nouvelleFenetre.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Fenetre_Principale::new);
    }
}
**/
