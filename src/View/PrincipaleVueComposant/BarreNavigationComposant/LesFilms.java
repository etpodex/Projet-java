package View.PrincipaleVueComposant.BarreNavigationComposant;

import View.PrincipaleVueComposant.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LesFilms extends JButton{

    public LesFilms (BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        setFocusPainted(false);
        setText("Les Films");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Les Films\" a été cliqué!");
                barre_navigation.clicLesFilms();
            }
        });
    }
}
