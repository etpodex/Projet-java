package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffConnexionEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class Connexion extends JButton{

    public Connexion (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Connexion");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffConnexionEvenement());
        });
    }

}
