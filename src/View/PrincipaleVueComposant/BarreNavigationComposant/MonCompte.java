package View.PrincipaleVueComposant.BarreNavigationComposant;

import View.PrincipaleVueComposant.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MonCompte extends JButton {

    public MonCompte (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Mon Compte");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Mon Compte\" a été cliqué!");
                barre_navigation.clicMonCompte();
            }
        });
    }

}