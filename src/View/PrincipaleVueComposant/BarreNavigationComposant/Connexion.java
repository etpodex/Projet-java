package View.PrincipaleVueComposant.BarreNavigationComposant;

import View.PrincipaleVueComposant.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Connexion extends JButton{

    public Connexion (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Connexion");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Connexion\" a été cliqué!");
                barre_navigation.clicConnexion();
            }
        });
    }

}
