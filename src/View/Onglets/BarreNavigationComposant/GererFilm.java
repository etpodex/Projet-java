package View.Onglets.BarreNavigationComposant;

import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GererFilm extends JButton {

    public GererFilm (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Gerer Film");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Gerer Film\" a été cliqué!");
                barre_navigation.clicGererFilm();
            }
        });
    }
}
