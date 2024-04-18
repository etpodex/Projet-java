package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffAccueilEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class Accueil extends JButton {

    public Accueil (){
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