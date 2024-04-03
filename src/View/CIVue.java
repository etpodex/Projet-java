package View;

import Controller.Evenements.ConnexionEvenement;
import Controller.Evenements.FileEvenements;
import Controller.Evenements.InscriptionEvenement;
import Controller.Evenements.RetourCIEvenement;
import Model.Utilisateur;
import jdk.jshell.execution.Util;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class CIVue {
    /**ATTRIBUT**/

    private Inscription inscription_panel; // Ajout de la référence à Inscription
    private Connexion connexion_panel;
    private String current_view;


    public CIVue() {}


    public void creationCIPanel(JFrame frame, int frame_width, int frame_height, int choix){
        JPanel CIPanel = new JPanel();

        //structure
        int header_panel_height = (int) (frame_height * 0.1);
        int mid_panel_height = (int) (frame_height * 0.8);

        //création des panels
        Header header_panel = new Header(frame_width, header_panel_height);
        Connexion connexion_panel = new Connexion();
        Inscription inscription_panel = new Inscription(frame_width, mid_panel_height);
        Footer footer_panel = new Footer(this);

        this.inscription_panel = inscription_panel;
        this.connexion_panel = connexion_panel;

        if(choix == 1){
            CIPanel.setLayout(new BorderLayout());
            CIPanel.add(header_panel, BorderLayout.NORTH);
            CIPanel.add(connexion_panel, BorderLayout.CENTER);
            CIPanel.add(footer_panel, BorderLayout. SOUTH);

            this.current_view = "Connexion";

            frame.getContentPane().add(CIPanel);
        }
        else if(choix == 2){
            CIPanel.setLayout(new BoxLayout(CIPanel, BoxLayout.Y_AXIS));
            CIPanel.add(header_panel);
            CIPanel.add(inscription_panel);
            CIPanel.add(footer_panel);

            this.current_view = "Insription";

            frame.getContentPane().add(CIPanel);
        }
    }

    /// Méthode pour récupérer les données d'inscription à partir de Inscription
    public Utilisateur getInscriptionData() {
        if (inscription_panel != null) {
            return inscription_panel.getInscriptionData();
        } else {
            return null;
        }
    }

    public String[] getConnexionData() {
        if (inscription_panel != null) {
            return connexion_panel.getConnexionData();
        } else {
            return null; // Retourne null si Inscription n'est pas initialisé
        }
    }

    public String getCurrentView(){
        return current_view;
    }
}

class Inscription extends JPanel {

    private static final int FIELD_WIDTH = 20;

    private JTextField nomField;
    private JTextField prenomField;
    private JFormattedTextField ageField;
    private JTextField mailField;
    private JPasswordField passwordField;

    private JComboBox<Integer> ageComboBox;

