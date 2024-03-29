package View.Onglets.BarreNavigationComposant;

import Controller.Evenements.Affichage.AffGererSeanceEvenement;
import Controller.Evenements.FileEvenements;
import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;

public class GererSeance extends JButton {

    public GererSeance (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Gerer Seance");

        addActionListener(e -> {
            FileEvenements.getInstance().publier(new AffGererSeanceEvenement());
        });
    }
}
