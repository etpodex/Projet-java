package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.Affichage.AffLesFilms;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LesFilms extends JButton{

    public LesFilms (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Les Films");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffLesFilms());
        });
    }
}
