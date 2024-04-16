package View.Onglets.GererFilmVueComposant;

import javax.swing.*;
import java.awt.*;


public class Grille extends JPanel{

    // constructeur
    public Grille(){
        setLayout(new BorderLayout());

        JPanel grillePanel = new JPanel(new GridLayout(6,7));
        grillePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        String[] colonnesNoms = {"Titre", "Acteur", "Temps", "Note", "Synopsis", "Affiche", "Supprimer"};
        for (String colonnesNom : colonnesNoms) {
            JLabel label = new JLabel(colonnesNom);
            grillePanel.add(label);
        }

    }

}
