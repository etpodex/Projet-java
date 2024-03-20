/**BIBLIOTHEQUES**/
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Vue {

    /**ATTRIBUTS**/
    JFrame fenetrePrincipale;
    JTextField emailField;
    JPasswordField passwordField;
    JButton inscriptionButton;
    JButton connexionButton;
    private JPanel lesFilmsPanel;

    /**CONSTRUCTEUR**/
    public Vue() {
        creerEtAfficherGUI();
    }

    /**METHODES**/
    private void creerEtAfficherGUI() {

        /** --- Creation fenetre principale --- **/

        fenetrePrincipale = new JFrame("Cinema");
        fenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenir la taille de l'écran pour avoir une fenetre au top
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Taille de la fenêtre en fonction de la taille de l'écran obtenue juste au dessus
        fenetrePrincipale.setSize(screenWidth, screenHeight);

        /** --- ONGLETS --- **/

        //ACCUEIL

        JPanel accueilPanel = new JPanel();
        accueilPanel.add(new JLabel("Voici l'Accueil"));


        //LES FILMS

        //creation panel les films
        lesFilmsPanel = new JPanel();
        lesFilmsPanel.setLayout(new GridBagLayout());


        //CONNEXION

        //creation panel
        JPanel connexionPanel = new JPanel();

        //creation formulaire :

        JLabel emailLabel = new JLabel("Email:");
        connexionPanel.add(emailLabel);

        JTextField emailField = new JTextField(20);
        connexionPanel.add(emailField);

        JLabel passwordLabel = new JLabel("Mot de passe:");
        connexionPanel.add(passwordLabel);

        JPasswordField passwordField = new JPasswordField(20);
        connexionPanel.add(passwordField);

        JButton inscriptionButton = new JButton("Inscription");
        connexionPanel.add(inscriptionButton);

        JButton connexionButton = new JButton("Connexion");
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


        //Affichage fenetre principale

        //integration des onglets dans la fenetre principale
        fenetrePrincipale.add(onglets);
        //faire apparaitre la fenetre
        fenetrePrincipale.setVisible(true);
    }

    //Methode pour obtenir le contenu du champ de saisie Email
    public String getEmail() {
        return emailField.getText();
    }

    //Methode pour obtenir le contenu du champ de saisie mdp
    public String getPassword() {
        return new String(passwordField.getPassword());
    }

    //Methode pour afficher les affiches et le titre des films dans l'onglet Les Films
    public void afficherFilms(List<String> titresFilms, List<ImageIcon> affichesFilms) {
        //boucle verif
        if (titresFilms != null && affichesFilms != null) {
            lesFilmsPanel.removeAll();
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.anchor = GridBagConstraints.NORTHWEST; // Alignement en haut à gauche
            gbc.weightx = 0.0; // Fixe la taille horizontale
            gbc.weighty = 0.0; // Fixe la taille verticale
            gbc.gridheight = 1; // Hauteur fixe pour chaque composant individuel
            gbc.insets = new Insets(10, 10, 10, 10); // Marge

            for (int i = 0; i < titresFilms.size(); i++) {
                JLabel afficheLabel = new JLabel(affichesFilms.get(i));
                lesFilmsPanel.add(afficheLabel, gbc);

                gbc.gridx++; // Passage à la colonne suivante pour le titre
                gbc.weightx = 1.0; // Permet l'extension horizontale pour le titre
                gbc.anchor = GridBagConstraints.WEST; // Alignement à gauche pour le titre
                gbc.insets = new Insets(10, 0, 10, 10); // Marge ajustée pour le titre

                JLabel titleLabel = new JLabel(titresFilms.get(i));
                lesFilmsPanel.add(titleLabel, gbc);

                gbc.gridy++; // Passage à la ligne suivante pour le prochain film
                gbc.gridx = 0; // Réinitialisation de la colonne pour le prochain affichage d'affiche
                gbc.weightx = 0.0; // Réinitialisation du poids horizontal
                gbc.anchor = GridBagConstraints.NORTHWEST; // Réinitialisation de l'ancrage
                gbc.insets = new Insets(10, 10, 10, 10); // Réinitialisation des marges
            }
        }
    }


    //Methode pour afficher la nouvelle fenetre quand bouton page connexion ou inscription est selectionné
    public void afficherNouvelleFenetre() {
        //Fermer la fenetre actuelle
        fenetrePrincipale.dispose();

        //Creation nouvelleFenetre
        JFrame nouvelleFenetrePrincipale = new JFrame("Nouvelle fenetre");
        nouvelleFenetrePrincipale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Obtenir la taille de l'écran pour avoir une fenetre au top
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();

        // Taille de la fenêtre en fonction de la taille de l'écran obtenue juste au dessus
        nouvelleFenetrePrincipale.setSize(screenWidth, screenHeight);

        /**ONGLETS**/

        //Accueil
        JPanel accueilPanel = new JPanel();
        accueilPanel.add(new JLabel("Voici l'Accueil"));

        //Les Films
        JPanel lesFilmsPanel = new JPanel();
        lesFilmsPanel.add(new JLabel("Voici Les Films"));

        //Mes Billets
        JPanel mesBilletsPanel = new JPanel();
        mesBilletsPanel.add(new JLabel("Voici vos billets"));

        //Votre Profil
        JPanel monProfilPanel = new JPanel();
        monProfilPanel.add(new JLabel("Voici votre profil"));
        BoutonDeconnexion(monProfilPanel, nouvelleFenetrePrincipale);

        JTabbedPane onglets = new JTabbedPane();
        onglets.addTab("Accueil", accueilPanel);
        onglets.addTab("Les Films", lesFilmsPanel);
        onglets.addTab("Mes Billets", mesBilletsPanel);
        onglets.addTab("Mon Profil", monProfilPanel);

        nouvelleFenetrePrincipale.add(onglets);
        nouvelleFenetrePrincipale.setVisible(true);
    }

    // Méthode pour le bouton de déconnexion et pour afficher la fenêtre principale
    public void BoutonDeconnexion(JPanel profilPanel, JFrame nouvelleFenetrePrincipale) {
        JButton deconnexionButton = new JButton("Déconnexion");
        deconnexionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fermer la fenêtre actuelle (Mon Profil)
                nouvelleFenetrePrincipale.dispose();
                // Réafficher la fenêtre principale
                creerEtAfficherGUI();
            }
        });
        profilPanel.add(deconnexionButton);
    }

}