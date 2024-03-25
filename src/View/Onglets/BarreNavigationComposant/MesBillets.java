package View.Onglets.BarreNavigationComposant;

/**BIBLIOTHEQUE**/

import View.Onglets.BarreNavigation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class MesBillets extends JButton{

    public MesBillets(BarreNavigation barre_navigation){
        setBackground(Color.WHITE);
        setForeground(Color.GRAY);
        setBorder(BorderFactory.createLineBorder(Color.WHITE, 2));
        setFocusPainted(false);
        setText("Mes Billets");

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Le bouton \"Mes Billets\" a été cliqué!");
                barre_navigation.clicMesBillets();
            }
        });
    }

}