    public Inscription(int panelWidth, int panelHeight) {
        setPreferredSize(new Dimension(panelWidth, panelHeight));
        setBackground(Color.WHITE); // Couleur de fond du panneau

        // Création des étiquettes et des champs de texte pour chaque champ du formulaire
        JLabel[] labels = {
                new JLabel("Nom:"),
                new JLabel("Prénom:"),
                new JLabel("Âge:"),
                new JLabel("E-mail:"),
                new JLabel("Mot de passe:")
        };

        nomField = new JTextField(FIELD_WIDTH);
        prenomField = new JTextField(FIELD_WIDTH);
        mailField = new JTextField(FIELD_WIDTH);
        passwordField = new JPasswordField(FIELD_WIDTH); // Champs de mot de passe

        // Création d'un champ de texte pour l'âge avec un filtre pour n'accepter que les chiffres
        try {
            MaskFormatter ageFormatter = new MaskFormatter("##"); // Format pour deux chiffres
            ageField = new JFormattedTextField(ageFormatter);
            ageField.setColumns(3); // Taille du champ
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // Mise en page des composants avec une disposition de grille améliorée
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espacement entre les composants

        // Ajout des étiquettes et des champs de texte à la grille
        for (int i = 0; i < labels.length; i++) {
            gbc.gridx = 0; // Colonne des étiquettes
            gbc.gridy = i; // Ligne actuelle
            gbc.anchor = GridBagConstraints.LINE_END; // Alignement à droite
            add(labels[i], gbc);

            gbc.gridx = 1; // Colonne des champs de texte
            gbc.anchor = GridBagConstraints.LINE_START; // Alignement à gauche
            if (i == 2) {
                add(ageField, gbc); // Ajout du champ de texte pour l'âge
            } else {
                add(getFieldComponent(i), gbc);
            }
        }
    }

    // Méthode pour obtenir le champ de texte correspondant à l'index
    private JTextField getFieldComponent(int index) {
        switch (index) {
            case 0: return nomField;
            case 1: return prenomField;
            case 3: return mailField;
            case 4: return passwordField;
            default: return null;
        }
    }

    // Méthode pour récupérer les données d'inscription
    public Utilisateur getInscriptionData() {
        Utilisateur utilisateur = new Utilisateur(null, mailField.getText(), nomField.getText(), prenomField.getText(), Integer.parseInt(ageField.getText()), 1, passwordField.getText());
        return utilisateur;
    }
}

class Header extends JPanel{
    public Header(int frame_width, int frame_height){
        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        JLabel label = new JLabel("CINAMAX");
        label.setHorizontalAlignment(SwingConstants.CENTER); // Centrer le texte horizontalement dans le JLabel
        label.setVerticalAlignment(SwingConstants.CENTER); // Centrer le texte verticalement dans le JLabel

        int panel_height = (int) (frame_height); // Ajustement pour que le panel de Logo prenne 10% de l'écran
        label.setPreferredSize(new Dimension(frame_width,panel_height));
        add(label);
    }
}

class Footer extends JPanel{
    private JButton bouton_valider;
    private JButton bouton_retour;

    public Footer(CIVue ci_vue){


        //couleur pour voir
        setBackground(new Color(186, 230, 187));

        setLayout(new GridBagLayout());

        bouton_valider = new JButton("Valider");
        bouton_valider.addActionListener(e -> {
            if (ci_vue.getCurrentView().equals("Inscription")) {
                FileEvenements.getInstance().publier(new InscriptionEvenement(ci_vue.getInscriptionData()));
            } else if (ci_vue.getCurrentView().equals("Connexion")){
                FileEvenements.getInstance().publier(new ConnexionEvenement());
            }
        });

        bouton_retour = new JButton("Retour");
        bouton_retour.addActionListener(e -> {FileEvenements.getInstance().publier(new RetourCIEvenement());});

        //GridBagLayout :
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.EAST;
        gbc.weightx = 1.0; // Poids pour occuper l'espace disponible dans la colonne

        add(bouton_valider, gbc);

        gbc.anchor = GridBagConstraints.WEST;
        add(bouton_retour, gbc);
    }

}

class Connexion extends JPanel {

    private JTextField emailField;
    private JPasswordField passwordField;

    public Connexion() {
        setLayout(new BorderLayout());

        // Création du panneau pour le formulaire de connexion
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(0, 0, 10, 0); // Espacement entre les champs

        // Panel pour la paire d'étiquette-champ de saisie de l'e-mail
        JLabel emailLabel = new JLabel("Mail :");
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formPanel.add(emailLabel, gbc);
        gbc.gridy++;
        emailField = new JTextField(20);
        formPanel.add(emailField, gbc);

        // Panel pour la paire d'étiquette-champ de saisie du mot de passe
        JLabel passwordLabel = new JLabel("Mot de passe :");
        gbc.gridy++;
        formPanel.add(passwordLabel, gbc);
        gbc.gridy++;
        passwordField = new JPasswordField(20);
        formPanel.add(passwordField, gbc);

        // Ajoute le panneau du formulaire au centre du panneau principal
        add(formPanel, BorderLayout.CENTER);
    }

    // Méthode pour récupérer les données de connexion
    public String[] getConnexionData() {
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        return new String[]{email, password};
    }
}