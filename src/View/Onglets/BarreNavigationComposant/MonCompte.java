package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffMonCompteEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class MonCompte extends JButton {

    public MonCompte (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Mon Compte");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffMonCompteEvenement());
        });
    }

}