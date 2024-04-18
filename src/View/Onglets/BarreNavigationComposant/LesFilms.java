package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffLesFilmsEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class LesFilms extends JButton{

    public LesFilms (){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Les Films");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffLesFilmsEvenement());
        });
    }
}
