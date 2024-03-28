package View.Onglets.BarreNavigationComposant;

import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GererOffre extends JButton {

    public GererOffre (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Gerer Offre");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Gerer Offre\" a été cliqué!");
                barre_navigation.clicGererOffre();
            }
        });
    }
}
