package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.Affichage.AffAccueilEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class Accueil extends JButton {

    public Accueil (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Accueil");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffAccueilEvenement());
        });
    }
}