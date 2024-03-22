package View.PrincipaleVueComposant.BarreNavigationComposant;

/**BIBLIOTHEQUE**/

import View.PrincipaleVueComposant.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Calendrier extends JButton{

    public Calendrier (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Calendrier");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Calendrier\" a été cliqué!");
                barre_navigation.clicCalendrier();
            }
        });
    }

}
