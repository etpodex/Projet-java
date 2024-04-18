package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.AffichageOnglet.AffGererFilmEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class GererFilm extends JButton {

    public GererFilm (){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Gerer Film");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffGererFilmEvenement());
        });
    }
}
